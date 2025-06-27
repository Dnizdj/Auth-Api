# 🚀 API de Autenticação e Autorização JWT (AV2)

![Java](https://img.shields.io/badge/Java-17%2B-blue?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.3.x-green?style=for-the-badge&logo=spring)
![License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Concluído-brightgreen?style=for-the-badge)

---

## 📄 Sobre o Projeto

Este projeto é uma API RESTful completa desenvolvida como parte da avaliação AV2, com foco na implementação de um sistema robusto de *autenticação e autorização usando JSON Web Tokens (JWT)*.

A aplicação demonstra conceitos essenciais de desenvolvimento backend, incluindo segurança com Spring Security, persistência de dados com Spring Data JPA, documentação de API com Swagger/OpenAPI, monitoramento com Actuator e Prometheus, e containerização com Docker.

---

## ✨ Funcionalidades

* *Cadastro e Login de Usuários:* Endpoints públicos para registro e login.
* *Geração de Token JWT:* Após o login, um token JWT é gerado para autenticar as requisições futuras.
* *Controle de Acesso Baseado em Papéis (Roles):* Acesso diferenciado para usuários com permissões de ADMIN e USER.
* *Endpoints Protegidos:* Rotas CRUD que exigem autenticação e, em alguns casos, autorização específica.
* *Documentação Interativa:* Geração automática de documentação com Swagger UI para fácil visualização e teste dos endpoints.
* *Monitoramento de Métricas:* Exposição de métricas da aplicação (saúde, uso de memória, etc.) através do Spring Boot Actuator, prontas para serem consumidas pelo Prometheus.
* *Containerização:* Suporte a Docker para um deploy fácil e padronizado.

---

## 🛠️ Tecnologias Utilizadas

O projeto foi construído utilizando as seguintes tecnologias:

| Categoria                | Tecnologia                                           |
| ------------------------ | ---------------------------------------------------- |
| *Backend* | Java 17, Spring Boot 3, Maven                  |
| *Banco de Dados* | Spring Data JPA, H2 Database (em memória)        |
| *Segurança* | Spring Security, JWT, Spring OAuth2 Resource Server |
| *Testes* | JUnit 5, Mockito, JMeter (Carga)               |
| *Documentação* | Springdoc OpenAPI (Swagger)                        |
| *Monitoramento* | Spring Boot Actuator, Prometheus                 |
| *DevOps* | Docker                                             |

---

## 🚀 Como Executar o Projeto

Siga os passos abaixo para executar a aplicação localmente.

### Pré-requisitos

* *JDK 17 ou superior* ([Download](https://www.oracle.com/java/technologies/downloads/))
* *Maven* ([Download](https://maven.apache.org/download.cgi))
* *Docker* (Opcional, para execução em container) ([Download](https://www.docker.com/products/docker-desktop/))

### 1. Clonando o Repositório

bash
git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)
cd seu-repositorio


### 2. Executando a Aplicação

Você pode executar a API de duas maneiras:

#### Método A: Via Maven Wrapper

Esta é a forma mais simples e não requer instalação do Maven (ele baixa a versão correta automaticamente).


#### Método B: Via Docker

Esta forma garante que a aplicação rode em um ambiente isolado e padronizado.

bash
# 1. Empacote a aplicação em um arquivo .jar
./mvnw clean package

# 2. Construa a imagem Docker
docker build -t auth-api .

# 3. Rode o container
docker run -p 8080:8080 auth-api


### 3. Acessando a Aplicação

Após iniciar, a API estará disponível em http://localhost:8080.

---

## 📖 Documentação da API (Endpoints)

Para testar os endpoints protegidos, primeiro utilize a rota POST /auth/login para obter um token. Em seguida, clique no botão *"Authorize"* no topo da página do Swagger e cole o token no formato Bearer <seu_token>.

### Endpoints Principais

| Método HTTP | Endpoint           | Descrição                                 | Necessita Autenticação? | Permissão Mínima |
| :---------- | :----------------- | :---------------------------------------- | :---------------------- | :--------------- |
| POST      | /auth/register   | Registra um novo usuário.                 | ❌ Não                  | -                |
| POST      | /auth/login      | Autentica um usuário e retorna um token JWT. | ❌ Não                  | -                |
| GET       | /product         | Exibe uma lista de produtos.              | ✅ Sim                  | USER           |
| POST      | /product         | Cria um novo produto.                     | ✅ Sim                  | ADMIN          |

---

## 🩺 Monitoramento

A aplicação expõe endpoints do Actuator para monitoramento:

* *Saúde da Aplicação:* http://localhost:8080/actuator/health
* *Métricas para Prometheus:* http://localhost:8080/actuator/prometheus

Essas métricas podem ser coletadas por um servidor Prometheus e visualizadas em dashboards no Grafana.
