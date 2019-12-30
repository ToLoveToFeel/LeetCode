package _0387_First_Unique_Character_in_a_String;

class Solution {
    public int firstUniqChar(String s) {
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (1 == nums[s.charAt(i) - 'a'])
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).firstUniqChar("loveleetcode"));
    }
}