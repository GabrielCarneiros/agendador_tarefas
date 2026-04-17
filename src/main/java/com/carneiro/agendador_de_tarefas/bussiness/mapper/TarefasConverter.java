package com.carneiro.agendador_de_tarefas.bussiness.mapper;

import com.carneiro.agendador_de_tarefas.bussiness.dto.TarefasDTO;
import com.carneiro.agendador_de_tarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasConverter {
    TarefasEntity paraTarefaEntity(TarefasDTO dto);
    TarefasDTO paraTarefaDTO(TarefasEntity entity);
}
