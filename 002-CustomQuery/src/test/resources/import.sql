INSERT INTO AUTHOR (ID, FIRST_NAME, LAST_NAME, VERSION) VALUES (1, 'Thorben', 'Janssen', 0);
INSERT INTO AUTHOR (ID, FIRST_NAME, LAST_NAME, VERSION) VALUES (2, 'Alexandre', 'Rodriguez', 0);

insert into book (id, title, version) values (1, 'Hibernate Tips', 0);

insert into book_author (fk_book, fk_author) values (1, 1);
