package _0345_Reverse_Vowels_of_a_String;

public class Solution3 {
    // 和Solution思想一样，只不过写法不同
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
        else if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ) return true;
        return false;
    }
    public String reverseVowels(String s) {

        if(s.length() <= 1) return s;
        int i = 0;
        int j = s.length() - 1;
        char[] word = s.toCharArray();

        while(i < j){
            while(i < s.length() && !isVowel(word[i])) i++;
            while(j >= 0 && !isVowel(word[j])) j--;

            if(i<j){
                char temp = word[i];
                word[i] = word[j];
                word[j] = temp;
            }
            i++;
            j--;
        }

        return new String(word);
    }

    public static void main(String[] args) {
        String s = "leetcode";

        System.out.println((new Solution3()).reverseVowels(s));
    }
}
