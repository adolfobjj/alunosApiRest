package br.com.luizApiRest.controller;

import br.com.luizApiRest.dto.AlunosDto;
import br.com.luizApiRest.model.Alunos;
import br.com.luizApiRest.repository.AlunosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunosController {
    @Autowired
    private AlunosRepository repositoryAlunos;

    @GetMapping
    public List<AlunosDto> listaAlunos(){
        List<Alunos> alunos = repositoryAlunos.findAll();
        return  AlunosDto.convert(alunos);

    }
    @GetMapping("/alunoId")
    public Alunos listaId(@PathVariable Long alunoId){
        return repositoryAlunos.findById(alunoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não encontrado."));
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
