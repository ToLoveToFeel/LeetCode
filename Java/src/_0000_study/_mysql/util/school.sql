/*
 DQL连续需要的准备工作
 */

-- ================================创建数据库=================================
create database if not exists `school`;
-- 创建一个school数据库
use `school`;-- 创建学生表

-- ================================创建学生表，并添加数据=================================
drop table if exists `student`;
create table `student`(
	`StudentNo` int(4) not null comment '学号',
    `LoginPwd` varchar(20) default null,
    `StudentName` varchar(20) default null comment '学生姓名',
    `Sex` tinyint(1) default null comment '性别，0或1',
    `GradeId` int(11) default null comment '年级编号',
    `Phone` varchar(50) not null comment '联系电话，允许为空',
    `Address` varchar(255) not null comment '地址，允许为空',
    `BornDate` datetime default null comment '出生时间',
    `Email` varchar (50) not null comment '邮箱账号允许为空',
    `IdentityCard` varchar(18) default null comment '身份证号',
    primary key (`StudentNo`),
    unique key `IdentityCard`(`IdentityCard`),
    key `email` (`Email`)
)engine=myisam default charset=utf8;
-- 插入学生数据 其余自行添加 这里只添加了2行
insert into `student` (`StudentNo`,`LoginPwd`,`StudentName`,`Sex`,`GradeId`,`Phone`,`Address`,`BornDate`,`Email`,`IdentityCard`)
values
(1000,'123456','张伟',0,2,'13800001234','北京朝阳','1980-1-1','text123@qq.com','123456198001011234'),
(1001,'123456','赵强',1,3,'13800002222','广东深圳','1990-11-21','text111@qq.com','123456199001011233'),
(1002,'123456','刘洋',1,3,'13800002222','辽宁大连','1995-1-9','text111@qq.com','123456199001011234'),
(1003,'123456','刘洋洋',0,3,'13800002222','浙江杭州','1998-9-1','text111@qq.com','123456199001011239'),
(1004,'123456','赵杰',1,3,'13800002222','广东深圳','1990-10-10','text111@qq.com','123456199001011264'),
(1005,'123456','刘丽霞',0,2,'13800002222','广东佛山','1994-11-11','text111@qq.com','123456199001016833'),
(1006,'123456','仓央嘉措',0,2,'13800002222','安徽合肥','1994-5-1','text111@qq.com','123456199405016892');


-- ================================创建年级表，并添加数据=================================
drop table if exists `grade`;
create table `grade`(
    `GradeId` int(11) not null auto_increment comment '年级编号',
    `GradeName` varchar(50) not null comment '年级名称',
    primary key (`GradeId`)
) engine=innodb auto_increment = 6 default charset = utf8;
-- 插入年级数据
insert into `grade` (`GradeId`,`GradeName`)
values(1,'大一'),(2,'大二'),(3,'大三'),(4,'大四'),(5,'预科班');

-- ================================创建科目表，并添加数据=================================
-- 创建科目表
drop table if exists `subject`;
create table `subject`(
	`SubjectNo`int(11) not null auto_increment comment '课程编号',
    `SubjectName` varchar(50) default null comment '课程名称',
    `ClassHour` int(4) default null comment '学时',
    `GradeId` int(4) default null comment '年级编号',
    primary key (`SubjectNo`)
)engine = innodb auto_increment = 19 default charset = utf8;
insert into `subject`(`SubjectNo`,`SubjectName`,`ClassHour`,`GradeId`)values
(1,'高等数学-1',110,1),
(2,'高等数学-2',110,2),
(3,'高等数学-3',100,3),
(4,'高等数学-4',130,4),
(5,'C语言-1',110,1),
(6,'C语言-2',110,2),
(7,'C语言-3',100,3),
(8,'C语言-4',130,4),
(9,'Java程序设计-1',110,1),
(10,'Java程序设计-2',110,2),
(11,'Java程序设计-3',100,3),
(12,'Java程序设计-4',130,4),
(13,'数据库结构-1',110,1),
(14,'数据库结构-2',110,2),
(15,'数据库结构-3',100,3),
(16,'数据库结构-4',130,4),
(17,'C#基础',130,1);

-- ================================创建成绩表，并添加数据=================================
-- 创建成绩表
drop table if exists `result`;
create table `result`(
	`StudentNo` int(4) not null comment '学号',
    `SubjectNo` int(4) not null comment '课程编号',
    `ExamDate` datetime not null comment '考试日期',
    `StudentResult` int (4) not null comment '考试成绩',
    key `SubjectNo` (`SubjectNo`)
)engine = innodb default charset = utf8;

-- 插入成绩数据  这里仅插入了一组，其余自行添加
insert into `result`(`StudentNo`,`SubjectNo`,`ExamDate`,`StudentResult`)
values
(1000,1,'2013-11-11 16:00:00',85),
(1000,2,'2013-11-12 16:00:00',70),
(1000,3,'2013-11-11 09:00:00',68),
(1000,4,'2013-11-13 16:00:00',98),
(1000,5,'2013-11-14 16:00:00',58),
(1001,4,'2013-11-11 16:00:00',85),
(1002,3,'2013-11-12 16:00:00',70),
(1003,2,'2013-11-11 09:00:00',68),
(1004,5,'2013-11-13 16:00:00',98),
(1005,1,'2013-11-14 16:00:00',58);





























