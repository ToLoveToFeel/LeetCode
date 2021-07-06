/*
事务：要么都成功，要么都失败

结合 _0000_study\_db\_jdbc\senior\transaction\description.txt 一起查看

事务的原则：ACID
    原子，一致，隔离，持久

    原子性：要么都成功，要么都失败
    一致性：事务前后的数据完整性要保证一致
    持久性：事务一旦提交则不可逆，被持久化到数据库中
    隔离性：多个用户并发访问数据库时，数据库为每一个用户开启的事务，不会被其他事务的操作数据所干扰，多个并发事物之间要相互隔离

隔离所导致的一些问题：
    脏读：指一个事务读取了另外一个事务未提交的数据
    不可重复读：在一个事务内读取某一行数据，多次读取结果不同。(这个不一定是错误，只是某些场合不对)
    虚读(幻读)：是指在一个事务内读取到别的事务插入的数据，导致前后读取不一致

数据库提供的4种事务隔离级别：read uncommited、read commited、repeatable read、serializable
- Mysql 支持 4 种事务隔离级别。Mysql 默认的事务隔离级别为: repeatable read。
- Mysql 是默认开启事务自动提交的。

 */
-- ================================事务命令=================================
# -- 查询事务级别
# select @@tx_isolation;
#
# -- 设置事务级别
# set global transaction isolation level read committed;  -- 设置全局事务
# set session transaction isolation level repeatable read ;  -- 设置session事务
#
# -- 关闭和开启事务
# set autocommit = 0;  -- 关闭事务
# set autocommit = 1;  -- 开启事务
#
# -- 开启事务
# start transaction;  -- 开启事务
#
# -- 保存点
# savepoint myPoint;  -- 设置一个事务的保存点
# rollback to savepoint myPoint;  -- 回滚到保存点
# release savepoint myPoint;  -- 撤销保存点
#
#
# -- 提交事务：持久化
# commit;
# -- 回滚
# rollback;

-- ================================事务：转账例子=================================
-- 删除数据库
drop database if exists `shop`;
-- 创建数据库
create database if not exists `shop` character set utf8 collate utf8_general_ci;
-- 使用数据库
use `shop`;
-- 删除表
drop table if exists `account`;
-- 在选中的数据库中创建表
create table `account` (
    `id` int(3) not null auto_increment comment '主键',
    `name` varchar(30) not null comment '姓名',
    `money` decimal(9, 2) not null comment '账户余额',
    primary key (`id`)
)engine=innodb default charset=utf8;
-- 向表中插入数据
insert into `account`(`name`, `money`)
values ('A', 5000.00),
       ('B', 10000.00);

-- 模拟事务，转账
set autocommit = 0;  -- 关闭自动提交
start transaction;  -- 开启一个事务

-- 转账
update `account` set `money`=`money`-500 where `name`='A';  -- A减500
update `account` set `money`=`money`+500 where `name`='B';  -- B加500

-- 成功则提交事务
commit;
-- 错误则回滚事务
rollback;

-- 开启事务自动提交(即恢复默认值)
set autocommit = 1;







