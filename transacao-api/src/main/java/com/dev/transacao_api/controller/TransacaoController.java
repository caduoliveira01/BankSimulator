package com.dev.transacao_api.controller;

import com.dev.transacao_api.dto.TransacaoRequestDTO;
import com.dev.transacao_api.service.TransacaoService;
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
    public ResponseEntity<Void> addTransacao(@RequestBody TransacaoRequestDTO transacaoRequestDTO){
        transacaoService.adicionarTransacao(transacaoRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTransacao(){
        transacaoService.limparTransacao();
        return ResponseEntity.ok().build();
    }

}
