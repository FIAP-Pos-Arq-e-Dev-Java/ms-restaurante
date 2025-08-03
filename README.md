# MS-Restaurante

## 📋 Descrição do Projeto

O **MS-Restaurante** é um microserviço desenvolvido em Java Spring Boot para gerenciamento de restaurantes, cardápios e tipos de cozinha. Este projeto foi desenvolvido como parte da pós-graduação em Arquitetura e Desenvolvimento Java da FIAP (Faculdade de Informática e Administração Paulista).

O sistema permite o cadastro, consulta, atualização e exclusão de restaurantes, itens de cardápio e tipos de cozinha, seguindo os princípios da Clean Architecture e boas práticas de desenvolvimento.

## 🏗️ Arquitetura

O projeto segue os princípios da **Clean Architecture**, organizando o código em camadas bem definidas:

### Estrutura de Camadas

```
src/main/java/com/fiap/ms/restaurante/
├── application/           # Camada de Aplicação
│   ├── gateways/         # Interfaces dos gateways
│   └── usecase/          # Casos de uso da aplicação
├── domain/               # Camada de Domínio
│   ├── domainService/    # Serviços de domínio
│   ├── exception/        # Exceções de domínio
│   ├── model/           # Modelos de domínio
│   └── rules/           # Regras de negócio
├── entrypoints/         # Camada de Interface
│   └── controllers/     # Controllers REST
├── infraestrutura/      # Camada de Infraestrutura
│   └── dataproviders/   # Provedores de dados
│       ├── config/      # Configurações
│       └── database/    # Implementações de banco de dados
```

### Principais Entidades

- **Restaurante**: Gerenciamento de restaurantes com informações como nome, endereço, horário de funcionamento e tipo de cozinha
- **ItemCardapio**: Gerenciamento de itens do cardápio com nome, descrição, preço e disponibilidade
- **TipoCozinha**: Categorização dos tipos de cozinha (italiana, brasileira, japonesa, etc.)

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.3**
- **Spring Security** (Autenticação JWT)
- **Spring Data JPA**
- **MySQL 8.0**
- **MapStruct** (Mapeamento de objetos)
- **SpringDoc OpenAPI** (Documentação da API)
- **Docker & Docker Compose**
- **Maven** (Gerenciamento de dependências)
- **JUnit 5** (Testes unitários)
- **Lombok** (Redução de boilerplate)

## 📦 Pré-requisitos

- Java 21+
- Maven 3.6+
- Docker e Docker Compose
- MySQL 8.0 (se executar localmente)

## 🛠️ Instalação e Execução

### Opção 1: Execução com Docker (Recomendado)

1. Clone o repositório:
```bash
git clone <repository-url>
cd ms-restaurante
```

2. Execute com Docker Compose:
```bash
docker-compose up --build
```

O serviço estará disponível em: `http://localhost:8081/ms-restaurante`

### Opção 2: Execução Local

1. Configure o banco MySQL:
```sql
CREATE DATABASE `db-tc-grupo8`;
CREATE USER 'adm123'@'localhost' IDENTIFIED BY 'adm123';
GRANT ALL PRIVILEGES ON `db-tc-grupo8`.* TO 'adm123'@'localhost';
```

2. Execute a aplicação:
```bash
mvn clean install
mvn spring-boot:run
```

## 📚 Documentação da API

### Swagger UI
A documentação interativa da API está disponível em:
- **Local**: `http://localhost:8081/ms-restaurante/swagger-ui.html`
- **Docker**: `http://localhost:8081/ms-restaurante/swagger-ui.html`

### Principais Endpoints

#### Restaurantes
- `GET /ms-restaurante/v1/restaurantes` - Buscar restaurantes
- `POST /ms-restaurante/v1/restaurantes` - Criar restaurante
- `PATCH /ms-restaurante/v1/restaurantes/{id}` - Atualizar restaurante
- `DELETE /ms-restaurante/v1/restaurantes/{id}` - Deletar restaurante
- `GET /ms-restaurante/v1/restaurantes/usuario/{usuarioId}/exists` - Verificar existência por usuário

#### Itens do Cardápio
- `GET /ms-restaurante/v1/item-cardapio` - Buscar itens do cardápio
- `POST /ms-restaurante/v1/item-cardapio` - Criar item do cardápio
- `PATCH /ms-restaurante/v1/item-cardapio/{id}` - Atualizar item do cardápio
- `DELETE /ms-restaurante/v1/item-cardapio/{id}` - Deletar item do cardápio

