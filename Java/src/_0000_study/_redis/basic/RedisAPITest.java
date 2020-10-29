package _0000_study._redis.basic;

import _0000_study._redis.util.RedisUtils;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.Set;

/**
 * Date: 2020/10/29 21:41
 * Content:
 */
public class RedisAPITest {

    public static void main(String[] args) throws IOException {
        Jedis jedis = RedisUtils.getConnection();

        // 选择1号库
        jedis.select(1);
        // 清空当前库的缓存
        jedis.flushDB();
        // 设置 key
        jedis.set("k1", "Hello World!");
        jedis.set("k2", "Simple Life!");
        jedis.set("k3", "Simple Love!");
        // 获取键对应的值
        System.out.println(jedis.get("k1"));
        // 获取所有的键
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
        // 获取当前库的大小(键值对的个数)
        System.out.println(jedis.dbSize());
    }
}
