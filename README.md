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
Required: Java JDK and PostgreSQL server in localhost

1. Execute scripts in *db* folder in PostgreSQL to create sample database
2. To run application in IDE: `SpringbootJwtApplication.java`
3. To run application by maven: `mvn springboot:run`
4. To build JAR package, run: `mvn clean package`

### Obtain JWT token
```
POST: http://localhost:8080/oauth/token

HEADER:
Authorization: Basic dGVzdGp3dGNsaWVudGlkOlhZN2ttem9OemwxMDA=
Content-Type: application/x-www-form-urlencoded

BODY:
grant_type: password
username: admin
password: jwtpass
```

### Test API with access token
```
POST: http://localhost:8080/v1/user

HEADER:
Authorization: Bearer <access_token>
Content-Type: application/json

BODY:
{
	"username": "thanhpl"
}
```
