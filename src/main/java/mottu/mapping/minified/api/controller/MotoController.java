package mottu.mapping.minified.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import mottu.mapping.minified.api.dto.CountSectorDTO;
import mottu.mapping.minified.api.dto.MotoRequestDTO;
import mottu.mapping.minified.api.dto.MotoResponseDTO;
import mottu.mapping.minified.api.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/motos")
@SecurityRequirement(name = "bearerAuth")
public class MotoController {

    @Autowired
    private MotoService motoService;

    @GetMapping
    @Operation(summary = "Retorna todas as motos persistidas nos setores de um pátio, páginadas (10 por página)")
    public ResponseEntity<Page<MotoResponseDTO>> getAll(Pageable pageable) {
        Page<MotoResponseDTO> motos = motoService.getAll(pageable);
        return ResponseEntity.ok(motos);
    }

    @GetMapping("/count-motos-by-sector")
    @Operation(summary = "Retorna a quantidade de motos em seus diferentes setores")
    public ResponseEntity<List<CountSectorDTO>> countMotosBySector() {
        List<CountSectorDTO> motos = motoService.countMotosBySector();
        return ResponseEntity.ok(motos);
    }

    @GetMapping("/{idMoto}")
    @Operation(summary = "Busca e retorna uma moto por id")
    public ResponseEntity<MotoResponseDTO> getById(@PathVariable Long idMoto) {
        MotoResponseDTO moto = motoService.getById(idMoto);
        return ResponseEntity.ok(moto);
    }

    @PutMapping("/{idMoto}")
    @Operation(summary = "Atualiza cadastro de uma moto")
    public ResponseEntity<MotoResponseDTO> update(@PathVariable Long idMoto, @RequestBody MotoRequestDTO dto) {
        MotoResponseDTO moto = motoService.update(idMoto, dto);
        return ResponseEntity.ok(moto);
    }

    @PostMapping
    @Operation(summary = "Cadastra uma moto")
    public ResponseEntity<MotoResponseDTO> create(@RequestBody MotoRequestDTO dto) {
        return ResponseEntity.ok(motoService.create(dto));
    }

    @DeleteMapping("/{idMoto}")
    @Operation(summary = "Deleta uma moto")
    public ResponseEntity<Void> delete(@PathVariable Long idMoto) {
        motoService.delete(idMoto);
        return ResponseEntity.noContent().build();
    }
}
