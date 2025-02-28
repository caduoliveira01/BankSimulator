package com.dev.transacao_api.service;

import com.dev.transacao_api.dto.TransacaoRequestDTO;
import com.dev.transacao_api.exceptions.UnprocessableEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransacaoService {

    private final List<TransacaoRequestDTO> listaTransacao= new ArrayList<>();

    public void adicionarTransacao(TransacaoRequestDTO transacaoRequestDTO){

        if (transacaoRequestDTO.dataHora().isAfter(OffsetDateTime.now())){
            log.error("Data e hora maiores que a data atual!");
            throw new UnprocessableEntity("Data e hora maiores que a data atual!");
        }

        if (transacaoRequestDTO.valor()<0){
            log.error("Valor menor que zero!");
            throw new UnprocessableEntity("Valor não pode ser menor que zero");
        }

        listaTransacao.add(transacaoRequestDTO);
    }

    public void limparTransacao(){
        listaTransacao.clear();
    }

    public List<TransacaoRequestDTO> buscarTransacao(Integer intervaloBusca){
            OffsetDateTime intervalo = OffsetDateTime.now().minusSeconds(intervaloBusca);

            return listaTransacao.stream().
                    filter(transacao -> transacao.dataHora()
                            .isAfter(intervalo)).toList();
    }
}
