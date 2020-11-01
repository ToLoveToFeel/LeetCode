package _0000_study._db._redis.senior;

import _0000_study._db._redis.util.RedisUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.io.IOException;
import java.util.List;

/**
 * Date: 2020/10/31 21:01
 * Content:
 */
public class TransactionTest {
    @Test
    public void test1() throws IOException {
        Jedis jedis = RedisUtils.getConnection();
        // 选择0号库
        jedis.select(0);
        // 清空当前库的缓存
        jedis.flushDB();

        // 开启事务
        Transaction tx = jedis.multi();
        // 设置事务执行的内容
        tx.set("k1", "v1");
        tx.set("k2", "v22");
        // 执行事务
        tx.exec();
//        // 放弃事务
//        tx.discard();
    }

    /*
     * 通俗点讲，watch命令就是标记一个键，如果标记了一个键， 在提交事务前如果该键被别人修改过，那事务就会失败，这种情况通常可以在程序中
     * 重新再尝试一次。
     * 首先标记了键balance，然后检查余额是否足够，不足就取消标记，并不做扣减； 足够的话，就启动事务进行更新操作，
     * 如果在此期间键balance被其它人修改， 那在提交事务（执行exec）时就会报错， 程序中通常可以捕获这类错误再重新执行一次，直到成功。
     */
    @Test
    public void test2() throws IOException {
        Jedis jedis = RedisUtils.getConnection();
        int balance = 100;  // 可用余额
        int debt = 0;  // 欠额
        int amtToSubtract = 10;  // 实刷额度

        // 设置
        jedis.set("balance", String.valueOf(balance));
        jedis.set("debt", String.valueOf(debt));

        jedis.watch("balance");
        // jedis.set("balance","5");  // 此句不该出现，讲课方便。模拟其他程序已经修改了该条目

        balance = Integer.parseInt(jedis.get("balance"));
        if (balance < amtToSubtract) {
            jedis.unwatch();
            System.out.println("money is not enough!");
        } else {
            System.out.println("***********transaction***********");
            Transaction transaction = jedis.multi();
            transaction.decrBy("balance", amtToSubtract);
            transaction.incrBy("debt", amtToSubtract);
//            try {
//                TimeUnit.SECONDS.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            List<Object> res = transaction.exec();
            balance = Integer.parseInt(jedis.get("balance"));
            debt = Integer.parseInt(jedis.get("debt"));

            if (res != null) {
                System.out.println("balance : " + balance);
                System.out.println("debt : " + debt);
                System.out.println("successful!");
            } else {
                System.out.println("监控过程中balance被其他客户端修改，事务被终止!");
            }
        }
    }
}
