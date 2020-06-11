--create table person
--(
--   id integer not null,
--   name varchar(255) not null,
--   location varchar(255),
--   birth_date timestamp,
--   primary key(id)
--);


INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(10001,  'Ranga', 'Hyderabad',sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(10002,  'James', 'New York',sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(10003,  'Pieter', 'Amsterdam',sysdate());

INSERT INTO COURSE(ID, NAME) VALUES (20001, 'SPRING IN 50 STEPS');
INSERT INTO COURSE(ID, NAME) VALUES (20002, 'JPA IN 50 STEPS');
INSERT INTO COURSE(ID, NAME) VALUES (20003, 'SPRINGBOOT IN 50 STEPS');