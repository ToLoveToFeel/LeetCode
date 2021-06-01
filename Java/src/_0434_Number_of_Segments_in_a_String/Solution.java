package _0434_Number_of_Segments_in_a_String;

/**
 * Date: 2021/6/1 20:15
 */
public class Solution {

    public int countSegments(String s) {
        if (s.trim().length() == 0) return 0;
        return s.trim().split("\\s+").length;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).countSegments(""));  // 0
        System.out.println((new Solution()).countSegments("Hello, my name is John"));  // 5
    }
}
