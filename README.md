# DocumentoIdentidad
 Gestion de documento de identidad


#Install apache tomcat 9.0


#DB
CREATE DATABASE prueba_tecnica;
USE prueba_tecnica;

CREATE TABLE cat_departamentos(
	id_departamento INT NOT NULL,
	nombre_departamento VARCHAR(75) NOT NULL,
	CONSTRAINT pk_id_departamento PRIMARY KEY(id_departamento)
);
CREATE TABLE cat_municipios(
	id_municipio INT NOT NULL,
	id_departamento INT NOT NULL,
	nombre_municipio VARCHAR(75) NOT NULL,
	CONSTRAINT pk_id_municipio PRIMARY KEY(id_municipio),
	CONSTRAINT fk_cat_depto_cat_muni FOREIGN KEY(id_departamento) REFERENCES cat_departamentos(id_departamento)
);
CREATE TABLE cat_estado_familiar(
	id_estado_familiar INT NOT NULL,
	nombre_estado_familiar VARCHAR(75) NOT NULL,
	estado CHAR(1) NOT NULL,
	CONSTRAINT pk_estado_familiar PRIMARY KEY(id_estado_familiar)
);
CREATE TABLE cat_profesiones(
	id_profesion INT NOT NULL,
	nombre_profesion VARCHAR(75) NOT NULL,
	estado CHAR(1) NOT NULL,
	CONSTRAINT pk_profesiones PRIMARY KEY(id_profesion)
);
CREATE TABLE cat_tipo_sangre(
	id_tipo_sangre INT NOT NULL,
	tipo_sangre VARCHAR(20),
	CONSTRAINT pk_id_tipo_sangre PRIMARY KEY(id_tipo_sangre)
);

CREATE TABLE documento_identidad(
	id_documento CHAR(10) NOT NULL,
	id_estado_familiar INT NOT NULL,
	id_tipo_sangre INT NULL,
	id_profesion INT NULL,
	id_municipio INT NULL,
	nombres VARCHAR(200) NOT NULL,
	apellidos VARCHAR(200) NOT NULL,
	conocido_por VARCHAR(200) NULL,
	genero CHAR(1) NOT NULL,
	fecha_nacimiento DATE NOT NULL,
	id_lugar_nacimiento INT NULL,
	fecha_expedicion DATE NULL,
	id_lugar_expedicion INT NULL,
	fecha_expiracion DATE NULL,
	residencia VARCHAR(250) NULL,	
	id_residencia INT NULL,
	nombre_completo_madre VARCHAR(250) NULL,
	nombre_completo_padre VARCHAR(250) NULL,
	conyuge VARCHAR(250) NULL,
	tramite VARCHAR(10) NULL,
	nit VARCHAR(14) NULL,
	codigo_zona VARCHAR(50) NULL,
	url_foto VARCHAR(255) NULL,
	estado CHAR(1) NOT NULL,
	CONSTRAINT pk_id_documento PRIMARY KEY(id_documento),
	CONSTRAINT fk_documento_estado_fam FOREIGN KEY(id_estado_familiar) REFERENCES cat_estado_familiar(id_estado_familiar),
	CONSTRAINT fk_documento_tipo_sangre FOREIGN KEY(id_tipo_sangre) REFERENCES cat_tipo_sangre(id_tipo_sangre),
	CONSTRAINT fk_documento_profesion FOREIGN KEY(id_profesion) REFERENCES cat_profesiones(id_profesion),
	CONSTRAINT fk_documento_municipio FOREIGN KEY(id_municipio) REFERENCES cat_municipios(id_municipio),
	CONSTRAINT fk_documento_lugar_nac FOREIGN KEY(id_lugar_nacimiento) REFERENCES cat_municipios(id_municipio),
	CONSTRAINT fk_documento_lugar_expe FOREIGN KEY(id_lugar_expedicion) REFERENCES cat_municipios(id_municipio),
	CONSTRAINT fk_documento_residencia FOREIGN KEY(id_residencia) REFERENCES cat_municipios(id_municipio)
);

CREATE TABLE parametros(
	id_parametro VARCHAR(20) NOT NULL,
	nombre_parametro VARCHAR(200) NOT NULL,
	valor_parametro VARCHAR(250) NOT NULL,
	estado_parametro CHAR(1) NOT NULL
);

