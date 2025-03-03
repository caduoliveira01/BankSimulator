package com.dev.transacao_api.service;

import com.dev.transacao_api.dto.EstatisticaResponseDTO;
import com.dev.transacao_api.dto.TransacaoRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EstatisticaService {

    private TransacaoService transacaoService;

    public EstatisticaResponseDTO calcularEstatistica(Integer intervalo){
        
        log.info("iniciada busca de estatisticas de transações pelo período de tempo "+intervalo);
        List<TransacaoRequestDTO> transacaoRequestDTOList = transacaoService.buscarTransacao(intervalo);

        if(transacaoRequestDTOList.isEmpty()){
            return new EstatisticaResponseDTO(0L,0.0,0.0,0.0,0.0);
        }
        DoubleSummaryStatistics estatisticas = transacaoRequestDTOList.stream()
                .mapToDouble(TransacaoRequestDTO::valor).summaryStatistics();

        log.info("estatísticas retornadas com sucesso");
        return new EstatisticaResponseDTO(estatisticas.getCount(),
                estatisticas.getSum(),
                estatisticas.getAverage(),
                estatisticas.getMin(),
                estatisticas.getMax());
    }

}
