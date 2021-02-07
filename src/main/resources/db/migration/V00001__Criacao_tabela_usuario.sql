CREATE TABLE "planner"."usuario"(
    "id" bigserial primary key,
    "nome" varchar(255) not null,
    "email" varchar(255) not null,
    "senha" varchar(255) not null,
    "data_hora_criacao" timestamp default now() not null
);