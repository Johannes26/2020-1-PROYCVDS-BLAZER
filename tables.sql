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
num int GENERATED ALWAYS AS IDENTITY,
descripcion varchar(100) NOT NULL,
usuarioproponente int,
palabrasclave varchar(20) NOT NULL,
fechaRegistro DATE DEFAULT now(),
estado varchar(30) DEFAULT 'En espera de revisión',
areaProponente varchar(30) NOT NULL,
PRIMARY KEY(num),
FOREIGN KEY (usuarioproponente)
REFERENCES USUARIO (id)
);


insert into USUARIO (id,nombre,apellido,email,telefono,tipoUsuario,contrasena) values (2158130,'Johann','Bogota','johann.bogota@mail.escuelaing.edu.co',123444,'administrador','1234');
insert into USUARIO (id,nombre,apellido,email,telefono,tipoUsuario,contrasena) values (2157826,'Johan','Guerrero','johan.Guerrero@mail.escuelaing.edu.co',314021111,'usuario de consulta','0000');
insert into INICIATIVA (descripcion,usuarioproponente,palabrasclave,areaProponente) values ('descripcion iniciativa',2158130,'palabras clave ini','Administrador');

