package _0134_Gas_Station;

/**
 * Date: 2020/11/18 15:21
 * Content:
 * https://leetcode-cn.com/problems/gas-station/solution/shi-yong-tu-de-si-xiang-fen-xi-gai-wen-ti-by-cyayc/
 *
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.8 MB, 在所有 Java 提交中击败了77.95%的用户
 */
public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int spareGas = 0;  // 总的剩余汽油量
        int minSpareGas = Integer.MAX_VALUE;  // 总的最少剩余汽油量
        int minIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            spareGas += (gas[i] - cost[i]);
            if (spareGas < minSpareGas) {
                minSpareGas = spareGas;
                minIndex = i;
            }
        }

        return spareGas < 0 ? -1 : (minIndex + 1) % gas.length;
    }

    public static void main(String[] args) {

//        int[] gas = {1, 2, 3, 4, 5};
//        int[] cost = {3, 4, 5, 1, 2};
//        System.out.println((new Solution()).canCompleteCircuit(gas, cost));
        int[] gas = {4, 5, 1, 2, 3};
        int[] cost = {1, 2, 3, 4, 5};
        System.out.println((new Solution()).canCompleteCircuit(gas, cost));
    }
}

/*
    int[] gas = {1, 2, 3, 4, 5};
    int[] cost = {3, 4, 5, 1, 2};
    那么：
    gas - cost = {-2, -2, -2, 3, 3};
    由 gas - cost 数组构成的折线图的走势是一定的
 */
