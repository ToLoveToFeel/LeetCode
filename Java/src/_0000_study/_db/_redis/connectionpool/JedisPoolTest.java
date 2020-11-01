package _0000_study._db._redis.connectionpool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Date: 2020/11/1 10:12
 * Content:
 */
public class JedisPoolTest {

    public static void main(String[] args) {
        // 获取数据库连接池
        JedisPool jedisPool = JedisPoolUtil.getInstance();
        // 获取数据库连接池中的一个实例
        Jedis jedis = jedisPool.getResource();
        // 清当前数据库
        jedis.flushDB();
        // 向数据库中写入数据 并 获得写入的数据
        jedis.set("key", "value");
        System.out.println(jedis.get("key"));
        // 将连接还回数据库连接池
        JedisPoolUtil.release(jedisPool, jedis);
    }
}
