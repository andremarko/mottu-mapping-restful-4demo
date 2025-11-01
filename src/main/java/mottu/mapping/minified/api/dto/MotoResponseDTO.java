package mottu.mapping.minified.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MotoResponseDTO {
    private Long motorcycleId;
    private String plate;
    private String coordinates;
    private SectorDTO sector;
    private ModelDTO model;
}
