# 🏭 Sistema de Monitoramento de Máquinas

## 📌 Sobre o projeto

O Sistema de Monitoramento de Máquinas é uma aplicação Back-End desenvolvida em Java com Spring Boot, como parte da Aula 11 da disciplina de Desenvolvimento Back-End.

O projeto simula uma solução para a empresa fictícia **CloudTech Solutions**, permitindo cadastrar máquinas industriais, registrar informações de produção e consultar dados relacionados ao consumo de energia e à quantidade de peças produzidas.

A aplicação disponibiliza uma API REST que pode ser testada utilizando o Thunder Client.

## 🎯 Objetivo

Desenvolver uma API REST para realizar o monitoramento básico de máquinas industriais, utilizando os conceitos de desenvolvimento Back-End, arquitetura em camadas, persistência de dados e requisições HTTP.

## 🚀 Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- H2 Database
- Maven
- Thunder Client
- Visual Studio Code

## ⚙️ Funcionalidades

O sistema possui as seguintes funcionalidades:

- **RF01:** Cadastrar máquinas industriais.
- **RF02:** Registrar dados de produção e consumo de energia.
- **RF03:** Consultar máquinas cadastradas.
- **RF04:** Consultar registros e histórico de produção.
- **RF05:** Verificar se a aplicação está funcionando.
- Consultar informações da versão da aplicação.
- Exibir uma mensagem de boas-vindas.

## 📂 Estrutura do projeto

```text
monitoramento-maquinas/
│
├── src/
│   ├── main/
│   │   ├── java/com/senai/monitoramento_maquinas/
│   │   │   ├── controller/
│   │   │   │   ├── HomeController.java
│   │   │   │   ├── MaquinaController.java
│   │   │   │   ├── ProducaoController.java
│   │   │   │   └── StatusController.java
│   │   │   │
│   │   │   ├── models/
│   │   │   │   ├── Maquina.java
│   │   │   │   └── Producao.java
│   │   │   │
│   │   │   ├── repository/
│   │   │   │   ├── MaquinaRepository.java
│   │   │   │   └── ProducaoRepository.java
│   │   │   │
│   │   │   ├── service/
│   │   │   │   ├── MaquinaService.java
│   │   │   │   └── ProducaoService.java
│   │   │   │
│   │   │   └── MonitoramentoMaquinasApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│
├── .gitignore
├── pom.xml
└── README.md
```

## 🌐 Endpoints da API

A aplicação utiliza a porta `8080`.

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/` | Exibe a mensagem inicial |
| GET | `/status` | Verifica o status da aplicação |
| GET | `/versao` | Consulta a versão do sistema |
| GET | `/maquinas` | Lista todas as máquinas |
| GET | `/maquinas/{id}` | Consulta uma máquina pelo ID |
| POST | `/maquinas/cadastro` | Cadastra uma nova máquina |
| GET | `/producao` | Lista todos os registros de produção |
| GET | `/producao?maquinaId=1` | Consulta o histórico de uma máquina |
| POST | `/producao` | Registra dados de produção |

## 🏭 Exemplo de cadastro de máquina

**Requisição:**

`POST /maquinas/cadastro`

**JSON:**

```json
{
  "nome": "Máquina CNC 01",
  "tipo": "CNC",
  "setor": "Usinagem",
  "status": "em operação"
}
```

**Resposta esperada:**

```json
{
  "id": 1,
  "nome": "Máquina CNC 01",
  "tipo": "CNC",
  "setor": "Usinagem",
  "status": "em operação"
}
```

**Status HTTP:** `201 Created`

## ⚡ Exemplo de registro de produção

**Requisição:**

`POST /producao`

**JSON:**

```json
{
  "maquinaId": 1,
  "consumoKw": 12.5,
  "horarioAcionamento": "08:30",
  "pecasProduzidas": 150
}
```

O sistema associa o registro à máquina cadastrada e armazena os dados de produção.

**Status HTTP esperado:** `201 Created`

## 💻 Como executar o projeto

### Pré-requisitos

- JDK 21 ou superior compatível com o projeto
- Maven instalado
- Git, caso deseje clonar o repositório

### Passo 1 — Abrir o projeto

Abra a pasta `monitoramento-maquinas` no terminal.

### Passo 2 — Compilar

Execute:

```bash
mvn clean compile
```

### Passo 3 — Iniciar a aplicação

Execute:

```bash
mvn spring-boot:run
```

Após a inicialização, a API estará disponível em:

`http://localhost:8080`

### Passo 4 — Verificar o funcionamento

Acesse:

`http://localhost:8080/status`

**Resposta esperada:**

```json
{
  "status": "online",
  "mensagem": "Aplicação de monitoramento em execução"
}
```

## 🗄️ Banco de dados

O projeto utiliza o banco de dados **H2**, configurado para armazenar os dados localmente.

O Hibernate é responsável pelo gerenciamento das tabelas por meio do Spring Data JPA.

O console do H2 pode ser acessado em:

`http://localhost:8080/h2-console`

Configurações de conexão:

- **JDBC URL:** `jdbc:h2:file:./data/monitoramento`
- **Usuário:** `sa`
- **Senha:** em branco

O diretório `data/` está incluído no `.gitignore` para evitar o envio do banco local ao GitHub.

## 🧪 Testes realizados

Os endpoints principais foram testados manualmente utilizando o Thunder Client.

| Teste | Método | Resultado |
|---|---|---|
| Verificar status | GET | 200 OK |
| Cadastrar máquina | POST | 201 Created |
| Listar máquinas | GET | 200 OK |
| Registrar produção | POST | 201 Created |
| Consultar produção | GET | 200 OK |
| Consultar histórico por máquina | GET | 200 OK |
| Página inicial | GET | 200 OK |
| Consultar versão | GET | 200 OK |

Os testes demonstraram o funcionamento das principais funcionalidades da API.

## 📚 Contexto acadêmico

Projeto desenvolvido como atividade prática da **Aula 11 — Desenvolvimento Back-End**, com foco em Spring Boot, API REST, persistência de dados e testes de endpoints.

**Instituição:** SENAI

**Professor:** Me. Daniel Vieira

## 👨‍💻 Desenvolvedor

**Maycol Jhanpool Ticona Ticona**

Curso Superior de Tecnologia em Análise e Desenvolvimento de Sistemas (ADS).