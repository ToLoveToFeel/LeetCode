
-- ================================环境准备=================================
-- 删除数据库
drop database if exists `leetcode`;
-- 创建数据库
create database if not exists `leetcode`;
-- 切换到该数据库
use `leetcode`;
-- 创建表
create table if not exists `courses` (
    `id` int(10) not null auto_increment comment '主键',
    `student` varchar(10) not null comment '学生姓名',
    `class` varchar(30) not null comment '学生选的课程',
    primary key (`id`)
)engine=innodb default charset=utf8;
-- 插入数据
insert into `courses`(`student`, `class`)
values ('A', 'Math'),
       ('B', 'English'),
       ('C', 'Math'),
       ('D', 'Biology'),
       ('E', 'Math'),
       ('F', 'Computer'),
       ('G', 'Math'),
       ('H', 'Math'),
       ('I', 'Math');


-- ================================题解=================================
/*
 执行用时：213 ms, 在所有 MySQL 提交中击败了89.68%的用户
 内存消耗：0 B, 在所有 MySQL 提交中击败了100.00%的用户
 */
select `class` from `courses`
group by `class`
having count(distinct `student`) >= 5;


