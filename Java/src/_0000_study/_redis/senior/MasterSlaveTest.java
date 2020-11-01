package _0000_study._redis.senior;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Date: 2020/11/1 9:50
 * Content:
 */
public class MasterSlaveTest {

    @Test
    public void test() throws Exception {
        Jedis jedisM = new Jedis("127.0.0.1", 6379);  // 主机
        Jedis jedisS = new Jedis("127.0.0.1", 6380);  // 从机

        // 配从不配主
        jedisS.slaveof("127.0.0.1", 6379);
        jedisM.flushDB();
        // 读写分离：主机负责写，从机负责读(从机没有写的权利)
        jedisM.set("class", "1122");
        TimeUnit.MILLISECONDS.sleep(10);  // 第一次来不及读取
        String res = jedisS.get("class");
        System.out.println(res);
    }
}
