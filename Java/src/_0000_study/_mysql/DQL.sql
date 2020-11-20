/*
DQL : 数据查询语言 select
    (1) 所有的查询都要用到它
    (2) 简单的查询，复杂的查询，它都能做
    (3) 数据库中最核心的语言
    (4) 使用频率最高的语句

select 表达式 from 表
    数据库中的表达式：文本值，列，null，函数，计算表达式，系统变量......

select [all | distinct]
{* | table.* | field1 [as alias1], field2 [as alias2], ...}
from table_name [as table_alias]
    [left | right | inner join table_name2]  -- 联合查询
    [where ...]  -- 指定结果满足的调价
    [group by ...]  -- 指定结果按照哪几个字段来分组
    [having ...]  -- 过滤分组的记录必须满足的次要条件
    [order by ...]  -- 指定查询记录按照一个或者多个条件排序
    [limit {[offset,] row_count}]  -- 指定查询的记录从哪条至哪条

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
/*
 where子句(返回boolean值)：模糊查询
    运算符             语法                      描述
    is null           a is null                如果a为null, 结果为真
    is not null       a is not null            如果a不为null, 结果为真
    between           a between b and c        如果a在b和c之间，则结果为真
    like              a like b                 SQL匹配，如果a匹配b, 则结果为真
    in                a in (a1, a2,...)        假设a在(a1, a2,...)之中，结果为真
*/
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

-- 查询 高等数学-1 课程成绩排名前10的学生，并且分数要大于80的学生信息(学号，姓名，课程名称，分数)
select s.`StudentNo`, `StudentName`, `SubjectName`, `StudentResult`
from `student` s
inner join `result` r
on s.`StudentNo`=r.`StudentNo`
inner join `subject` sub
on r.`SubjectNo`=sub.`SubjectNo`
where `SubjectName`='高等数学-1'
order by `StudentResult` desc
limit 0,10;


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


-- ================================排序order by=================================
-- 将查询的结果进行排序
-- 升序 asc; 降序 desc
-- order by 待排序的字段 排序策略
select s.`StudentNo`, `StudentName`, `SubjectNo`, `StudentResult`
from student as s
inner join result as r
where s.StudentNo = r.StudentNo
order by `StudentResult` desc;


-- ================================分页limit=================================
/*
为什么需要分页？
    (1) 缓解数据库压力
    (2) 给人的体验更好
*/
-- 语法：limit 起始值, 页面的大小
select s.`StudentNo`, `StudentName`, `SubjectNo`, `StudentResult`
from student as s
inner join result as r
where s.StudentNo = r.StudentNo
order by `StudentResult` desc
limit 0,5;

/*
第一页     limit 0,5           (1-1)*5
第二页     limit 5,5           (1-1)*5
第三页     limit 10,5          (1-1)*5
第n页     limit (n-1)*5,5      (n-1)*pageSize, pageSize

pageSize : 页面大小
(n-1)*pageSize : 起始值
n : 当前页数
总页数 = 数据总数 / 页面大小 + 1
*/


-- ================================子查询=================================
-- 1.查询 高等数学-1 的所有考试结果(学号，科目编号，成绩)，降序排列
-- 方式一：使用连接查询
select `StudentNo`, r.`SubjectNo`, `StudentResult`
from `result` r
inner join `subject` sub
on r.`SubjectNo`=sub.`SubjectNo`
where `SubjectName`='高等数学-1'
order by `StudentResult` desc;
-- 方式二：使用子查询(查询过程：由里及外)
select `StudentNo`, `SubjectNo`, `StudentResult`
from `result` where `SubjectNo`=(
    select `SubjectNo` from `subject` where `SubjectName`='高等数学-1'
);

-- 2.查询课程为 高等数学-1 且分数不小于 80 的同学的学号和姓名
-- 方式一：使用连接查询
select s.`StudentNo`, `StudentName`
from `student` s
inner join `result` r
on s.`StudentNo`=r.`StudentNo`
inner join `subject` sub
on r.`SubjectNo`=sub.`SubjectNo`
where `SubjectName`='高等数学-1' and `StudentResult`>=80;
-- 方式二：使用子查询(查询过程：由里及外)
select `StudentNo`, `StudentName` from `student` where `StudentNo` in (
    select `StudentNo` from `result` where `StudentResult`>=80 and `SubjectNo`=(
        select `SubjectNo` from `subject` where `SubjectName`='高等数学-1'
        )
    );
