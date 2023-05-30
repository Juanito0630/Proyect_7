use Juanito;
select *from users_tbl;

create table users_tbl(
user_id int(11) auto_increment primary key,
user_firstname varchar(50) not null,
user_lastname varchar(50) not null,
user_email varchar (60) not null,
user_password varbinary (255) not null
);
insert into users_tbl
values ('', 'Juan', 'Rodriguez', 'Juanito0630@gmail.com', 'Gominola123');

select *from users_tbl;

insert into users_tbl
values ('', 'Daniel', 'Alarcon', 'Daniprimo15@gmail.com', 'aeiouoiea');

drop table users_tbl;