package com.carneiro.agendador_de_tarefas.bussiness.service;

import com.carneiro.agendador_de_tarefas.bussiness.dto.TarefasDTO;
import com.carneiro.agendador_de_tarefas.bussiness.mapper.TarefasConverter;
import com.carneiro.agendador_de_tarefas.infrastructure.entity.TarefasEntity;
import com.carneiro.agendador_de_tarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.carneiro.agendador_de_tarefas.infrastructure.repository.TarefasRepository;
import com.carneiro.agendador_de_tarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefaService {
    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefasConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO salvarTarefa (String token, TarefasDTO dto){
        String email = jwtUtil.extraiEmailToken(token.substring(7));

        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatus(StatusNotificacaoEnum.PENDENTE);
        TarefasEntity entity = tarefasConverter.paraTarefaEntity(dto);
        dto.setEmalUsuario(email);
        return tarefasConverter.paraTarefaDTO(tarefasRepository.save(entity));
    }
}