INSERT INTO parametros(id_parametro, nombre_parametro, valor_parametro, estado_parametro)
VALUES('P_VALIDA_SESION', 'PARAMETRO USUARIO Y CLAVE GENERICO, PARA VALIDAR SESION', 'Admin&sa123', 'A');

INSERT INTO parametros(id_parametro, nombre_parametro, valor_parametro, estado_parametro)
VALUES('P_ELIMINACION_REG', 'PARAMETRO PARA VALIDAR SI SE ELIMINA EL REGISTRO', 'N', 'A');

INSERT INTO cat_departamentos (id_departamento, nombre_departamento) VALUES (1, 'Ahuachapán');
INSERT INTO cat_departamentos (id_departamento, nombre_departamento) VALUES (2, 'Cabañas');
INSERT INTO cat_departamentos (id_departamento, nombre_departamento) VALUES (3, 'Chalatenango');
INSERT INTO cat_departamentos (id_departamento, nombre_departamento) VALUES (4, 'Cuscatlán');
INSERT INTO cat_departamentos (id_departamento, nombre_departamento) VALUES (5, 'La Libertad');
INSERT INTO cat_departamentos (id_departamento, nombre_departamento) VALUES (6, 'La Paz');
INSERT INTO cat_departamentos (id_departamento, nombre_departamento) VALUES (7, 'La Unión');
INSERT INTO cat_departamentos (id_departamento, nombre_departamento) VALUES (8, 'Morazán');
INSERT INTO cat_departamentos (id_departamento, nombre_departamento) VALUES (9, 'San Miguel');
INSERT INTO cat_departamentos (id_departamento, nombre_departamento) VALUES (10, 'San Salvador');
INSERT INTO cat_departamentos (id_departamento, nombre_departamento) VALUES (11, 'San Vicente');
INSERT INTO cat_departamentos (id_departamento, nombre_departamento) VALUES (12, 'Santa Ana');
INSERT INTO cat_departamentos (id_departamento, nombre_departamento) VALUES (13, 'Sonsonate');
INSERT INTO cat_departamentos (id_departamento, nombre_departamento) VALUES (14, 'Usulután');

INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (1, 1, 'Ahuachapán');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (2, 1, 'Jujutla');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (3, 1, 'Atiquizaya');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (4, 1, 'Concepción de Ataco');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (5, 1, 'El Refugio');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (6, 1, 'Guaymango');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (7, 1, 'Apaneca');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (8, 1, 'San Francisco Menéndez');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (9, 1, 'San Lorenzo');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (10, 1, 'San Pedro Puxtla');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (11, 1, 'Tacuba');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (12, 1, 'Turín');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (13, 2, 'Cinquera');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (14, 2, 'Villa Dolores');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (15, 2, 'Guacotecti');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (16, 2, 'Ilobasco');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (17, 2, 'Jutiapa');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (18, 2, 'San Isidro');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (19, 2, 'Sensuntepeque');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (20, 2, 'Ciudad de Tejutepeque');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (21, 2, 'Victoria');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (22, 3, 'Agua Caliente');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (23, 3, 'Arcatao');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (24, 3, 'Azacualpa');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (25, 3, 'Chalatenango');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (26, 3, 'Citalá');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (27, 3, 'Comalapa');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (28, 3, 'Concepción Quezaltepeque');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (29, 3, 'Dulce Nombre de María');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (30, 3, 'El Carrizal');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (31, 3, 'El Paraíso');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (32, 3, 'La Laguna');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (33, 3, 'La Palma');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (34, 3, 'La Reina');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (35, 3, 'Las Vueltas');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (36, 3, 'Nombre de Jesús');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (37, 3, 'Nueva Concepción');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (38, 3, 'Nueva Trinidad');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (39, 3, 'Ojos de Agua');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (40, 3, 'Potonico');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (41, 3, 'San Antonio de la Cruz');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (42, 3, 'San Antonio Los Ranchos');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (43, 3, 'San Fernando');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (44, 3, 'San Francisco Lempa');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (45, 3, 'San Francisco Morazán');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (46, 3, 'San Ignacio');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (47, 3, 'San Isidro Labrador');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (48, 3, 'San José Cancasque');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (49, 3, 'San José Las Flores');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (50, 3, 'San Luis del Carmen');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (51, 3, 'San Miguel de Mercedes');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (52, 3, 'San Rafael');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (53, 3, 'Santa Rita');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (54, 3, 'Tejutla');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (55, 4, 'Candelaria');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (56, 4, 'Cojutepeque');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (57, 4, 'El Carmen');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (58, 4, 'El Rosario');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (59, 4, 'Monte San Juan');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (60, 4, 'Oratorio de Concepción');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (61, 4, 'San Bartolomé Perulapía');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (62, 4, 'San Cristóbal');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (63, 4, 'San José Guayabal');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (64, 4, 'San Pedro Perulapán');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (65, 4, 'San Rafael Cedros');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (66, 4, 'San Ramón');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (67, 4, 'Santa Cruz Analquito');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (68, 4, 'Santa Cruz Michapa');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (69, 4, 'Suchitoto');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (70, 4, 'Tenancingo');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (71, 5, 'Antiguo Cuscatlán');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (72, 5, 'Chiltiupán');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (73, 5, 'Ciudad Arce');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (74, 5, 'Colón');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (75, 5, 'Comasagua');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (76, 5, 'Huizúcar');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (77, 5, 'Jayaque');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (78, 5, 'Jicalapa');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (79, 5, 'La Libertad');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (80, 5, 'Nueva San Salvador');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (81, 5, 'Nuevo Cuscatlán');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (82, 5, 'Opico');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (83, 5, 'Quezaltepeque');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (84, 5, 'Sacacoyo');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (85, 5, 'San José Villanueva');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (86, 5, 'San Matías');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (87, 5, 'San Pablo Tacachico');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (88, 5, 'Talnique');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (89, 5, 'Tamanique');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (90, 5, 'Teotepeque');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (91, 5, 'Tepecoyo');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (92, 5, 'Zaragoza');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (93, 6, 'Cuyultitán');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (94, 6, 'El Rosario');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (95, 6, 'Jerusalén');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (96, 6, 'Mercedes La Ceiba');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (97, 6, 'Olocuilta');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (98, 6, 'Paraíso de Osorio');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (99, 6, 'San Antonio Masahuat');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (100, 6, 'San Emigdio');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (101, 6, 'San Francisco Chinameca');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (102, 6, 'San Juan Nonualco');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (103, 6, 'San Juan Talpa');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (104, 6, 'San Juan Tepezontes');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (105, 6, 'San Luis La Herradura');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (106, 6, 'San Luis Talpa');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (107, 6, 'San Miguel Tepezontes');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (108, 6, 'San Pedro Masahuat');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (109, 6, 'San Pedro Nonualco');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (110, 6, 'San Rafael Obrajuelo');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (111, 6, 'Santa María Ostuma');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (112, 6, 'Santiago Nonualco');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (113, 6, 'Tapalhuaca');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (114, 6, 'Zacatecoluca');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (115, 7, 'Anamorós');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (116, 7, 'Bolívar');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (117, 7, 'Concepción de Oriente');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (118, 7, 'Conchagua');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (119, 7, 'El Carmen');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (120, 7, 'El Sauce');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (121, 7, 'Intipucá');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (122, 7, 'La Unión');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (123, 7, 'Lislique');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (124, 7, 'Meanguera del Golfo');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (125, 7, 'Nueva Esparta');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (126, 7, 'Pasaquina');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (127, 7, 'Polorós');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (128, 7, 'San Alejo');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (129, 7, 'San José');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (130, 7, 'Santa Rosa de Lima');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (131, 7, 'Yayantique');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (132, 7, 'Yucuayquín');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (133, 8, 'Arambala');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (134, 8, 'Cacaopera');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (135, 8, 'Chilanga');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (136, 8, 'Corinto');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (137, 8, 'Delicias de Concepción');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (138, 8, 'El Divisadero');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (139, 8, 'El Rosario');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (140, 8, 'Gualococti');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (141, 8, 'Guatajiagua');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (142, 8, 'Joateca');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (143, 8, 'Jocoaitique');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (144, 8, 'Jocoro');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (145, 8, 'Lolotiquillo');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (146, 8, 'Meanguera');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (147, 8, 'Osicala');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (148, 8, 'Perquín');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (149, 8, 'San Carlos');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (150, 8, 'San Fernando');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (151, 8, 'San Francisco Gotera');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (152, 8, 'San Isidro');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (153, 8, 'San Simón');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (154, 8, 'Sensembra');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (155, 8, 'Sociedad');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (156, 8, 'Torola');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (157, 8, 'Yamabal');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (158, 8, 'Yoloaiquín');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (159, 9, 'Carolina');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (160, 9, 'Chapeltique');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (161, 9, 'Chinameca');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (162, 9, 'Chirilagua');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (163, 9, 'Ciudad Barrios');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (164, 9, 'Comacarán');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (165, 9, 'El Tránsito');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (166, 9, 'Lolotique');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (167, 9, 'Moncagua');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (168, 9, 'Nueva Guadalupe');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (169, 9, 'Nuevo Edén de San Juan');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (170, 9, 'Quelepa');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (171, 9, 'San Antonio');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (172, 9, 'San Gerardo');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (173, 9, 'San Jorge');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (174, 9, 'San Luis de la Reina');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (175, 9, 'San Miguel');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (176, 9, 'San Rafael');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (177, 9, 'Sesori');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (178, 9, 'Uluazapa');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (179, 10, 'Aguilares');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (180, 10, 'Apopa');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (181, 10, 'Ayutuxtepeque');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (182, 10, 'Cuscatancingo');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (183, 10, 'Delgado');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (184, 10, 'El Paisnal');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (185, 10, 'Guazapa');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (186, 10, 'Ilopango');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (187, 10, 'Mejicanos');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (188, 10, 'Nejapa');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (189, 10, 'Panchimalco');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (190, 10, 'Rosario de Mora');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (191, 10, 'San Marcos');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (192, 10, 'San Martín');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (193, 10, 'San Salvador');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (194, 10, 'Santiago Texacuangos');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (195, 10, 'Santo Tomás');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (196, 10, 'Soyapango');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (197, 10, 'Tonacatepeque');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (198, 11, 'Apastepeque');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (199, 11, 'Guadalupe');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (200, 11, 'San Cayetano Istepeque');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (201, 11, 'San Esteban Catarina');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (202, 11, 'San Ildefonso');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (203, 11, 'San Lorenzo');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (204, 11, 'San Sebastián');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (205, 11, 'Santa Clara');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (206, 11, 'Santo Domingo');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (207, 11, 'San Vicente');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (208, 11, 'Tecoluca');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (209, 11, 'Tepetitán');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (210, 11, 'Verapaz');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (211, 12, 'Candelaria de la Frontera');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (212, 12, 'Chalchuapa');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (213, 12, 'Coatepeque');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (214, 12, 'El Congo');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (215, 12, 'El Porvenir');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (216, 12, 'Masahuat');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (217, 12, 'Metapán');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (218, 12, 'San Antonio Pajonal');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (219, 12, 'San Sebastián Salitrillo');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (220, 12, 'Santa Ana');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (221, 12, 'Santa Rosa Guachipilín');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (222, 12, 'Santiago de la Frontera');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (223, 12, 'Texistepeque');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (224, 13, 'Acajutla');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (225, 13, 'Armenia');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (226, 13, 'Caluco');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (227, 13, 'Cuisnahuat');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (228, 13, 'Izalco');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (229, 13, 'Juayúa');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (230, 13, 'Nahuizalco');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (231, 13, 'Nahulingo');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (232, 13, 'Salcoatitán');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (233, 13, 'San Antonio del Monte');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (234, 13, 'San Julián');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (235, 13, 'Santa Catarina Masahuat');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (236, 13, 'Santa Isabel Ishuatán');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (237, 13, 'Santo Domingo');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (238, 13, 'Sonsonate');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (239, 13, 'Sonzacate');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (240, 14, 'Alegría');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (241, 14, 'Berlín');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (242, 14, 'California');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (243, 14, 'Concepción Batres');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (244, 14, 'El Triunfo');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (245, 14, 'Ereguayquín');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (246, 14, 'Estanzuelas');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (247, 14, 'Jiquilisco');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (248, 14, 'Jucuapa');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (249, 14, 'Jucuarán');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (250, 14, 'Mercedes Umaña');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (251, 14, 'Nueva Granada');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (252, 14, 'Ozatlán');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (253, 14, 'Puerto El Triunfo');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (254, 14, 'San Agustín');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (255, 14, 'San Buenaventura');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (256, 14, 'San Dionisio');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (257, 14, 'San Francisco Javier');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (258, 14, 'Santa Elena');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (259, 14, 'Santa María');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (260, 14, 'Santiago de María');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (261, 14, 'Tecapán');
INSERT INTO cat_municipios (id_municipio, id_departamento, nombre_municipio) VALUES (262, 14, 'Usulután');


