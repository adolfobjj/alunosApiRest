package br.com.luizApiRest.service;

import br.com.luizApiRest.model.Alunos;
import br.com.luizApiRest.repository.AlunosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlunosService {

    @Autowired
    private AlunosRepository alunosRepository;

    public Optional<Alunos> buscarAlunoPorCpf(String cpf) {
        return alunosRepository.findByCpf(cpf);
    }
}
