package _0000_study._jdbc.connectionpool;

import _0000_study._jdbc.util.JDBCUtils;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Date: 2020/10/22 15:53
 * Content:
 */
public class DruidTest {
    @Test
    public void getConnection() throws Exception {
        Properties pros = new Properties();

        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(JDBCUtils.PORPERTYPATH + "druid.properties");

        pros.load(is);

        DataSource source = DruidDataSourceFactory.createDataSource(pros);
        Connection conn = source.getConnection();
        System.out.println(conn);
    }
}
