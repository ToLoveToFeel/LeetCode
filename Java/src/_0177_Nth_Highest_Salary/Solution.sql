
-- ================================环境准备=================================
-- 删除数据库
drop database if exists `leetcode`;
-- 创建数据库
create database if not exists `leetcode`;
-- 切换到该数据库
use `leetcode`;
-- 创建表
create table if not exists `Employee` (
    `Id` int(10) not null auto_increment comment '主键',
    `Salary` varchar(30) not null comment '员工名字',
    primary key (`Id`)
)engine=innodb default charset=utf8;
-- 插入数据
insert into `Employee` (`Salary`)
values ('10000'),
       ('20000'),
       ('30000');

-- ================================题解=================================
/*
 执行用时：319 ms, 在所有 MySQL 提交中击败了24.10%的用户
内存消耗：0 B, 在所有 MySQL 提交中击败了100.00%的用户
 */
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  set N := N - 1;
  RETURN (
      # Write your MySQL query statement below.
      select ifnull(
      (
          select distinct `Salary`
	      from `Employee`
	      order by `Salary` desc
	      limit N,1
      )
      ,null)
  );
END


