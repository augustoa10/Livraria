CREATE SCHEMA IF NOT EXISTS `livraria` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `livraria` ;

-- -----------------------------------------------------
-- Table `livraria`.`Autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livraria`.`Autor` (
  `idAutor` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(120) NULL,
  `dataNascimento` VARCHAR(15) NULL,
  `dataFalecimento` VARCHAR(15) NULL,
  `localNascimento` VARCHAR(80) NULL,
  `localFalecimento` VARCHAR(80) NULL,
  `biografia` TEXT NULL,
  PRIMARY KEY (`idAutor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `livraria`.`Editora`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livraria`.`Editora` (
  `idEditora` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(120) NULL,
  `endereco` VARCHAR(120) NULL,
  `telefone` VARCHAR(40) NULL,
  `cnpj` VARCHAR(30) NULL,
  PRIMARY KEY (`idEditora`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `livraria`.`Livro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livraria`.`Livro` (
  `idLivro` INT NOT NULL AUTO_INCREMENT,
  `isbn` VARCHAR(20) NULL,
  `titulo` VARCHAR(50) NULL,
  `dataPublicacao` VARCHAR(15) NULL,
  `categoria` VARCHAR(40) NULL,
  `precoVenda` DOUBLE NULL,
  `resumo` TEXT NULL,
  `indice` TEXT NULL,
  `precoCusto` DOUBLE NULL,
  `margemLucro` DOUBLE NULL,
  `estoque` INT NULL,
  `autor` TEXT NOT NULL,
  `editora` INT NOT NULL,
  PRIMARY KEY (`idLivro`),
  INDEX `fk_Livro_Editora1_idx` (`editora` ASC),
  CONSTRAINT `fk_Livro_Editora1`
    FOREIGN KEY (`editora`)
    REFERENCES `livraria`.`Editora` (`idEditora`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `livraria`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livraria`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(120) NULL,
  `sobrenome` VARCHAR(120) NULL,
  `email` VARCHAR(50) NULL,
  `senha` VARCHAR(20) NULL,
  `cpf` VARCHAR(20) NULL,
  `dataNascimento` VARCHAR(15) NULL,
  `telefone` VARCHAR(30) NULL,
  `endereco` VARCHAR(150) NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB
COMMENT = '		';
