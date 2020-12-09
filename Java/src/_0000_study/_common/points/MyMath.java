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

    // 求解组合 C(a, b) 保证结果小于 Integer.MAX_VALUE
    // C(a, b) = a! / (b! * (a-b)!) = ((b+1)*...*a) / (a-b)!
    @Test
    public void test02() {

        int a = 5;
        int b = 2;

        long res = 1;
        int len = Math.min(a - b, b);
        for (int i = 0; i < len; i++) {
            res *= (a - i);
            res /= (i + 1);
        }

        System.out.println(res);
    }

}
