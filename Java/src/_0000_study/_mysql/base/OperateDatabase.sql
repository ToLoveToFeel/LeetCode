/*
操作数据库 --> 操作数据库中的表 --> 操作数据库中表的字段

操作数据库：（了解）
    1. 创建数据库
    2. 删除数据库
    3. 使用数据库
    4. 查看所有的数据库
idea中的sql文件选中需要执行的命令后，Ctrl+Enter可以执行
 */

-- 1. 创建数据库
create database if not exists westos;

-- 2. 删除数据库
drop database if exists westos;

-- 3. 使用数据库
use `school`;

-- 4. 查看所有的数据库
show databases;

