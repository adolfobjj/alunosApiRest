package br.com.luizApiRest.controller;

import br.com.luizApiRest.repository.AlunosRepository;
import br.com.luizApiRest.dto.AlunosDto;
import br.com.luizApiRest.model.Alunos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunosController {

    @Autowired
    private AlunosRepository alunosRepository;

    @GetMapping
    @Cacheable(value = "listaAlunos", sync = false)
    public Page<AlunosDto> listaAlunos(@RequestParam(required = false) String aluno,
                                       @PageableDefault(sort = "id", direction = Sort.Direction.DESC)
                                               Pageable pagainacao){

        Page<Alunos> alunos = alunosRepository.findAll(pagainacao);
        return AlunosDto.convert(alunos);
    }

    @GetMapping("/{alunoId}")
    public ResponseEntity<AlunosDto> buscarPorId(@PathVariable Long alunoId){
        Optional<Alunos> alunos = alunosRepository.findById(alunoId);
        if (alunos.isPresent()){
            return  ResponseEntity.ok(new AlunosDto(alunos.get()));
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<AlunosDto> buscarAlunoPorCpf(@PathVariable String cpf) {
        Optional<Alunos> alunoOptional = alunosRepository.findByCpf(cpf);
        if (alunoOptional.isPresent()) {
            Alunos aluno = alunoOptional.get();
            AlunosDto alunoDto = new AlunosDto(aluno);
            return ResponseEntity.ok(alunoDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CacheEvict(value = "listaAlunos", allEntries = true)
    public Alunos add(@Valid @RequestBody Alunos alunos){
        return alunosRepository.save(alunos);
    }

    @PutMapping("/{alunoId}")
    @CacheEvict(value = "listaAlunos", allEntries = true)
    public ResponseEntity<Alunos> update(@PathVariable Long alunoId, @RequestBody Alunos alunos){

        if(!alunosRepository.existsById(alunoId)){
            return ResponseEntity.notFound().build();
        }

        alunos.setId(alunoId);
        alunos = alunosRepository.save(alunos);
        return ResponseEntity.ok(alunos);
    }

    @DeleteMapping("/{alunoId}")
    @CacheEvict(value = "listaAlunos", allEntries = true)
    public ResponseEntity<Void> delete(@PathVariable Long alunoId){

        if(!alunosRepository.existsById(alunoId)){
            return ResponseEntity.notFound().build();
        }

        alunosRepository.deleteById(alunoId);
        return ResponseEntity.noContent().build();
    }

}