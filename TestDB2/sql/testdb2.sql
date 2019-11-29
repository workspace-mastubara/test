drop database if exists testdb2;
create database testdb2;
use testdb2;

create table test_table(id int, name varchar(255), password varchar(255));

insert into test_table values
(1,"taro","123"),
(2,"jiro","456"),
(3,"hanako","789");