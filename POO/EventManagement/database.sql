CREATE DATABASE IF NOT EXISTS evento_management;
USE evento_management;

-- Tabla Ubicacion
CREATE TABLE Ubicacion (
    idUbicacion INT PRIMARY KEY AUTO_INCREMENT,
    direccion VARCHAR(255) NOT NULL,
    ciudad VARCHAR(100) NOT NULL,
    pais VARCHAR(100) NOT NULL,
    capacidad INT NOT NULL,
    fechaCreacion DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Tabla TipoEventos
CREATE TABLE TipoEventos (
    idTipoEvento INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    descripcion VARCHAR(255),
    fechaCreacion DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Tabla ModalidadEvento
CREATE TABLE ModalidadEvento (
    idModalidad INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    descripcion VARCHAR(255),
    fechaCreacion DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Tabla Categoria
CREATE TABLE Categoria (
    idCategoria INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    descripcion VARCHAR(255),
    fechaCreacion DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Tabla Persona
CREATE TABLE Persona (
    idPersona INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    telefono VARCHAR(20),
    documento VARCHAR(30) UNIQUE,
    tipoDocumento VARCHAR(50),
    fechaNacimiento DATE,
    genero VARCHAR(20),
    fechaCreacion DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Tabla Evento
CREATE TABLE Evento (
    idEvento INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(200) NOT NULL,
    descripcion TEXT,
    fechaInicio DATETIME NOT NULL,
    fechaFin DATETIME NOT NULL,
    idUbicacion INT NOT NULL,
    idTipoEvento INT NOT NULL,
    idModalidad INT NOT NULL,
    idOrganizador INT,
    estado VARCHAR(50) DEFAULT 'Pendiente',
    presupuesto DECIMAL(15, 2),
    fechaCreacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (idUbicacion) REFERENCES Ubicacion(idUbicacion),
    FOREIGN KEY (idTipoEvento) REFERENCES TipoEventos(idTipoEvento),
    FOREIGN KEY (idModalidad) REFERENCES ModalidadEvento(idModalidad),
    FOREIGN KEY (idOrganizador) REFERENCES Persona(idPersona)
);

-- Tabla EventoCategoria
CREATE TABLE EventoCategoria (
    idEventoCategoria INT PRIMARY KEY AUTO_INCREMENT,
    idEvento INT NOT NULL,
    idCategoria INT NOT NULL,
    FOREIGN KEY (idEvento) REFERENCES Evento(idEvento),
    FOREIGN KEY (idCategoria) REFERENCES Categoria(idCategoria),
    UNIQUE KEY unique_evento_categoria (idEvento, idCategoria)
);

-- Tabla Organizador
CREATE TABLE Organizador (
    idOrganizador INT PRIMARY KEY,
    empresa VARCHAR(150),
    telefono VARCHAR(20),
    email VARCHAR(100),
    numeroEventos INT DEFAULT 0,
    FOREIGN KEY (idOrganizador) REFERENCES Persona(idPersona)
);

-- Tabla Administrador
CREATE TABLE Administrador (
    idAdministrador INT PRIMARY KEY,
    numeroControl VARCHAR(50) UNIQUE,
    nivelAcceso INT DEFAULT 1,
    estado VARCHAR(50) DEFAULT 'Activo',
    FOREIGN KEY (idAdministrador) REFERENCES Persona(idPersona)
);

-- Tabla Asistente
CREATE TABLE Asistente (
    idAsistente INT PRIMARY KEY,
    interesCategorias VARCHAR(255),
    historialAsistencias INT DEFAULT 0,
    FOREIGN KEY (idAsistente) REFERENCES Persona(idPersona)
);

-- Tabla Ponente
CREATE TABLE Ponente (
    idPonente INT PRIMARY KEY,
    especialidad VARCHAR(100),
    biografia TEXT,
    experienciaAnios INT,
    FOREIGN KEY (idPonente) REFERENCES Persona(idPersona)
);

-- Tabla Inscripcion
CREATE TABLE Inscripcion (
    idInscripcion INT PRIMARY KEY AUTO_INCREMENT,
    idAsistente INT NOT NULL,
    idEvento INT NOT NULL,
    fechaInscripcion DATETIME DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(50) DEFAULT 'Registrado',
    FOREIGN KEY (idAsistente) REFERENCES Asistente(idAsistente),
    FOREIGN KEY (idEvento) REFERENCES Evento(idEvento),
    UNIQUE KEY unique_inscripcion (idAsistente, idEvento)
);

-- Tabla Pago
CREATE TABLE Pago (
    idPago INT PRIMARY KEY AUTO_INCREMENT,
    idInscripcion INT NOT NULL,
    monto DECIMAL(15, 2) NOT NULL,
    metodoPago VARCHAR(50),
    fechaPago DATETIME DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(50) DEFAULT 'Pendiente',
    FOREIGN KEY (idInscripcion) REFERENCES Inscripcion(idInscripcion)
);

-- Tabla Reserva
CREATE TABLE Reserva (
    idReserva INT PRIMARY KEY AUTO_INCREMENT,
    idEvento INT NOT NULL,
    idAsistente INT NOT NULL,
    numeroAsientos INT NOT NULL DEFAULT 1,
    fechaReserva DATETIME DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(50) DEFAULT 'Confirmada',
    FOREIGN KEY (idEvento) REFERENCES Evento(idEvento),
    FOREIGN KEY (idAsistente) REFERENCES Asistente(idAsistente)
);

-- Tabla EventoPonente
CREATE TABLE EventoPonente (
    idEventoPonente INT PRIMARY KEY AUTO_INCREMENT,
    idEvento INT NOT NULL,
    idPonente INT NOT NULL,
    horaPresentacion TIME,
    tema VARCHAR(200),
    FOREIGN KEY (idEvento) REFERENCES Evento(idEvento),
    FOREIGN KEY (idPonente) REFERENCES Ponente(idPonente),
    UNIQUE KEY unique_evento_ponente (idEvento, idPonente)
);

-- Tabla Notificacion
CREATE TABLE Notificacion (
    idNotificacion INT PRIMARY KEY AUTO_INCREMENT,
    idPersona INT NOT NULL,
    idEvento INT,
    mensaje TEXT NOT NULL,
    tipo VARCHAR(50),
    fechaEnvio DATETIME DEFAULT CURRENT_TIMESTAMP,
    leida BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (idPersona) REFERENCES Persona(idPersona),
    FOREIGN KEY (idEvento) REFERENCES Evento(idEvento)
);

-- Tabla Certificado
CREATE TABLE Certificado (
    idCertificado INT PRIMARY KEY AUTO_INCREMENT,
    idAsistente INT NOT NULL,
    idEvento INT NOT NULL,
    numeroCertificado VARCHAR(100) UNIQUE NOT NULL,
    fechaEmision DATETIME DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(50) DEFAULT 'Generado',
    FOREIGN KEY (idAsistente) REFERENCES Asistente(idAsistente),
    FOREIGN KEY (idEvento) REFERENCES Evento(idEvento),
    UNIQUE KEY unique_certificado (idAsistente, idEvento)
);

-- Índices para mejorar performance
CREATE INDEX idx_evento_fecha ON Evento(fechaInicio, fechaFin);
CREATE INDEX idx_evento_tipo ON Evento(idTipoEvento);
CREATE INDEX idx_evento_ubicacion ON Evento(idUbicacion);
CREATE INDEX idx_inscripcion_asistente ON Inscripcion(idAsistente);
CREATE INDEX idx_inscripcion_evento ON Inscripcion(idEvento);
CREATE INDEX idx_pago_inscripcion ON Pago(idInscripcion);
CREATE INDEX idx_notificacion_persona ON Notificacion(idPersona);
