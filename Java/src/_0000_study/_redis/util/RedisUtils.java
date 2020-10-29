package _0000_study._redis.util;

import _0000_study._redis.basic.ConnectionTest;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Date: 2020/10/29 20:38
 * Content:
 */
public class RedisUtils {
    // 配置文件路径
    public static final String PORPERTYPATH = "_0000_study\\_redis\\util\\";

    // 获取数据库的连接
    public static Jedis getConnection() throws IOException {
        // 1.读取配置文件
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream(PORPERTYPATH + "redis.properties");
        Properties pros = new Properties();
        pros.load(is);
        String ip = pros.getProperty("ip");
        int port = Integer.parseInt(pros.getProperty("port"));

        // 2.获取连接 并返回
        return new Jedis(ip, port);
    }
}
