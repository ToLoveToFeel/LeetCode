package _0000_study._jdbc.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

/**
 * Date: 2020/10/22 21:11
 * Content: 此 utils 使用已经提供好的包
 */
public class DataBaseUtils {
    // 配置文件路径, DBCP连接池需要 src\\
    public static final String PORPERTYPATH = "_0000_study\\_jdbc\\util\\";
    public static final String PORPERTYPATHSRC = "src\\" + PORPERTYPATH;

    /*
     * 使用 数据库连接池 建立连接
     */
    // 使用数据库连接池 C3P0 获取数据库的连接
    private static ComboPooledDataSource C3P0source = new ComboPooledDataSource("helloc3p0");

    public static Connection getConnectionUsingC3P0() throws Exception {
        return C3P0source.getConnection();
    }

    // 使用数据库连接池 DBCP 获取数据库的连接
    private static DataSource DBCPsource;

    static {
        try {
            Properties pros = new Properties();
            FileInputStream is = new FileInputStream(new File(DataBaseUtils.PORPERTYPATHSRC + "dbcp.properties"));
            pros.load(is);
            DBCPsource = BasicDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnectionUsingDBCP() throws Exception {
        return DBCPsource.getConnection();
    }

    // 使用数据库连接池 Druid 获取数据库的连接
    private static DataSource Druidsource;

    static {
        try {
            Properties pros = new Properties();
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(DataBaseUtils.PORPERTYPATH + "druid.properties");
            pros.load(is);
            Druidsource = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnectionUsingDruid() throws Exception {
        return Druidsource.getConnection();
    }

    /*
     * 关闭连接
     */
    public static void closeResource(Connection conn) {
        DbUtils.closeQuietly(conn, null, null);
    }

    public static void closeResource(Connection conn, Statement ps) {
        DbUtils.closeQuietly(conn, ps, null);
    }

    public static void closeResource(Connection conn, Statement ps, ResultSet rs) {
        DbUtils.closeQuietly(conn, ps, rs);
    }

    /*
     * 通用的增删改查操作，使用 dbutils 提供的现有类
     */
    private static QueryRunner queryRunner = new QueryRunner();

    // 通用的增删改操作
    public static int updateRowWithTx(Connection conn, String sql, Object... args) {
        int count = 0;
        try {
            count = queryRunner.update(conn, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    // 获取一个对象
    public static <T> T getInstanceWithTx(Connection conn, Class<T> clazz, String sql, Object... args) {
        T t = null;
        try {
            t = queryRunner.query(conn, sql, new BeanHandler<T>(clazz), args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    // 获取所有对象
    public static <T> List<T> getForListWithTx(Connection conn, Class<T> clazz, String sql, Object... args) {
        List<T> list = null;
        try {
            list = queryRunner.query(conn, sql, new BeanListHandler<T>(clazz), args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // 获取一个查询特殊值方法，专门用来执行像 select count(*)...这样的sql语句
    public static Object getValue(Connection conn, String sql, Object... args) {
        Object count = 0;
        try {
            count = queryRunner.query(conn, sql, new ScalarHandler(), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }
}
