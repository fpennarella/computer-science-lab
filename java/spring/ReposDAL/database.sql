DROP DATABASE IF EXISTS spring_api_school;

CREATE DATABASE spring_api_school;

USE spring_api_school;

create table Studenti (
	idStudente integer primary key auto_increment,
    nome varchar(250) not null,
    cognome varchar(250) not null,
    matricola varchar(10) not null unique,
    dataDiNascita date not null
);

create table Docenti (
	idDocente integer primary key auto_increment,
    nome varchar(250) not null,
    cognome varchar(250) not null,
    materia varchar(250) not null
);

INSERT INTO Studenti (nome, cognome, matricola, dataDiNascita) VALUES
('Marco', 'Rossi', 'MAT000001', '2002-03-15'),
('Giulia', 'Bianchi', 'MAT000002', '2001-07-22'),
('Luca', 'Ferrari', 'MAT000003', '2003-01-10'),
('Sara', 'Romano', 'MAT000004', '2002-11-05'),
('Andrea', 'Esposito', 'MAT000005', '2001-09-18'),
('Francesca', 'Russo', 'MAT000006', '2003-04-27'),
('Matteo', 'Conti', 'MAT000007', '2002-06-12'),
('Chiara', 'Marino', 'MAT000008', '2001-12-30'),
('Davide', 'Gallo', 'MAT000009', '2003-08-09'),
('Elena', 'Greco', 'MAT000010', '2002-10-21');

INSERT INTO Docenti (nome, cognome, materia) VALUES
('Alessandro', 'Verdi', 'Matematica'),
('Laura', 'Fontana', 'Italiano'),
('Paolo', 'Ricci', 'Informatica'),
('Martina', 'Lombardi', 'Inglese'),
('Stefano', 'Moretti', 'Fisica'),
('Valentina', 'Barbieri', 'Storia'),
('Giorgio', 'Rizzo', 'Chimica'),
('Silvia', 'De Luca', 'Biologia'),
('Simone', 'Pellegrini', 'Filosofia'),
('Anna', 'Serra', 'Geografia');
