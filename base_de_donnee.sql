DROP TABLE IF EXISTS JOPARTICIPER;
DROP TABLE IF EXISTS JOACCUEILLIR;
DROP TABLE IF EXISTS JOSCORE;
DROP TABLE IF EXISTS JOATHLETE;
DROP TABLE IF EXISTS JOEPREUVE;
DROP TABLE IF EXISTS JOEQUIPE;
DROP TABLE IF EXISTS JOSPORT;
DROP TABLE IF EXISTS JOPAYS;



CREATE TABLE JOACCUEILLIR (
    idEpreuve INT NOT NULL,
    idEquipe  INT NOT NULL,
    PRIMARY KEY (idEpreuve, idEquipe)
);


CREATE TABLE JOATHLETE (
    idA        INT NOT NULL,
    nomA       VARCHAR(42),
    prenomA    VARCHAR(42),
    sexeA      CHAR(1),
    forceA     INT,
    agiliteA   INT,
    enduranceA INT,
    nbOrA      INT,
    nbArgentA  INT,
    nbBronzeA  INT,
    idEquipe   INT NOT NULL,
    nomPays    VARCHAR(42),
    PRIMARY KEY (idA)
);

CREATE TABLE JOEPREUVE (
    idEpreuve    INT NOT NULL,
    nomEpreuve   VARCHAR(42),
    genreEpreuve CHAR(1),
    idS          INT NOT NULL,
    PRIMARY KEY (idEpreuve)
);

CREATE TABLE JOEQUIPE (
    idEquipe        INT NOT NULL,
    nomEquipe       VARCHAR(42),
    nbOrEquipe      INT,
    nbArgentEquipe  INT,
    nbBronzeEquipe  INT,
    PRIMARY KEY (idEquipe)
);

CREATE TABLE JOPARTICIPER (
    idEpreuve INT NOT NULL,
    idA       INT NOT NULL,
    PRIMARY KEY (idEpreuve, idA)
);

CREATE TABLE JOPAYS (
    nomPays VARCHAR(42),
    PRIMARY KEY (nomPays)
);

CREATE TABLE JOSCORE (
    idScore       INT NOT NULL,
    positionScore INT,
    score         FLOAT,
    idEpreuve     INT NOT NULL,
    idA           INT NOT NULL,
    PRIMARY KEY (idScore)
);

CREATE TABLE JOSPORT (
    idS              INT NOT NULL,
    nomSport         VARCHAR(42),
    nbMembresEquipe  INT,
    distance         INT,
    arme             VARCHAR(42),
    PRIMARY KEY (idS)
);

ALTER TABLE JOACCUEILLIR ADD FOREIGN KEY (idEquipe) REFERENCES JOEQUIPE (idEquipe);
ALTER TABLE JOACCUEILLIR ADD FOREIGN KEY (idEpreuve) REFERENCES JOEPREUVE (idEpreuve);

ALTER TABLE JOATHLETE ADD FOREIGN KEY (nomPays) REFERENCES JOPAYS (nomPays);
ALTER TABLE JOATHLETE ADD FOREIGN KEY (idEquipe) REFERENCES JOEQUIPE (idEquipe);

ALTER TABLE JOEPREUVE ADD FOREIGN KEY (idS) REFERENCES JOSPORT (idS);

ALTER TABLE JOPARTICIPER ADD FOREIGN KEY (idA) REFERENCES JOATHLETE (idA);
ALTER TABLE JOPARTICIPER ADD FOREIGN KEY (idEpreuve) REFERENCES JOEPREUVE (idEpreuve);

ALTER TABLE JOSCORE ADD FOREIGN KEY (idEquipe) REFERENCES JOEQUIPE (idEquipe);
ALTER TABLE JOSCORE ADD FOREIGN KEY (idA) REFERENCES JOATHLETE (idA);
ALTER TABLE JOSCORE ADD FOREIGN KEY (idEpreuve) REFERENCES JOEPREUVE (idEpreuve);

INSERT INTO JOSPORT (idS, nomSport, nbMembresEquipe, distance, arme) VALUES (1, 'Athlétisme', 4, 110, null),
                                                                            (2, 'Athlétisme', 4, 400, null),
                                                                            (3, 'Escrime', null, null, 'fleuret'),
                                                                            (4, 'Escrime', null, null, 'épée'),
                                                                            (5, 'Handball', 7, null, null),
                                                                            (6, 'Natation', 4, 100, null),
                                                                            (7, 'Natation', 4, 400, null),
                                                                            (8, 'Volley-ball', 6, null, null); 

INSERT INTO JOPAYS (nomPays) VALUES ('Allemagne'),
                                    ('Angleterre'),
                                    ('Australie'),
                                    ('Biélorussie'),
                                    ('Brésil'),
                                    ('Chine'),
                                    ('Etats-Unis'),
                                    ('France'),
                                    ('Grande-Bretagne'),
                                    ('Italie'),
                                    ('Japon'),
                                    ('Kenya'),
                                    ('Maroc'),
                                    ('Pays-Bas'),
                                    ('ROC'),
                                    ('Turquie');

INSERT INTO JOEPREUVE (idEpreuve, nomEpreuve, genreEpreuve, idS) VALUES (1, 'Natation 100 brasse', 'F', 6),
                                                                        (2, 'Natation 100 brasse', 'M', 6),
                                                                        (3, 'Natation relais libre', 'F', 7),
                                                                        (4, 'Natation relais libre', 'M', 7),
                                                                        (5, 'Handball', 'F', 5),
                                                                        (6, 'Handball', 'M', 5),
                                                                        (7, 'Volley-Ball', 'F', 8),
                                                                        (8, 'Volley-Ball', 'M', 8),
                                                                        (9, 'Escrime fleuret', 'F', 3),
                                                                        (10, 'Escrime fleuret', 'M', 3),
                                                                        (11, 'Escrime épée', 'F', 4),
                                                                        (12, 'Escrime épée', 'M', 4),
                                                                        (13, 'Athlétisme 110 haies', 'F', 1),
                                                                        (14, 'Athlétisme 110 haies', 'M', 1),
                                                                        (15, 'Athlétisme relais 400m', 'F', 2),
                                                                        (16, 'Athlétisme relais 400m', 'M', 2);

