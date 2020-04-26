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

CREATE TABLE PALABRASCLAVE(
id SERIAL,
descripcion varchar(20) NOT NULL,
PRIMARY KEY(id)
);

CREATE TABLE INICIATIVA (
num SERIAL,
descripcion varchar(100) NOT NULL,
usuarioProponente int NOT NULL,
fechaRegistro DATE DEFAULT now(),
estado varchar(30) DEFAULT 'En espera de revision',
areaProponente varchar(30) NOT NULL,
PRIMARY KEY(num),
FOREIGN KEY (usuarioproponente)
REFERENCES USUARIO (id)
);

CREATE TABLE INICIATIVAPALABRA(
id SERIAL,
idIniciativa int,
idPalabraClave int,
PRIMARY KEY(id),
FOREIGN KEY (idIniciativa)
REFERENCES INICIATIVA (num),
FOREIGN KEY (idPalabraClave)
REFERENCES PALABRASCLAVE (id)
);

CREATE TABLE VOTO(
idUsuario int,
numIniciativa int,
PRIMARY KEY (idUsuario, numIniciativa),
FOREIGN KEY (idUsuario) 
REFERENCES USUARIO(id),
FOREIGN KEY (numIniciativa) 
REFERENCES INICIATIVA(num)
);


CREATE TABLE COMENTARIO(
idComentario int,
descripcion varchar(100) NOT NULL,
FechaDeRegistro DATE DEFAULT now(),
numIniciativa int NOT NULL,
usuario int NOT NULL,
PRIMARY KEY (idComentario),
FOREIGN KEY (usuario) 
REFERENCES USUARIO(id),
FOREIGN KEY (numIniciativa) 
REFERENCES INICIATIVA(num),
);



insert into USUARIO (id,nombre,apellido,email,telefono,tipoUsuario,contrasena) values (2157826,'Johan','Guerrero','johan.Guerrero@mail.escuelaing.edu.co',314021111,'Proponente','0000');
insert into USUARIO (id,nombre,apellido,email,telefono,tipoUsuario,contrasena) values (2158130,'Johann','Bogota','johann.bogota@mail.escuelaing.edu.co',123444,'Administrador','1234');
insert into INICIATIVA (descripcion,usuarioproponente,areaProponente) values ('descripcion iniciativa',2158130,'Administrador');

