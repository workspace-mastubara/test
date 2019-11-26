drop database if exists testdb;
create database testdb;
use testdb;
create table test_table(
user_id int,
user_name varchar(255),
password varchar(255)
);

insert into test_table values
(1,"taro","123"),
(2,"jiro","456"),
(3,"hanako","789");
