-- pqf - Pizza Quadrada Flix
CREATE TABLE pqf_movie (
    id              NUMBER(10) NOT NULL,
    title           VARCHAR2(200),
    path            VARCHAR2(300) NOT NULL,
    movie_file      varchar2(200) NOT NULL,
    duration        NUMBER(6), -- in minutes
    synopsis        VARCHAR2(2000),
    director        VARCHAR2(200),
    year            NUMBER(4),
    gender          VARCHAR2(100),
    classification  NUMBER(2),
    cover_file      VARCHAR2(200) -- image file inside 'path'
);

ALTER TABLE pqf_movie ADD CONSTRAINT pqf_movie_pk PRIMARY KEY (id);
ALTER TABLE pqf_movie ADD CONSTRAINT pqf_movie_title_uk UNIQUE (title);

CREATE SEQUENCE pqf_movie_sq INCREMENT BY 1 MINVALUE 1 MAXVALUE 999999999999999 NOCYCLE;
