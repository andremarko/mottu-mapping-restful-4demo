package mottu.mapping.minified.api.mapper;

import mottu.mapping.minified.api.dto.ModelDTO;
import mottu.mapping.minified.api.model.Model;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModelMapper {
    ModelDTO toModelDTO(Model model);
}
