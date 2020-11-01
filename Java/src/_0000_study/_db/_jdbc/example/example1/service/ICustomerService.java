package _0000_study._db._jdbc.example.example1.service;

import _0000_study._db._jdbc.example.example1.pojo.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * Date: 2020/10/22 11:05
 * Content: 相当于 尚硅谷 jdbc 讲解中的 CustomerDAO
 * 此接口用于规范针对于customers表的常用操作
 */
public interface ICustomerService {
    // 将 cust 对象添加到数据库中
    void insert(Connection conn, Customer cust);

    // 针对指定的id，删除表中的一条记录
    void deleteById(Connection conn, int id);

    // 针对内存中的 cust 对象，去修改数据表中指定的记录
    void update(Connection conn, Customer cust);

    // 针对指定的 id 查询得到对应的 Customer 对象
    Customer getCustomerById(Connection conn, int id);

    // 查询表中的所有记录构成的集合
    List<Customer> getAll(Connection conn);

    // 返回数据表中的数据的条目数
    Long getCount(Connection conn);

    // 返回数据表中最大的生日
    Date getMaxBirth(Connection conn);
}
