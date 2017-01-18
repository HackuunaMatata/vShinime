CREATE DATABASE `vshinime` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE articles
(
    user_id INT(11) NOT NULL,
    title VARCHAR(100) NOT NULL,
    annotation VARCHAR(500),
    date DATE NOT NULL
);

CREATE TABLE messages
(
    id_from INT(11) NOT NULL,
    id_to INT(11) NOT NULL,
    text TEXT NOT NULL,
    datetime DATETIME NOT NULL,
    `read` TINYINT(1) NOT NULL
);

CREATE TABLE positions
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);
CREATE UNIQUE INDEX positions_id_uindex ON positions (id);
CREATE UNIQUE INDEX positions_name_uindex ON positions (name);

CREATE TABLE userinfo
(
    id INT(11) PRIMARY KEY NOT NULL,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    position_id INT(11) NOT NULL,
    bday DATE NOT NULL,
    magazine VARCHAR(70) NOT NULL,
    photo VARCHAR(50)
);
CREATE UNIQUE INDEX UserInfo_id_uindex ON userinfo (id);

CREATE TABLE users
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    login VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(50)
);
CREATE UNIQUE INDEX users_id_uindex ON users (id);
CREATE UNIQUE INDEX users_login_uindex ON users (login);

INSERT INTO `users` (`id`,`login`,`password`,`email`) VALUES (12,'admin','admin','Kozerog1996@yandex.ru');

INSERT INTO `users` (`id`,`login`,`password`,`email`) VALUES (13,'Nikita','Nikita','vesdet@gmail.com');

INSERT INTO `users` (`id`,`login`,`password`,`email`) VALUES (14,'Dima','Dima','pxjoke@qmail.com');

INSERT INTO `users` (`id`,`login`,`password`,`email`) VALUES (15,'Filipp','Filipp','filipp@makedonia.com');


INSERT INTO `userinfo` (`id`,`name`,`surname`,`position_id`,`bday`,`magazine`,`photo`) VALUES (12,'Александра','Панкратова',4,'1996-01-01','Политех','null');

INSERT INTO `userinfo` (`id`,`name`,`surname`,`position_id`,`bday`,`magazine`,`photo`) VALUES (13,'Никита','Рыжов',5,'1995-06-27','EPAM','null');

INSERT INTO `userinfo` (`id`,`name`,`surname`,`position_id`,`bday`,`magazine`,`photo`) VALUES (14,'Дмитрий','Груздев',3,'1995-04-23','EPAM','null');

INSERT INTO `userinfo` (`id`,`name`,`surname`,`position_id`,`bday`,`magazine`,`photo`) VALUES (15,'Филипп','Македонский',2,'1996-02-27','ЕКБ','null');


INSERT INTO `positions` (`id`,`name`) VALUES (2,'Глава правления');

INSERT INTO `positions` (`id`,`name`) VALUES (3,'Журналист');

INSERT INTO `positions` (`id`,`name`) VALUES (5,'Журналист и Глава правления');

INSERT INTO `positions` (`id`,`name`) VALUES (1,'Руководитель');

INSERT INTO `positions` (`id`,`name`) VALUES (4,'Руководитель и Глава правления');

INSERT INTO `messages` (`id_from`,`id_to`,`text`,`datetime`,`read`) VALUES (13,12,'Привет','2017-01-18 22:23:19',0);

INSERT INTO `messages` (`id_from`,`id_to`,`text`,`datetime`,`read`) VALUES (14,13,'привет. я Дима','2017-01-18 22:34:22',0);

INSERT INTO `messages` (`id_from`,`id_to`,`text`,`datetime`,`read`) VALUES (15,13,'hi','2017-01-18 22:38:45',0);


INSERT INTO `articles` (`user_id`,`title`,`annotation`,`date`) VALUES (12,'Первая статья','Самая-самая первая статья','2016-01-18');

INSERT INTO `articles` (`user_id`,`title`,`annotation`,`date`) VALUES (13,'Сентябрь','Осень','2016-09-13');

INSERT INTO `articles` (`user_id`,`title`,`annotation`,`date`) VALUES (13,'Май','Весна','2015-05-13');

INSERT INTO `articles` (`user_id`,`title`,`annotation`,`date`) VALUES (15,'Дота для задрота','WOW vs WOT','2017-01-18');
