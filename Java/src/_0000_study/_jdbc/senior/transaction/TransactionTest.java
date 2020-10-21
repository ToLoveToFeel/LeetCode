package _0000_study._jdbc.senior.transaction;

import _0000_study._jdbc.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/*
 * 1.什么叫数据库事务？
 * 事务：一组逻辑操作单元,使数据从一种状态变换到另一种状态。
 * 		> 一组逻辑操作单元：一个或多个DML操作。
 *
 * 2.事务处理的原则：保证所有事务都作为一个工作单元来执行，即使出现了故障，都不能改变这种执行方式。
 * 当在一个事务中执行多个操作时，要么所有的事务都被提交(commit)，那么这些修改就永久地保存
 * 下来；要么数据库管理系统将放弃所作的所有修改，整个事务回滚(rollback)到最初状态。
 *
 * 3.数据一旦提交，就不可回滚
 *
 * 4.哪些操作会导致数据的自动提交？
 * 		> DDL(Create、Drop、Alter等)操作一旦执行，都会自动提交。
 * 			> set autocommit = false 对DDL操作失效
 * 		> DML(增删改)默认情况下，一旦执行，就会自动提交。
 * 			> 我们可以通过set autocommit = false的方式取消DML操作的自动提交。
 * 		>  默认在关闭连接时，会自动的提交数据
 */
public class TransactionTest {
    /*
     * 针对于数据表 user_table 来说：
     * AA 用户给 BB 用户转账 100
     *
     * update user_table set balance = balance - 100 where user = 'AA';
     * update user_table set balance = balance + 100 where user = 'BB';
     */
    @Test
    public void testUpdateWithTx() {
        Connection conn = null;
        try {
            // 1.获取数据库的连接
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);  // (1) 取消 DML 语句自动提交
            // 2.设置预编译sql语句  (返回PreparedStatement的实例: 在 updateRowWithTx 中有实现)
            String sql1 = "update user_table set balance = balance - 100 where user = ?";
            JDBCUtils.updateRowWithTx(conn, sql1, "AA");
//            // 模拟网络异常
//            System.out.println(10 / 0);
            String sql2 = "update user_table set balance = balance + 100 where user = ?";
            JDBCUtils.updateRowWithTx(conn, sql2, "BB");

            System.out.println("转账成功");

            // (2) 提交数据
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // (3) 回滚数据
            try {
                if (conn != null)
                    conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            // (4) 修改连接 conn 为自动提交数据，这里不写也行，主要是针对数据库连接池的使用
            try {
                if (conn != null)
                    conn.setAutoCommit(true);
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
            // 5.资源的关闭
            JDBCUtils.closeResource(conn);
        }
    }
}
