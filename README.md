# Mini Rede Social - Projeto Full Stack com Java Spring Boot

## Sobre o projeto

Este projeto foi desenvolvido com o objetivo de compor meu **portfólio de desenvolvimento Full Stack**, colocando em prática conhecimentos de back-end, banco de dados, APIs REST e front-end integrado.

A aplicação simula uma **rede social simples**, permitindo que usuários possam:

- criar contas
- publicar postagens
- comentar publicações
- curtir postagens
- visualizar um feed interativo

O projeto foi construído utilizando **Java + Spring Boot** no back-end, **MySQL** para persistência de dados e **HTML/CSS/JavaScript com Bootstrap** no front-end.

---

## Objetivo

O principal objetivo deste projeto foi consolidar conhecimentos em:

- desenvolvimento de APIs REST
- modelagem de banco de dados relacional
- relacionamentos entre entidades com JPA/Hibernate
- integração entre front-end e back-end
- manipulação de requisições HTTP
- versionamento de código com Git/GitHub

---

## Funcionalidades

### Gestão de usuários
- Cadastro de usuários
- Listagem de usuários

### Postagens
- Criação de postagens
- Exibição de postagens em feed

### Comentários
- Comentários em postagens
- Listagem de comentários

### Curtidas
- Curtir postagens
- Registro de curtidas por usuário

### Interface Web
- Cadastro via navegador
- Publicação de postagens
- Visualização dinâmica do feed
- Botão de curtir integrado à API

---

## Tecnologias utilizadas

### Back-end
- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven

### Banco de dados
- MySQL

### Front-end
- HTML5
- CSS3
- JavaScript
- Bootstrap 5

### Ferramentas
- VS Code
- Git
- GitHub
- Postman
- MySQL Workbench

---

## Arquitetura do projeto

```text
src/main/java/com/redesocial/social
├── controller
│   ├── UsuarioController.java
│   ├── PostagemController.java
│   ├── ComentarioController.java
│   └── CurtidaController.java
│
├── model
│   ├── Usuario.java
│   ├── Postagem.java
│   ├── Comentario.java
│   └── Curtida.java
│
├── repository
│   ├── UsuarioRepository.java
│   ├── PostagemRepository.java
│   ├── ComentarioRepository.java
│   └── CurtidaRepository.java
│
└── SocialApplication.java


src/main/resources
├── static
│   ├── index.html
│   ├── style.css
│   └── app.js
│
└── application.properties
```

---

## Modelagem de relacionamentos

Este projeto utiliza relacionamentos entre entidades com **JPA/Hibernate**.

### Usuário e Postagens

```text
Usuario 1 ---- N Postagem
```

### Usuário e Comentários

```text
Usuario 1 ---- N Comentario
```

### Postagem e Comentários

```text
Postagem 1 ---- N Comentario
```

### Usuário e Curtidas

```text
Usuario 1 ---- N Curtida
```

### Postagem e Curtidas

```text
Postagem 1 ---- N Curtida
```

---

## Como executar o projeto

### 1. Clonar o repositório

```bash
git clone URL_DO_SEU_REPOSITORIO
```

---

### 2. Entrar na pasta do projeto

```bash
cd rede-social-java
```

---

### 3. Criar o banco de dados MySQL

Execute no MySQL:

```sql
CREATE DATABASE social_db;
```

---

### 4. Configurar o arquivo `application.properties`

Editar:

```properties
src/main/resources/application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/social_db
spring.datasource.username=root
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 5. Executar a aplicação

```bash
./mvnw spring-boot:run
```

---

### 6. Acessar no navegador

```text
http://localhost:8080
```

---

## Endpoints da API

### Usuários

```text
GET  /usuarios
POST /usuarios
```

---

### Postagens

```text
GET  /postagens
POST /postagens
```

---

### Comentários

```text
GET  /comentarios
POST /comentarios
```

---

### Curtidas

```text
GET  /curtidas
POST /curtidas
```

---

## Exemplos de requisições JSON

### Criar usuário

```json
{
  "nome": "Gustavo",
  "email": "gustavo@email.com",
  "senha": "123456"
}
```

---

### Criar postagem

```json
{
  "texto": "Minha primeira postagem!",
  "usuario": {
    "id": 1
  }
}
```

---

### Criar comentário

```json
{
  "texto": "Muito boa essa postagem!",
  "usuario": {
    "id": 1
  },
  "postagem": {
    "id": 1
  }
}
```

---

### Curtir postagem

```json
{
  "usuario": {
    "id": 1
  },
  "postagem": {
    "id": 1
  }
}
```

---

## Aprendizados com este projeto

Durante o desenvolvimento deste projeto, pratiquei:

- construção de APIs REST com Spring Boot
- persistência de dados com JPA/Hibernate
- criação de relacionamentos entre entidades
- integração entre front-end e back-end
- testes de endpoints com Postman
- versionamento com Git e GitHub
- organização de projeto Full Stack

---

## Melhorias futuras

Próximas evoluções planejadas:

- autenticação e login com Spring Security
- criptografia de senha com BCrypt
- edição e exclusão de postagens
- contador de curtidas em tempo real
- exibição de comentários no feed
- upload de foto de perfil
- melhoria visual da interface
- deploy em nuvem

---

## Autor

**Gustavo de Oliveira Nicolau**

Projeto desenvolvido como parte do meu portfólio de desenvolvimento, com foco em prática e evolução nas tecnologias Java, Spring Boot e desenvolvimento Full Stack.