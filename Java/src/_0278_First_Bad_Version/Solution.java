package _0278_First_Bad_Version;

/**
 * Date: 2021/2/4 8:58
 * Content:
 * 执行用时：16 ms, 在所有 Java 提交中击败了99.30%的用户
 * 内存消耗：35.1 MB, 在所有 Java 提交中击败了74.29%的用户
 */
public class Solution {

    public int firstBadVersion(int n) {

        int l = 1, r = n;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (isBadVersion(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    boolean isBadVersion(int version) {

        return version >= 3;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).firstBadVersion(5));  // 3
    }
}
