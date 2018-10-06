SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema dds
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `dds` ;
-- -----------------------------------------------------
-- Schema dds
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dds` DEFAULT CHARACTER SET utf8 ;

-- -----------------------------------------------------
-- Table `dds`.`TipoDocu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dds`.`TipoDocu` ;

CREATE TABLE IF NOT EXISTS `dds`.`TipoDocu` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `descripion` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`descripion` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

-- Tipos de documentos aceptados segun enunciado entrega0
INSERT INTO `dds`.`TipoDocu` (`descripion`) 
VALUES ('DNI (Documento Nacional de Identidad)');

INSERT INTO `dds`.`TipoDocu` (`descripion`) 
VALUES ('CI (Cédula de Identidad)');

INSERT INTO `dds`.`TipoDocu` (`descripion`) 
VALUES ('LE (Libreta de Enrolamiento)');

INSERT INTO `dds`.`TipoDocu` (`descripion`) 
VALUES ('LC (Libreta Cívica');

-- -----------------------------------------------------
-- Table `dds`.`Categorias`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dds`.`Categorias` ;

CREATE TABLE IF NOT EXISTS `dds`.`Categorias` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `descripion` VARCHAR(30) NULL DEFAULT NULL,
  `cargoFijo` DOUBLE(11,2) NOT NULL,
  `cargoVariable` DOUBLE(11,3) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`descripion` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

INSERT INTO `dds`.`Categorias` (`descripion`, `cargoFijo`, `cargoVariable`) 
VALUES ('R1',18.76,0.644);

INSERT INTO `dds`.`Categorias` (`descripion`, `cargoFijo`, `cargoVariable`) 
VALUES ('R2',5.32,0.644);

INSERT INTO `dds`.`Categorias` (`descripion`, `cargoFijo`, `cargoVariable`) 
VALUES ('R3',60.71,0.681);

INSERT INTO `dds`.`Categorias` (`descripion`, `cargoFijo`, `cargoVariable`) 
VALUES ('R4',71.74,0.738);

INSERT INTO `dds`.`Categorias` (`descripion`, `cargoFijo`, `cargoVariable`) 
VALUES ('R5',110.38,0.974);

-- -----------------------------------------------------
-- Table `dds`.`Zonas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dds`.`Zonas` ;

CREATE TABLE IF NOT EXISTS `dds`.`Zonas` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NULL DEFAULT NULL,
  `radio` INT(11) NOT NULL,
  `centroLongitud` FLOAT(11,7) NOT NULL,
  `centroLatitud` FLOAT(11,7) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dds`.`Transformadores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dds`.`Transformadores` ;
CREATE TABLE IF NOT EXISTS `dds`.`Transformadores` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NULL DEFAULT NULL,
  `longitud` FLOAT(11,7) NOT NULL,
  `latitud` FLOAT(11,7) NOT NULL,
  `id_zona` INT(11) NOT NULL,
  PRIMARY KEY (`id`,`id_zona`),
  INDEX `fk_id_zona_idx` (`id_zona` ASC),
  CONSTRAINT `fk_id_zona`
    FOREIGN KEY (`id_zona`)
    REFERENCES `dds`.`Zonas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `dds`.`Usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dds`.`Usuarios` ;
CREATE TABLE IF NOT EXISTS `dds`.`Usuarios` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_tipoDoc` INT(11) NOT NULL,
  `nroDoc` INT(11) NOT NULL,
  `fechaAlta` DATE NOT NULL,
  `nombre` VARCHAR(30) NOT NULL,
  `apellido` VARCHAR(30) NOT NULL,
  `domicilioServicio` VARCHAR(50) NOT NULL,
  `domicilioLongitud` FLOAT(11,7) NOT NULL,
  `domicilioLatitud` FLOAT(11,7) NOT NULL,
  `usuario` VARCHAR(30) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  `flagAdmin` BOOLEAN NOT NULL,
  `fechaAltaAdmin` DATE NOT NULL,
  `id_categoria` INT(11) NOT NULL,
  `id_transformador` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `id_tipoDoc`, `id_categoria`, `id_transformador`),
  INDEX `fk_id_categoria_idx` (`id_categoria` ASC),
  INDEX `fk_id_tipo_documento_idx` (`id_tipoDoc` ASC),
  INDEX `fk_id_transformador_idx` (`id_transformador` ASC),
  CONSTRAINT `fk_id_categoria`
    FOREIGN KEY (`id_categoria`)
    REFERENCES `dds`.`Categorias` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_tipo_documento`
    FOREIGN KEY (`id_tipoDoc`)
    REFERENCES `dds`.`TipoDocu` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_transformador`
    FOREIGN KEY (`id_transformador`)
    REFERENCES `dds`.`Transformadores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `dds`.`Dispositivos_Permitidos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dds`.`Dispositivos_Permitidos` ;

