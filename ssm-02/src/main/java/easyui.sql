create table role(
id int(10) primary key auto_increment,
name varchar(30),
sort int(10),
remark varchar(30)
);

insert into role values(default,'角色1',1,'备注1');
insert into role values(default,'角色2',2,'备注2');
insert into role values(default,'角色3',3,'备注3');
insert into role values(default,'角色4',4,'备注4');
insert into role values(default,'角色5',5,'备注5');
insert into role values(default,'角色6',6,'备注6');
insert into role values(default,'角色7',7,'备注7');
insert into role values(default,'角色8',8,'备注8');

create table menu(
id int(10) primary key auto_increment,
name varchar(30),
pid int(10)
);
INSERT into menu values(default,'系统设置',0);
INSERT into menu values(default,'系统公告',0);
INSERT into menu values(default,'角色管理',1);
INSERT into menu values(default,'部门管理',1);
INSERT into menu values(default,'权限管理',1);
INSERT into menu values(default,'公告管理',2);
INSERT into menu values(default,'公告类别',2);

create table role_menu(
id int(10) primary key auto_increment,
rid int(10),
mid int(10)
);
insert into role_menu values(default,1,1);
insert into role_menu values(default,1,3);
insert into role_menu values(default,1,5);