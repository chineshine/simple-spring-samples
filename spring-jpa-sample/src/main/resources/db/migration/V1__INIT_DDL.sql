-- users
create table if not exists `users`(
	id int auto_increment comment '主键标识',
	username varchar(255) comment '用户名称',
	password varchar(255) comment '密码',
	enabled tinyint(1) comment '账户是否可用',
	PRIMARY KEY(id)
);

-- authorities
create table if not exists `authorities`(
	id int auto_increment comment '主键标识',
	username varchar(255) comment '用户名称',
	authority varchar(255) comment '授权码',
	PRIMARY KEY(id)
	);