CREATE TABLE IF NOT EXISTS `dds`.`Dispositivos_Permitidos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  `usoMinimo` INT NOT NULL,
  `usoMaximo` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`nombre` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

INSERT INTO `dds`.`Dispositivos_Permitidos` (`nombre`, `usoMinimo`, `usoMaximo`) 
VALUES ('Aire Acondicionado',90,360);

INSERT INTO `dds`.`Dispositivos_Permitidos` (`nombre`, `usoMinimo`, `usoMaximo`) 
VALUES ('Lámpara',90,360);

INSERT INTO `dds`.`Dispositivos_Permitidos` (`nombre`, `usoMinimo`, `usoMaximo`) 
VALUES ('Televisor (LED/LCD/Tubo)',90,360);

INSERT INTO `dds`.`Dispositivos_Permitidos` (`nombre`, `usoMinimo`, `usoMaximo`) 
VALUES ('Lavarropas',6,30);

INSERT INTO `dds`.`Dispositivos_Permitidos` (`nombre`, `usoMinimo`, `usoMaximo`) 
VALUES ('Computadora',60,360);

INSERT INTO `dds`.`Dispositivos_Permitidos` (`nombre`, `usoMinimo`, `usoMaximo`) 
VALUES ('Microondas',3,15);

INSERT INTO `dds`.`Dispositivos_Permitidos` (`nombre`, `usoMinimo`, `usoMaximo`) 
VALUES ('Plancha',3,30);

INSERT INTO `dds`.`Dispositivos_Permitidos` (`nombre`, `usoMinimo`, `usoMaximo`) 
VALUES ('Ventilador',120,360);


-- -----------------------------------------------------
-- Table `dds`.`dispositivos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dds`.`dispositivos` ;
CREATE TABLE IF NOT EXISTS `dds`.`dispositivos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `idFabrica` VARCHAR(45) NULL DEFAULT NULL,
  `consumoPorHora` DOUBLE NOT NULL,
  `consumoPorHoraAhorro` DOUBLE NOT NULL,
  `id_usuario` INT(11) NOT NULL,
  `flagInteligente` BOOLEAN NOT NULL,
   PRIMARY KEY (`id`),
    INDEX `fk_id_usuario_idx` (`id_usuario` ASC),
  CONSTRAINT `fk_usuario`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `dds`.`usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dds`.`actuadores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dds`.`actuadores` ;

CREATE TABLE IF NOT EXISTS `dds`.`actuadores` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_regla` INT(11) NOT NULL,
  `operacion` VARCHAR(20) NULL DEFAULT NULL,
  `id_sensor` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `id_regla`, `id_sensor`),
  INDEX `fk_id_regla_idx` (`id_regla` ASC),
  INDEX `fk_id_sensor_idx` (`id_sensor` ASC),
  CONSTRAINT `fk_regla`
    FOREIGN KEY (`id_regla`)
    REFERENCES `dds`.`reglas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sensor`
    FOREIGN KEY (`id_sensor`)
    REFERENCES `dds`.`sensores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `dds`.`reglas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dds`.`reglas` ;
CREATE TABLE IF NOT EXISTS `dds`.`reglas` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `descripcion_UNIQUE` (`descripcion` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `dds`.`sensores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dds`.`sensores` ;
CREATE TABLE IF NOT EXISTS `dds`.`sensores` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(30) NOT NULL,
  `medicion` INT(11) NOT NULL, 
  PRIMARY KEY (`id`),
  UNIQUE INDEX `descripcion_UNIQUE` (`descripcion` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `dds`.`dispositivo_Actuador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dds`.`dispositivo_Actuador` ;
CREATE TABLE IF NOT EXISTS `dds`.`dispositivo_Actuador` (
  `id_dispositivo` INT(11) NOT NULL AUTO_INCREMENT,
  `id_actuador` INT(11) NOT NULL,
  PRIMARY KEY (`id_dispositivo`, `id_actuador`),
  INDEX `fk_dispositivo_idx` (`id_dispositivo` ASC),
  CONSTRAINT `fk_dispositivo`
    FOREIGN KEY (`id_dispositivo`)
    REFERENCES `dds`.`dispositivos` (`id`),
  CONSTRAINT `fk_actuador`
    FOREIGN KEY (`id_actuador`)
    REFERENCES `dds`.`actuadores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `dds`.`dispConvertido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dds`.`dispConvertido` ;
CREATE TABLE IF NOT EXISTS `dds`.`dispConvertido` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_dispositivo` INT(11) NOT NULL,
  `fechaConversion` DATE,
   PRIMARY KEY (`id`,`id_dispositivo`),
    INDEX `fk_dispositivo1_idx` (`id_dispositivo` ASC),
  CONSTRAINT `fk_dispositivo1`
    FOREIGN KEY (`id_dispositivo`)
    REFERENCES `dds`.`dispositivos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `dds`.`estado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dds`.`estado` ;
CREATE TABLE IF NOT EXISTS `dds`.`estado` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `descripcion_UNIQUE` (`descripcion` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `dds`.`estados_dispositivos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dds`.`estados_dispositivos` ;
CREATE TABLE IF NOT EXISTS `dds`.`estados_dispositivos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_dispositivo` INT(11) NOT NULL,
  `id_estado` INT(11) NOT NULL,
  `fecha_desde` DATE,
  `fecha_hasta` DATE,
   PRIMARY KEY (`id`,`id_dispositivo`,`id_estado`),
    INDEX `fk_dispositivo2_idx` (`id_dispositivo` ASC),
	INDEX `fk_estado_idx` (`id_estado` ASC),
  CONSTRAINT `fk_dispositivo2`
    FOREIGN KEY (`id_dispositivo`)
    REFERENCES `dds`.`dispositivos` (`id`),
	CONSTRAINT `fk_estado`
    FOREIGN KEY (`id_estado`)
    REFERENCES `dds`.`estado` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

------------------------

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;