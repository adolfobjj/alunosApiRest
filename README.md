# Projeto de Gerenciamento de Alunos e Cursos

Este projeto consiste em um sistema de gerenciamento de alunos e cursos, onde é possível cadastrar alunos, atribuir cursos a eles e realizar consultas baseadas em CPF para obter informações sobre os alunos.

## Classes

### Alunos

A classe `Alunos` representa os alunos do sistema. Cada aluno possui os seguintes atributos:

- `id`: Identificador único do aluno.
- `usuario`: Nome de usuário do aluno.
- `cpf`: CPF do aluno.
- `email`: Endereço de e-mail do aluno.
- `nome`: Nome do aluno.
- `sobrenome`: Sobrenome do aluno.
- `idade`: Idade do aluno.
- `cursos`: Curso(s) associado(s) ao aluno.
  

### Cursos

A classe `Cursos` representa os cursos disponíveis no sistema. Cada curso possui os seguintes atributos:

- `id`: Identificador único do curso.
- `curso`: Nome do curso.
- `dataInicio`: Data de início do curso.
- `dataConclusao`: Data de conclusão do curso.
- `nota`: Nota atribuída ao curso.

## Funcionalidades

- Cadastro de Alunos: Permite cadastrar novos alunos no sistema, fornecendo informações como nome, sobrenome, CPF, e-mail, idade, entre outros.
- Associação de Cursos: Permite associar um ou mais cursos a um aluno, fornecendo informações como nome do curso, data de início, data de conclusão e nota.
- Consulta por CPF: Permite buscar informações de um aluno pelo CPF, retornando detalhes como nome, sobrenome, idade, cursos associados, entre outros.

## Pré-requisitos

- Java
- Spring Boot
- Banco de dados (por exemplo, MySQL, PostgreSQL, H2)

## Configuração

Antes de executar o projeto, certifique-se de configurar o ambiente de desenvolvimento corretamente, incluindo a configuração do banco de dados e as dependências necessárias.

## Instalação

Siga as instruções fornecidas no arquivo de configuração do projeto para instalar as dependências e configurar o projeto corretamente.

## Uso

Consulte a documentação fornecida ou os comentários no código-fonte para entender como usar as funcionalidades do sistema.

## Contribuição

Se desejar contribuir com o projeto, sinta-se à vontade para enviar pull requests, relatar problemas ou sugerir melhorias.


## Agradecimentos

Agradecemos a todos os contribuidores e apoiadores deste projeto.

#Exemplos : <br>
Primeiro crie um curso: <br><br>
http://localhost:8080/api/cursos <br><br>
{<br>
    "curso": "Engenharia de Software",<br>
    "dataIncio": "2022-01-01",<br>
    "dataConclusao": "2026-01-01",<br>
    "nota": 9<br>
}<br><br>
Depois o aluno: <br><br>
http://localhost:8080/alunos <br><br>
{<br>
    "usuario": "joaosilva",<br>
    "senha": "senha123",<br>
    "email": "joao.silva@example.com",<br>
    "nome": "João",<br>
    "sobreNome": "Silva",<br>
    "idade": 20,<br>
    "cpf": "12345678900",<br>
    "cursos": {<br>
        "id": 1,<br>
        "curso": "Engenharia de Software",<br>
        "dataIncio": "2022-01-01",<br>
        "dataConclusao": "2026-01-01",<br>
        "nota": 9<br>
    }<br>
}<br><br>
