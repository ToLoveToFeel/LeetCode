package _0000_study._db._jdbc.connectionpool;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Date: 2020/10/22 14:33
 * Content:
 */
public class C3P0Test {
    // 方式一：
    @Test
    public void testGetConnection() throws Exception {
        // 获取c3p0数据库连接池
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.jdbc.Driver"); // loads the jdbc driver
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/test?rewriteBatchedStatements=true");
        cpds.setUser("root");
        cpds.setPassword("123456");

        // 通过设置相关的参数，对数据库连接池进行管理：
        // 设置初始时数据库连接池中的连接数
        cpds.setInitialPoolSize(10);

        Connection conn = cpds.getConnection();
        System.out.println(conn);

//        // 销毁c3p0数据库连接池
//        DataSources.destroy(cpds);
    }

    // 方式二：使用配置文件
    @Test
    public void testGetConnection1() throws SQLException {
        // 配置文件 c3p0-config.xml 在 idea 中必须位于 resource 中（Resource Root）
        ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
        Connection conn = cpds.getConnection();
        System.out.println(conn);
    }
}
