package com.aline.forum.models;

import com.aline.forum.enums.StatusTopicoEnum;
import com.aline.forum.records.TopicoRequestRecord;
import com.aline.forum.records.TopicoResponseRecord;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "titulo")
    private String titulo;
    @Column(name = "mensagem")
    private String mensagem;
    @Column(name = "dataCriacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusTopicoEnum status = StatusTopicoEnum.NAO_RESPONDIDO;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "topico")
    private List<Resposta> respostas = new ArrayList<>();

    public TopicoResponseRecord topicoToRecord(Topico topico) {
        return new TopicoResponseRecord(topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus().name(),
                topico.getAutor().getNome(),
                topico.getCurso().getNome(),
                topico.getRespostas().stream().map(Resposta::getMensagem).collect(Collectors.toList()));

    }


}
