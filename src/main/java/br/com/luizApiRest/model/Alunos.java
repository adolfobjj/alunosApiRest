package br.com.luizApiRest.model;

import lombok.Data;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;

@Entity
@Data
public class Alunos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String usuario;
    @Column
    private String senha;
    @Column
    private String email;
    @Column
    private String nome;
    @Column
    private String sobrenome;
    @Column
    private Integer idade;



}