-- 方式三：使用连接和子查询(查询过程：由里及外)
select s.`StudentNo`, `StudentName`
from `student` s
inner join `result` r
on s.`StudentNo`=r.`StudentNo`
where `StudentResult`>=80 and `SubjectNo`=(
        select `SubjectNo` from `subject` where `SubjectName`='高等数学-1'
);


-- ================================MySQL函数：常用函数(也不是那么常用)=================================
/*
 官网：https://dev.mysql.com/doc/refman/5.7/en/sql-function-reference.html
 MySQL字符串的下标都是从1开始的
*/
-- 数学运算
select abs(-8);  -- 绝对值
select ceiling(9.4);  -- 向上取整
select floor(9.4);  -- 向下取整
select rand();  -- 返回一个在0~1之间的随机数[0~1)
select sign(10.1);  -- 判断一个数的符号，0:0，负数返回-1，正数返回1
-- 字符串函数
select char_length('即使再小的帆也能远航');  -- 字符串长度
select concat('我', '爱', '你');  -- 拼接字符串
select insert('我爱编程', 1, 2, '超级热爱');  -- 从某个位置开始用 '超级热爱' 替换 '我爱编程' 指定长度
select lower('I love you!');  -- 转为小写字母
select upper('I love you!');  -- 转为大写字母
select instr('I love you!', 'ov');  -- 返回第一次出现的字符串的索引
select replace('坚持就能成功!', '坚持', '努力');  -- 体现出现的指定字符串
select substr('坚持就能成功!', 1, 4);  -- 返回指定的子字符串(源字符串, 截取的位置, 截取的长度)
select reverse('I love you!');  -- 翻转字符串

-- 查询姓 刘 的同学，更改姓为 柳
select replace(`StudentName`, '刘', '柳') from `student`
where `StudentName` like '刘%';

-- 时间日期函数
select current_date();  -- 获取当前日期, 精确到日
select curdate();  -- 获取当前日期, 精确到日
select now();  -- 获取当前日期, 精确到秒
select localtime();  -- 获取本地时间, 精确到秒
select sysdate();  -- 获取系统时间, 精确到秒

select year(now());
select month(now());
select day(now());
select hour(now());
select minute(now());
select second(now());

-- 系统
select system_user();  -- 获取当前系统用户
select user();  -- 获取当前系统用户
select version();  -- 获取数据库版本


-- ================================MySQL函数：聚合函数=================================
-- 下面三种写法都能统计表中的数据，有什么区别？
select count(`StudentName`) from `student`;  -- count(字段)，如果某个字段为null，则不会被记入
select count(*) from `student`;  -- count(*), 如果某个字段为null，会被记入；本质：计算行数
select count(1) from `student`;  -- count(1), 如果某个字段为null，会被记入；本质：计算行数

select sum(`StudentResult`) as '总和' from `result`;
select avg(`StudentResult`) as '平均分' from `result`;
select max(`StudentResult`) as '最高分' from `result`;
select min(`StudentResult`) as '最低分' from `result`;

-- 查询平均分大于 60 的课程的平均分，最高分，最低分
select `SubjectName`, avg(`StudentResult`) as '平均分', max(`StudentResult`), min(`StudentResult`)
from result r
inner join `subject` sub
on r.`SubjectNo`=sub.`SubjectNo`
group by r.SubjectNo  -- 分类的字段
having `平均分`>=60;


-- ================================扩展：MD5加密=================================
drop table if exists `testmd5`;
create table `testmd5` (
    `id` int(4) not null comment '主键',
    `name` varchar(20) not null comment '名字',
    `pwd` varchar(50) not null comment '密码',
    primary key (`id`)
)engine=innodb default charset=utf8;

-- 插入明文密码
insert into `testmd5` values (1, 'zs', '123456');
-- 插入加密后的密码
insert into `testmd5` values (2, 'ls', MD5('123456'));
-- 查询加密后的用户信息
select * from `testmd5` where `id`=2 and `pwd`=MD5('123456');









