package _0557_Reverse_Words_in_a_String_III;

class Solution {
    public String reverseWords(String s) {
        // 字符串按空格分割，保存到数组中
        String[] arr = s.split(" ");
        // 对数组进行遍历，然后每个元素进行翻转
        for (int i = 0; i < arr.length; i++)
            arr[i] = new StringBuilder(arr[i]).reverse().toString();
        return String.join(" ", arr);
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println((new Solution()).reverseWords(s));
    }
}
