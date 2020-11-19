/*
DQL : 数据查询语言 select
    (1) 所有的查询都要用到它
    (2) 简单的查询，复杂的查询，它都能做
    (3) 数据库中最核心的语言
    (4) 使用频率最高的语句

select 表达式 from 表
    数据库中的表达式：文本值，列，null，函数，计算表达式，系统变量......

where子句(返回boolean值)：模糊查询
    运算符             语法                      描述
    is null           a is null                如果a为null, 结果为真
    is not null       a is not null            如果a不为null, 结果为真
    between           a between b and c        如果a在b和c之间，则结果为真
    like              a like b                 SQL匹配，如果a匹配b, 则结果为真
    in                a in (a1, a2,...)        假设a在(a1, a2,...)之中，结果为真

*/
-- 准备，执行util包下的school.sql文件即可

-- =================================================================
-- 查询全部的学生
select * from `student`;

-- 查询指定字段
select `StudentNo`, `StudentName` from `student`;
-- 别名：给结果起一个别名 as，也可以给表起一个别名
select `StudentNo` as '学号', `StudentName` as '学生姓名'  from `student` as s;

-- 函数，例如 concat
select concat('姓名 : ', `StudentName`) as '新名字' from `student`;

-- 去重，查询哪些同学参加了考试
select distinct `StudentNo` from `result`;


-- ================================一些特殊查询=================================
-- 查看系统版本(函数)
select version();
-- 用于计算(表达式)
select 100*3+2 as 'count';
-- 查询自增的步长(变量)
select @@auto_increment_increment;
-- 查看当前的隔离级别(变量)
SELECT @@tx_isolation;  -- REPEATABLE-READ


-- ================================查询结果后进行操作=================================
-- 将所有学员成绩 +1分，查看
select `StudentNo`, `StudentResult`+1 as '提分后' from `result`;


-- ================================where子句：逻辑运算符=================================
-- 查询考试成绩在 85~100 之间的。and 也可以用 && 代替, 或者使用between...and...
select `StudentNo`, `StudentResult` from `result`
where `StudentResult`>=85 and `StudentResult`<=100;

select `StudentNo`, `StudentResult` from `result`
where `StudentResult`>=85 && `StudentResult`<=100;

select `StudentNo`, `StudentResult` from `result`
where `StudentResult` between 85 and 100;

-- 查询除了1000号学生之外的学生的成绩
select `StudentNo`, `StudentResult` from `result`
where `StudentNo`!=1000;

select `StudentNo`, `StudentResult` from `result`
where not `StudentNo`=1000;


-- ================================where子句：模糊查询=================================
-- ----------------------like--------------------------
-- like 结合，%(代表0到任意个字符) _(代表一个字符)
-- 查询姓刘的同学
select `StudentNo`, `StudentName` from `student`
where `StudentName` like '刘%';

-- 查询姓刘的同学，名字是二个字的
select `StudentNo`, `StudentName` from `student`
where `StudentName` like '刘_';

-- 查询姓刘的同学，名字是三个字的
select `StudentNo`, `StudentName` from `student`
where `StudentName` like '刘__';

-- 查询名字中有嘉字的同学
select `StudentNo`, `StudentName` from `student`
where `StudentName` like '%嘉%';

-- ----------------------in--------------------------
-- 查询 1001,1002,1003号学员
select `StudentNo`, `StudentName` from `student`
where `StudentNo` in (1001, 1002, 1003);

-- 查询在北京朝阳和安徽合肥的学生
select `StudentNo`, `StudentName` from `student`
where `Address` in ('北京朝阳', '安徽合肥');

-- ----------------------null / is null--------------------------
-- 查询地址为空的学生  null ''
select `StudentNo`, `StudentName` from `student`
where `Address`='' or `Address` is null;

-- 查询有出生日期的同学  不为空
select `StudentNo`, `StudentName` from `student`
where `BornDate` is not null;


-- ================================联表查询join=================================
-- 查询参加了考试的同学(学号，姓名，科目编号，分数)  两个表
/*
思路：
    1.分析需求，分析查询的字段来自哪些表
    2.确定使用哪种连接查询？7种
      确定不同表的的交叉点(两个表中哪个数据是相同的)
针对本问题：student 表中的 StudentNo = result 表中的 StudentNo

join on:
    join 连接的表 on 判断的条件
    连接查询
where:
    等值查询

*/
-- inner join
select s.`StudentNo`, `StudentName`, `SubjectNo`, `StudentResult`
from student as s
inner join result as r
where s.StudentNo = r.StudentNo;

-- right join
select s.`StudentNo`, `StudentName`, `SubjectNo`, `StudentResult`
from student s
right join result r
on s.StudentNo = r.StudentNo;

-- left join
select s.`StudentNo`, `StudentName`, `SubjectNo`, `StudentResult`
from student s
left join result r
on s.StudentNo = r.StudentNo;

-- 查询缺考的同学
select s.`StudentNo`, `StudentName`, `SubjectNo`, `StudentResult`
from student s
left join result r
on s.StudentNo = r.StudentNo
where `StudentResult` is null;

-- 查询学员所属的年级(学号，姓名，年级)
select `StudentNo`, `StudentName`, `GradeName`
from `student` s
inner join `grade` g
on s.GradeId = g.GradeId;

-- 查询科目所属的年级(科目名称，年级名称)
select `SubjectName`, `GradeName`
from `subject` sub
inner join `grade` g
on sub.`GradeId`=g.`GradeId`;

-- 查询参加了考试的同学(学号，姓名，科目名，分数)  三个表
-- 核心思想：两个表查询后的结果可以看成一个表
select s.`StudentNo`, `StudentName`, `SubjectName`, `StudentResult`
from student as s
inner join result as r
on s.StudentNo = r.StudentNo
inner join subject as sub
on r.`SubjectNo`=sub.`SubjectNo`;

-- 查询参加了 高等数学-1 考试的同学(学号，姓名，科目名，分数)  三个表
select s.`StudentNo`, `StudentName`, `SubjectName`, `StudentResult`
from student as s
inner join result as r
on s.StudentNo = r.StudentNo
inner join subject as sub
on r.`SubjectNo`=sub.`SubjectNo`
where `SubjectName`='高等数学-1';


-- ================================自连接=================================
-- 准备
drop table if exists `category`;
create table `category` (
    `categoryId` int(10) unsigned not null auto_increment comment '主题id',
    `parentId` int(10) not null comment '父id',
    `categoryName` varchar(50) not null comment '主题名字',
    primary key (`categoryId`)
) engine=innodb auto_increment=9 default charset=utf8;

insert into `category` (`categoryId`, `parentId`, `categoryName`)
values ('2', '1', '信息技术'),
('3', '1', '软件开发'),
('4', '3', '数据库'),
('5', '1', '美术设计'),
('6', '3', 'web开发'),
('7', '5', 'ps技术'),
('8', '2', '办公信息');
/*
核心：一张表拆为两张一样的表即可、

父表：
    categoryId          categoryName
    2                   信息技术
    3                   软件开发
    5                   美术设计
子类：
    parentId            categoryId          categoryName
    2                   8                   办公信息
    3                   4                   数据库
    3                   6                   web开发
    5                   7                   美术设计
操作：查询父类对应的子类关系
    -父类-                 -子类-
    信息技术               办公信息
    软件开发               数据库
    软件开发               web开发
    美术设计               ps技术
*/
select a.`categoryName` as '父栏目', b.`categoryName` as '子栏目'
from `category` as a, `category` as b
where a.`categoryId`=b.`parentId`;

















