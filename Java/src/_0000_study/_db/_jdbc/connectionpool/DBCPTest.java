package _0000_study._db._jdbc.connectionpool;

import _0000_study._db._jdbc.util.JDBCUtils;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Date: 2020/10/22 15:17
 * Content: 测试DBCP的数据库连接池技术
 */
public class DBCPTest {
    @Test
    public void testGetConnection() throws SQLException {
        // 创建了DBCP的数据库连接池
        BasicDataSource source = new BasicDataSource();

        // 设置基本信息
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/test?rewriteBatchedStatements=true");
        source.setUsername("root");
        source.setPassword("123456");

        // 还可以设置其他涉及数据库连接池管理的相关属性：
        source.setInitialSize(10);
        source.setMaxActive(10);
        // ......

        Connection conn = source.getConnection();
        System.out.println(conn);
    }

    // 方式二：推荐：使用配置文件
    @Test
    public void testGetConnection1() throws Exception {
        Properties pros = new Properties();

//        // 方式1：
//		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(JDBCUtils.PORPERTYPATHSRC + "dbcp.properties");
        // 方式2：
        FileInputStream is = new FileInputStream(new File(JDBCUtils.PORPERTYPATHSRC + "dbcp.properties"));

        pros.load(is);
        DataSource source = BasicDataSourceFactory.createDataSource(pros);

        Connection conn = source.getConnection();
        System.out.println(conn);
    }
}
