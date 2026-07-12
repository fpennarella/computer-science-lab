-- Creazione del database
CREATE DATABASE spring_api_university;

-- Selezione del database
USE spring_api_university;

-- Creazione della tabella Students
CREATE TABLE Students (
    studentID INT PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(250) NOT NULL,
    lastName VARCHAR(250) NOT NULL,
    enrollment VARCHAR(10) NOT NULL UNIQUE, -- Matricola
    email VARCHAR(200)
);

-- Inserimento di 10 studenti
INSERT INTO Students (firstName, lastName, enrollment, email) VALUES
('Mario', 'Rossi', 'S100001', 'mario.rossi@example.com'),
('Luigi', 'Bianchi', 'S100002', 'luigi.bianchi@example.com'),
('Giulia', 'Verdi', 'S100003', 'giulia.verdi@example.com'),
('Francesca', 'Neri', 'S100004', 'francesca.neri@example.com'),
('Alessandro', 'Ferrari', 'S100005', 'alessandro.ferrari@example.com'),
('Sara', 'Esposito', 'S100006', 'sara.esposito@example.com'),
('Matteo', 'Romano', 'S100007', 'matteo.romano@example.com'),
('Chiara', 'Gallo', 'S100008', 'chiara.gallo@example.com'),
('Davide', 'Conti', 'S100009', 'davide.conti@example.com'),
('Elena', 'Moretti', 'S100010', 'elena.moretti@example.com');

select * from students;