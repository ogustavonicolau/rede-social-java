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

O principal objetivo deste projeto é consolidar conhecimentos em:

- desenvolvimento de APIs REST
- modelagem de banco de dados relacional
- Spring Boot
- Spring Data JPA
- Spring Security
- criptografia de senhas com BCrypt
- arquitetura em camadas
- integração entre front-end e back-end
- versionamento com Git e GitHub

---

# Tecnologias utilizadas

## Back-end

- Java 21
- Spring Boot
- Spring Data JPA
- Spring Security
- Hibernate
- Maven

## Banco de Dados

- MySQL

## Front-end

- HTML5
- CSS3
- JavaScript
- Bootstrap 5

## Ferramentas

- VS Code
- Git
- GitHub
- Postman
- MySQL Workbench

---

# Funcionalidades Implementadas

## Usuários

- Cadastro de usuários
- Listagem de usuários
- Senhas criptografadas com BCrypt

## Autenticação

- Login por e-mail e senha
- Validação de credenciais
- Resposta estruturada utilizando DTOs

## Postagens

- Criação de postagens
- Listagem de postagens

## Comentários

- Criação de comentários
- Listagem de comentários

## Curtidas

- Registro de curtidas
- Listagem de curtidas

---

# Arquitetura Atual do Projeto

```text
src/main/java/com/redesocial/social
│
├── config
│   └── SecurityConfig.java
│
├── controller
│   ├── AuthController.java
│   ├── UsuarioController.java
│   ├── PostagemController.java
│   ├── ComentarioController.java
│   └── CurtidaController.java
│
├── dto
│   ├── LoginRequest.java
│   └── LoginResponse.java
│
├── service
│   ├── AuthService.java
│   └── UsuarioService.java
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
```

---

# Arquitetura em Camadas

O projeto está sendo organizado utilizando o padrão:

```text
Controller
↓
Service
↓
Repository
↓
Banco de Dados
```

### Controller

Responsável por receber requisições HTTP.

Exemplo:

```java
POST /usuarios
POST /auth/login
```

### Service

Responsável pelas regras de negócio.

Exemplos:

- criptografar senhas
- validar login
- processar informações antes de salvar

### Repository

Responsável pela comunicação com o banco de dados utilizando Spring Data JPA.

---

# Segurança

O projeto utiliza Spring Security para criptografia de senhas.

### BCrypt

As senhas dos usuários são armazenadas de forma segura utilizando:

```java
BCryptPasswordEncoder
```

Exemplo:

```text
Senha original:
123456

Senha armazenada:
$2a$10$...
```

Dessa forma nenhuma senha é salva em texto puro no banco de dados.

---

# Endpoints da API

## Usuários

### Criar usuário

```http
POST /usuarios
```

Exemplo:

```json
{
  "nome": "Gustavo",
  "email": "gustavo@email.com",
  "senha": "123456"
}
```

---

### Listar usuários

```http
GET /usuarios
```

---

## Autenticação

### Login

```http
POST /auth/login
```

Exemplo:

```json
{
  "email": "gustavo@email.com",
  "senha": "123456"
}
```

Resposta:

```json
{
  "mensagem": "Login realizado com sucesso",
  "email": "gustavo@email.com"
}
```

---

## Postagens

```http
GET  /postagens
POST /postagens
```

---

## Comentários

```http
GET  /comentarios
POST /comentarios
```

---

## Curtidas

```http
GET  /curtidas
POST /curtidas
```

---

# Banco de Dados

Criar o banco:

```sql
CREATE DATABASE social_db;
```

Configurar o arquivo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/social_db
spring.datasource.username=root
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

# Executando o Projeto

## Clonar o repositório

```bash
git clone https://github.com/ogustavonicolau/rede-social-java.git
```

## Entrar na pasta

```bash
cd rede-social-java
```

## Executar aplicação

```bash
./mvnw spring-boot:run
```

## Acessar

```text
http://localhost:8080
```

---

# Aprendizados

Durante o desenvolvimento deste projeto foram praticados conceitos como:

- APIs REST
- Spring Boot
- Spring Security
- BCrypt
- JPA/Hibernate
- DTOs
- Arquitetura em camadas
- MySQL
- Integração Front-end e Back-end
- Git e GitHub

---

# Próximas Melhorias

Planejadas para as próximas versões:

- JWT Authentication
- Proteção de rotas
- UsuarioResponse DTO
- PostagemService
- ComentarioService
- CurtidaService
- Edição de postagens
- Exclusão de postagens
- Upload de foto de perfil
- Feed mais moderno
- Deploy na nuvem

---

# Autor

**Gustavo de Oliveira Nicolau**

Projeto desenvolvido para fins de estudo, prática e composição de portfólio profissional em desenvolvimento Full Stack utilizando Java e Spring Boot.