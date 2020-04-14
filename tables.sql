CREATE TABLE USUARIO (
id int NOT NULL,
nombre varchar(10) NOT NULL,
apellido varchar(10) NOT NULL,
email varchar(50) NOT NULL,
telefono int,
tipoUsuario varchar(30) NOT NULL,
contrasena varchar(30) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE INICIATIVA (
num int NOT NULL,
descripcion varchar(20) NOT NULL,
usuarioproponente int NOT NULL,
palabrasclave varchar(20) NOT NULL,
PRIMARY KEY(num),
FOREIGN KEY (usuarioproponente)
REFERENCES USUARIO (id) 
);


insert into USUARIO (id,nombre,apellido,email,telefono,tipoUsuario,contrasena) values (2158130,'Johann','Bogota','johann.bogota@mail.escuelaing.edu.co',123444,'administrador','1234');