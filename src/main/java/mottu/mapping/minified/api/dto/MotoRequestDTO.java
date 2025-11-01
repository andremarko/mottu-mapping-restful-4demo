package mottu.mapping.minified.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MotoRequestDTO {
    @Schema(description = "Placa da moto", example = "MOTO0041")
    private String plate;
    @Schema(description = "Localização da moto", example="10.124,-20.201")
    private String coordinates;
    @Schema(description = "Modelo da moto", example="1")
    private Long modelId;
    @Schema(description= "Setor em que a moto se localiza", example="1")
    private Long sectorId;
}
