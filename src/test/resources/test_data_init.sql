-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: transferapp
-- ------------------------------------------------------
-- Server version	8.0.18


DELETE FROM `patient`;
DELETE FROM `patHistory`;

--
-- Dumping data for table `user_account`
--
INSERT INTO `patient` (id,address, dob, family, given, phone, sex)
VALUES
(1,'2 Warren Street','1968-06-22','Ferguson','Lucas','387-866-1399','M'),
(2,'745 West Valley Farms Drive','1952-09-27','Rees','Pippa','628-423-0993','F'),
(3,'599 East Garden Ave','1952-11-11','Arnold','Edward','123-727-2779','M'),
(4,'894 Hall Street','1946-11-26','Sharp','Anthony','451-761-8383','M'),
(5,'4 Southampton Road','1958-06-29','Ince','Wendy','802-911-9975','F'),
(6,'40 Sulphur Springs Dr','1949-12-07','Ross','Tracey','131-396-5049','F'),
(7,'12 Cobblestone St','1966-12-31','Wilson','Claire','300-452-1091','F'),
(8,'193 Vale St','1945-06-24','Buckland','Max','833-534-0864','M'),
(9,'12 Beechwood Road','1964-06-18','Clark','Natalie','241-467-9197','F'),
(10,'1202 Bumble Dr','1959-06-28','Bailey','Piers','747-815-0557','M');


INSERT INTO `patHistory` (note, patId)
VALUES
('Le patient déclare qu\'il \" se sent très bien \" Poids égal ou inférieur au poids recommandé','1'),
('Le patient déclare qu\'il se sent fatigué pendant la journée Il se plaint également de douleurs musculaires Tests de laboratoire indiquant une microalbumine élevée','1'),
('Le patient déclare qu\'il ne se sent pas si fatigué que ça Fumeur, il a arrêté dans les 12 mois précédents Tests de laboratoire indiquant que les anticorps sont élevés','1'),
('Le patient déclare qu\'il ressent beaucoup de stress au travail Il se plaint également que son audition est anormale dernièrement'','2'),
('Le patient déclare avoir fait une réaction aux médicaments au cours des 3 derniers mois Il remarque également que son audition continue d\'être anormale'','2'),
('Tests de laboratoire indiquant une microalbumine élevée'','2'),
('Le patient déclare que tout semble aller bien Le laboratoire rapporte que l\'hémoglobine A1C dépasse le niveau recommandé Le patient déclare qu’il fume depuis longtemps','2'),
('Le patient déclare qu\'il fume depuis peu','3'),
('Tests de laboratoire indiquant une microalbumine élevée','3'),
('Le patient déclare qu\'il est fumeur et qu\'il a cessé de fumer l\'année dernière Il se plaint également de crises d\'apnée respiratoire anormales Tests de laboratoire indiquant un taux de cholestérol LDL élevé','3'),
('Tests de laboratoire indiquant un taux de cholestérol LDL élevé','3'),
('Le patient déclare qu\'il lui est devenu difficile de monter les escaliers Il se plaint également d’être essoufflé Tests de laboratoire indiquant que les anticorps sont élevés Réaction aux médicaments','4'),
('Le patient déclare qu\'il a mal au dos lorsqu\'il reste assis pendant longtemps','4'),
('Le patient déclare avoir commencé à fumer depuis peu Hémoglobine A1C supérieure au niveau recommandé','4'),
('Le patient déclare avoir des douleurs au cou occasionnellement Le patient remarque également que certains aliments ont un goût différent Réaction apparente aux médicaments Poids corporel supérieur au poids recommandé','5'),
('Le patient déclare avoir eu plusieurs épisodes de vertige depuis la dernière visite. Taille incluse dans la fourchette concernée','5'),
('Le patient déclare qu\'il souffre encore de douleurs cervicales occasionnelles Tests de laboratoire indiquant une microalbumine élevée Fumeur, il a arrêté dans les 12 mois précédents','5'),
('Le patient déclare avoir eu plusieurs épisodes de vertige depuis la dernière visite. Tests de laboratoire indiquant que les anticorps sont élevés','5'),
('Le patient déclare qu\'il se sent bien Poids corporel supérieur au poids recommandé','6'),
('Le patient déclare qu\'il se sent bien','6'),
('Le patient déclare qu\'il se réveille souvent avec une raideur articulaire Il se plaint également de difficultés pour s’endormir Poids corporel supérieur au poids recommandé Tests de laboratoire indiquant un taux de cholestérol LDL élevé','7'),
('Les tests de laboratoire indiquent que les anticorps sont élevés Hémoglobine A1C supérieure au niveau recommandé','8'),
('Le patient déclare avoir de la difficulté à se concentrer sur ses devoirs scolaires Hémoglobine A1C supérieure au niveau recommandé','9'),
('Le patient déclare qu\'il s’impatiente facilement en cas d’attente prolongée Il signale également que les produits du distributeur automatique ne sont pas bons Tests de laboratoire signalant des taux anormaux de cellules sanguines','9'),
('Le patient signale qu\'il est facilement irrité par des broutilles Il déclare également que l\'aspirateur des voisins fait trop de bruit Tests de laboratoire indiquant que les anticorps sont élevés','9'),
('Le patient déclare qu\'il n\'a aucun problème','10'),
('Le patient déclare qu\'il n\'a aucun problème Taille incluse dans la fourchette concernée Hémoglobine A1C supérieure au niveau recommandé','10'),
('Le patient déclare qu\'il n\'a aucun problème Poids corporel supérieur au poids recommandé Le patient a signalé plusieurs épisodes de vertige depuis sa dernière visite','10'),
('Le patient déclare qu\'il n\'a aucun problème  Tests de laboratoire indiquant une microalbumine élevée','10');