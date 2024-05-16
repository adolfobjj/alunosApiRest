package br.com.luizApiRest.model;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cursos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column @NotEmpty @NotNull
    private String curso;

    @Column @NotNull
    private LocalDate dataIncio;

    @Column
    private LocalDate dataConclusao;

    @Column
    private Long nota;


}
