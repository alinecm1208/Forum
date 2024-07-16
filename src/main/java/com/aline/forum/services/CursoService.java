package com.aline.forum.services;

import com.aline.forum.models.Curso;
import com.aline.forum.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso findByNome(String curso) {
        return cursoRepository.findByNome(curso);
    }
}
