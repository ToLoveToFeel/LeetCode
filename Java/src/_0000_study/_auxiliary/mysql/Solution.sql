
-- ================================环境准备=================================
-- 删除数据库
drop database if exists `leetcode`;
-- 创建数据库
create database if not exists `leetcode`;
-- 切换到该数据库
use `leetcode`;
-- 创建表
create table if not exists `Person` (
    `PersonId` int(10) not null auto_increment comment '学生id',
    `FirstName` varchar(30) not null comment '学生名字',
    `LastName` varchar(30) not null comment '学生id姓',
    primary key (`PersonId`)
)engine=innodb default charset=utf8;

create table if not exists `Address` (
    `AddressId` int(10) not null auto_increment comment '地址id',
    `PersonId` int(10) not null comment '学生id',
    `City` varchar(30) not null comment '学生所在城市',
    `State` varchar(30) not null comment '学生所在的州',
    primary key (`AddressId`)
)engine=innodb default charset=utf8;
-- 插入数据
insert into `Person`
values ('1', 'Xiaoxiao', 'Wang'),
       ('2', 'Y', 'H'),
       ('3', '..', 'Wang');

insert into `Address`
values ('10', '1', '安徽省', '阜阳市'),
       ('11', '2', '辽宁省', '大连市');

-- ================================题解=================================
/*
 Leetcode 0175
 这种方式不正确，因为如果Person表中的PersonId在 Address 表中不存在，则不会显示此人
 */
select `FirstName`, `LastName`, `City`, `State`
from `Person`, `Address`
where Person.`PersonId`=Address.`PersonId`;

/*
 执行用时：280 ms, 在所有 MySQL 提交中击败了45.62%的用户
 内存消耗：0 B, 在所有 MySQL 提交中击败了100.00%的用户
 */
select `FirstName`, `LastName`, `City`, `State`
from `Person`
left join `Address`
on Person.`PersonId`=Address.`PersonId`;

