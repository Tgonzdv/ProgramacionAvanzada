-- Crear base de datos
CREATE DATABASE IF NOT EXISTS healthhub;
USE healthhub;

-- Tabla Persona (superclase)
CREATE TABLE Persona (
    id INT PRIMARY KEY AUTO_INCREMENT,
    rol VARCHAR(20),
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    fecha_nac DATE,
    domicilio VARCHAR(100),
    dni INT UNIQUE
);



-- Tabla Medico (hereda de Persona)
CREATE TABLE Medico (
    id INT PRIMARY KEY,
    matricula INT UNIQUE,
    especialidad VARCHAR(50),
    FOREIGN KEY (id) REFERENCES Persona(id) ON DELETE CASCADE
);

-- Tabla Historial (1 a 1 con Paciente)
CREATE TABLE Historial (
    id INT PRIMARY KEY AUTO_INCREMENT,
    paciente_id INT UNIQUE,
    registro_clinico TEXT,
    FOREIGN KEY (id) REFERENCES Persona(id) ON DELETE CASCADE
);

-- Tabla Turno (relaciona Paciente y Médico)
CREATE TABLE Turno (
    id INT PRIMARY KEY AUTO_INCREMENT,
    paciente_id INT,
    medico_id INT,
    registro TEXT,
    fecha DATETIME,
    FOREIGN KEY (paciente_id) REFERENCES Persona(id) ON DELETE CASCADE,
    FOREIGN KEY (medico_id) REFERENCES Medico(id) ON DELETE CASCADE
);
