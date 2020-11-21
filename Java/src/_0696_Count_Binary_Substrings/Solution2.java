package _0696_Count_Binary_Substrings;

class Solution2 {
    public int countBinarySubstrings(String s) {

        int res = 0;
        int[] count = new int[2];  // count[0]记录'0'出现的次数，count[1]记录'1'出现的次数
        char prev = '2';  // 记录当前遍历字符的前一个字符
        for (char c : s.toCharArray()) {
            int index = c - '0';
            if (c != prev) {
                prev = c;
                count[index] = 0;
            }

            count[index]++;
            if (count[1 - index] >= count[index]) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution2()).countBinarySubstrings("00110011"));
    }
}
