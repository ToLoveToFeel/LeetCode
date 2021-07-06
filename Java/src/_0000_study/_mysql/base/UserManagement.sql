/*
 用户管理

 用户表：mysql.user

 本质：对 mysql.user 进行增删改查
 */
-- 创建用户
-- create user 用户名 identified by '密码'
create user wxx identified by '123456';

-- 修改密码(修改当前用户密码)
set password = password('123456');

-- 修改密码(修改指定用户密码)
set password for wxx = password('123456');

-- 重命名
-- rename user 原来名字 to 新名字
rename user wxx to wxx2;
rename user wxx2 to wxx;

-- 用户授权 all privileges 全部的权限
-- all privileges 除了grant的权限，其他的权限都能赋予
grant all privileges on *.* to wxx;
grant all privileges on *.* to wxx with grant option;  -- 授予全部权限，包括grant权限

-- 查询指定用户的权限
show grants for wxx;
show grants for root@localhost;

-- 撤销权限
-- revoke 哪些权限 on 在哪个库那个表撤销 from 用户
revoke all privileges on *.* from wxx;

-- 删除用户
drop user wxx;

