package com.dev.transacao_api.dto;

public record EstatisticaResponseDTO(Long count,
                                     Double sum,
                                     Double avg,
                                     Double min,
                                     Double max) {
}
