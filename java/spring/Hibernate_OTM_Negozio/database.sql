DROP DATABASE IF EXISTS spring_api_negozi;

CREATE DATABASE IF NOT EXISTS spring_api_negozi;

USE spring_api_negozi;

CREATE TABLE IF NOT EXISTS Persona (
    personaID INTEGER PRIMARY KEY AUTO_INCREMENT,
    nominativo VARCHAR(250) NOT NULL,
    telefono VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS Carta (
    cartaID INTEGER PRIMARY KEY AUTO_INCREMENT,
    codice VARCHAR(10) NOT NULL,
    negozio VARCHAR(250) NOT NULL,
    personaRIF INTEGER NOT NULL,
    FOREIGN KEY (personaRIF) REFERENCES Persona(personaID) ON DELETE CASCADE,
    UNIQUE(codice, negozio)
);


INSERT INTO Persona (nominativo, telefono, email) VALUES
('Marco Rossi', '3331112233', 'marco.rossi@email.com'),
('Giulia Bianchi', '3332223344', 'giulia.bianchi@email.com'),
('Luca Ferrari', '3333334455', 'luca.ferrari@email.com'),
('Sara Romano', '3334445566', 'sara.romano@email.com'),
('Andrea Esposito', '3335556677', 'andrea.esposito@email.com'),
('Elena Russo', '3336667788', 'elena.russo@email.com'),
('Matteo Conti', '3337778899', 'matteo.conti@email.com'),
('Chiara Greco', '3338889900', 'chiara.greco@email.com'),
('Davide Lombardi', '3339990011', 'davide.lombardi@email.com'),
('Francesca Marino', '3330001122', 'francesca.marino@email.com');


INSERT INTO Carta (codice, negozio, personaRIF) VALUES
('A001B2C3D4', 'SuperMarket Napoli', 3),
('F002G3H4I5', 'Moda Italia', 1),
('J003K4L5M6', 'Tech Store', 7),
('N004O5P6Q7', 'SuperMarket Napoli', 2),
('R005S6T7U8', 'Libreria Centro', 10),
('V006W7X8Y9', 'Moda Italia', 4),
('Z007A8B9C0', 'Sport World', 6),
('D008E9F0G1', 'Tech Store', 5),
('H009I0J1K2', 'Libreria Centro', 8),
('L010M1N2O3', 'SuperMarket Napoli', 9),
('P011Q2R3S4', 'Sport World', 3),
('T012U3V4W5', 'Moda Italia', 7),
('X013Y4Z5A6', 'Tech Store', 2),
('B014C5D6E7', 'Libreria Centro', 1),
('F015G6H7I8', 'Sport World', 10),
('J016K7L8M9', 'SuperMarket Napoli', 5),
('N017O8P9Q0', 'Moda Italia', 6),
('R018S9T0U1', 'Tech Store', 4),
('V019W0X1Y2', 'Libreria Centro', 9),
('Z020A1B2C3', 'Sport World', 8);