package _0058_Length_of_Last_Word;

public class Solution2 {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0)
            return 0;

        int size = s.length();
        int count = 0;
        while (size-1-count >= 0 && s.charAt(size-1-count) == ' ')
            count++;
        int blank = count;
        while (size-1-count >= 0 && s.charAt(size-1-count) != ' ')
            count++;

        return count - blank;
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).lengthOfLastWord(" Hello World "));
    }
}
