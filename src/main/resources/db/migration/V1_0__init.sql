create table employees
(
    id         serial not null
        constraint employees_pkey
            primary key,
    surname    varchar,
    name       varchar,
    patronymic varchar,
    email      varchar,
    gender     varchar
);

alter table employees
    owner to postgres;

create table material_values
(
    id       serial not null
        constraint material_values_pkey
            primary key,
    category varchar,
    name     varchar,
    date     date,
    cost     integer
);

alter table material_values
    owner to postgres;

create table employees_material_values
(
    id           serial not null
        constraint employees_material_values_pk
            primary key,
    employees_id integer
        constraint employees_material_values_employees__fk
            references employees,
    material_id  integer
        constraint employees_material_values_material__fk
            references material_values
);

alter table employees_material_values
    owner to postgres;
