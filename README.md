# Prueba Tecnica/ consumo API MARVEL

## Descripción

Este es un proyecto de ejemplo desarrollado con Spring Boot. Desarrolado en Spring Boot
el cual hace uso de la API publica de Marvel https://developer.marvel.com/

## Características
- [ ] Se Implemento Spring Security 6 con JWT 
- [ ] Cosume la API publica de Marvel
- [ ] Hace uso de roles de usuario ADMIN y USER para acceder a determinadas rutas/endpoints



## Tecnologías Utilizadas
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- Spring Security 6
- JWT
- REST Template
- MySQL
- Maven

## Requisitos
- JDK 21 o superior
- Maven 4.0.0 
- MySQL Server 

## Configuración del Proyecto
1. Clona este repositorio: `git clone https://github.com/ManuelDuran95/MarvelAPI_pruebatecnica`
2. Importa el proyecto en al IDE favorito(Se sugiere el uso de IntelliJ IDEA).
3. Configura la conexión a la base de datos en el archivo `application.properties`.
4. Ejecuta la aplicación: `mvn spring-boot:run` o ejecutar desde el IDE.



1. Base de datos
CREATE DATABASE marv001;
2. registrar un usuario
   http://localhost:8082/register
payload
   {
   "firstName":"Usuario Nombre",
   "lastName":"Usuario Apellido",
   "username":"usuariotest01",
   "password":"123456"
}
3. Agregar token en el header

para crear usuario ADMIN
registrar usuario normal
y luego ejecutar

UPDATE dbname.users  SET role = 'ADMIN' WHERE id = userID;


Exportar la configuracion de PostMan con el archivo export_postman.json


