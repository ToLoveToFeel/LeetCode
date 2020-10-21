package _0000_study._jdbc.basic.preparedstatement.crud;

import _0000_study._jdbc.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

/**
 * Date: 2020/10/20 20:42
 * Content:
 * <p>
 * 使用 PreparedStatement 来替换 Statement , 实现对数据表的增删改操作
 * 增删改；查
 */
public class PreparedStatementUpdateTest {

    // 增
    // 注意：异常需要 try-catch-finally 处理，因为为了保证资源一定被关闭
    // 但是为了看得清晰，这里省略，实际生产环境代码一定要加上
    @Test
    public void testInsert() throws Exception {
        // 1.获取数据库连接
        Connection conn = JDBCUtils.getConnection();
        // 2.预编译sql语句，返回 PreparedStatement 的实例
        String sql = "insert into customers(name,email,birth) values(?,?,?)";  // ?:占位符
        PreparedStatement ps = conn.prepareStatement(sql);
        // 3.填充占位符
        ps.setObject(1, "哪吒");
        ps.setObject(2, "nezha@qq.com");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf.parse("1000-01-01");
        ps.setObject(3, new Date(date.getTime()));
        // 4.执行
        boolean success = ps.execute();
        if (success)
            System.out.println("插入成功!");
        else
            System.out.println("插入失败!");
        // 5.资源的关闭
        JDBCUtils.closeResource(conn, ps);
    }

    // 通用的增删改操作: 针对不同的操作（增删改），针对不同的表
    // 无返回值
    public void update(String sql, Object... args) {  // sql中占位符的个数与可变形参的长度相同！
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1.获取数据库的连接
            conn = JDBCUtils.getConnection();
            // 2.预编译sql语句，返回PreparedStatement的实例
            ps = conn.prepareStatement(sql);
            // 3.填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);  // 小心参数声明错误！！
            }
            // 4.执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5.资源的关闭
            JDBCUtils.closeResource(conn, ps);
        }
    }

    // 通用的增删改操作: 针对不同的操作（增删改），针对不同的表
    // 有返回值, 返回增删改影响的行数
    public int updateRow(String sql, Object... args) {  // sql中占位符的个数与可变形参的长度相同！
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1.获取数据库的连接
            conn = JDBCUtils.getConnection();
            // 2.预编译sql语句，返回PreparedStatement的实例
            ps = conn.prepareStatement(sql);
            // 3.填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);  // 小心参数声明错误！！
            }
            // 4.执行
            /*
             * ps.execute():
             * 如果执行的是查询操作，有返回结果，则此方法返回true;
             * 如果执行的是增、删、改操作，没有返回结果，则此方法返回false.
             */
            // 方式一：
            // return ps.execute();
            // 方式二：
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5.资源的关闭
            JDBCUtils.closeResource(conn, ps);
        }
        return 0;
    }

    @Test
    public void testCommonUpdate() {
//        String sql = "delete from customers where id = ?";
//        update(sql, 3);

        String sql = "update `order` set order_name = ? where order_id = ?";
        update(sql, "DD", "2");
    }
}
