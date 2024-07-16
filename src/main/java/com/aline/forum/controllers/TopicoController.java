package com.aline.forum.controllers;

import com.aline.forum.models.Topico;
import com.aline.forum.records.TopicoRequestRecord;
import com.aline.forum.records.TopicoResponseRecord;
import com.aline.forum.repositories.CursoRepository;
import com.aline.forum.repositories.UsuarioRepository;
import com.aline.forum.services.CursoService;
import com.aline.forum.services.TopicoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("topico")
public class TopicoController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<TopicoResponseRecord> criarTopico(HttpServletRequest request, @RequestBody @Valid TopicoRequestRecord topico) {

        String email = request.getUserPrincipal().getName();
        Topico topicoSave = topicoService.save(topico, email);

        return ResponseEntity.ok(topicoSave.topicoToRecord(topicoSave));
    }

    @GetMapping
    public ResponseEntity<List<TopicoResponseRecord>> listarTopicos() {
        List<Topico> topicos = topicoService.findAll();
        List<TopicoResponseRecord> topicoResponseRecordList = new ArrayList<>();
        for (Topico topico : topicos) {
            topicoResponseRecordList.add(topico.topicoToRecord(topico));
        }
        return ResponseEntity.ok(topicoResponseRecordList);
    }

    @GetMapping("{id}")
    public ResponseEntity<TopicoResponseRecord> pegarUmTopico(@PathVariable Long id) {
        Topico topico = topicoService.findById(id);
        return ResponseEntity.ok(topico.topicoToRecord(topico));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<TopicoResponseRecord> atualizarUmTopico(@PathVariable Long id,
                                                                  @RequestBody @Valid TopicoRequestRecord topico) {
        Topico topicoDb = topicoService.findById(id);
        topicoDb.setTitulo(topico.titulo());
        topicoDb.setMensagem(topico.mensagem());
        topicoDb.setCurso(cursoService.findByNome(topico.curso()));
        topicoDb.setDataCriacao(topicoDb.getDataCriacao());

        return ResponseEntity.ok(topicoDb.topicoToRecord(topicoDb));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCurso(@PathVariable Long id) {
        topicoService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
