package com.dev.transacao_api.service;

import com.dev.transacao_api.dto.EstatisticaResponseDTO;
import com.dev.transacao_api.dto.TransacaoRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EstatisticaService {

    private TransacaoService transacaoService;

    public EstatisticaResponseDTO calcularEstatistica(Integer intervalo){
        List<TransacaoRequestDTO> transacaoRequestDTOList = transacaoService.buscarTransacao(intervalo);

        DoubleSummaryStatistics estatisticas = transacaoRequestDTOList.stream()
                .mapToDouble(TransacaoRequestDTO::valor).summaryStatistics();

        return new EstatisticaResponseDTO(estatisticas.getCount(),
                estatisticas.getSum(),
                estatisticas.getAverage(),
                estatisticas.getMin(),
                estatisticas.getMax());
    }

}
