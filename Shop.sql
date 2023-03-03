DROP DATABASE IF EXISTS Shop;
CREATE DATABASE Shop;
USE Shop;
-- Ex 1.1 a 1.4
-- 1.1 = lancer le script avec source Shop.sql
-- 1.2 = show tables;
CREATE TABLE T_articles ( 
IdArticle int(4) PRIMARY KEY AUTO_INCREMENT,
Description varchar(30) NOT NULL,
Brand varchar(30) NOT NULL,
UnitaryPrice float(8) NOT NULL

) ENGINE = InnoDB;
--- 1.3 = describe t_article; pour afficher la table.
INSERT into T_articles (Description, Brand, UnitaryPrice) values ('Souris', 'Logitoch', 65);
INSERT into T_articles (Description, Brand, UnitaryPrice) values ('Clavier', 'Microhard', 49.5);
INSERT into T_articles (Description, Brand, UnitaryPrice) values ('OS', 'Fenetre', 150);
INSERT into T_articles (Description, Brand, UnitaryPrice) values ('Tapis de Souris', 'Chapeau Bleu', 5);
INSERT into T_articles (Description, Brand, UnitaryPrice) values ('Cle USB 8 To', 'Syno', 8);
INSERT into T_articles (Description, Brand, UnitaryPrice) values ('Laptop', 'PH', 1199);
INSERT into T_articles (Description, Brand, UnitaryPrice) values ('CD x 500', 'CETME', 250);
INSERT into T_articles (Description, Brand, UnitaryPrice) values ('DVD-R x100', 'CETME', 99);
INSERT into T_articles (Description, Brand, UnitaryPrice) values ('DVD+R', 'CETME', 105);
INSERT into T_articles (Description, Brand, UnitaryPrice) values ('Batterie Laptop', 'PH', 80);
INSERT into T_articles (Description, Brand, UnitaryPrice) values ('Casque Audio', 'Syno', 105);
INSERT into T_articles (Description, Brand, UnitaryPrice) values ('WebCam', 'Logitoch', 755);

SELECT * FROM T_articles;

CREATE TABLE T_users (
IdUser int(4) PRIMARY KEY AUTO_INCREMENT,
Login varchar(20) NOT NULL,
Password varchar(30) NOT NULL

) ENGINE = InnoDB;

INSERT INTO T_users (IdUser, Login, Password) values (1, 'Anderson', 'Neo');
INSERT INTO T_users (IdUser, Login, Password) values (2, 'Skywalker', 'Luke');
INSERT INTO T_users (IdUser, Login, Password) values (3, 'Plissken', 'Snake');
INSERT INTO T_users (IdUser, Login, Password) values (4, 'Ripley', 'Ellen');

SELECT * FROM T_users;
-- 1.4 ajout d'occurences :
INSERT INTO T_articles (Description, Brand, UnitaryPrice) values ('IPhone 50', 'Pomme', 20000);
INSERT INTO T_articles (Description, Brand, UnitaryPrice) values ('Carte graphique', 'Radin', 79);
-- Ex. 1.5 - Modif élément

--UPDATE T_articles
--SET Description = 'Camera',
--UnitaryPrice = 75.5
--WHERE IdArticle = 12

-- Ex 1.6 : Supprimer un élément (ne pas oublier WHERE)
-- DELETE FROM t_article WHERE cond;
-- Ex 1.7 Select PU from t_articles where PU > 100;
-- Ex 1.8 Select * from t_articles where PU between 50 and 150;
-- Ex 1.9 select UnitaryPrice, IdArticle from t_articles order by UnitaryPrice;
-- Ex 1.10 select Description from t_articles;
-- Ex 1.11 SELECT DISTINCT `colonne` = permet de retirer les doublons qui se trouvent dans une BDD.
-- Variante = SELECT COUNT(*) AS doublon, PrixUnitaire
-- From t_articles
-- GROUP BY UnitaryPrice
-- HAVING COUNT UnitaryPrice > 1
-- Pour repérer et supprimer des doublons dans une catégorie.
-- Ex 1.12 Création de t_category :

CREATE TABLE T_categories ( 

IdCategory INT(4) PRIMARY KEY AUTO_INCREMENT,
CatName VARCHAR(30) NOT NULL,
Description VARCHAR(100) NOT NULL

) ENGINE = InnoDB;


INSERT INTO T_categories (IdCategory, CatName, Description) values (1, 'Hardware', 'Materiel info servant a utiliser un ordinateur');
INSERT INTO T_categories (IdCategory, CatName, Description) values (10, 'Software', 'Logiciels exploitables, coutent souvent trop cher');
INSERT INTO T_categories (IdCategory, CatName, Description) values (11, 'Smartphone', 'Outil servant a plein de trucs, sauf telephonner');
INSERT INTO T_categories (IdCategory, CatName, Description) values (100, 'PC', 'Ordinateur personnel, lieu ou naissent les geeks');

ALTER TABLE T_articles ADD COLUMN IdCategory INT(4);
ALTER TABLE T_articles ADD FOREIGN KEY(IdCategory) REFERENCES T_categories(IdCategory);
-- Une colonne a bien été ajoutée, mais prend la valeur NULL par défaut.
-- 1.12 Pour ajouter des éléments : update t_articles set IdCategory (foreign key) where IdArticle (primary);

INSERT INTO T_articles (Description, Brand, UnitaryPrice) values ('Office', 'Microhard', 150);

UPDATE T_articles
SET description = 'Camera',
unitaryPrice = 75.5,
WHERE idArticle = 12