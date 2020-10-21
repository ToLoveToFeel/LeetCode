package _0000_study._jdbc.basic.preparedstatement.crud;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import _0000_study._jdbc.basic.preparedstatement.bean.Order;
import _0000_study._jdbc.util.JDBCUtils;
import org.junit.Test;

/**
 * 针对于Order表的通用的查询操作
 */
public class OrderForQuery {
    /*
     * 针对于表的字段名与类的属性名不相同的情况：
     * 1. 必须声明sql时，使用类的属性名来命名字段的别名
     * 2. 使用ResultSetMetaData时，需要使用getColumnLabel()来替换getColumnName(),
     *    获取列的别名。
     *  说明：如果sql中没有给字段其别名，getColumnLabel()获取的就是列名
     */
    @Test
    public void testOrderForQuery() {
        String sql = "select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id = ?";
        Order order = orderForQuery(sql, 1);
        System.out.println(order);
    }


    // 通用的针对于order表的查询操作
    public Order orderForQuery(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1.获取数据库的连接
            conn = JDBCUtils.getConnection();
            // 2.预编译sql语句，返回PreparedStatement的实例
            ps = conn.prepareStatement(sql);
            // 3.填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            // 4.执行,并返回结果集
            rs = ps.executeQuery();
            // 获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            // 获取列数
            int columnCount = rsmd.getColumnCount();
            if (rs.next()) {
                Order order = new Order();
                for (int i = 0; i < columnCount; i++) {
                    // 获取每个列的列值:通过 ResultSet
                    Object columnValue = rs.getObject(i + 1);
                    // 通过 ResultSetMetaData
                    // 获取列的列名：getColumnName() -- 不推荐使用
                    // 获取列的别名：getColumnLabel()
                    // String columnName = rsmd.getColumnName(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    // 通过反射，将对象指定名 columnName 的属性赋值为指定的值 columnValue
                    // 报错原因，我们拿着的列名 order_id, 但是Order中对应的是orderId
                    Field field = Order.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(order, columnValue);
                }
                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5.资源的关闭
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }

    @Test
    public void testQuery1() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1.获取数据库的连接
            conn = JDBCUtils.getConnection();
            // 2.预编译sql语句，返回PreparedStatement的实例
            String sql = "select order_id,order_name,order_date from `order` where order_id = ?";
            ps = conn.prepareStatement(sql);
            // 3.填充占位符
            ps.setObject(1, 1);
            // 4.执行,并返回结果集
            rs = ps.executeQuery();
            if (rs.next()) {
                int id = (int) rs.getObject(1);
                String name = (String) rs.getObject(2);
                Date date = (Date) rs.getObject(3);

                Order order = new Order(id, name, date);
                System.out.println(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5.资源的关闭
            JDBCUtils.closeResource(conn, ps, rs);
        }
    }
}
