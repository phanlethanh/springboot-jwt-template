# springboot-jwt-template
REST API project with Json Web Token.

This template is personalized from:
* https://github.com/nydiarra/springboot-jwt 
* [Secure a Spring Boot REST API With JSON Web Token + Reference to Angular Integration](https://medium.com/@nydiarra/secure-a-spring-boot-rest-api-with-json-web-token-reference-to-angular-integration-e57a25806c50)

Using stack:
* Springboot 2.0.4
* PostgreSQL database
* Lombok plugin

### Setup instruction
Required: Java JDK 1.8 and PostgreSQL 10 server in localhost

1. Execute scripts of *db* folder in PostgreSQL to create sample database
2. To run application in IDE: `SpringbootJwtApplication.java`
3. To run application by maven: `mvn springboot:run`
4. To build JAR package: `mvn clean package`

### Obtain JWT token

**POST** http://localhost:8080/oauth/token

**HEADER**
* Authorization: Basic dGVzdGp3dGNsaWVudGlkOlhZN2ttem9OemwxMDA=
* Content-Type: application/x-www-form-urlencoded

**BODY**
* grant_type: password
* username: admin
* password: jwtpass

**RESPONSE**
```json
{
    "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoicGhhbmxldGhhbmg5M0BnbWFpbC5jb20iLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNTM5NjQ4NzAyLCJhdXRob3JpdGllcyI6WyJBRE1JTiIsIk1FTUJFUiJdLCJqdGkiOiIxNzVmMjM4NS0zMTA2LTQzZjctYTExYy0xZWEwZDRlMjI3OWMiLCJjbGllbnRfaWQiOiJ0ZXN0and0Y2xpZW50aWQifQ.w0cBqB0GIA8pnk9kAR3Xz41G3YGK5EZlb5MVK05mbH8",
    "token_type": "bearer",
    "expires_in": 43199,
    "scope": "read write",
    "jti": "175f2385-3106-43f7-a11c-1ea0d4e2279c"
}
```

### Test API with access token

**POST** http://localhost:8080/v1/user

**HEADER**
* Authorization: Bearer <access_token>
* Content-Type: application/json

**BODY**
```json
{
    "username": "thanhpl"
}
```
