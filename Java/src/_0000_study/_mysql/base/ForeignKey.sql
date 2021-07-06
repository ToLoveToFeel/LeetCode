/*
外键
    删除有外键关系的表的时候，必须要先删除引用别人的表(从表，例如下面的student),再删除被引用的表(主表，例如下面的grade)

    以下的操作都是物理外键，数据库级别的外键，不建议使用(避免数据库过多造成困扰)，以下是推荐方式：
    最佳实践：
        数据库就是单纯的表，只用来存储数据，只有行(数据)和列(字段)
        我们想使用多张表的数据，在代码层面去实现(比如Java层面)
*/

-- 删除某数据库中的表
drop table if exists `student`;
drop table if exists `grade`;

create table if not exists `grade` (
    `gradeId` int(10) not null comment '学生的年级',
    `gradeName` varchar(50) not null comment '年级名称',
    primary key (`gradeId`)
)engine=innodb default charset=utf8;

-- ================================第一种创建外键的方式=================================
-- 学生表的 gradeId 字段 要求引用年级表的 gradeId
-- 定义外键key
-- 给这个外键添加约束(执行引用)  references 引用
create table if not exists `student` (
    `id` int(4) not null auto_increment comment '学号',
    `name` varchar(30) not null default '匿名' comment '姓名',
    `pwd` varchar(20) not null default '123456' comment '密码',
    `sex` varchar(2) not null default '女' comment '性别',
    `birthday` datetime default null comment '出生日期',
    `address` varchar(100) default null comment '家庭住址',
    `email` varchar(50) default null comment '邮箱',
    `gradeId` int(10) not null comment '学生的年级',
    primary key(`id`),
    key `FK_gradeId` (`gradeId`),
    constraint `FK_gradeId` foreign key (`gradeId`) references `grade`(`gradeId`)
)engine=innodb default charset=utf8;


-- ================================第二种创建外键的方式=================================
-- 创建表之后再添加约束
-- 创建表的时候没有外键关系
create table if not exists `student` (
    `id` int(4) not null auto_increment comment '学号',
    `name` varchar(30) not null default '匿名' comment '姓名',
    `pwd` varchar(20) not null default '123456' comment '密码',
    `sex` varchar(2) not null default '女' comment '性别',
    `birthday` datetime default null comment '出生日期',
    `address` varchar(100) default null comment '家庭住址',
    `email` varchar(50) default null comment '邮箱',
    `gradeId` int(10) not null comment '学生的年级',
    primary key(`id`)
)engine=innodb default charset=utf8;
-- 创建表之后，给student表增加外键
alter table `student`
    add constraint `FK_gradeId` foreign key (`gradeId`) references `grade`(`gradeId`);

