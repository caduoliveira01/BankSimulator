package com.dev.transacao_api.dto;

import java.time.OffsetDateTime;

public record TransacaoRequestDTO(double valor, OffsetDateTime dataHora) {
}
