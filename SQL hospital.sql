-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hospital
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hospital
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hospital` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `hospital` ;

-- -----------------------------------------------------
-- Table `hospital`.`especialidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`especialidad` (
  `nom_esp` VARCHAR(50) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `fec_cre` DATE NOT NULL,
  `est_esp` TINYINT(1) NOT NULL,
  PRIMARY KEY (`est_esp`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `hospital`.`historia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`historia` (
  `id_his` INT NOT NULL,
  `diagnostico` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `tratamiento` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `observaciones` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  PRIMARY KEY (`id_his`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `hospital`.`medico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`medico` (
  `id_med` VARCHAR(10) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `nom_med` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `cor_med` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `tel_med` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  PRIMARY KEY (`id_med`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `hospital`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`persona` (
  `id_per` VARCHAR(10) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `nom_per` VARCHAR(50) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `fec_nac` DATE NOT NULL,
  `dir_dom` VARCHAR(50) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `dir_cor` VARCHAR(50) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `num_tel` VARCHAR(10) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `genero_idgenero` INT NOT NULL,
  `ciudad_idciudad` INT NOT NULL,
  PRIMARY KEY (`id_per`),
  INDEX `fk_persona_genero1_idx` (`genero_idgenero` ASC) VISIBLE,
  INDEX `fk_persona_ciudad1_idx` (`ciudad_idciudad` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `hospital`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`rol` (
  `id_Rol` INT NOT NULL,
  `nom_Rol` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  PRIMARY KEY (`id_Rol`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `hospital`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`usuario` (
  `id_usr` VARCHAR(10) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `fec_ing` DATE NOT NULL,
  `nom_usr` VARCHAR(10) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `pas_usr` VARCHAR(20) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `name_usr` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `cor_usr` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `tel_usr` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `Rol_id_Rol` INT NOT NULL,
  PRIMARY KEY (`id_usr`),
  INDEX `fk_usuario_Rol1_idx` (`Rol_id_Rol` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_Rol1`
    FOREIGN KEY (`Rol_id_Rol`)
    REFERENCES `hospital`.`rol` (`id_Rol`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `hospital`.`cita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`cita` (
  `id_Cita` TINYINT(1) NOT NULL,
  `persona_id_per` VARCHAR(10) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `medico_id_med` VARCHAR(10) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `especialidad_est_esp` TINYINT(1) NOT NULL,
  `usuario_id_usr` VARCHAR(10) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `fec_cit` DATE NOT NULL,
  `hor_cit` TIME NOT NULL,
  `est_cit` VARCHAR(1) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `num_fac` INT NULL DEFAULT NULL,
  `Historia_id_his` INT NULL DEFAULT NULL,
  `diagnostico` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `tratamiento` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `observaciones` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  PRIMARY KEY (`id_Cita`),
  INDEX `fk_Cita_persona1_idx` (`persona_id_per` ASC) VISIBLE,
  INDEX `fk_Cita_medico1_idx` (`medico_id_med` ASC) VISIBLE,
  INDEX `fk_Cita_especialidad1_idx` (`especialidad_est_esp` ASC) VISIBLE,
  INDEX `fk_Cita_usuario1_idx` (`usuario_id_usr` ASC) VISIBLE,
  INDEX `fk_Cita_Historia1_idx` (`Historia_id_his` ASC) VISIBLE,
  CONSTRAINT `fk_Cita_especialidad1`
    FOREIGN KEY (`especialidad_est_esp`)
    REFERENCES `hospital`.`especialidad` (`est_esp`),
  CONSTRAINT `fk_Cita_Historia1`
    FOREIGN KEY (`Historia_id_his`)
    REFERENCES `hospital`.`historia` (`id_his`),
  CONSTRAINT `fk_Cita_medico1`
    FOREIGN KEY (`medico_id_med`)
    REFERENCES `hospital`.`medico` (`id_med`),
  CONSTRAINT `fk_Cita_persona1`
    FOREIGN KEY (`persona_id_per`)
    REFERENCES `hospital`.`persona` (`id_per`),
  CONSTRAINT `fk_Cita_usuario1`
    FOREIGN KEY (`usuario_id_usr`)
    REFERENCES `hospital`.`usuario` (`id_usr`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `hospital`.`examen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`examen` (
  `idexamen` INT NOT NULL,
  `examen` VARCHAR(45) NOT NULL,
  `laboratorio` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idexamen`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hospital`.`cita_examen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`cita_examen` (
  `cita_id_Cita` TINYINT(1) NOT NULL,
  `examen_idexamen` INT NOT NULL,
  `excantidad` INT NOT NULL,
  `exdetalle` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cita_id_Cita`, `examen_idexamen`),
  INDEX `fk_cita_has_examen_examen1_idx` (`examen_idexamen` ASC) VISIBLE,
  INDEX `fk_cita_has_examen_cita1_idx` (`cita_id_Cita` ASC) VISIBLE,
  CONSTRAINT `fk_cita_has_examen_cita1`
    FOREIGN KEY (`cita_id_Cita`)
    REFERENCES `hospital`.`cita` (`id_Cita`),
  CONSTRAINT `fk_cita_has_examen_examen1`
    FOREIGN KEY (`examen_idexamen`)
    REFERENCES `hospital`.`examen` (`idexamen`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `hospital`.`medicamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`medicamento` (
  `idmedicamento` INT NOT NULL,
  `medicamento` VARCHAR(50) NOT NULL,
  `laboratorio` VARCHAR(45) NOT NULL,
  `presenta` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idmedicamento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hospital`.`cita_medicamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`cita_medicamento` (
  `cita_id_Cita` TINYINT(1) NOT NULL,
  `medicamento_idmedicamento` INT NOT NULL,
  `cantidad` INT NOT NULL,
  `detalle` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cita_id_Cita`, `medicamento_idmedicamento`),
  INDEX `fk_cita_has_medicamento_medicamento1_idx` (`medicamento_idmedicamento` ASC) VISIBLE,
  INDEX `fk_cita_has_medicamento_cita1_idx` (`cita_id_Cita` ASC) VISIBLE,
  CONSTRAINT `fk_cita_has_medicamento_cita1`
    FOREIGN KEY (`cita_id_Cita`)
    REFERENCES `hospital`.`cita` (`id_Cita`),
  CONSTRAINT `fk_cita_has_medicamento_medicamento1`
    FOREIGN KEY (`medicamento_idmedicamento`)
    REFERENCES `hospital`.`medicamento` (`idmedicamento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `hospital`.`ciudad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`ciudad` (
  `idciudad` INT NOT NULL,
  `nom_ciudad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idciudad`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hospital`.`detalle fac`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`detalle fac` (
  `id_det` INT NOT NULL,
  `cant` INT NOT NULL,
  `detalle` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `valor` DOUBLE NOT NULL,
  PRIMARY KEY (`id_det`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `hospital`.`factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`factura` (
  `id_fac` INT NOT NULL,
  `cedula` VARCHAR(10) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `nombre` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `direccion` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `telefono` VARCHAR(10) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `total` DOUBLE NOT NULL,
  `Cita_id_Cita` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id_fac`),
  INDEX `fk_factura_Cita1_idx` (`Cita_id_Cita` ASC) VISIBLE,
  CONSTRAINT `fk_factura_Cita1`
    FOREIGN KEY (`Cita_id_Cita`)
    REFERENCES `hospital`.`cita` (`id_Cita`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `hospital`.`detalle fac_has_factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`detalle fac_has_factura` (
  `detalle fac_id_det` INT NOT NULL,
  `factura_id_fac` INT NOT NULL,
  PRIMARY KEY (`detalle fac_id_det`, `factura_id_fac`),
  INDEX `fk_detalle fac_has_factura_factura1_idx` (`factura_id_fac` ASC) VISIBLE,
  INDEX `fk_detalle fac_has_factura_detalle fac1_idx` (`detalle fac_id_det` ASC) VISIBLE,
  CONSTRAINT `fk_detalle fac_has_factura_detalle fac1`
    FOREIGN KEY (`detalle fac_id_det`)
    REFERENCES `hospital`.`detalle fac` (`id_det`),
  CONSTRAINT `fk_detalle fac_has_factura_factura1`
    FOREIGN KEY (`factura_id_fac`)
    REFERENCES `hospital`.`factura` (`id_fac`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `hospital`.`genero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`genero` (
  `idgenero` INT NOT NULL,
  `genero` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idgenero`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hospital`.`medico_especialidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`medico_especialidad` (
  `medico_id_med` VARCHAR(10) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `especialidad_est_esp` TINYINT(1) NOT NULL,
  PRIMARY KEY (`medico_id_med`, `especialidad_est_esp`),
  INDEX `fk_medico_has_especialidad_especialidad1_idx` (`especialidad_est_esp` ASC) VISIBLE,
  INDEX `fk_medico_has_especialidad_medico1_idx` (`medico_id_med` ASC) VISIBLE,
  CONSTRAINT `fk_medico_has_especialidad_especialidad1`
    FOREIGN KEY (`especialidad_est_esp`)
    REFERENCES `hospital`.`especialidad` (`est_esp`),
  CONSTRAINT `fk_medico_has_especialidad_medico1`
    FOREIGN KEY (`medico_id_med`)
    REFERENCES `hospital`.`medico` (`id_med`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `hospital`.`opciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`opciones` (
  `idmenus` INT NOT NULL,
  `nom_menu` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  PRIMARY KEY (`idmenus`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `hospital`.`menu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital`.`menu` (
  `opciones_idmenus` INT NOT NULL,
  `Rol_id_Rol` INT NOT NULL,
  PRIMARY KEY (`opciones_idmenus`, `Rol_id_Rol`),
  INDEX `fk_opciones_has_Rol_Rol1_idx` (`Rol_id_Rol` ASC) VISIBLE,
  INDEX `fk_opciones_has_Rol_opciones1_idx` (`opciones_idmenus` ASC) VISIBLE,
  CONSTRAINT `fk_opciones_has_Rol_opciones1`
    FOREIGN KEY (`opciones_idmenus`)
    REFERENCES `hospital`.`opciones` (`idmenus`),
  CONSTRAINT `fk_opciones_has_Rol_Rol1`
    FOREIGN KEY (`Rol_id_Rol`)
    REFERENCES `hospital`.`rol` (`id_Rol`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


-- -----------------------------------------------------
-- DATOS INICIALES
-- -----------------------------------------------------
INSERT INTO `hospital`.`rol` (`id_Rol`, `nom_Rol`) VALUES ('1', 'Admin');
INSERT INTO `hospital`.`rol` (`id_Rol`, `nom_Rol`) VALUES ('2 ', 'Secretaria');
INSERT INTO `hospital`.`rol` (`id_Rol`, `nom_Rol`) VALUES ('3', 'Medico');
INSERT INTO `hospital`.`rol` (`id_Rol`, `nom_Rol`) VALUES ('4', 'Paciente');

INSERT INTO `hospital`.`usuario` (`id_usr`, `fec_ing`, `nom_usr`, `pas_usr`, `name_usr`, `cor_usr`, `tel_usr`, `Rol_id_Rol`) VALUES ('admin', '2022-01-25', 'admin', 'root', 'admin', 'admin@gmail.com', '0999', '1');
INSERT INTO `hospital`.`usuario` (`id_usr`, `fec_ing`, `nom_usr`, `pas_usr`, `name_usr`, `cor_usr`, `tel_usr`, `Rol_id_Rol`) VALUES ('paciente', '2022-01-25', 'paciente', 'root', 'paciente', 'paciente@gmail.com', '0988', '4');


INSERT INTO `hospital`.`genero` (`idgenero`, `genero`) VALUES ('1', 'Femenino');
INSERT INTO `hospital`.`genero` (`idgenero`, `genero`) VALUES ('2', 'Masculino');


INSERT INTO `hospital`.`ciudad` (`idciudad`, `nom_ciudad`) VALUES ('1', 'Loja');
INSERT INTO `hospital`.`ciudad` (`idciudad`, `nom_ciudad`) VALUES ('2', 'Cuenca');
INSERT INTO `hospital`.`ciudad` (`idciudad`, `nom_ciudad`) VALUES ('3', 'Guayaquil');
INSERT INTO `hospital`.`ciudad` (`idciudad`, `nom_ciudad`) VALUES ('4', 'Quito');
INSERT INTO `hospital`.`ciudad` (`idciudad`, `nom_ciudad`) VALUES ('5', 'Ambato');
INSERT INTO `hospital`.`ciudad` (`idciudad`, `nom_ciudad`) VALUES ('6', 'Machala');

INSERT INTO `hospital`.`especialidad` (`nom_esp`, `fec_cre`, `est_esp`) VALUES ('Cardiología', '2022-01-25', '1');
INSERT INTO `hospital`.`especialidad` (`nom_esp`, `fec_cre`, `est_esp`) VALUES ('Pediatría', '2022-01-25', '2');
INSERT INTO `hospital`.`especialidad` (`nom_esp`, `fec_cre`, `est_esp`) VALUES ('Gastroenterología', '2022-01-25', '3');

INSERT INTO `hospital`.`examen` (`idexamen`, `examen`, `laboratorio`) VALUES ('1', 'Endoscopia', 'Exalab');
INSERT INTO `hospital`.`examen` (`idexamen`, `examen`, `laboratorio`) VALUES ('2', 'Tomografía', 'Veris');
INSERT INTO `hospital`.`examen` (`idexamen`, `examen`, `laboratorio`) VALUES ('3', 'Rayos X', 'Imagenlab');

INSERT INTO `hospital`.`medicamento` (`idmedicamento`, `medicamento`, `laboratorio`, `presenta`) VALUES ('1', 'Paracetamol', 'Pfyzer', '1gr');
INSERT INTO `hospital`.`medicamento` (`idmedicamento`, `medicamento`, `laboratorio`, `presenta`) VALUES ('2', 'Ibuprofeno', 'Generico', '600mg');
INSERT INTO `hospital`.`medicamento` (`idmedicamento`, `medicamento`, `laboratorio`, `presenta`) VALUES ('3', 'Omeprazol', 'Bayern', '20mg');




