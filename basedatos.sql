 -- Crear base de datos
CREATE DATABASE IF NOT EXISTS healthhub;
USE healthhub;

-- Tabla Paciente
CREATE TABLE Paciente (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    email VARCHAR(100) UNIQUE,
    telefono VARCHAR(20),
    fecha_nac DATE,
    domicilio VARCHAR(100),
    dni VARCHAR(14) UNIQUE
);

-- Tabla Médico
CREATE TABLE Medico (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    domicilio VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(255),
  dni VARCHAR(14) UNIQUE,
    matricula INT UNIQUE,
    especialidad VARCHAR(50)
);

-- Tabla Recepcionista
CREATE TABLE Recepcionista (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    domicilio VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(255),
    dni VARCHAR(14) UNIQUE

);

-- Tabla Historial (1 a 1 con Paciente)
CREATE TABLE Historial (
    id INT PRIMARY KEY AUTO_INCREMENT,
    paciente_id INT UNIQUE,
    registro_clinico TEXT,
    FOREIGN KEY (paciente_id) REFERENCES Paciente(id) ON DELETE CASCADE
);

-- tabla agenda
CREATE TABLE Agenda (
    id INT PRIMARY KEY AUTO_INCREMENT,
    medico_id INT,
    fecha DATE,
    hora TIME,
    FOREIGN KEY (medico_id) REFERENCES Medico(id) ON DELETE CASCADE
);


-- Tabla Turno (relaciona Paciente y Médico)
CREATE TABLE Turno (
    id INT PRIMARY KEY AUTO_INCREMENT,
    paciente_id INT,
    medico_id INT,
    registro TEXT,
    fecha DATETIME,
    FOREIGN KEY (paciente_id) REFERENCES Paciente(id) ON DELETE CASCADE,
    FOREIGN KEY (medico_id) REFERENCES Medico(id) ON DELETE CASCADE
);