alter table "planner"."usuario" alter column "email" drop not null;
alter table "planner"."usuario" alter column "senha" drop not null;

create schema if not exists "plugin";

create table "plugin"."chat_telegram" (
    "chat_id" bigint primary key,
    "usuario_telegram" varchar(255) not null unique,
    "usuario_primeiro_nome" varchar(255),
    "usuario_sobrenome" varchar(255),
    "usuario_nome_completo" varchar(255),
    "usuario_apelido" varchar(15),
    "usuario_planner_id" bigint not null,
    foreign key ("usuario_planner_id") references "planner"."usuario"("id")
);
