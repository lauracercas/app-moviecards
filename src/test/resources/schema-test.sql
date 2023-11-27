CREATE SCHEMA IF NOT EXISTS moviesdb_test;
USE moviesdb_test;

create table moviesdb_test.Actor
(
    id        int auto_increment primary key,
    name      varchar(45) not null,
    birthDate date null,
    country   varchar(45) not null
);


create table moviesdb_test.Movie
(
    id       int auto_increment
        primary key,
    title    varchar(45)  not null,
    year     int          not null,
    duration int not null,
    country  varchar(45)  not null,
    director varchar(45)  not null,
    genre    varchar(45)  not null,
    sinopsis varchar(300) not null
);


CREATE TABLE moviesdb_test.Movie_Actor
(
    movie_id INT,
    actor_id INT,
    PRIMARY KEY (movie_id, actor_id),
    FOREIGN KEY (movie_id) REFERENCES Movie (id),
    FOREIGN KEY (actor_id) REFERENCES Actor (id)
);