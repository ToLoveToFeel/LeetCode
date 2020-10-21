package _0000_study._jdbc.basic.preparedstatement.batchinsert;

import _0000_study._jdbc.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Date: 2020/10/21 19:39
 * Content: 演示批量插入
 * 使用PreparedStatement实现批量数据的操作
 * <p>
 * update、delete本身就具有批量操作的效果。
 * 此时的批量操作，主要指的是批量插入。使用PreparedStatement如何实现更高效的批量插入？
 * <p>
 * 题目：向goods表中插入20000条数据
 * CREATE TABLE goods(
 * id INT PRIMARY KEY AUTO_INCREMENT,
 * NAME VARCHAR(25)
 * );
 * 查询 goods 表中记录数量：SELECT COUNT(*) FROM goods;
 * 清空 goods 表：TRUNCATE TABLE goods;
 * 方式一：使用Statement
 * Connection conn = JDBCUtils.getConnection();
 * Statement st = conn.createStatement();
 * for(int i = 1;i <= 20000;i++){
 *      String sql = "insert into goods(name)values('name_" + i + "')";
 *      st.execute(sql);
 * }
 */
public class BatchInsertTest {
    // 批量插入的方式二：使用PreparedStatement
    @Test
    public void batchInsertTest1() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();
            // 1.获取数据库连接
            conn = JDBCUtils.getConnection();
            // 2.预编译sql语句，返回PreparedStatement的实例
            String sql = "insert into goods(name) values(?)";
            ps = conn.prepareStatement(sql);
            // 3.填充占位符
            for (int i = 1; i <= 20000; i++) {
                ps.setObject(1, "name_" + i);
                // 4.执行
                ps.execute();
            }

            long end = System.currentTimeMillis();
            System.out.println("花费的时间为：" + (end - start) / 1000.0 + "s");  // 20000条数据：30s
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5.资源的关闭
            JDBCUtils.closeResource(conn, ps);
        }
    }

    /*
     * 批量插入的方式三：
     * 1.addBatch()、executeBatch()、clearBatch()
     * 2.mysql服务器默认是关闭批处理的，我们需要通过一个参数，让mysql开启批处理的支持。
     * 		 ?rewriteBatchedStatements=true 写在配置文件的url后面
     * 3.使用更新的mysql 驱动：mysql-connector-java-5.1.37-bin.jar
     */
    @Test
    public void batchInsertTest2() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();
            // 1.获取数据库连接
            conn = JDBCUtils.getConnection();
            // 2.预编译sql语句，返回PreparedStatement的实例
            String sql = "insert into goods(name) values(?)";
            ps = conn.prepareStatement(sql);
            // 3.填充占位符
            for (int i = 1; i <= 1000000; i++) {
                ps.setObject(1, "name_" + i);
                // (1) "攒"sql
                ps.addBatch();
                if (i % 500 == 0) {
                    // 4.执行   (2) 执行batch
                    ps.executeBatch();
                    // (3) 清空batch
                    ps.clearBatch();
                }
            }

            long end = System.currentTimeMillis();
            // 2万条数据：0.592s      100万条数据：11.7s
            System.out.println("花费的时间为：" + (end - start) / 1000.0 + "s");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5.资源的关闭
            JDBCUtils.closeResource(conn, ps);
        }
    }

    // 批量插入的方式四：设置连接不允许自动提交数据
    @Test
    public void batchInsertTest3() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();
            // 1.获取数据库连接
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);  // 设置不允许自动提交数据
            // 2.预编译sql语句，返回PreparedStatement的实例
            String sql = "insert into goods(name) values(?)";
            ps = conn.prepareStatement(sql);
            // 3.填充占位符
            for (int i = 1; i <= 1000000; i++) {
                ps.setObject(1, "name_" + i);
                // (1) "攒"sql
                ps.addBatch();
                if (i % 500 == 0) {
                    // 4.执行   (2) 执行batch
                    ps.executeBatch();
                    // (3) 清空batch
                    ps.clearBatch();
                }
            }
            conn.commit();  // 提交数据

            long end = System.currentTimeMillis();
            // 100万条数据：7.573s
            System.out.println("花费的时间为：" + (end - start) / 1000.0 + "s");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5.资源的关闭
            JDBCUtils.closeResource(conn, ps);
        }
    }
}
