package com.carneiro.agendador_de_tarefas.controller;

import com.carneiro.agendador_de_tarefas.bussiness.dto.TarefasDTO;
import com.carneiro.agendador_de_tarefas.bussiness.service.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefasController {
    private final TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefasDTO> salvarTarefas(@RequestBody TarefasDTO dto,
                                                    @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(tarefaService.salvarTarefa(token, dto));
    }

}
