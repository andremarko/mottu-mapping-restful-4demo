package mottu.mapping.minified.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectorDTO {
    private Long sectorId;
    private String name;
    private String description;
    private String colorRgb;
}
