/*
 索引：索引是帮助MySQL高效获取数据的数据结构。

 索引的分类：
    (1) 主键索引(PRIMARY KEY)
        唯一的标识，主键不可重复，只能有一个列作为主键
    (2) 唯一索引(UNIQUE KEY)
        避免重复的列出现，唯一索引可重复，多个列都可以标识为唯一索引
    (3) 常规索引(KEY / INDEX)
        默认的
    (4) 全文索引(FullText)
        在特定的数据库引擎下才有，MYISAM，最新的INNODB也有
        快速定位数据

 索引的使用：
    (1) 在创建表的时候给字段增加索引
    (2) 创建完毕后，增加索引

 对所有讲解的极好的博客：
    http://blog.codinglabs.org/articles/theory-of-mysql-index.html

 索引在小数据量的时候用处不大，但是在大数据的时候，区别十分明显

 索引原则：
    (1) 索引不是越多越好
    (2) 不要对经常变动的数据加索引
    (3) 小数据量的表不需要添加索引
    (4) 索引一般加在常用的查询字段上

 索引的数据结构：
    (1) Hash类型的索引
    (2) Btree : Innodb的默认数据结构
 */
-- ================================关于所有的一些命令=================================
-- 切换数据库
use `school`;

-- 显示所有的索引信息
show index from `student`;

-- 给字段增加索引(给 student 表中的字段 StudentName 字段增加全文索引)
alter table `student` add fulltext index `StudentNameIndex`(`StudentName`);

-- explain 分析sql执行的状况
explain select * from `student`;  -- 非全文索引
explain select * from `student` where match(`StudentName`) against('刘');


-- ================================索引测试=================================
-- 删除 school 中的表 app_user
drop table if exists `app_user`;
-- 创建表
create table `app_user` (
    `id` bigint(20) unsigned not null auto_increment comment '主键',
    `name` varchar(50) default ''comment '用户昵称',
    `email` varchar(50) not null comment '用户邮箱',
    `phone` varchar(20) default '' comment '手机号',
    `gender` tinyint(4) unsigned default '0' comment '性别（0：男；1：女）',
    `password` varchar(100) not null comment '密码',
    `age` tinyint(4) default '0' comment '年龄',
    primary key (`id`)
)engine = innodb default charset = utf8 comment 'app用户表';


-- 插入100万条数据
-- 定义函数
delimiter $$  -- 写函数之前必须要写，标志

create function mock_data()
returns int
begin
    declare num int default 1000000;
    declare i int default 0;
    while i < num do
        insert into `app_user`(`name`, `email`, `phone`, `gender`, `password`, `age`)
        values (
                concat('用户', i),
                '1137247975@qq.com',
                concat('13', floor(rand()*(999999999 - 100000000)+100000000)),
                floor(rand()*2),
                uuid(),
                floor(rand()*100)
                );
        set i = i + 1;
    end while;
    return i;
end;
-- 执行函数
select mock_data();

-- 查询某个用户
select * from `app_user` where `name`='用户9999';  -- 未创建索引：1s多；创建索引后：30ms左右
-- 分析sql
explain select * from `app_user` where `name`='用户9999';

-- 创建索引 (命名：id_表名_字段名)
-- create index 索引名 on 表(字段)
create index `id_app_user_name` on `app_user`(`name`);





