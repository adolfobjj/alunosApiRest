package br.com.luizApiRest.controller;

import br.com.luizApiRest.model.Alunos;
import br.com.luizApiRest.repository.RepositoryAlunos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunosController {
    @Autowired
    private RepositoryAlunos repositoryAlunos;

    @GetMapping
    public List<Alunos> listaAlunos(){
        return repositoryAlunos.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Alunos add(@RequestBody Alunos alunos){
        return repositoryAlunos.save(alunos);
    }
    @PutMapping("/{alunoId}")
    public ResponseEntity<Alunos> update(@PathVariable Long alunoId, @RequestBody Alunos alunos){
        if(!repositoryAlunos.existsById(alunoId)){
            return  ResponseEntity.notFound().build();
        }

        alunos.setId(alunoId);
        alunos = repositoryAlunos.save(alunos);
        return ResponseEntity.ok(alunos);
    }
    @DeleteMapping("/{alunoId}")
    public ResponseEntity<Alunos> delete(@PathVariable Long alunoId){

        if(!repositoryAlunos.existsById(alunoId)){
            return  ResponseEntity.notFound().build();
        }

        repositoryAlunos.deleteById(alunoId);
        return ResponseEntity.noContent().build();
    }
}
