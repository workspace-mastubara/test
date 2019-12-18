drop database if exists login_matsubara;
create database login_matsubara;
use login_matsubara;

create table user(
id int,
user_name varchar(255),
password varchar(255));

insert into user values
(1,"taro","123"),
(2,"jiro","123"),
(3,"hanako","123");
