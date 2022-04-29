package br.com.luizApiRest.dto;

import br.com.luizApiRest.model.Alunos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunosDto {

    private Long id;
    private String usuario;
    private String cpf;
    private String email;
    private String nome;
    private String sobrenome;
    private Integer idade;

    public AlunosDto(Alunos alunos){
        this.id = alunos.getId();
        this.usuario = alunos.getUsuario();
        this.cpf  = alunos.getCpf();
        this.email = alunos.getEmail();
        this.nome = alunos.getNome();
        this.sobrenome = alunos.getSobreNome();
        this.idade = alunos.getIdade();
    }
    public static List<AlunosDto> convert(List<Alunos> alunos){
        return alunos.stream().map(AlunosDto::new).collect(Collectors.toList());
    }

}
