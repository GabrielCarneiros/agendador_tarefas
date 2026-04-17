package com.carneiro.agendador_de_tarefas.controller;

import com.carneiro.agendador_de_tarefas.bussiness.dto.TarefasDTO;
import com.carneiro.agendador_de_tarefas.bussiness.service.TarefaService;
import com.carneiro.agendador_de_tarefas.infrastructure.entity.TarefasEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping("/eventos")
    public ResponseEntity<List<TarefasDTO>> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso =DateTimeFormat.ISO.DATE_TIME ) LocalDateTime dataFinal){

        return ResponseEntity.ok(tarefaService.buscaTarefasAgendadasPorPeriodo(dataInicial, dataFinal));

    }

    @GetMapping
    public ResponseEntity<List<TarefasDTO>> buscaTarefasPorEmail(@RequestHeader ("Authorization") String token){
        return ResponseEntity.ok(tarefaService.buscaTarefasPorEmail(token));
    }

}
