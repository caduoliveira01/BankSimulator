package com.dev.transacao_api.controller;

import com.dev.transacao_api.dto.EstatisticaResponseDTO;
import com.dev.transacao_api.service.EstatisticaService;
import com.dev.transacao_api.service.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("estatistica")
@RequiredArgsConstructor
public class EstatisticasController {

    private EstatisticaService estatisticaService;

    public ResponseEntity<EstatisticaResponseDTO> buscarEstatisticas(@RequestParam(value = "intervalo"
            ,required = false,defaultValue = "60") Integer intervalo){

       return ResponseEntity.ok(estatisticaService.calcularEstatistica(intervalo));
    }
}
