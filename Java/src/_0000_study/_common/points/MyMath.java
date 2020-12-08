package _0000_study._common.points;

import org.junit.Test;

/**
 * Date: 2020/12/8 16:06
 * Content: 关于数学的实用点
 */
public class MyMath {

    // 判断一个数是不是 2 的幂次
    @Test
    public void test01() {

        for (int i = 1; i <= 16; i++) {
            if ((i & (i - 1)) == 0)
                System.out.println(i + " 是 2 的幂次============");
            else
                System.out.println(i + " 不是 2 的幂次....");
        }

    }
}
