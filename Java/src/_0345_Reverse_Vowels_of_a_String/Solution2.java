package _0345_Reverse_Vowels_of_a_String;

public class Solution2 {
    // 和Solution思想一样，只不过写法不同，三种解法中速度最快
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public String reverseVowels(String s) {
        int l = 0;
        int r = s.length() - 1;
        char[] chars = s.toCharArray();
        while (l < r) {
            if (isVowel(chars[l])) {
                while (l <= r && !isVowel(chars[r])) {
                    r--;
                }
                swap(chars, l, r);
                r--;
            }
            l++;
        }
        return new String(chars);
    }

    private boolean isVowel(char c){
        switch (c){
            case 'a':
            case 'A':
            case 'e':
            case 'E':
            case 'i':
            case 'I':
            case 'o':
            case 'O':
            case 'u':
            case 'U':
                return true;
            default:
                return false;
        }
    }

    public void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        String s = "leetcode";

        System.out.println((new Solution2()).reverseVowels(s));
    }
}
