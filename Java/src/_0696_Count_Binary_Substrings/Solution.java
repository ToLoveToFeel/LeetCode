package _0696_Count_Binary_Substrings;


public class Solution {
    // 超时
    public int countBinarySubstrings(String s) {

        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++)
            if (match(i, s))
                sum++;
        return sum;
    }

    private boolean match(int i, String s) {
        int zeroNum = 0;
        int oneNum = 0;
        if (s.charAt(i) == '0') {
            while (i < s.length() && s.charAt(i) == '0') {
                zeroNum++;
                i++;
            }
            while (i < s.length() && s.charAt(i) == '1') {
                oneNum++;
                if (oneNum == zeroNum)
                    return true;
                i++;
            }
        } else {
            while (i < s.length() && s.charAt(i) == '1') {
                oneNum++;
                i++;
            }
            while (i < s.length() && s.charAt(i) == '0') {
                zeroNum++;
                if (zeroNum == oneNum)
                    return true;
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).countBinarySubstrings("00110011"));
    }
}
