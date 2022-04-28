package br.com.luizApiRest.repository;

import br.com.luizApiRest.model.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryAlunos extends JpaRepository<Alunos,Long> {
}
