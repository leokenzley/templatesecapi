# Java e Clean Architecture OpenAPI Swagger. 

## Tecnologias Utilizadas

- **Java**: 21
- **Spring Boot**: 3.4.4
- **Maven**: 3.11.0
- **Springdoc OpenAPI**: 1.7.0
- **Jakarta Validation API**: 3.0.2
- **Jakarta Servlet API**: 5.0.0
- **Jackson Databind**: 2.13.0
- **Hibernate Validator**: 8.0.0.Final
- **OpenAPI Generator Maven Plugin**: 6.6.0

## Como Executar a Aplicação

### Pré-requisitos

- **Java 21** deve estar instalado e configurado no seu `PATH`.
- **Maven 3.11.0** ou superior deve estar instalado.

### Passos para Executar

1. **Clone o repositório**:
    ```sh
    git clone [https://github.com/leokenzley/tempapiclearch.git](https://github.com/leokenzley/tempapiclearch.git)
    cd tempapiclearch
    ```

2. **Compile e execute os testes**:
    ```sh
    mvn clean install
    ```

3. **Execute a aplicação**:
    ```sh
    mvn spring-boot:run
    ```

4. **Acesse a aplicação**:
    - A aplicação estará disponível em `http://localhost:8080`.

### Documentação da API

- A documentação da API gerada pelo Springdoc OpenAPI pode ser acessada em `http://localhost:8080/swagger-ui.html`.

### Executando a aplicação.   
- execute o seguinte comando:
```sh
  docker run -d --name keycloak \
 -p 8080:8080 \
 -e KEYCLOAK_ADMIN=admin \
 -e KEYCLOAK_ADMIN_PASSWORD=admin \
 quay.io/keycloak/keycloak:24.0.1 \
 start-dev
 ```
- Acesse a aplicação em `http://localhost:8080` e faça login com as credenciais:
  - **Usuário**: `admin`
  - **Senha**: `admin`

### Gerando o architype desta aplicação
[Aqui](https://github.com/leokenzley/tempapiclearch/tree/main/.dev/architype)

## Referências

- [Documentação Oficial do Apache Maven](https://maven.apache.org/guides/index.html)
- [Guia de Referência do Spring Boot Maven Plugin](https://docs.spring.io/spring-boot/3.4.4/maven-plugin)
- [Criar uma imagem OCI](https://docs.spring.io/spring-boot/3.4.4/maven-plugin/build-image.html)
- [Spring Web](https://docs.spring.io/spring-boot/3.4.4/reference/web/servlet.html)
- [Construindo um Serviço Web RESTful](https://spring.io/guides/gs/rest-service/)
- [Servindo Conteúdo Web com Spring MVC](https://spring.io/guides/gs/serving-web-content/)
- [Construindo serviços REST com Spring](https://spring.io/guides/tutorials/rest/)

## Contato

- **Nome**: Leo Kenzley
- **Email**: leokenzley@gmail.com
- **GitHub**: [leokenzley](https://github.com/leokenzley)
