drop database if exists musicserver;
create database musicserver;
use musicserver;
drop table if exists music;
create table music (
  id int primary key auto_increment,
  title varchar(50) not null,
  single varchar(30) not null,
  time varchar(13) not null,
  url varchar (1000) not null,
  userid int(11) not null
);
drop table if exists user;
create table user (
  id int primary key auto_increment,
  username varchar(20) not null,
  password varchar(32) not null
);
drop table if exists lovemusic;
create table lovemusic (
  id int primary key auto_increment,
  user_id int(11) not null,
  music_id int(11) not null
);