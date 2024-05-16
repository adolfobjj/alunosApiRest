package br.com.luizApiRest.controller;
import br.com.luizApiRest.model.Cursos;
import br.com.luizApiRest.repository.CursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
public class CursosController {

    @Autowired
    private CursosRepository cursosRepository;

    @GetMapping
    public Iterable<Cursos> listaCursos() {
        return cursosRepository.findAll();
    }

    @GetMapping("/{cursoId}")
    public ResponseEntity<Cursos> buscarCursoPorId(@PathVariable Long cursoId) {
        Optional<Cursos> curso = cursosRepository.findById(cursoId);
        return curso.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cursos adicionarCurso(@RequestBody Cursos curso) {
        return cursosRepository.save(curso);
    }

    @PutMapping("/{cursoId}")
    public ResponseEntity<Cursos> atualizarCurso(@PathVariable Long cursoId, @RequestBody Cursos cursoAtualizado) {
        Optional<Cursos> cursoExistente = cursosRepository.findById(cursoId);
        if (cursoExistente.isPresent()) {
            cursoAtualizado.setId(cursoId);
            return ResponseEntity.ok(cursosRepository.save(cursoAtualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{cursoId}")
    public ResponseEntity<Void> deletarCurso(@PathVariable Long cursoId) {
        if (cursosRepository.existsById(cursoId)) {
            cursosRepository.deleteById(cursoId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
