package mottu.mapping.minified.api.service;

import mottu.mapping.minified.api.dto.SectorDTO;
import mottu.mapping.minified.api.mapper.SectorMapper;
import mottu.mapping.minified.api.model.Sector;
import mottu.mapping.minified.api.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SectorService {

    @Autowired
    private SectorRepository sectorRepository;

    @Autowired
    private SectorMapper sectorMapper;

    // alimenta dropdown de alteração de setor de moto
    public List<SectorDTO> getAll() {
        List<Sector> sectors = sectorRepository.findByYard_YardId(1L);
        return sectors.stream().map(sectorMapper::toSectorDTO).collect(Collectors.toList());
    }
}
