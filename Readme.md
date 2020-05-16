# Blazer App
## Proyecto CVDS (Ciclos de Vida y Desarrollo de Software) - 2020-1.


### Integrantes:
1. Esteban Bernal (Team)
2. Johann Bogota (Scrum master)
3. Johan Guerrero (Team)
4. Daniel Vargas (Team)

### Profesores:
1. Julian Velasco (Product Owner) 
2. Oscar Ospina (Product Owner)

# Despcripción del producto

1. Descripción General:

Se presenta la aplicación BlazerApp para un banco de iniciativas de la Escuela Colombiana de Ingenieria Julio Garavito donde todos los miembros de la comunidad pueden participar activamente presentando sus ideas respecto a las iniciativas que se tengan para los diferentes proyectos. Esta aplicación busca facilitar el registro y control de ideas que mejoren la participación de la universidad.

2. Manual de Usuario:

Lo primero que deben hacer todos los usuarios es ingresar con su usuario y contraseña.

![Inicio de Sesion](https://user-images.githubusercontent.com/54051399/82111107-2be23900-9708-11ea-86f4-6a79cf658561.PNG)

Para esta aplicación utilizamos 4 usuarios:
- Publico
- Administrador
- PMO
- Proponente

### Para todos los usuarios:

Los usuarios tienen la capacidad de consultar las iniciativas registradas, ademas si tienen algun interes en cierta iniciativa puede dar like o agaregar su comentario respecto a esta, por otro lado tambien podran consultar los comentarios que hayan registrado otros usuarios para cada iniciativa.

![Consultar Iniciativas](https://user-images.githubusercontent.com/54051399/82111146-9f844600-9708-11ea-80ea-86aa9af304ff.PNG)

![Agregar Comentarios por iniciativa](https://user-images.githubusercontent.com/54051399/82111357-546b3280-970a-11ea-8c61-b0fd72202d08.PNG)

Podra consultar las palabras clave de cada iniciativa.

![Consultar las palabras clave de cada iniciativa](https://user-images.githubusercontent.com/54051399/82111253-9647a900-9709-11ea-8059-c786248476ac.PNG)

Podra consultar las iniciativas relacionadas de cada iniciativa.

![Consultar las iniciativas agrupadas](https://user-images.githubusercontent.com/54051399/82111283-cbec9200-9709-11ea-812d-ced5951aa7f7.PNG)

Si desea hacer un filtro, tendra dos opciones, consultar iniciativas por palabra clave o por estado.

![Consultar Iniciativas por palabra](https://user-images.githubusercontent.com/54051399/82111307-0ce4a680-970a-11ea-8e4f-31b5e7b25c29.PNG)

![Consultar Iniciativas por estado](https://user-images.githubusercontent.com/54051399/82111310-153ce180-970a-11ea-849b-f6ad022568f8.PNG)

Y por ultimo podran consultar las estadisticas de las iniciativas.

![Consultar Estadisticas](https://user-images.githubusercontent.com/54051399/82111536-9f397a00-970b-11ea-8009-bd17eef90bbb.PNG)

### Para usuarios Administrador y PMO:

En este caso, estos usuarios tendran el acceso a modificar los estados de las inicitivas.

![Cambiar estado a las iniciativas](https://user-images.githubusercontent.com/54051399/82111393-98f6ce00-970a-11ea-82f7-02b0782c2aa1.PNG)

### Para Administrador:

El administrador puede consultar los usuarios registrados en nuestra base de datos y definir los roles de cada uno.

![ConsultarUsuarios Admin](https://user-images.githubusercontent.com/54051399/82111761-eecc7580-970c-11ea-9a63-7081151b5b99.PNG)

![Cambiar Rol de los usuarios](https://user-images.githubusercontent.com/54051399/82111440-f723b100-970a-11ea-9a6b-9ac42d2c7a79.PNG)

Por otro lado podra agrupar iniciativas que tengan cierta relación.

![Agrupar Iniciativas](https://user-images.githubusercontent.com/54051399/82111735-ccd2f300-970c-11ea-95da-c1d0bfdfa379.PNG)

### Para Proponente:

El usuario proponente podra insertar iniciativas de cualquier tema que el desee, igualmente podra agregar las palabaras clave relacionadas a esta separadas por comas, igualmente podra consultar y estar al pendiente de todo lo que ocurra con sus iniciativas registradas.

![Agregar Iniciativa](https://user-images.githubusercontent.com/54051399/82111603-02c3a780-970c-11ea-8e7a-890af4861ffd.PNG)

![Consultar Mis iniciativas](https://user-images.githubusercontent.com/54051399/82111681-7665b480-970c-11ea-8530-4550cc1c85bf.PNG)

Tambien podra modificar la descripcion de cualquier iniciativa que este en espera de revisión. 

![Modificar iniciativa](https://user-images.githubusercontent.com/54051399/82111658-50d8ab00-970c-11ea-98ef-7611cb367cb4.PNG)

# Arquitectura y diseño

### Modelo de Entidad-Relacion

![Modelo de clases](https://user-images.githubusercontent.com/54051399/82111801-276c4f00-970d-11ea-805e-ff010f302a52.PNG)

### Modelo de capas

![Diagrama](https://user-images.githubusercontent.com/54051399/82111870-8af67c80-970d-11ea-92b2-4e9df989c5b0.PNG)

### Tecnologias utilizadas

- PrimeFaces
- Java
- MyBatis
- Guice
- Maven
- PostgresSQL (Squirrel)
- xhtml
- xml
- github

### Enlace de la aplicación en Heroku

[![Heroku](https://heroku-badge.herokuapp.com/?app=heroku-badge)](https://proyecto-cvds-blazer.herokuapp.com)

### Enlace al sistema de integración continua y calidad de codigo

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/c42353620eed40daaf4102f82214411e)](https://app.codacy.com/manual/Johannes26/2020-1-PROYCVDS-BLAZER/dashboard)

[![CircleCI](https://circleci.com/gh/PDSW-ECI/base-proyectos.svg?style=svg)](https://app.circleci.com/pipelines/github/Johannes26/2020-1-PROYCVDS-BLAZER/39/workflows/9a2f6975-9421-4d64-b83d-07fb3241ea42/jobs/39)

# Descripcion del proceso

La metodología que se utilizo para este proyecto fue SCRUM, que se basa en trabajar colaborativamente en equipo y obtener el mejor resultado posible en el proyecto, se realiza con entrega parciales semana a semana, estos ciclos llevan el nombre de sprint los cuales contienen una lista de tareas con su priorización y su desarrollador.

### Enlace a taiga 

[Taiga](https://tree.taiga.io/project/johann99-plataforma-banco-de-iniciativas-de-proyectos/backlog)

### Sprint 1

![Sprint1](https://user-images.githubusercontent.com/54051399/82112106-787d4280-970f-11ea-89c4-fc6e840402c5.PNG)

Este sprint fue con el cual tuvimos más problemas gracias a que estabamos en el proceso de aprendizaje de la conexión con la base de datos PostgresSQL, para este sprint faltaron completar algunas tareas, pero se completaron por completo para el siguiente sprint.

[Sprint1 Burndown chart](https://tree.taiga.io/project/johann99-plataforma-banco-de-iniciativas-de-proyectos/taskboard/sprint1-2405)

### Sprint 2

![Sprint2](https://user-images.githubusercontent.com/54051399/82112195-4f10e680-9710-11ea-8edd-74c8fb43b1f6.PNG)

El avance fue mayor, semana a semana se tuvo un progreso de manera concisa y cada uno de los miembros trabajo equitativamente, para este sprint faltaron completar algunas tareas, pero se completaron por completo para el siguiente sprint.

[Sprint2 Burndown chart](https://tree.taiga.io/project/johann99-plataforma-banco-de-iniciativas-de-proyectos/taskboard/sprint-2-9318)

### Sprint 3

![Sprint3](https://user-images.githubusercontent.com/54051399/82112203-6e0f7880-9710-11ea-83a0-c882eb6ac98f.PNG)

Se finalizo el proyecto despues tiempo despues de la finalización del sprint, pero se muestra completo y funcionando a la perfección gracias al trabajo de todos los integrantes.

[Sprint3 Burndown chart](https://tree.taiga.io/project/johann99-plataforma-banco-de-iniciativas-de-proyectos/taskboard/sprint-3-6249)
