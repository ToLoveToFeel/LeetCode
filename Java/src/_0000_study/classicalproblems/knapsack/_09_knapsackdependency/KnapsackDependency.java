package _0000_study.classicalproblems.knapsack._09_knapsackdependency;

import java.util.Arrays;

/**
 * Date: 2020/12/19 20:14
 * Content: 参考最下面的说明
 */
public class KnapsackDependency {

    // 如果**编号为i的物品**(这里是编号，不是id)不在叶子节点，则head[i]!=-1,否则head[i]=-1,这里的head其实是最右侧的孩子节点对应的唯一标识(id)
    private int[] head;
    // good[id] : 唯一标识 id 对应的物品是 good[id], 注意：根节点没有唯一标识id
    private int[] good;
    // next[id] : 唯一标识 id 对应的物品 的下一个左兄弟物品对应的索引
    private int[] next;
    // 物品对应的唯一标识 id
    private int id;

    private int[][] dp;

    // 编号为son的物品 依赖于 编号为parent的物品
    private void add(int son, int parent) {
        good[id] = son;
        next[id] = head[parent];
        head[parent] = id++;
    }

    // 当前考察 编号为u的物品，所能得到的最大价值
    private void dfs(int u, int[] weights, int[] values, int C) {

        for (int i = head[u]; i != -1; i = next[i]) {  // 遍历 编号为u的物品 的孩子节点，从最右侧的孩子物品开始遍历

            int son = good[i];
            // 考察 编号为u的物品 的某个子节点
            dfs(son, weights, values, C);
            // 事先为 编号为u的物品 留出位置
            for (int j = C - weights[u]; j >= 0; j--) {  // 遍历容量，递减遍历

                for (int k = 0; k <= j; k++) {  // 遍历决策
                    dp[u][j] = Math.max(dp[u][j], dp[u][j - k] + dp[son][k]);
                }
            }
        }

        // 背包容量足够，将 编号为u的物品 的物品放入背包
        for (int i = C; i >= weights[u]; i--) {
            dp[u][i] = dp[u][i - weights[u]] + values[u];
        }
        // 背包容量不足，因此 编号为u的物品 的物品无法放入背包，因此也无法放入依赖于此物品的物品
        for (int i = 0; i < weights[u]; i++) {
            dp[u][i] = 0;
        }
    }

    public int knapsackDependency(int[] weights, int[] values, int[] parents, int C) {

        int n = weights.length;

        // 初始化数据
        id = 0;
        head = new int[n];
        good = new int[n];
        next = new int[n];
        dp = new int[n][C + 1];

        Arrays.fill(head, -1);

        int root = 0;  // 存储根节点物品编号
        for (int i = 0; i < n; i++) {
            int p = parents[i];
            if (p == -1)
                root = i;
            else
                add(i, p);
        }

        // 从根节点开始向下递归
        dfs(root, weights, values, C);

        return dp[root][C];
    }

    public static void main(String[] args) {

        // n件物品，编号为 0~n-1
        int[] weights = {2, 2, 3, 2, 3, 4, 3, 2, 3};  // 每件物品的重量
        int[] values = {3, 2, 5, 2, 5, 7, 6, 2, 5};  // 每件物品的价值
        int[] parents = {-1, 0, 0, 0, 0, 1, 1, 1, 1};  // 每件物品所依赖的物品编号
        int weightCapacity = 7;  // 最大能承载的重量
        System.out.println((new KnapsackDependency()).knapsackDependency(
                weights,
                values,
                parents,
                weightCapacity
                )
        );
    }
}

/*
 n件物品，编号为 0~n-1
 int[] weights = {2, 2, 3, 2, 3, 4, 3, 2, 3};  // 每件物品的重量
 int[] values = {3, 2, 5, 2, 5, 7, 6, 2, 5};  // 每件物品的价值
 int[] parents = {-1, 0, 0, 0, 0, 1, 1, 1, 1};  // 每件物品所依赖的物品编号
            (id, 编号)
                                 * (无, 0)
                        /         |        |      \
                       /          |        |       \
                   * (0, 1)      *(1, 2)   *(2,3)  *(3,4)
              /     |     |   \
         *(4,5) *(5,6) *(6,7) *(7, 8)

good[id] = son;
next[id] = head[parent];
head[parent] = id++;


 // 编号为0的物品的最右侧孩子的对应的id为0, 其中good,next的下标都是id
 id = 0, add(1, 0), good[0] = 1, next[0] = -1, head[0] = 0;
 // 编号为0的物品的最右侧孩子的对应的id为1, 因为next[1] = 0，所以id为1的下一件紧挨着的左兄弟id为0
 id = 1, add(2, 0), good[1] = 2, next[1] = 0, head[0] = 1;
 // 编号为0的物品的最右侧孩子的对应的id为2, 因为next[2] = 1，所以id为2的下一件紧挨着的左兄弟id为1
 id = 2, add(3, 0), good[2] = 3, next[2] = 1, head[0] = 2;
 // 编号为0的物品的最右侧孩子的对应的id为3, 因为next[3] = 2，所以id为3的下一件紧挨着的左兄弟id为2
 id = 3, add(4, 0), good[3] = 4, next[3] = 2, head[0] = 3;

 // 编号为1的物品的最右侧孩子的对应的id为4, 其中good,next的下标都是id
 id = 4, add(5, 1), good[4] = 5, next[4] = -1, head[1] = 4;
 // 编号为1的物品的最右侧孩子的对应的id为5, 因为next[5] = 4，所以id为5的下一件紧挨着的左兄弟id为4
 id = 5, add(6, 1), good[5] = 6, next[5] = 4, head[1] = 5;
 // 编号为1的物品的最右侧孩子的对应的id为6, 因为next[6] = 5，所以id为6的下一件紧挨着的左兄弟id为5
 id = 6, add(7, 1), good[6] = 7, next[6] = 5, head[1] = 6;
 // 编号为1的物品的最右侧孩子的对应的id为6, 因为next[6] = 5，所以id为6的下一件紧挨着的左兄弟id为5
 id = 7, add(8, 1), good[7] = 8, next[7] = 6, head[1] = 7;

 通过head[0]，得到 编号为0的物品 的最右孩子节点编号3， 然后通过next可以找到 编号为0的物品 所有的孩子(相当于从右向左遍历)
    next[3] = 2     next[2] = 1     next[1] = 0     next[0] = -1
  id    3     ------>   2     ------>   1     ------>   0     ------>   -1
  编号   4     ------>   3     ------>   2     ------>   1     ------>   结束

  通过head[1]，得到 编号为1的物品 的最右孩子节点编号7， 然后通过next可以找到 编号为1的物品 所有的孩子(相当于从右向左遍历)
    next[7] = 6     next[6] = 5     next[5] = 4     next[4] = -1
  id    7     ------>   6     ------>   5     ------>   4     ------>   -1
  编号   8     ------>   7     ------>   6     ------>   5     ------>   结束
 */
