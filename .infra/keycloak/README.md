```md
# Configurando Spring Security com Keycloak no Spring Boot 3.4.4

## 1️⃣ Subindo o Keycloak (Docker)
Se ainda não tem o Keycloak rodando, use este comando Docker:

```bash
docker run -d --name keycloak \
  -p 8080:8080 \
  -e KEYCLOAK_ADMIN=admin \
  -e KEYCLOAK_ADMIN_PASSWORD=admin \
  quay.io/keycloak/keycloak:24.0.1 \
  start-dev
```
Acesse: [http://localhost:8080](http://localhost:8080)  
Usuário: `admin`  
Senha: `admin`

---

## 2️⃣ Criando um Cliente no Keycloak
1. Acesse o **Keycloak** e entre no **Realm "master"** (ou crie outro).
2. Vá em **Clients → Create Client**:
    - **Client ID**: `spring-app`
    - **Client Type**: OpenID Connect
    - **Root URL**: `http://localhost:8081`
3. **Salvar e Configurar:**
    - **Authentication Flow**: `standard flow` ✅
    - **Access Type**: `confidential`
    - **Valid Redirect URIs**: `http://localhost:8081/*`

---

## 3️⃣ Adicionando Dependências ao `pom.xml`
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-oauth2-resource-server</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

---

## 4️⃣ Configurando o `application.yml`
```yaml
server:
  port: 8081

spring:
  security:
    oauth2:
      resourceserver:
        jwt:
          issuer-uri: http://localhost:8080/realms/master
```

---

## 5️⃣ Configurando o `SecurityConfig.java`
Crie essa classe para habilitar a autenticação JWT:

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/public").permitAll()
                .anyRequest().authenticated()
            )
            .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())))
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

    private JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        grantedAuthoritiesConverter.setAuthoritiesClaimName("realm_access.roles");
        grantedAuthoritiesConverter.setAuthorityPrefix("ROLE_");

        JwtAuthenticationConverter jwtConverter = new JwtAuthenticationConverter();
        jwtConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
        return jwtConverter;
    }
}
```

---


---

## 7️⃣ Obtendo um Access Token via cURL
Para gerar um **Access Token** para o client `spring-app`, use o seguinte comando:

```bash
curl -X POST "http://localhost:8080/realms/master/protocol/openid-connect/token" \
     -H "Content-Type: application/x-www-form-urlencoded" \
     -d "client_id=spring-app" \
     -d "grant_type=password" \
     -d "username=seu_usuario" \
     -d "password=sua_senha"
```

Exemplo de resposta:
```json
{
  "access_token": "eyJhbGciOiJIUz...",
  "expires_in": 300,
  "refresh_token": "eyJhbGciOiJIUz...",
  "refresh_expires_in": 1800,
  "token_type": "Bearer",
  "not-before-policy": 0,
  "session_state": "12345678-1234-1234-1234-123456789abc",
  "scope": "profile email"
}
```

---

## 🚀 Testando a Segurança
1. **Acesse o endpoint público**:
   ```bash
   curl -X GET http://localhost:8081/public
   ```
   ✅ Deve responder normalmente.

2. **Acesse um endpoint protegido (sem token)**:
   ```bash
   curl -X GET http://localhost:8081/private
   ```
   ❌ Deve retornar `401 Unauthorized`.

3. **Chamar o endpoint com Token**:
   ```bash
   curl -X GET "http://localhost:8081/private" \
        -H "Authorization: Bearer SEU_ACCESS_TOKEN_AQUI"
   ```

Se o token for válido, o servidor responderá normalmente.  
Me avise se precisar de mais detalhes! 🚀
```

