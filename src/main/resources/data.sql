DROP TABLE IF EXISTS tbl_student;
CREATE TABLE tbl_student (
id INT AUTO_INCREMENT  PRIMARY KEY,
careers VARCHAR(150) NOT NULL,
dni VARCHAR(8) NOT NULL,
name VARCHAR(150) NOT NULL,
institute VARCHAR(150) NOT NULL,
lastname VARCHAR(150) NOT NULL,
status VARCHAR(20) NOT NULL
);

INSERT INTO tbl_student (careers, dni,name,institute,lastname,status) VALUES ('Agronomia','11253698','Pablo','Valle Grande','Perez','Aprobado');
INSERT INTO tbl_student (careers, dni,name,institute,lastname,status) VALUES ('Contabilidad','15482630','Nicole','Cayetano','Vilchez','Desaprobado');
INSERT INTO tbl_student (careers, dni,name,institute,lastname,status) VALUES ('Sistemas','20153698','Alison','Taylor','Ramos','Aprobado');
INSERT INTO tbl_student (careers, dni,name,institute,lastname,status) VALUES ('Sistemas','75365805','Joseph','UTP','Florian','Aprobado');
