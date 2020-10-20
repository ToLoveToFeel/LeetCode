package _0000_study._jdbc.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Date: 2020/10/20 20:20
 * Content:
 */
public class JDBCUtils {
    // 配置文件路径
    public static final String PORPERTYPATH = "_0000_study\\_jdbc\\util\\jdbc.properties";

    // 获取数据库的连接
    public static Connection getConnection() throws Exception {
        // 1.读取配置文件中的4个基本信息
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(PORPERTYPATH);

        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        // 2.加载驱动
        Class.forName(driverClass);

        // 3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);

        return conn;
    }


    // 关闭连接和Statement的操作
    public static void closeResource(Connection conn, Statement ps) {
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 关闭资源操作
    public static void closeResource(Connection conn, Statement ps, ResultSet rs) {
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
