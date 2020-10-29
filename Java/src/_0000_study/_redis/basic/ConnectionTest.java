package _0000_study._redis.basic;

import _0000_study._redis.util.RedisUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Date: 2020/10/29 20:31
 * Content:
 * 测试 redis 连接, 首先要启动 redis: 配置好环境变量后在cmd中输入redis-server.exe可以启动redis服务端
 */
public class ConnectionTest {

    @Test
    public void test1() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println(jedis.ping());  // PONG
    }

    @Test
    public void test2() throws IOException {
        // 1.读取配置文件
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream(RedisUtils.PORPERTYPATH + "redis.properties");
        Properties pros = new Properties();
        pros.load(is);
        String ip = pros.getProperty("ip");
        int port = Integer.parseInt(pros.getProperty("port"));

        // 2.获取连接
        Jedis jedis = new Jedis(ip, port);

        System.out.println(jedis.ping());  // PONG
    }
}
