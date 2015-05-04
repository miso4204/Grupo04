/*
Created: 31/03/2015
Modified: 31/03/2015
Model: RE PostgreSQL 9.2
Database: PostgreSQL 9.2
*/

INSERT INTO categoria (cat_id, cat_nombre) VALUES (1, 'hombre');
INSERT INTO categoria (cat_id, cat_nombre) VALUES (2, 'mujer');
INSERT INTO compra (com_id, com_valor, com_pais, com_ciudad, com_direccion, com_fecha, tip_pag_id, tar_id, usu_id, per_id) VALUES (1, 50000.000, 'colombia', 'bogota', 
'callefasdfa', '20150101', 1, 1, 1, 1);
INSERT INTO diseno (dis_id, dis_nombre, dis_valor, dis_numero_ventas, dis_url, cat_id, est_id, usu_id) VALUES (0, 'diseño', 20000.000, 0, 
'Batch_2012_Shirt_Design_by_LimeX.png', 1, 1, 1);
INSERT INTO diseno (dis_id, dis_nombre, dis_valor, dis_numero_ventas, dis_url, cat_id, est_id, usu_id) VALUES (1, 'diseño2', 20000.000, 0, 'beautiful-peace-design-
vector-554109.jpg', 2, 1, 1);
INSERT INTO diseno (dis_id, dis_nombre, dis_valor, dis_numero_ventas, dis_url, cat_id, est_id, usu_id) VALUES (2, 'diseño3', 30000.000, 0, 'RcdRRK7gi.png', 1, 1, 1);
INSERT INTO disenosxproddis (dis_prodis_id, dis_prodis_posicion, dis_id, pro_dis_id) VALUES (1, 1, 1, 1);
INSERT INTO disenosxproddis (dis_prodis_id, dis_prodis_posicion, dis_id, pro_dis_id) VALUES (2, 2, 2, 1);
INSERT INTO disenosxproddis (dis_prodis_id, dis_prodis_posicion, dis_id, pro_dis_id) VALUES (3, 1, 0, 2);
INSERT INTO disenosxproddis (dis_prodis_id, dis_prodis_posicion, dis_id, pro_dis_id) VALUES (4, 2, 1, 2);
INSERT INTO perfil (per_id, per_nombre) VALUES (2, 'cliente');
INSERT INTO perfil (per_id, per_nombre) VALUES (3, 'artista');
INSERT INTO perfil (per_id, per_nombre) VALUES (1, 'administrador');INSERT INTO perfil (per_id, per_nombre) VALUES (2, 'cliente');
INSERT INTO perfil (per_id, per_nombre) VALUES (3, 'artista');
INSERT INTO perfil (per_id, per_nombre) VALUES (1, 'administrador');
INSERT INTO persona (per_id, per_tipo_documento, per_numero_documento, per_primer_nombre, per_primer_apelido, per_email, per_direccion) VALUES (1, '01', '1053804751', 
'julio', 'galvez', 'jc.galvez10@uniandes.edu.co', 'Calle 44C #45 - 28');
INSERT INTO persona (per_id, per_tipo_documento, per_numero_documento, per_primer_nombre, per_primer_apelido, per_email, per_direccion) VALUES (4607, 'CC', '1234', 
'alejo', 'alejo', 'car', 'cara');
INSERT INTO proddisxcompra (prodis_com_id, pro_dis_id, com_id) VALUES (1, 1, 1);
INSERT INTO proddisxcompra (prodis_com_id, pro_dis_id, com_id) VALUES (2, 2, 1);
INSERT INTO producto (pro_id, pro_nombre, pro_cantidad, pro_valor, pro_url, cat_id, est_id) VALUES (1, 'producto1', 1, 30000.000, 'APL.jpg', 1, 1);
INSERT INTO producto (pro_id, pro_nombre, pro_cantidad, pro_valor, pro_url, cat_id, est_id) VALUES (2, 'producto2', 1, 10000.000, 'BAN.jpg', 1, 1);
INSERT INTO producto (pro_id, pro_nombre, pro_cantidad, pro_valor, pro_url, cat_id, est_id) VALUES (3, 'producto3', 1, 15000.000, 'GRP.jpg', 2, 2);
INSERT INTO productodisenado (pro_dis_id, pro_dis_cantidad, pro_dis_valor, pro_id) VALUES (1, 1, 50000.000, 1);
INSERT INTO productodisenado (pro_dis_id, pro_dis_cantidad, pro_dis_valor, pro_id) VALUES (2, 1, 30000.000, 1);

INSERT INTO tarjetacredito (tar_id, tar_numero, tar_fecha_expiracion, tar_codigo_seguridad, tar_tipo, per_id) VALUES (1, '123456789', '2017-12-31', 1234, 'master', 1);
INSERT INTO tipopago (tip_pag_id, tip_pag_nombre) VALUES (1, 'credito');
INSERT INTO tipopago (tip_pag_id, tip_pag_nombre) VALUES (2, 'PSE');
INSERT INTO usuario (usu_id, usu_usuario, usu_contrasena, per_id) VALUES (1, 'jcgalvez', '1053804751', 1);
INSERT INTO usuario (usu_id, usu_usuario, usu_contrasena, per_id) VALUES (1174, 'alejo', 'alejo', 4607);
INSERT INTO usuarioxperfil (usuper_id, usu_id, per_id) VALUES (1, 1, 2);
INSERT INTO usuarioxperfil (usuper_id, usu_id, per_id) VALUES (8422, 1174, 2);