insert into cat_tipo_sangre(id_tipo_sangre, tipo_sangre) values(1, 'O negativo');
insert into cat_tipo_sangre(id_tipo_sangre, tipo_sangre) values(2, 'O positivo');
insert into cat_tipo_sangre(id_tipo_sangre, tipo_sangre) values(3, 'A negativo');
insert into cat_tipo_sangre(id_tipo_sangre, tipo_sangre) values(4, 'A positivo');
insert into cat_tipo_sangre(id_tipo_sangre, tipo_sangre) values(5, 'B negativo');
insert into cat_tipo_sangre(id_tipo_sangre, tipo_sangre) values(6, 'B positivo');
insert into cat_tipo_sangre(id_tipo_sangre, tipo_sangre) values(7, 'AB negativo');
insert into cat_tipo_sangre(id_tipo_sangre, tipo_sangre) values(8, 'AB positivo');


insert into cat_profesiones(id_profesion, nombre_profesion, estado)values(1, 'Estudiante', 'A');
insert into cat_profesiones(id_profesion, nombre_profesion, estado)values(2, 'Abogado/a', 'A');
insert into cat_profesiones(id_profesion, nombre_profesion, estado)values(3, 'Arquitecto/a', 'A');
insert into cat_profesiones(id_profesion, nombre_profesion, estado)values(4, 'Catedrático/a', 'A');
insert into cat_profesiones(id_profesion, nombre_profesion, estado)values(5, 'Dentista', 'A');
insert into cat_profesiones(id_profesion, nombre_profesion, estado)values(6, 'Dentista/a', 'A');
insert into cat_profesiones(id_profesion, nombre_profesion, estado)values(7, 'Economista', 'A');
insert into cat_profesiones(id_profesion, nombre_profesion, estado)values(8, 'Fiscal', 'A');
insert into cat_profesiones(id_profesion, nombre_profesion, estado)values(9, 'Gerente', 'A');
insert into cat_profesiones(id_profesion, nombre_profesion, estado)values(10, 'Informático/a', 'A');
insert into cat_profesiones(id_profesion, nombre_profesion, estado)values(11, 'Interventor/a', 'A');
insert into cat_profesiones(id_profesion, nombre_profesion, estado)values(12, 'Maestro/a', 'A');
insert into cat_profesiones(id_profesion, nombre_profesion, estado)values(13, 'Psicólogo/a', 'A');
insert into cat_profesiones(id_profesion, nombre_profesion, estado)values(14, 'Químico/a', 'A');
insert into cat_profesiones(id_profesion, nombre_profesion, estado)values(15, 'Sexólogo/a', 'A');
insert into cat_profesiones(id_profesion, nombre_profesion, estado)values(16, 'Tutor/a', 'A');
insert into cat_profesiones(id_profesion, nombre_profesion, estado)values(17, 'Virólogo/a', 'A');
insert into cat_profesiones(id_profesion, nombre_profesion, estado)values(18, 'Vicedirector/a', 'A');
insert into cat_profesiones(id_profesion, nombre_profesion, estado)values(19, 'Veterinario/a', 'A');
insert into cat_profesiones(id_profesion, nombre_profesion, estado)values(20, 'Zootécnico/a', 'A');

insert into cat_estado_familiar(id_estado_familiar, nombre_estado_familiar, estado)values(1, 'Soltero/a.', 'A');
insert into cat_estado_familiar(id_estado_familiar, nombre_estado_familiar, estado)values(2, 'Casado/a.', 'A');
insert into cat_estado_familiar(id_estado_familiar, nombre_estado_familiar, estado)values(3, 'Unión libre o unión de hecho.', 'A');
insert into cat_estado_familiar(id_estado_familiar, nombre_estado_familiar, estado)values(4, 'Separado/a.', 'A');
insert into cat_estado_familiar(id_estado_familiar, nombre_estado_familiar, estado)values(5, 'Separado/a.', 'A');
insert into cat_estado_familiar(id_estado_familiar, nombre_estado_familiar, estado)values(6, 'Divorciado/a.', 'A');
insert into cat_estado_familiar(id_estado_familiar, nombre_estado_familiar, estado)values(7, 'Viudo/a.', 'A');



