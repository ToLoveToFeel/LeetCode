/*
DQL : 数据查询语言 select
    (1) 所有的查询都要用到它
    (2) 简单的查询，复杂的查询，它都能做
    (3) 数据库中最核心的语言
    (4) 使用频率最高的语句


*/
-- 准备，执行util包下的school.sql文件即可

-- 查询全部的学生
select * from `student`;

-- 查询指定字段
select `StudentNo`, `StudentName` from student;
-- 别名：给结果起一个别名 as，也可以给表起一个别名
select `StudentNo` as '学号', `StudentName` as '学生姓名'  from student as s;

-- 函数，例如 concat
select concat('姓名 : ', `StudentName`) as '新名字' from student;








