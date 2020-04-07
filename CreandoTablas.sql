CREATE TABLE Usuario(
id number(11) NOT NULL,
nombre varchar(10) NOT NULL,
apellido varchar(10) NOT NULL,
email varchar(20) NOT NULL,
telefono number(10),
tipo_usuario varchar(30) NOT NULL
PRIMARY KEY (id));

CREATE TABLE Iniciativa(
Num number(11)NOT NULL,
descripción varchar(100)NOT NULL,
usuario_proponente number(11)NOT NULL,
tipo_proponente varchar(30)NOT NULL,
palabras_clave varchar(100) NOT NULL,
PRIMARY KEY (Num));