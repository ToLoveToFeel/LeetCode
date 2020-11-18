/*
DDL : 数据库定义语言
    create\drop\alter

create table:
    create table [if not exists] `表名` (
        `字段名` 列类型 [属性] [索引] [注释],
        `字段名` 列类型 [属性] [索引] [注释],
        ......
        `字段名` 列类型 [属性] [索引] [注释]
    )[表类型] [字符集设置] [注释];


 */
-- 1.目标：创建一个 school 数据库
-- 2.创建学生表（列，字段），使用 SQL 创建
--   学号int, 登陆密码varchar(20), 姓名, 性别varchar(2), 出生日期datetime, 家庭住址, 邮箱

-- 1. 创建数据库
create database if not exists `school`;
use `school`;
-- 2.
/*
 注意点：
    (1) 使用英文括号，表的名字 和 字段 尽量使用 `` 括起来
    (2) auto_increment 自增
    (3) 字符串使用单引号括起来
    (4) 所有的语句后面加英文逗号，最后一个不用加
    (5) 主键，一般一个表只有一个
 */
create table if not exists `student` (
    `id` int(4) not null auto_increment comment '学号',
    `name` varchar(30) not null default '匿名' comment '姓名',
    `pwd` varchar(20) not null default '123456' comment '密码',
    `sex` varchar(2) not null default '女' comment '性别',
    `birthday` datetime default null comment '出生日期',
    `address` varchar(100) default null comment '家庭住址',
    `email` varchar(50) default null comment '邮箱',
    primary key(`id`)
)engine=innodb default charset=utf8;

-- 删除某数据库中的表
drop table if exists `student`;

-- =================================================================

-- 查看创建数据库的语句
show create database `school`;
-- 查看创建表的语句
show create table `student`;
-- 显示表的结构
desc student;

-- =================================================================

-- 修改表名
alter table student rename as students;
alter table students rename as student;
-- 增加表的字段
alter table student add age int(11);
-- 修改表的字段(重命名，修改约束)
alter table student modify age varchar(11);  -- 修改约束
alter table student change age age1 int(3);  -- 字段重命名
-- 删除表的字段
alter table student drop age1;






