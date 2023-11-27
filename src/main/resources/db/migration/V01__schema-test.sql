

create table Actor
(
    id        int auto_increment primary key,
    name      varchar(45) not null,
    birthDate date null,
    country   varchar(45) not null
);


create table Movie
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


CREATE TABLE Movie_Actor
(
    movie_id INT,
    actor_id INT,
    PRIMARY KEY (movie_id, actor_id),
    FOREIGN KEY (movie_id) REFERENCES Movie (id),
    FOREIGN KEY (actor_id) REFERENCES Actor (id)
);