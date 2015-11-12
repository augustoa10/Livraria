DROP DATABASE IF EXISTS livraria;
CREATE SCHEMA IF NOT EXISTS livraria DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE livraria ;

-- -----------------------------------------------------
-- Table `livraria`.`Livro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Livro (
  idLivro INT NOT NULL AUTO_INCREMENT,
  isbn INT NULL,
  titulo VARCHAR(50) NULL,
  dataPublicacao VARCHAR(15) NULL,
  precoVenda DOUBLE NULL,
  resumo TEXT NULL,
  indice TEXT NULL,
  precoCusto DOUBLE NULL,
  margemLucro DOUBLE NULL,
  estoque INT NULL,
  PRIMARY KEY (idLivro))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `livraria`.`Autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Autor (
  idAutor INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(120) NULL,
  dataNascimento VARCHAR(15) NULL,
  dataFalecimento VARCHAR(15) NULL,
  localNascimento VARCHAR(80) NULL,
  localFalecimento VARCHAR(80) NULL,
  biografia TEXT NULL,
  PRIMARY KEY (idAutor))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `livraria`.`Editora`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Editora (
  idEditora INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(120) NULL,
  endereco VARCHAR(120) NULL,
  telefone VARCHAR(20) NULL,
  cnpj VARCHAR(20) NULL,
  PRIMARY KEY (idEditora))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `livraria`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Categoria (
  idCategoria INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(120) NULL,
  PRIMARY KEY (idCategoria))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Livro_has_Autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Livro_has_Autor (
  Livro_idLivro 	INT NOT NULL,
  Autor_idAutor 	INT NOT NULL,
  PRIMARY KEY (Livro_idLivro, Autor_idAutor),
  FOREIGN KEY (Livro_idLivro) REFERENCES Livro (idLivro),
  FOREIGN KEY (Autor_idAutor) REFERENCES Autor (idAutor))
  ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Livro_has_Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Livro_has_Categoria (
  Livro_idLivro 			INT NOT NULL,
  Categoria_idCategoria 	INT NOT NULL,
  PRIMARY KEY (Livro_idLivro, Categoria_idCategoria),
  FOREIGN KEY (Livro_idLivro) REFERENCES Livro (idLivro),
  FOREIGN KEY (Categoria_idCategoria) REFERENCES Categoria (idCategoria))
  ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `livraria`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Cliente (
  idCliente INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(120) NULL,
  sobrenome VARCHAR(120) NULL,
  email VARCHAR(50) NULL,
  senha VARCHAR(20) NULL,
  confirmaSenha VARCHAR(20) NULL,
  cpf VARCHAR(20) NULL,
  sexo VARCHAR(20) NULL,
  dataNascimento VARCHAR(15) NULL,
  telefone VARCHAR(20) NULL,
  celular VARCHAR(20) NULL,
  cidade VARCHAR(30) NULL,
  bairro VARCHAR(30) NULL,
  rua VARCHAR(30) NULL,
  numero VARCHAR(20) NULL,
  PRIMARY KEY (idCliente))
ENGINE = InnoDB;

