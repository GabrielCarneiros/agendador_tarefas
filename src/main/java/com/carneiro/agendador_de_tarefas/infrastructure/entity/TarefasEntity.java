package com.carneiro.agendador_de_tarefas.infrastructure.entity;

import com.carneiro.agendador_de_tarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("tarefa")
public class TarefasEntity {

    @id
    private String id;
    private String nomeTarefa;
    private String descricao;
    private LocalDateTime dataCriacao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyy HH:mm")
    private LocalDateTime dataEvento;
    private String emalUsuario;
    private LocalDateTime dataAlteracao;
    private StatusNotificacaoEnum status;


}
