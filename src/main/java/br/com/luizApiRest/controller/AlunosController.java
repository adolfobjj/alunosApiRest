package br.com.luizApiRest.controller;

import br.com.luizApiRest.model.Alunos;
import br.com.luizApiRest.repository.RepositoryAlunos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlunosController {
    @Autowired
    private RepositoryAlunos repositoryAlunos;

    @GetMapping("/alunos")
    public List<Alunos> listaAlunos(){
        return repositoryAlunos.findAll();
    }
    @PostMapping("/alunos")
    @ResponseStatus(HttpStatus.CREATED)
    public Alunos add(@RequestBody Alunos alunos){
        return repositoryAlunos.save(alunos);
    }
}
