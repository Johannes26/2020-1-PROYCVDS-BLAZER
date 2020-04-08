CREATE TABLE Usuario(
id number(11) NOT NULL,
nombre varchar(10) NOT NULL,
apellido varchar(10) NOT NULL,
email varchar(20) NOT NULL,
telefono number(10),
tipo_usuario varchar(30) NOT NULL
contrasena varchar(30) NOT NULL
PRIMARY KEY (id));

CREATE TABLE Iniciativa(
numero number(11)NOT NULL,
descripción varchar(100)NOT NULL,
usuario_proponente number(11)NOT NULL,
palabras_clave varchar(100) NOT NULL,
PRIMARY KEY (numero));
KEY 'fk_INICIATIVA_USUARIO'('usuario_proponente'),
CONSTRAINT 'fk_INICIATIVA_USUARIO' FOREIGN KEY ('usuario_proponente')
REFERENCES 'Usuario' ('id') ON DELETE NO ACTION ON UPDATE NO ACTION
)