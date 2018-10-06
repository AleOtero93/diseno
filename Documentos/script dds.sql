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
--  Agregar tablas faltantes
-- -----------------------------------------------------


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



