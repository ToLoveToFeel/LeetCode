/*
DML : 数据操作语言
    insert / delete / update

insert : insert into 表名[(字段1, 字段2, ...)] values ('值1', '值2', ...), ('值1', '值2', ...);
    (1) 字段和字段之间使用英文逗号隔开
    (2) 字段是可以省略的，但是后面的值必须要一一对应，不能少
    (3) 可以同时插入多条数据，values后面的值，需要使用英文逗号隔开

update : update 表名 set column_name=value[,column_name=value,...] [where 条件];
    (1) column_name是数据库的列名，尽量带上``
    (2) 筛选的条件如果没有加上，则会修改所有的列
    (3) value，可以是一个具体的值，也可以是一个变量
    (4) 多个需要修改的属性之间，用英文逗号隔开

*/
-- 准备
drop table if exists `grade`;
drop table if exists `student`;

create table if not exists `grade` (
    `gradeId` int(10) not null auto_increment comment '学生的年级',
    `gradeName` varchar(50) not null comment '年级名称',
    primary key (`gradeId`)
)engine=innodb default charset=utf8;

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

-- ================================insert=================================
insert into `grade`(`gradeName`) values('大一');

-- 由于主键自增，我们可以省略主键(如果不写表的字段，会从前到后一一匹配)
-- 一般写插入语句，我们一定要数据和字段一一对应!
insert into `grade` values('2', '大二');

-- 插入多条数据
insert into `grade` values('3', '大三'), ('4', '大四');

insert into `student`(`name`, `pwd`, `sex`, `birthday`)
values ('张三', 'abcdef', '男', '2000-01-01 17:05:20'),
       ('李四', '123456', '男', '1999-01-01'),
       ('王五', '123321', '男', '2001-01-01');


-- ================================update=================================
-- 修改学员的名字
update `student` set `name`='wxx' where `id`=1;

-- 修改所有人的名字
-- update `student` set `name`='someone';

-- 修改多个属性
update `student` set name='kuang', email='24736743@qq.com' where id=1;
update `student` set `birthday`=current_date where id=1;


-- ================================delete=================================
-- 删除数据(避免这样写，会全部删除)
-- delete from `student`;

-- 删除指定数据
delete from `student` where id=1;

-- 完全清空一个数据库表，表的结构和索引约束不会变
truncate `student`;
/*
    delete vs. truncate
    相同点：都能删除数据，清空一张表
    不同点：
        truncate :
            (1) 重新设置自增列，计数器归零
            (2) 不会影响事务
        delete :
            (1) 不会重新设置自增列，计数器不归零
                但要注意，如果使用 InnoDB 断电后自增会重新从1开始(存在内存中，断电即失)；
                如果使用 MYISAM 断电后自增会继续上一个自增量开始(存在文件中，不会丢失)
*/







