package mottu.mapping.minified.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountSectorDTO {
    private String sectorName;
    private Long motoCount;
}
