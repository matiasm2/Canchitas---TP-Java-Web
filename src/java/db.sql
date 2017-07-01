CREATE DATABASE canchas;
\c canchas;
CREATE TABLE rol (
    rol_id          SERIAL PRIMARY KEY,
    rol             varchar(40) unique
);

CREATE TABLE usuario (
    usuario_id      SERIAL PRIMARY KEY,
    rol_id          integer REFERENCES rol,
    nombre          varchar(120),
    email           varchar(120) unique,
    contrasena      varchar(120),
    token           varchar(120) unique
);

CREATE TABLE tamanocancha (
    tamanocancha_id     SERIAL PRIMARY KEY,
    tamanocancha        varchar(120) unique,
    precio              integer 
);

CREATE TABLE cancha (
    cancha_id           SERIAL PRIMARY KEY,
    tamanocancha        integer REFERENCES tamanocancha,
    nombre              varchar(40) unique
);

CREATE TABLE reserva (
    reserva_id          SERIAL PRIMARY KEY,
    usuario_id          integer REFERENCES usuario,
    cancha_id           integer REFERENCES cancha,
    fechaInicio         date,
    fechaFin            date,
    pagada              boolean,
    tokenInvitacion     varchar(120)
);

CREATE TABLE invitacion (
    invitacion_id       SERIAL PRIMARY KEY,
    usuario_id          integer REFERENCES usuario,
    reserva_id          integer REFERENCES reserva

);