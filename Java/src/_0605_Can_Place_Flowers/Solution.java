package _0605_Can_Place_Flowers;

/**
 * Date: 2021/1/1
 * Content:
 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：40 MB, 在所有 Java 提交中击败了52.73%的用户
 */
public class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int len = flowerbed.length;
        if (len == 1 && flowerbed[0] == 0)
            return n <= 1;

        int cnt = 0;
        // 处理前两个数据
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            cnt++;
        }
        // 处理中间的数据
        for (int i = 1; i < len - 2; i++) {
            if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                cnt++;
            }
        }
        // 处理最后两个数据
        if (flowerbed[len - 1] == 0 && flowerbed[len - 2] == 0) {
            flowerbed[len - 1] = 1;
            cnt++;
        }

        return cnt >= n;
    }

    public static void main(String[] args) {

//        int[] flowerbed = {1, 0, 0, 0, 1};
//        int n = 2;
        int[] flowerbed = {0, 0, 1, 0, 1};
        int n = 1;
        System.out.println((new Solution()).canPlaceFlowers(flowerbed, n));
    }
}
