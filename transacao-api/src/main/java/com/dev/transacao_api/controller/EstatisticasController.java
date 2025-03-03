package com.dev.transacao_api.controller;

import com.dev.transacao_api.dto.EstatisticaResponseDTO;
import com.dev.transacao_api.service.EstatisticaService;
import com.dev.transacao_api.service.TransacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("estatistica")
@RequiredArgsConstructor
public class EstatisticasController {

    private EstatisticaService estatisticaService;

    @GetMapping
    @Operation(description = "Endpoint responsavel por buscar estatisticas de transações")
    @ApiResponses(value ={@ApiResponse(responseCode = "200", description = "busca efetuada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na busca de estatisticas"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<EstatisticaResponseDTO> buscarEstatisticas(@RequestParam(value = "intervalo"
            ,required = false,defaultValue = "60") Integer intervalo){

       return ResponseEntity.ok(estatisticaService.calcularEstatistica(intervalo));
    }
}
