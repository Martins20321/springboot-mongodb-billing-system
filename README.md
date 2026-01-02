# 🎓 Projeto: Sistema de Gestão de Cobranças e Pagamentos

##  Visão Geral do Projeto
Este projeto consiste em uma **API RESTful desenvolvida com Spring Boot 3 e MongoDB**, voltada para a **gestão de cobranças e pagamentos**.  
O sistema permite o cadastro de clientes, criação de cobranças e registro de pagamentos, explorando conceitos fundamentais de **modelagem NoSQL orientada a documentos**.

O objetivo principal é consolidar conhecimentos sobre **MongoDB**, boas práticas de **arquitetura em camadas**, **DTOs**, regras de negócio e construção de APIs REST modernas.

Este é um **projeto de estudo prático**, desenvolvido para aprofundar a compreensão do paradigma NoSQL e sua aplicação em sistemas reais de cobrança.

---

## 🎯 Objetivos do Projeto
- Compreender as diferenças entre bancos de dados relacionais e os não relacionais(orientado a documentos).
- Aplicar modelagem NoSQL utilizando documentos aninhados e referências.
- Implementar operações completas de **CRUD**.
- Separar responsabilidades utilizando arquitetura em camadas.
- Aplicar o padrão **DTO (Data Transfer Object)**.
- Desenvolver regras de negócio para cobranças e pagamentos.
- Implementar tratamento global de exceções em APIs REST.

---

## 📖 Principais Conceitos Aplicados

### 🗂️ Modelagem de Domínio NoSQL
- **Documentos e Coleções**  
  Utilização de `@Document` e `@Id` para mapear entidades no MongoDB.

- **Objetos Aninhados**  
  Pagamentos são modelados como documentos aninhados dentro de cobranças, refletindo melhor o conceito de agregados.

- **Referências entre Documentos**  
  Uso de referências para relacionar clientes e cobranças de forma clara e organizada.

- **Enums de Domínio**  
  Estados e tipos são representados por enums, como:
  - `ChargeStatus`
  - `PaymentStatus`
  - `PaymentMethod`

---

### 🧱 Arquitetura em Camadas
O projeto segue uma arquitetura bem definida:

- **Resources (Controllers)**  
  Exposição dos endpoints REST.

- **Services**  
  Camada responsável pelas regras de negócio.

- **Repositories**  
  Acesso aos dados utilizando Spring Data MongoDB.

- **Domain**  
  Entidades de domínio e enums.

- **DTOs**  
  Objetos responsáveis pela transferência segura e otimizada de dados.

---

## 🛠️ Tecnologias Utilizadas

| Categoria        | Tecnologia              | Descrição |
|------------------|-------------------------|----------|
| Framework        | Spring Boot 3           | Desenvolvimento de APIs REST |
| Linguagem        | Java                    | Linguagem base do projeto |
| Banco de Dados   | MongoDB                 | Banco de dados NoSQL |
| Persistência     | Spring Data MongoDB     | Abstração de acesso a dados |
| Build Tool       | Maven                   | Gerenciamento de dependências |
| Testes           | Postman                 | Testes dos endpoints REST |
| Ferramenta BD    | MongoDB Compass         | Visualização e gestão dos dados |

---

## 🛡️ Tratamento de Exceções
O projeto utiliza um `ResourceExceptionHandler` (via `@ControllerAdvice`) para interceptar exceções e retornar respostas HTTP padronizadas:
* **ObjectNotFoundException**: Retorna status **404 Not Found** quando um recurso não é encontrado por ID.

---

## ⚙️ Como Executar o Projeto Localmente

1. **Pré-requisitos**: Certifique-se de ter o **JDK** e o **Maven** instalados, além do **MongoDB** rodando localmente.
2. **Configuração**: Em `application.properties`, configure a URI de conexão:  
   `spring.data.mongodb.uri=mongodb://localhost:27017/billing_mongo`.
3. **Carga Inicial**: O projeto possui uma classe de configuração `Instantiation` que popula o banco automaticamente com dados de teste ao iniciar.
4. **Execução**: Execute a classe principal da aplicação e acesse os endpoints via `http://localhost:8080`.
