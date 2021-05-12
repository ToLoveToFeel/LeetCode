package _0374_Guess_Number_Higher_or_Lower;

/**
 * Date: 2020/10/17 10:47
 * Content: 二分查找
 */
public class Solution {
    private static int pick = 6;  // pick是我们需要猜测的数据

    private int guess(int num) {
        return Integer.compare(pick, num);
    }

    public int guessNumber(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (guess(mid) >= 0) l = mid;  // 说明猜小了
            else r = mid - 1;
        }
        return l;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).guessNumber(10));
        System.out.println((new Solution()).guessNumber(1000));
    }
}
