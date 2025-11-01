package mottu.mapping.minified.api.mapper;

import mottu.mapping.minified.api.dto.SectorDTO;
import mottu.mapping.minified.api.model.Sector;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SectorMapper {
    SectorDTO toSectorDTO(Sector sector);
}
