package mottu.mapping.minified.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDTO {
    @Schema(description = "Nome do usuário que está fazendo login", example="operator")
    private String username;
    @Schema(description = "Senha do usuário que está fazendo login", example="oper123")
    private String password;
}
