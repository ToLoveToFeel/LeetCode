package _0058_Length_of_Last_Word;

public class Solution {
    public int lengthOfLastWord(String s) {
        s = trimBothEndsChars(s, " ");
        if (s.length() == 0)
            return 0;

        int size = s.length();
        int count = 0;
        while (size-1-count >= 0 && s.charAt(size-1-count) != ' ')
            count++;
        return count;
    }

    private static String trimBothEndsChars(String srcStr, String splitter) {
//        String regex = "^" + splitter + "*|" + splitter + "*$";  // 前后均匹配
        String regex = splitter + "*$";  // 只匹配后面
        return srcStr.replaceAll(regex, "");
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).lengthOfLastWord(" Hello World "));
    }
}
