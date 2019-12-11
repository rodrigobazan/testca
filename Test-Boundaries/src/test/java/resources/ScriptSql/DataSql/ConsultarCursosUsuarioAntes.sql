DELETE FROM curso_inscriptos;
DELETE FROM curso;
DELETE FROM cuenta;

INSERT INTO cuenta VALUES(1, '2019-12-08 12:00:00', 'Rodrigo Bazan', '123456', 'rabazan');

INSERT INTO curso VALUES(1, '2019-12-31 00:00:00', 10, 'Ionic 4');
INSERT INTO curso VALUES(2, '2019-12-31 00:00:00', 10, 'Nuevo Curso');
INSERT INTO curso VALUES(3, '2019-12-31 00:00:00', 10, 'Ionic 10');

INSERT INTO curso_inscriptos VALUES(1,1);
INSERT INTO curso_inscriptos VALUES(2,1);
INSERT INTO curso_inscriptos VALUES(3,1);