#### Tipos de Cozinha
- `GET /ms-restaurante/v1/tipo-cozinha` - Buscar tipos de cozinha
- `POST /ms-restaurante/v1/tipo-cozinha` - Criar tipo de cozinha
- `PATCH /ms-restaurante/v1/tipo-cozinha/{id}` - Atualizar tipo de cozinha
- `DELETE /ms-restaurante/v1/tipo-cozinha/{id}` - Deletar tipo de cozinha

## 🔐 Autenticação

O sistema utiliza **JWT (JSON Web Token)** para autenticação. Todas as requisições devem incluir o token JWT no header:

```
Authorization: Bearer <seu-jwt-token>
```

## 💾 Configuração do Banco de Dados

### Configurações Padrão
```properties
spring.datasource.url=jdbc:mysql://localhost/db-tc-grupo8?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=adm123
spring.datasource.password=adm123
spring.jpa.hibernate.ddl-auto=update
```

### Docker Compose
O arquivo `docker-compose.yml` já configura automaticamente:
- MySQL 8.0 na porta 3306
- Banco de dados: `db-tc-grupo8`
- Usuário: `adm123` / Senha: `adm123`

## 🧪 Testes

O projeto possui cobertura abrangente de testes unitários:

### Executar Testes
```bash
mvn test
```

### Estrutura de Testes
- **26 classes de teste** cobrindo todas as camadas
- Testes de **Use Cases**
- Testes de **Controllers**
- Testes de **Domain Services**
- Testes de **Data Providers**
- Testes de **Specifications**

### Categorias de Teste
- `src/test/java/com/fiap/ms/restaurante/application/usecase/` - Testes dos casos de uso
- `src/test/java/com/fiap/ms/restaurante/entrypoints/controllers/` - Testes dos controllers
- `src/test/java/com/fiap/ms/restaurante/domain/` - Testes do domínio
- `src/test/java/com/fiap/ms/restaurante/infraestrutura/` - Testes da infraestrutura

### Últimas Atualizações nos Testes
**Agosto 2025** - Implementação completa dos testes de especificação:
- **ItemCardapioSpecificationTest**: 10 casos de teste cobrindo filtros por nome e disponibilidade
- **RestauranteSpecificationTest**: 8 casos de teste cobrindo filtros por nome, usuário e horário
- **TipoCozinhaSpecificationTest**: 9 casos de teste cobrindo filtros por código e descrição

Estes testes garantem a robustez das funcionalidades de busca e filtro em todas as entidades principais do sistema.

## 🐳 Docker

### Dockerfile
O projeto utiliza build multi-stage:
- **Stage 1**: Build com Maven e Java 21
- **Stage 2**: Runtime com Alpine Java 21 JRE

### Docker Compose
Serviços configurados:
- **mysql**: Banco de dados MySQL 8.0
- **ms_restaurante**: Aplicação Spring Boot

## 📁 Estrutura do Projeto

```
ms-restaurante/
├── src/
│   ├── main/
│   │   ├── java/com/fiap/ms/restaurante/
│   │   │   ├── application/          # Casos de uso
│   │   │   ├── domain/              # Modelos e regras de negócio
│   │   │   ├── entrypoints/         # Controllers REST
│   │   │   └── infraestrutura/      # Configurações e dados
│   │   └── resources/
│   │       ├── application.properties
│   │       └── swagger-ui/          # Documentação OpenAPI
│   └── test/                        # Testes unitários
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md
```

## 🔧 Configurações Importantes

### Portas
- **Aplicação**: 8081
- **MySQL**: 3306

### Context Path
- Base URL: `/ms-restaurante`

### JWT Secret
Configurado em `application.properties` (altere em produção):
```properties
jwt.secret=DbqQrnCVpwdEsoU7YVUxiAOG1vajrqdp33jFk5abEFHTM8A7pyJzFWfrApt42gW8
```

## 🚀 Deploy

### Ambiente de Desenvolvimento
```bash
docker-compose up --build
```

### Ambiente de Produção
1. Altere as configurações de banco de dados
2. Configure um JWT secret seguro
3. Configure variáveis de ambiente apropriadas
4. Execute com perfil de produção

## 🤝 Contribuição

Este projeto foi desenvolvido como parte de um trabalho acadêmico da FIAP. Para contribuições:

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto foi desenvolvido para fins educacionais como parte da pós-graduação em Arquitetura e Desenvolvimento Java da FIAP.

## 👥 Equipe

Desenvolvido pelo **Grupo 8** da FIAP - Pós-graduação em Arquitetura e Desenvolvimento Java.

---

**Versão**: 1.0.0  
**Data de Atualização**: Agosto 2025