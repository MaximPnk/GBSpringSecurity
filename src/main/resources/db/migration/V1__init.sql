create table users (
    id                    bigserial,
    username              varchar(30) not null,
    password              varchar(80) not null,
    email                 varchar(50) unique,
    score                 bigint default 10,
    primary key (id)
);

create table roles (
    id                    serial,
    name                  varchar(50) not null,
    primary key (id)
);

CREATE TABLE users_roles (
    user_id               bigint not null,
    role_id               int not null,
    primary key (user_id, role_id),
    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id)
);

insert into roles (name)
values
    ('ROLE_USER'),
    ('ROLE_ADMIN');

insert into users (username, password, email)
values
    ('user', '$2y$12$OlA.qiLaFLaocQzObK2ks.IckUq.le2i76ilJl3C1EDqog1oszEGi', 'user@gmail.com'),
    ('admin', '$2y$12$5WD4x7TKkWR740J7kkQ2uOB8B1VnWFPuHiP6JzWWBYFEx1e1sDuaO', 'admin@gmail.com');

insert into users_roles (user_id, role_id)
values
    (1, 1),
    (2, 2);
