create table author
(
    id            serial primary key,
    full_name     varchar,
    creation_time timestamp
);

alter table budget
    add column author_id int default null;
alter table budget
    add constraint author_fk
        foreign key (author_id) references author;