package _0000_study.classicalproblems.reversepairs;

/**
 * Date: 2020/11/28 15:45
 * Content: 树状数组
 */
public class Fenwick {

    private int[] C;  // 树状数组
    private int n;  // 树状数组长度

    public Fenwick(int n) {
        this.n = n;
        C = new int[n + 1];  // nums[0]空闲，未使用
    }

    // 获取二进制表示下 除了最低位的1之外所有的1置零得到的数据
    // 比如 011010 ---> 00010
    private int lowBit(int x) {
        return x & (-x);
    }

    // 将 A[index] 更新为 A[index]+data
    public void update(int index, int data) {
        // 自底向上更新 nums
        while (index <= n) {
            C[index] += data;
            index += lowBit(index);  // 寻找父索引
        }
    }

    // 获取A[1...index]的数据之和
    public int query(int index) {
        // 自顶向下获取结果
        // 比如query(5) = C[5] + C[4]
        // 比如query(15) = C[15] + C[14] + C[12] + C[8]
        int sum = 0;
        while (index > 0) {
            sum += C[index];
            index -= lowBit(index);
        }
        return sum;
    }

}

/*
 A : 原数组        A[1]    A[2]    A[3]    A[4]
 C : 树状数组      C[1]     C[2]    C[3]    C[4]

 下标十进制                           下标二进制                                  lowBit(index),指数k为最后一个1后面0的个数
 C[1] = A[1]                        C[1] = A[1]                                 0001 --> 0001   2^0 一个元素相加
 C[2] = A[1] + A[2]                 C[10] = A[01] + A[10]                       0010 --> 0010   2^1 二个元素相加
 C[3] = A[3]                        C[11] = A[11]                               0011 --> 0001   2^0 一个元素相加
 C[4] = A[1] + A[2] + A[3] + A[4]   C[100] = A[01] + A[10] + A[11] +A[100]      0100 --> 0100   2^2 四个元素相加
 ......
 C[i] = A[i - 2^k + 1] + ... + A[i]  这里lowBit(i)=2^k                                           2^k 2^k个元素相加

                C[4]
             /       \
           C[2]       *
          /   \     /   \
        C[1]  *   C[3]  *
         |    |     |   |
       A[1]  A[2] A[3] A[4]
-----------------------------------父子关系下标索引的证明！！！关键！！！------------------------------------
 设 t = i+lowBit(i)
    lowBit(i+lowBit(i)) = 2^k1      lowBit(i)=2^k   指数k和k1的含义是最后一个1后面0的个数
    根据上面的定义，可以得出 k1 >= k+1
    因为 C[t] = A[t - 2^k1 + 1] + ... + A[t]，     t = i+lowBit(i) = i+2^k
    所以 C[t] = A[t - 2^k1 + 1] + ... + A[t - 2^(k+1) + 1] + ... + A[i] + ... + A[t]
             = A[t - 2^k1 + 1] + ... + A[i+2^k - 2^(k+1) + 1] + ... + A[i] + ... + A[t]
             = A[t - 2^k1 + 1] + ... + A[i+2^k - (2^k)*2 + 1] + ... + A[i] + ... + A[t]
             = A[t - 2^k1 + 1] + ... + (A[i - 2^k + 1] + ... + A[i]) + ... + A[t]
             = A[t - 2^k1 + 1] + ... + C[i] + ... + A[t]
  所以C[i]的父节点：C[i+lowBit(i)]
------------------------------------------------------------------------------------------------------
 参考网址：https://blog.csdn.net/bestsort/article/details/80796531
         https://leetcode-cn.com/problems/reverse-pairs/solution/fan-zhuan-dui-by-leetcode-solution/
 */
