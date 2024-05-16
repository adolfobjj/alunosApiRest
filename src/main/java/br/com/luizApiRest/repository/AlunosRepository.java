package br.com.luizApiRest.repository;

import br.com.luizApiRest.model.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunosRepository extends JpaRepository<Alunos,Long> {
    Optional<Alunos> findByCpf(String cpf);
}
