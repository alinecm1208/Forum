package com.aline.forum.records;

import java.time.LocalDateTime;
import java.util.List;

public record TopicoResponseRecord(
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        String status,
        String autor,
        String curso,
        List<String> respostas

) {
}
