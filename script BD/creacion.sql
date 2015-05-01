/*
Created: 31/03/2015
Modified: 31/03/2015
Model: RE PostgreSQL 9.2
Database: PostgreSQL 9.2
*/


-- Create schemas section -------------------------------------------------

CREATE SCHEMA "public" AUTHORIZATION "postgres"
;

-- Create tables section -------------------------------------------------

-- Table public.categoria

CREATE TABLE "public"."categoria"(
 "cat_id" Integer NOT NULL,
 "cat_nombre" Character varying(20) NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table public.categoria

ALTER TABLE "public"."categoria" ADD CONSTRAINT "categoria_pkey" PRIMARY KEY ("cat_id")
;

-- Table public.color

CREATE TABLE "public"."color"(
 "col_id" Integer NOT NULL,
 "col_nombre" Character varying(30) NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table public.color

ALTER TABLE "public"."color" ADD CONSTRAINT "color_pkey" PRIMARY KEY ("col_id")
;

-- Table public.compra

CREATE TABLE "public"."compra"(
 "com_id" Integer NOT NULL,
 "com_valor" Numeric(9,3) NOT NULL,
 "com_pais" Character varying(30) NOT NULL,
 "com_ciudad" Character varying(30) NOT NULL,
 "com_direccion" Character varying(30) NOT NULL,
 "tip_pag_id" Integer NOT NULL,
 "tar_id" Integer,
 "usu_id" Integer NOT NULL,
 "per_id" Integer
)
WITH (OIDS=FALSE)
;

-- Add keys for table public.compra

ALTER TABLE "public"."compra" ADD CONSTRAINT "compra_pkey" PRIMARY KEY ("com_id")
;

-- Table public.diseno

CREATE TABLE "public"."diseno"(
 "dis_id" Integer NOT NULL,
 "dis_nombre" Character varying(20) NOT NULL,
 "dis_valor" Numeric(9,3) NOT NULL,
 "dis_numero_ventas" Integer,
 "dis_url" Character varying(100) NOT NULL,
 "cat_id" Integer NOT NULL,
 "est_id" Integer NOT NULL,
 "usu_id" Integer NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table public.diseno

ALTER TABLE "public"."diseno" ADD CONSTRAINT "diseno_pkey" PRIMARY KEY ("dis_id")
;

-- Table public.oferta

CREATE TABLE "public"."oferta"(
 "ofe_id" Integer NOT NULL,
 "ofe_nombre" Character varying(50) NOT NULL,
 "ofe_descuento" Numeric(9,3) NOT NULL,
 "ofe_vigente" boolean
)
WITH (OIDS=FALSE)
;

-- Add keys for table public.oferta

ALTER TABLE "public"."oferta" ADD CONSTRAINT "oferta_pkey" PRIMARY KEY ("ofe_id")
;

-- Table public.disenosxproddis

CREATE TABLE "public"."disenosxproddis"(
 "dis_prodis_id" Integer NOT NULL,
 "dis_prodis_posicion" Integer NOT NULL,
 "dis_id" Integer NOT NULL,
 "pro_dis_id" Integer NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table public.disenosxproddis

ALTER TABLE "public"."disenosxproddis" ADD CONSTRAINT "disenosxproddis_pkey" PRIMARY KEY ("dis_prodis_id")
;

-- Table public.estilos

CREATE TABLE "public"."estilos"(
 "est_id" Integer NOT NULL,
 "est_nombre" Character varying(20)
)
WITH (OIDS=FALSE)
;

-- Add keys for table public.estilos

ALTER TABLE "public"."estilos" ADD CONSTRAINT "estilos_pkey" PRIMARY KEY ("est_id")
;

-- Table public.perfil

CREATE TABLE "public"."perfil"(
 "per_id" Integer NOT NULL,
 "per_nombre" Character varying(50) NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table public.perfil

ALTER TABLE "public"."perfil" ADD CONSTRAINT "perfil_pkey" PRIMARY KEY ("per_id")
;

-- Table public.persona

CREATE TABLE "public"."persona"(
 "per_id" Integer NOT NULL,
 "per_tipo_documento" Character varying(2) NOT NULL,
 "per_numero_documento" Character varying(20) NOT NULL,
 "per_primer_nombre" Character varying(50) NOT NULL,
 "per_primer_apelido" Character varying(50) NOT NULL,
 "per_email" Character varying(50) NOT NULL,
 "per_direccion" Character varying(50) NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table public.persona

ALTER TABLE "public"."persona" ADD CONSTRAINT "persona_pkey" PRIMARY KEY ("per_id")
;

-- Table public.proddisxcompra

CREATE TABLE "public"."proddisxcompra"(
 "prodis_com_id" Integer NOT NULL,
 "pro_dis_id" Integer NOT NULL,
 "com_id" Integer NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table public.proddisxcompra

ALTER TABLE "public"."proddisxcompra" ADD CONSTRAINT "proddisxcompra_pkey" PRIMARY KEY ("prodis_com_id")
;

-- Table public.producto

CREATE TABLE "public"."producto"(
 "pro_id" Integer NOT NULL,
 "pro_nombre" Character varying(50) NOT NULL,
 "pro_cantidad" Integer NOT NULL,
 "pro_valor" Numeric(9,3) NOT NULL,
 "pro_url" Character varying(100) NOT NULL,
 "cat_id" Integer NOT NULL,
 "est_id" Integer NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table public.producto

ALTER TABLE "public"."producto" ADD CONSTRAINT "producto_pkey" PRIMARY KEY ("pro_id")
;

-- Table public.productocolor

CREATE TABLE "public"."productocolor"(
 "pro_col_id" Integer NOT NULL,
 "pro_id" Integer NOT NULL,
 "col_id" Integer NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table public.productocolor

ALTER TABLE "public"."productocolor" ADD CONSTRAINT "productocolor_pkey" PRIMARY KEY ("pro_col_id")
;

-- Table public.productodisenado

CREATE TABLE "public"."productodisenado"(
 "pro_dis_id" Integer NOT NULL,
 "pro_dis_cantidad" Integer NOT NULL,
 "pro_dis_valor" Numeric(9,3) NOT NULL,
 "pro_id" Integer NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table public.productodisenado

ALTER TABLE "public"."productodisenado" ADD CONSTRAINT "productodisenado_pkey" PRIMARY KEY ("pro_dis_id")
;

-- Table public.productotalla

CREATE TABLE "public"."productotalla"(
 "pro_tal_id" Integer NOT NULL,
 "pro_id" Integer NOT NULL,
 "tal_id" Integer NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table public.productotalla

ALTER TABLE "public"."productotalla" ADD CONSTRAINT "productotalla_pkey" PRIMARY KEY ("pro_tal_id")
;

-- Table public.talla

CREATE TABLE "public"."talla"(
 "tal_id" Integer NOT NULL,
 "tal_nombre" Character varying(30) NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table public.talla

ALTER TABLE "public"."talla" ADD CONSTRAINT "talla_pkey" PRIMARY KEY ("tal_id")
;

-- Table public.tarjetacredito

CREATE TABLE "public"."tarjetacredito"(
 "tar_id" Integer NOT NULL,
 "tar_numero" Character varying(16) NOT NULL,
 "tar_fecha_expiracion" Date NOT NULL,
 "tar_codigo_seguridad" Integer NOT NULL,
 "tar_tipo" Character varying(50) NOT NULL,
 "per_id" Integer NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table public.tarjetacredito

ALTER TABLE "public"."tarjetacredito" ADD CONSTRAINT "tarjetacredito_pkey" PRIMARY KEY ("tar_id","per_id")
;

-- Table public.tipopago

CREATE TABLE "public"."tipopago"(
 "tip_pag_id" Integer NOT NULL,
 "tip_pag_nombre" Character varying(30) NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table public.tipopago

ALTER TABLE "public"."tipopago" ADD CONSTRAINT "tipopago_pkey" PRIMARY KEY ("tip_pag_id")
;

-- Table public.usuario

CREATE TABLE "public"."usuario"(
 "usu_id" Integer NOT NULL,
 "usu_usuario" Character varying(20) NOT NULL,
 "usu_contrasena" Character varying(20) NOT NULL,
 "per_id" Integer NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table public.usuario

ALTER TABLE "public"."usuario" ADD CONSTRAINT "usuario_pkey" PRIMARY KEY ("usu_id")
;

-- Table public.usuarioxperfil

CREATE TABLE "public"."usuarioxperfil"(
 "usuper_id" Integer NOT NULL,
 "usu_id" Integer NOT NULL,
 "per_id" Integer NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table public.usuarioxperfil

ALTER TABLE "public"."usuarioxperfil" ADD CONSTRAINT "usuarioxperfil_pkey" PRIMARY KEY ("usuper_id")
;

-- Create relationships section ------------------------------------------------- 

ALTER TABLE "public"."usuario" ADD CONSTRAINT "fk_persona_per_id" FOREIGN KEY ("per_id") REFERENCES "public"."persona" ("per_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "public"."usuarioxperfil" ADD CONSTRAINT "fk_usu_id" FOREIGN KEY ("usu_id") REFERENCES "public"."usuario" ("usu_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "public"."usuarioxperfil" ADD CONSTRAINT "fk_per_id" FOREIGN KEY ("per_id") REFERENCES "public"."perfil" ("per_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "public"."producto" ADD CONSTRAINT "fk_pro_cat_id" FOREIGN KEY ("cat_id") REFERENCES "public"."categoria" ("cat_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "public"."producto" ADD CONSTRAINT "fk_pro_est_id" FOREIGN KEY ("est_id") REFERENCES "public"."estilos" ("est_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "public"."productocolor" ADD CONSTRAINT "fk_productocolor_pro_id" FOREIGN KEY ("pro_id") REFERENCES "public"."producto" ("pro_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "public"."productocolor" ADD CONSTRAINT "fk_productocolor_col_id" FOREIGN KEY ("col_id") REFERENCES "public"."color" ("col_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "public"."productotalla" ADD CONSTRAINT "fk_productotalla_pro_id" FOREIGN KEY ("pro_id") REFERENCES "public"."producto" ("pro_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "public"."productotalla" ADD CONSTRAINT "fk_productotalla_tal_id" FOREIGN KEY ("tal_id") REFERENCES "public"."talla" ("tal_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "public"."diseno" ADD CONSTRAINT "fk_diseno_usu_id" FOREIGN KEY ("usu_id") REFERENCES "public"."usuario" ("usu_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "public"."diseno" ADD CONSTRAINT "fk_diseno_cat_id" FOREIGN KEY ("cat_id") REFERENCES "public"."categoria" ("cat_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "public"."diseno" ADD CONSTRAINT "fk_diseno_est_id" FOREIGN KEY ("est_id") REFERENCES "public"."estilos" ("est_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "public"."compra" ADD CONSTRAINT "fk_compra_usu_id" FOREIGN KEY ("usu_id") REFERENCES "public"."usuario" ("usu_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "public"."compra" ADD CONSTRAINT "fk_compra_tar_id" FOREIGN KEY ("tar_id", "per_id") REFERENCES "public"."tarjetacredito" ("tar_id", "per_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "public"."compra" ADD CONSTRAINT "fk_compra_tip_pag_id" FOREIGN KEY ("tip_pag_id") REFERENCES "public"."tipopago" ("tip_pag_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "public"."productodisenado" ADD CONSTRAINT "fk_productodisenado_prod_id" FOREIGN KEY ("pro_id") REFERENCES "public"."producto" ("pro_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "public"."proddisxcompra" ADD CONSTRAINT "fk_proddisxcomprac_com_id" FOREIGN KEY ("com_id") REFERENCES "public"."compra" ("com_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "public"."proddisxcompra" ADD CONSTRAINT "fk_proddisxcompra_prodis_id" FOREIGN KEY ("pro_dis_id") REFERENCES "public"."productodisenado" ("pro_dis_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "public"."disenosxproddis" ADD CONSTRAINT "fk_disenosxproddis_dis_id" FOREIGN KEY ("dis_id") REFERENCES "public"."diseno" ("dis_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "public"."disenosxproddis" ADD CONSTRAINT "fk_disenosxproddis_prodis_id" FOREIGN KEY ("pro_dis_id") REFERENCES "public"."productodisenado" ("pro_dis_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "public"."tarjetacredito" ADD CONSTRAINT "fk_per_tar" FOREIGN KEY ("per_id") REFERENCES "public"."persona" ("per_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;



-- Create roles section -------------------------------------------------


-- Grant permissions section -------------------------------------------------


