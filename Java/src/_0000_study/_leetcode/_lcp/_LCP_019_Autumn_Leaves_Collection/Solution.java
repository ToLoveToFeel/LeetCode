package _0000_study._leetcode._lcp._LCP_019_Autumn_Leaves_Collection;

/**
 * Date: 2020/10/1 10:06
 * Content:
 * 动态规划
 * 状态：
 * dp[i][0] = 代表从头开始全部修改成红色（纯红）需要修改几次
 * dp[i][1] = 代表从头开始是红色，然后现在是黄色（红黄），需要修改几次
 * dp[i][2] = 代表从头开始是红色，然后变成黄色，又变成红色（红黄红），需要修改几次
 * 状态转移：
 * dp[i][0] ：如果是黄的，就比之前加一
 * dp[i][1] ：可以从上一个纯红状态变化过来，也可以从上一个本身状态变化过来
 * dp[i][2] ：可以从上一个红黄状态变化过来，也可以从上一个本身状态变化过来
 */
public class Solution {
    public int minimumOperations(String leaves) {
        int[][] dp = new int[leaves.length()][3];

        for (int i = 0; i < leaves.length(); i++) {
            // dp[i][0]: [0...i]全红
            if (i < 1)
                dp[i][0] = (leaves.charAt(0) == 'r' ? 0 : 1);
            else
                dp[i][0] = dp[i - 1][0] + (leaves.charAt(i) == 'r' ? 0 : 1);
            // dp[i][1]: [0...i]"红黄"
            if (i < 1)
                dp[i][1] = dp[i][0];
            else
                dp[i][1] = Math.min(
                        dp[i - 1][0] + (leaves.charAt(i) == 'y' ? 0 : 1),
                        dp[i - 1][1] + (leaves.charAt(i) == 'y' ? 0 : 1)
                );
            // dp[i][2]: [0...i]"红黄红"
            if (i < 2)
                dp[i][2] = dp[i][1];
            else
                dp[i][2] = Math.min(
                        dp[i - 1][1] + (leaves.charAt(i) == 'r' ? 0 : 1),
                        dp[i - 1][2] + (leaves.charAt(i) == 'r' ? 0 : 1)
                );
        }
        return dp[leaves.length() - 1][2];
    }

    public static void main(String[] args) {
//        String leaves = "ryr";
        String leaves = "ryyyrryyyrr";
        System.out.println((new Solution()).minimumOperations(leaves));
    }
}


//// 初始化
//dp[0][0]=(leaves.charAt(0)=='y'?1:0);  // 如果第一片树叶为黄色的话需要调整一次
//dp[0][1]=dp[0][0];  // 想要构成 "红黄" 序列，但现在只有一片树叶，第一片树叶必须为 红色
//dp[1][1]=Math.min(dp[0][0]+(leaves.charAt(1)=='y'?0:1),
//                  dp[0][1]+(leaves.charAt(1)=='y'?0:1));
//dp[0][2]=dp[0][1];  // 想要构成 "红黄红" 序列，但现在只有一片树叶，第一片树叶必须为 红色
//dp[1][2]=dp[1][1];  // 想要构成 "红黄红" 序列，但现在只有两片树叶，第一片必须为 红色，第二片

/*
例如：leaves = "ryyyrryyyrr"
    dp              0(r)    1(ry)   2(ryr)
        r   0       0       0       0
        y   1       1       0       0
        y   2       2       0       1
        y   3       3       0       1
        r   4       3       1       0
        r   5       3       2       0
        y   6       4       2       1
        y   7       5       2       2
        y   8       6       2       3
        r   9       6       3       2
        r   10      6       4       2
 */



















