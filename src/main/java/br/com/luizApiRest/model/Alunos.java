package br.com.luizApiRest.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import java.util.List;
import java.util.Optional;

@Entity
@Data
public class Alunos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column  @NotNull @NotEmpty @Length(max = 25)
    private String usuario;

    @Column
    private String senha;

    @Column @NotNull @NotEmpty @Email
    private String email;

    @Column
    private String nome;

    @Column
    private String sobreNome;

    @Column
    private Integer idade;

    @Column @CPF @NotNull @NotEmpty
    private String cpf;

    @ManyToOne
    private Cursos cursos;



}
