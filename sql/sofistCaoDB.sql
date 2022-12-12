SET @@global.time_zone = '-3:00';
CREATE USER sofistCaoDB@localhost IDENTIFIED BY 'senha123';
CREATE DATABASE sofistCaoDB CHARACTER SET utf8 COLLATE utf8_general_ci;
GRANT ALL PRIVILEGES ON sofistCaoDB.* TO sofistCaoDB@localhost;
USE sofistCaoDB;

CREATE TABLE IF NOT EXISTS pet(
  idPet INT NOT NULL AUTO_INCREMENT,
  tipoDePet VARCHAR(30) NOT NULL,
  nome VARCHAR(50) NOT NULL,
  idade int NOT NULL,
  raca VARCHAR(50) NOT NULL,
  ultimoDono VARCHAR(50) NOT NULL,
  descricao VARCHAR(200) NOT NULL,
  PRIMARY KEY (idPet))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS Cliente (
  idCliente INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  dataNasc VARCHAR(50) NOT NULL,
  cpf VARCHAR(50) NOT NULL,
  celular VARCHAR(50) NOT NULL,
  cep VARCHAR(50) NOT NULL,
  ocupacao VARCHAR(50) NOT NULL,
  PRIMARY KEY (idCliente))
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS Adotados (
  idAdotados INT NOT NULL AUTO_INCREMENT,
  tipoDoPet VARCHAR(50) NOT NULL,
  nomeDoPet VARCHAR(50) NOT NULL,
  RacaDoPet VARCHAR(50) NOT NULL,
  idCliente int NOT NULL,
  dataAdocao VARCHAR(50) NOT NULL,
  FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente),
  PRIMARY KEY (idAdotados))
  ENGINE = InnoDB;

insert into pet (tipoDePet, nome, idade, raca, ultimoDono , descricao) values (
"cachorro", "Carlos", "5", "shitzu", "Ana Claudia", "fofo e carinhoso"
);
insert into pet (tipoDePet, nome, idade, raca, ultimoDono , descricao) values (
"gato", "Marie", "3", "Amarelo", "Jerusa", "preguiçosa e amável"
);
insert into pet (tipoDePet, nome, idade, raca, ultimoDono , descricao) values (
"cachorro", "Valentina", "4", "vira-lata", "Jeferson", "carente e mimada"
);
insert into Adotados ( tipoDoPet, nomeDoPet, RacaDoPet, dataAdocao) values(
"gato", "Roberto", "Cinza", "14/11/2022"
);
insert into Adotados ( tipoDoPet, nomeDoPet, RacaDoPet, dataAdocao) values(
"cachorro", "bruno", "vira-lata", "20/05/2022"
);