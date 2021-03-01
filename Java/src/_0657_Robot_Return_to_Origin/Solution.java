package _0657_Robot_Return_to_Origin;

/**
 * Created by WXX on 2021/3/1 10:05
 * 执行用时：5 ms, 在所有 Java 提交中击败了92.04%的用户
 * 内存消耗：38.5 MB, 在所有 Java 提交中击败了57.62%的用户
 */
public class Solution {

    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'R') y++;
            else if (c == 'L') y--;
            else if (c == 'U') x--;
            else x++;
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).judgeCircle("UD"));  // true
        System.out.println((new Solution()).judgeCircle("LL"));  // false
    }
}
