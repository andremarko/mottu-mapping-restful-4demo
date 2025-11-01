package mottu.mapping.minified.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import mottu.mapping.minified.api.dto.SectorDTO;
import mottu.mapping.minified.api.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sectors")
@SecurityRequirement(name = "bearerAuth")
public class SectorController {

    @Autowired
    private SectorService sectorService;

    @GetMapping()
    @Operation(summary="Retorna todos os setores de um determinado pátio cadastrado")
    public ResponseEntity<List<SectorDTO>> getAll() {
        List<SectorDTO> sectors = sectorService.getAll();
        return ResponseEntity.ok(sectors);
    }
}
