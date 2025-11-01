package mottu.mapping.minified.api.service;

import mottu.mapping.minified.api.dto.ModelDTO;
import mottu.mapping.minified.api.mapper.ModelMapper;
import mottu.mapping.minified.api.model.Model;
import mottu.mapping.minified.api.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelService {

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private ModelMapper modelMapper;

    /* alimenta dropdown mobile */
    public List<ModelDTO> getAll() {
        List<Model> models = modelRepository.findAll();
        return models.stream()
                .map(modelMapper::toModelDTO)
                .collect(Collectors.toList());
    }
}
