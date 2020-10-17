package _0374_Guess_Number_Higher_or_Lower;

/**
 * Date: 2020/10/17 10:47
 * Content:
 * 二分查找
 */
public class Solution {
    private static int pick;  // pick是我们需要猜测的数据

    private int guess(int num) {
        return Integer.compare(pick, num);
    }

    public int guessNumber(int n) {
        int l = 1, r = n;
        while (true) {
            int mid = (r - l) / 2 + l;
            if (guess(mid) == 0)
                return mid;

            if (guess(mid) > 0)  // 说明猜小了
                l = mid + 1;
            else  // 说明猜大了
                r = mid - 1;
        }
    }

    public static void main(String[] args) {
        int n = 10;
        pick = 6;
        System.out.println((new Solution()).guessNumber(n));
    }
}
