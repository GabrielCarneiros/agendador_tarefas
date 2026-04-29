package com.carneiro.agendador_de_tarefas.infrastructure.repository;

import com.carneiro.agendador_de_tarefas.infrastructure.entity.TarefasEntity;
import com.carneiro.agendador_de_tarefas.infrastructure.enums.StatusNotificacaoEnum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TarefasRepository extends MongoRepository<TarefasEntity, String> {
    List<TarefasEntity> findByDataEventoBetweenAndStatus(LocalDateTime dataInicial, LocalDateTime dataFinal, StatusNotificacaoEnum status);
    List<TarefasEntity> findByEmailUsuario(String email);

}
