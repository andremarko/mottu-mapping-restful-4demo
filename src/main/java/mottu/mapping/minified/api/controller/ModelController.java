package mottu.mapping.minified.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import mottu.mapping.minified.api.dto.ModelDTO;
import mottu.mapping.minified.api.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@SecurityRequirement(name = "bearerAuth")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @GetMapping
    @Operation(summary = "Retorna todos os modelos de motos cadastrados")
    public ResponseEntity<List<ModelDTO>> getAll() {
        List<ModelDTO> models = modelService.getAll();
        return ResponseEntity.ok(models);
    }
}
