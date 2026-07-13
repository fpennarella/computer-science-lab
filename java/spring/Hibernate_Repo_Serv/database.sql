DROP DATABASE IF EXISTS spring_api_negozi_exp;

CREATE DATABASE IF NOT EXISTS spring_api_negozi_exp;

USE spring_api_negozi_exp;

CREATE TABLE IF NOT EXISTS Persona (
    personaID INTEGER PRIMARY KEY AUTO_INCREMENT,
    nominativo VARCHAR(250) NOT NULL,
    telefono VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL UNIQUE,
    codice VARCHAR(10) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS Carta (
    cartaID INTEGER PRIMARY KEY AUTO_INCREMENT,
    codice VARCHAR(10) NOT NULL,
    negozio VARCHAR(250) NOT NULL,
    personaRIF INTEGER NOT NULL,
    FOREIGN KEY (personaRIF) REFERENCES Persona(personaID) ON DELETE CASCADE,
    UNIQUE(codice, negozio)
);

INSERT INTO Persona (nominativo, telefono, email, codice) VALUES
('Mario Rossi', '3331111111', 'mario.rossi@email.it', 'PRS0000001'),
('Luigi Bianchi', '3331111112', 'luigi.bianchi@email.it', 'PRS0000002'),
('Anna Verdi', '3331111113', 'anna.verdi@email.it', 'PRS0000003'),
('Marco Neri', '3331111114', 'marco.neri@email.it', 'PRS0000004'),
('Giulia Gallo', '3331111115', 'giulia.gallo@email.it', 'PRS0000005'),
('Paolo Esposito', '3331111116', 'paolo.esposito@email.it', 'PRS0000006'),
('Sara Romano', '3331111117', 'sara.romano@email.it', 'PRS0000007'),
('Francesco Greco', '3331111118', 'francesco.greco@email.it', 'PRS0000008'),
('Valentina Fontana', '3331111119', 'valentina.fontana@email.it', 'PRS0000009'),
('Davide Ricci', '3331111120', 'davide.ricci@email.it', 'PRS0000010'),
('Elena Conti', '3331111121', 'elena.conti@email.it', 'PRS0000011'),
('Matteo Ferri', '3331111122', 'matteo.ferri@email.it', 'PRS0000012'),
('Chiara Riva', '3331111123', 'chiara.riva@email.it', 'PRS0000013'),
('Alessandro Villa', '3331111124', 'alessandro.villa@email.it', 'PRS0000014'),
('Federica Longo', '3331111125', 'federica.longo@email.it', 'PRS0000015'),
('Luca Moretti', '3331111126', 'luca.moretti@email.it', 'PRS0000016'),
('Silvia Marchetti', '3331111127', 'silvia.marchetti@email.it', 'PRS0000017'),
('Andrea Pellegrini', '3331111128', 'andrea.pellegrini@email.it', 'PRS0000018'),
('Martina Serra', '3331111129', 'martina.serra@email.it', 'PRS0000019'),
('Giorgio De Luca', '3331111130', 'giorgio.deluca@email.it', 'PRS0000020');

INSERT INTO Carta (codice, negozio, personaRIF) VALUES
('CAR0000001', 'Esselunga', 1),
('CAR0000002', 'Conad', 1),
('CAR0000003', 'Lidl', 2),
('CAR0000004', 'Esselunga', 3),
('CAR0000005', 'MediaWorld', 3),
('CAR0000006', 'Unieuro', 3),
('CAR0000007', 'Decathlon', 5),
('CAR0000008', 'Amazon Store', 6),
('CAR0000009', 'Conad', 6),
('CAR0000010', 'Esselunga', 8),
('CAR0000011', 'Leroy Merlin', 9),
('CAR0000012', 'IKEA', 10),
('CAR0000013', 'Decathlon', 10),
('CAR0000014', 'Carrefour', 12),
('CAR0000015', 'Unieuro', 13),
('CAR0000016', 'MediaWorld', 13),
('CAR0000017', 'Conad', 15),
('CAR0000018', 'Esselunga', 15),
('CAR0000019', 'Lidl', 18),
('CAR0000020', 'Amazon Store', 20);





