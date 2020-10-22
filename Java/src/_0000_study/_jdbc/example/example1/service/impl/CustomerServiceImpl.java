package _0000_study._jdbc.example.example1.service.impl;

import _0000_study._jdbc.example.example1.dao.BaseDao;
import _0000_study._jdbc.example.example1.pojo.Customer;
import _0000_study._jdbc.example.example1.service.ICustomerService;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * Date: 2020/10/22 11:10
 * Content: 相当于 尚硅谷 jdbc 讲解中的 CustomerDAOImpl
 */
public class CustomerServiceImpl extends BaseDao implements ICustomerService {
    @Override
    public void insert(Connection conn, Customer cust) {
        String sql = "insert into customers(name,email,birth)values(?,?,?)";
        updateRowWithTx(conn, sql, cust.getName(), cust.getEmail(), cust.getBirth());
    }

    @Override
    public void deleteById(Connection conn, int id) {
        String sql = "delete from customers where id = ?";
        updateRowWithTx(conn, sql, id);
    }

    @Override
    public void update(Connection conn, Customer cust) {
        String sql = "update customers set name = ?,email = ?,birth = ? where id = ?";
        updateRowWithTx(conn, sql, cust.getName(), cust.getEmail(), cust.getBirth(), cust.getId());
    }

    @Override
    public Customer getCustomerById(Connection conn, int id) {
        String sql = "select id,name,email,birth from customers where id = ?";
        Customer customer = getInstanceWithTx(conn, Customer.class, sql, id);
        return customer;
    }

    @Override
    public List<Customer> getAll(Connection conn) {
        String sql = "select id,name,email,birth from customers";
        List<Customer> list = getForListWithTx(conn, Customer.class, sql);
        return list;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from customers";
        return getValue(conn, sql);
    }

    @Override
    public Date getMaxBirth(Connection conn) {
        String sql = "select max(birth) from customers";
        return getValue(conn, sql);
    }
}
