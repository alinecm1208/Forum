package com.aline.forum.services;

import com.aline.forum.models.Topico;
import com.aline.forum.records.TopicoRequestRecord;
import com.aline.forum.repositories.CursoRepository;
import com.aline.forum.repositories.TopicoRepository;
import com.aline.forum.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private UsuarioService usuarioService;


    public Topico save(TopicoRequestRecord topico, String email) {
        var novoTopico = new Topico();

        novoTopico.setMensagem(topico.mensagem());
        novoTopico.setTitulo(topico.titulo());
        var autor = usuarioService.findByEmail(email);
        novoTopico.setAutor(autor);
        var curso =  cursoService.findByNome(topico.curso());
        novoTopico.setCurso(curso);

        return topicoRepository.save(novoTopico);
    }

    public List<Topico> findAll() {
        return topicoRepository.findAll();
    }

    public Topico findById(Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        if (topico.isPresent()) {
            return topico.get();
        } else {
            throw new RuntimeException("Topico não encontrdo na base de dados");
        }
    }

    public void excluir(Long id) {
        topicoRepository.deleteById(id);
    }
}
