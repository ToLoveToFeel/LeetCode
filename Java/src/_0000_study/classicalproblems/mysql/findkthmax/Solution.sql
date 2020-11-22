
-- ================================环境准备=================================
-- 删除数据库
drop database if exists `leetcode`;
-- 创建数据库
create database if not exists `leetcode`;
-- 切换到该数据库
use `leetcode`;
-- 创建表
create table if not exists `result` (
    `id` int(10) not null auto_increment comment '学生id',
    `subjectName` varchar(30) not null comment '学生修的科目',
    `studentResult` varchar(30) not null comment '学生考试成绩',
    primary key (`id`)
)engine=innodb default charset=utf8;
-- 插入数据
insert into `result` (`subjectName`, `studentResult`)
values ('语文', '90'),
       ('数学', '65'),
       ('语文', '68'),
       ('数学', '96'),
       ('数学', '55'),
       ('数学', '82');

-- ================================题解=================================
/*
 寻找第K高的数据
 下面的2：代表查找第三大的
 */
select ifnull(
    (
        select distinct `studentResult`
	    from `result`
        where `subjectName`='数学'
	    order by `studentResult` desc
	    limit 2,1
    )
,null);

