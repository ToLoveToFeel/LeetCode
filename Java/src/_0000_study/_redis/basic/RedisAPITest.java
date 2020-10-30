package _0000_study._redis.basic;

import _0000_study._redis.util.RedisUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Date: 2020/10/29 21:41
 * Content:
 */
public class RedisAPITest {

    public static void main(String[] args) throws IOException {
        Jedis jedis = RedisUtils.getConnection();

        // 选择0号库
        jedis.select(0);
        // 清空当前库的缓存
        jedis.flushDB();
        // 设置 key
        jedis.set("k1", "Hello World!");
        jedis.set("k2", "Simple Life!");
        jedis.set("k3", "Simple Love!");
        // 判断键值对是否存在
        System.out.println(jedis.exists("k1"));  // true
        // 查看键值对的过期时间，-1表示永不过期，-2代表已经过期
        System.out.println(jedis.ttl("k1"));  // -1
        // 获取键对应的值
        System.out.println(jedis.get("k1"));  // Hello World!
        // 获取所有的键
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);  // [k3, k1, k2]
        // 获取当前库的大小(键值对的个数)
        System.out.println(jedis.dbSize());  // 3
    }

    @Test
    public void testString() throws IOException {
        Jedis jedis = RedisUtils.getConnection();
        // 选择1号库
        jedis.select(1);
        // 清空当前库的缓存
        jedis.flushDB();

        // set/append
        jedis.set("k1", "my");
        jedis.append("k1", "Redis");
        System.out.println(jedis.get("k1"));  // myRedis
        // mset/mget
        jedis.mset("s1", "v1", "s2", "v2", "s3", "v3");
        System.out.println(jedis.mget("s1", "s2", "s3"));  // [v1, v2, v3]
    }

    @Test
    public void testList() throws IOException {
        Jedis jedis = RedisUtils.getConnection();
        // 选择2号库
        jedis.select(2);
        // 清空当前库的缓存
        jedis.flushDB();

        // lpush/lrange
        jedis.lpush("list1", "v1", "v2", "v3", "v4");
        System.out.println(jedis.lrange("list1", 0, -1));  // [v4, v3, v2, v1]
        // rpush
        jedis.rpush("list2", "v1", "v2", "v3", "v4");
        System.out.println(jedis.lrange("list2", 0, -1));  // [v1, v2, v3, v4]
    }

    @Test
    public void testSet() throws IOException {
        Jedis jedis = RedisUtils.getConnection();
        // 选择3号库
        jedis.select(3);
        // 清空当前库的缓存
        jedis.flushDB();

        // sadd/smembers
        jedis.sadd("orders", "jd001");
        jedis.sadd("orders", "jd002", "jd003");
        System.out.println(jedis.smembers("orders"));  // [jd001, jd003, jd002]
        // srem
        jedis.srem("orders", "jd002");
        System.out.println(jedis.smembers("orders"));  // [jd001, jd003]
    }

    @Test
    public void testHash() throws IOException {
        Jedis jedis = RedisUtils.getConnection();
        // 选择4号库
        jedis.select(4);
        // 清空当前库的缓存
        jedis.flushDB();

        // hset/hget
        jedis.hset("hash1", "userName", "zhangsan");
        System.out.println(jedis.hget("hash1", "userName"));  // zhangsan
        // hmset/hmget
        Map<String, String> map = new HashMap<>();
        map.put("phone", "13012345678");
        map.put("address", "hangzhou");
        map.put("email", "abc@163.com");
        jedis.hmset("hash2", map);
        System.out.println(jedis.hmget("hash2", "address", "email"));  // [hangzhou, abc@163.com]
    }

    @Test
    public void testZset() throws IOException {
        Jedis jedis = RedisUtils.getConnection();
        // 选择5号库
        jedis.select(5);
        // 清空当前库的缓存
        jedis.flushDB();

        // zadd/zrange
        jedis.zadd("zset1", 60d, "v1");
        jedis.zadd("zset1", 70d, "v2");
        jedis.zadd("zset1", 80d, "v3");
        jedis.zadd("zset1", 90d, "v4");
        System.out.println(jedis.zrange("zset1", 0, -1));  // [v1, v2, v3, v4]
    }
}
