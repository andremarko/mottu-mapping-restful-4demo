package mottu.mapping.minified.api.service;

import mottu.mapping.minified.api.dto.CountSectorDTO;
import mottu.mapping.minified.api.dto.MotoRequestDTO;
import mottu.mapping.minified.api.dto.MotoResponseDTO;
import mottu.mapping.minified.api.mapper.MotoMapper;
import mottu.mapping.minified.api.model.Model;
import mottu.mapping.minified.api.model.Moto;
import mottu.mapping.minified.api.model.Sector;
import mottu.mapping.minified.api.repository.ModelRepository;
import mottu.mapping.minified.api.repository.MotoRepository;
import mottu.mapping.minified.api.repository.SectorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoService {

    @Autowired
    private MotoRepository motoRepository;

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private SectorRepository sectorRepository;

    @Autowired
    private MotoMapper motoMapper;

    // findBySector_Yard_Id
    public Page<MotoResponseDTO> getAll(Pageable pageable) {
        return motoRepository.findBySector_Yard_YardId(1L, pageable).map
                (motoMapper::toResponseDTO);
    }

    // count
    public List<CountSectorDTO> countMotosBySector() {
        return motoRepository.countMotosBySector();
    }

    // getById
    public MotoResponseDTO getById(Long motoId) {
        Moto moto = motoRepository.findById(motoId).orElseThrow(() -> new EntityNotFoundException("Moto not found"));
        return motoMapper.toResponseDTO(moto);
    }

    // update
    public MotoResponseDTO update(Long motoId, MotoRequestDTO dto) {
        // checar NotFoundException
        Moto moto = motoRepository.findById(motoId).orElseThrow(() -> new EntityNotFoundException("Moto not found"));
        Model model = modelRepository.findById(dto.getModelId()).orElseThrow(() -> new EntityNotFoundException("Model not found"));
        Sector sector = sectorRepository.findById(dto.getSectorId()).orElseThrow(() -> new EntityNotFoundException("Sector not found"));
        motoMapper.updateEntityFromDTO(dto, moto);
        moto.setModel(model);
        moto.setSector(sector);
        Moto updated = motoRepository.save(moto);
        return motoMapper.toResponseDTO(updated);
    }

    // create
    public MotoResponseDTO create(MotoRequestDTO dto) {
                                                                                // definir exceptions
        Model model = modelRepository.findById(dto.getModelId()).orElseThrow(() -> new EntityNotFoundException("Model not found"));
        Sector sector = sectorRepository.findById(dto.getSectorId()).orElseThrow(() -> new EntityNotFoundException("Sector not found"));
        Moto moto = motoMapper.toEntity(dto);
        moto.setSector(sector);
        moto.setModel(model);
        motoRepository.save(moto);
        return motoMapper.toResponseDTO(moto);
    }

    // delete
    public void delete(Long motoId) {
        if (!motoRepository.existsById(motoId)) {
            throw new EntityNotFoundException("Moto not found");
        }
        motoRepository.deleteById(motoId);
    }
}
