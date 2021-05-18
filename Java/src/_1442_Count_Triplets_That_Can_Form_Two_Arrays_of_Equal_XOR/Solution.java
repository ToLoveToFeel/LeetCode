package _1442_Count_Triplets_That_Can_Form_Two_Arrays_of_Equal_XOR;

/**
 * Date: 2021/5/18 8:58
 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：35.5 MB, 在所有 Java 提交中击败了100.00%的用户
 */
public class Solution {

    public int countTriplets(int[] arr) {

        int n = arr.length;
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] ^ arr[i - 1];

        int res = 0;
        for (int i = 0; i <= n; i++)
            for (int k = i + 2; k <= n; k++)
                if ((s[i] ^ s[k]) == 0)
                    res += k - i - 1;
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).countTriplets(new int[]{2, 3, 1, 6, 7}));  // 4
    }
}
