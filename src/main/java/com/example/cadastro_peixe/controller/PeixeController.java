package com.example.cadastro_peixe.controller;

import com.example.cadastro_peixe.business.PeixeService;
import com.example.cadastro_peixe.infrastructure.entitys.Peixe;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/peixe")
@RequiredArgsConstructor

public class PeixeController {
    private final PeixeService PeixeService;

    @PostMapping
    public ResponseEntity<Void> salvarPeixe(@RequestBody Peixe peixe){
        PeixeService.salvarPeixe(peixe);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Peixe> buscarPeixePorId(@RequestParam Integer id){
        return ResponseEntity.ok(PeixeService.buscarPeixePorId(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarPeixePorId(@RequestParam Integer id){
        PeixeService.deletarPeixePorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarPeixePorId(@RequestParam Integer id,
                                                      @RequestBody Peixe peixe){
        PeixeService.atualizarPeixePorId(id, peixe);
        return ResponseEntity.ok().build();
    }
}
