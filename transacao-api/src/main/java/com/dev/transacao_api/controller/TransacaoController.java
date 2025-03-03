package com.dev.transacao_api.controller;

import com.dev.transacao_api.dto.TransacaoRequestDTO;
import com.dev.transacao_api.service.TransacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private TransacaoService transacaoService;

    @PostMapping
    @Operation(description = "Endpoint responsavel por adicionar transações")
    @ApiResponses(value ={@ApiResponse(responseCode = "201", description = "Transação gravada com sucesso"),
                          @ApiResponse(responseCode = "422", description = "Campos não atendem os requisitos necessarios"),
                          @ApiResponse(responseCode = "400", description = "Erro de requisição"),
                          @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<Void> addTransacao(@RequestBody TransacaoRequestDTO transacaoRequestDTO){
        transacaoService.adicionarTransacao(transacaoRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    @Operation(description = "Endpoint responsavel por deletar transações")
    @ApiResponses(value ={@ApiResponse(responseCode = "200", description = "Transação deletadas com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de requisição"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<Void> deleteTransacao(){
        transacaoService.limparTransacao();
        return ResponseEntity.ok().build();
    }

}
