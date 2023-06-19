create database coffee;

use coffee;

CREATE TABLE user (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NOT NULL,
  age INT NOT NULL,
  role VARCHAR(45) NULL,
  password VARCHAR(45) NOT NULL);
  
  CREATE TABLE coffee(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(45) NOT NULL,
	description VARCHAR(200) NULL,
    price DOUBLE NOT NULL,
    creator VARCHAR(30) NOT NULL);
    
    SELECT * FROM user;
    SELECT * FROM coffee;
	drop table user;
    
INSERT INTO user (name, age, role, password) VALUES ('Bianca Andrade', '12', 'estudante', '12345');
INSERT INTO user (name, age, role, password) VALUES ('Bia an', '15', 'studante', '1269');
INSERT INTO user (name, age, role, password) VALUES ('Gab Matias', '28', 'gerente', 'qwerty');
INSERT INTO user (name, age, role, password) VALUES ('Jotin', '56', 'cliente', 'cleto');
INSERT INTO user (name, age, role, password) VALUES ('Brito', '09', 'vendedor', 'pokemon');
INSERT INTO user (name, age, role, password) VALUES ('ana', '89', 'caixa', 'd1nd1n');
INSERT INTO user (name, age, role, password) VALUES ('Victor', '59', 'cliente', 'wow');
INSERT INTO user (name, age, role, password) VALUES ('Carlos', '45', 'cliente', '1v1b2b');

INSERT INTO coffee (name, description, price, creator) VALUES ('Cafe Preto', 'cafe forte muito bom com tons amaderaidos', '45.99','Bianaca' );
INSERT INTO coffee (name, description, price, creator) VALUES ('Cafe Marrom', 'cafe  muito bom com tons amaderaidos', '60.99','Farias' );
INSERT INTO coffee (name, description, price, creator) VALUES ('Cafe Caramelo', 'cafe adocicado muito bom com tons amaderaidos', '89.99','Lois' );
INSERT INTO coffee (name, description, price, creator) VALUES ('Cafe Branco', 'cafe fraco muito bom com tons amaderaidos', '99.99','PaiPai' );
