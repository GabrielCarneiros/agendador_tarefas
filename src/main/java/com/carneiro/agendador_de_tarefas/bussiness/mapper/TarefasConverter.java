package com.carneiro.agendador_de_tarefas.bussiness.mapper;

import com.carneiro.agendador_de_tarefas.bussiness.dto.TarefasDTO;
import com.carneiro.agendador_de_tarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefasConverter {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "dataEvento", target = "dataEvento")
    @Mapping(source = "dataCriacao", target = "dataCriacao")
    TarefasEntity paraTarefaEntity(TarefasDTO dto);
    TarefasDTO paraTarefaDTO(TarefasEntity entity);
    List<TarefasEntity> paraListaTarefasEntity(List<TarefasDTO>tarefasDTOList);
    List<TarefasDTO> paraListaTarefasDTO(List<TarefasEntity>tarefasEntityList);
}
