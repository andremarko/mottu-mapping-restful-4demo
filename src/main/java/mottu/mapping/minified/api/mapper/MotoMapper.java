package mottu.mapping.minified.api.mapper;

import mottu.mapping.minified.api.dto.MotoRequestDTO;
import mottu.mapping.minified.api.dto.MotoResponseDTO;
import mottu.mapping.minified.api.model.Moto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MotoMapper {
    MotoResponseDTO toResponseDTO(Moto moto);
    Moto toEntity(MotoRequestDTO dto);
    void updateEntityFromDTO(MotoRequestDTO dto, @MappingTarget Moto moto);
}
