```md
# Configurando um Client Confidential no Keycloak 24.0.1 para Autenticação `client_credentials`

## 📌 1️⃣ Subindo o Keycloak via Docker
Se ainda não tem o Keycloak rodando, use este comando:

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

## 📌 2️⃣ Criando um Client Confidential

1. **Acesse o Keycloak** e entre no **Realm "master"** (ou crie um novo).
2. Vá em **Clients → Create Client**.
3. Configure as opções:
    - **Client ID**: `my-confidential-client`
    - **Client Type**: OpenID Connect
    - **Authentication Flow**: `client credentials` ✅
    - **Access Type**: `confidential`
    - **Root URL**: Deixe vazio ou configure conforme necessário.
4. Clique em **Save**.

Agora, vá até a aba **Credentials** e copie o **Client Secret**, pois precisaremos dele.

---

## 📌 3️⃣ Configurando as Permissões do Client

1. Vá até a aba **Settings** do client `my-confidential-client`.
2. Marque **Service Accounts Enabled** ✅.
3. Em **Authorization**, selecione `Standard Flow` ❌ (desativado) e `Client Credentials` ✅ (ativado).
4. Vá até a aba **Service Account Roles**.
5. Clique em **Assign Role** e adicione o papel desejado, como `realm-management → view-users`.
6. Salve as configurações.

---

## 📌 4️⃣ Obtendo um Token via `client_credentials`
Agora podemos obter um token usando `curl`:

```bash
curl -X POST "http://localhost:8080/realms/master/protocol/openid-connect/token" \
     -H "Content-Type: application/x-www-form-urlencoded" \
     -d "grant_type=client_credentials" \
     -d "client_id=my-confidential-client" \
     -d "client_secret=SEU_CLIENT_SECRET"
```

Se tudo estiver certo, a resposta será algo assim:

```json
{
  "access_token": "eyJhbGciOiJIUzI1NiIsInR...",
  "expires_in": 300,
  "token_type": "Bearer",
  "scope": "profile email"
}
```

---

## 📌 5️⃣ Testando um Endpoint Protegido
Agora podemos usar o token para acessar um endpoint protegido:

```bash
curl -X GET "http://localhost:8081/protected-endpoint" \
     -H "Authorization: Bearer SEU_ACCESS_TOKEN"
```

Se o token for válido, você receberá a resposta esperada. 🚀

---

Agora seu **Client Confidential** está configurado para `client_credentials` no Keycloak 24.0.1!  
Caso precise de ajustes, me avise. 🚀🔥
```

