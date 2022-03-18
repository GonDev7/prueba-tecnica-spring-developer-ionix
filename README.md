# IONIX reto prueba técnica sprinboot

## Servicio desarrollado con springboot

### modo de ejecución

- Clone el repositorio en: https://github.com/GonDev7/prueba-tecnica-spring-developer-ionix.git
- Dirijase a la carpeta del proyecto
- Ejecute el comando docker-compose up para levantar los servicios de bases de datos
- Ejecute el comando 'mvn spring-boot:run' para ejecutar proyecto

Se levantaran 2 servicios

- Base de datos mysql: `http://localhost:3306`
- Interfaz web adminer: `http://localhost:8080`

Servicios rest

- Crear usuario (POST): `http://localhost:3000/api/user/create`
- Listar usuarios (GET): `http://localhost:3000/api/users`
- Buscar usuario por email (GET): `http://localhost:3000/api/find-user/(email)`
- Encriptar texto (POST): `http://localhost:3000/api/parameter-encryption`
