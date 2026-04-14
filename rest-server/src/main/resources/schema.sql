create sequence users_seq start with 1;
create table users (id bigint not null, name varchar(255), email varchar(255), primary key (id));
alter table if exists users add constraint users_name_uniq unique (name);
alter table if exists users add constraint users_email_uniq unique (email);
