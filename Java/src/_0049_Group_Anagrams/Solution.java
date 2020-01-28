package _0049_Group_Anagrams;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Time Limit Exceeded
    // 时间复杂度：O(n^2 * len(s))，s是strs中字符串最大的长度
    // 空间复杂度：O(n)
    int[] letters1 = new int[26];
    int[] letters2 = new int[26];
    boolean[] isAdd;
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        if (strs.length == 0)
            return res;

        // 初始化
        initLetters(letters1);
        initLetters(letters2);
        isAdd = new boolean[strs.length];
        for (int i = 0; i < isAdd.length; i++)
            isAdd[i] = false;

        for (int i = 0; i < strs.length; i++)
            if (!isAdd[i]){
                isAdd[i] = true;
                // 字符次数统计数组初始化
                initLetters(letters1);
                // 将字符串strs[i]字符次数统计写入letters1中
                countLetters(strs[i] ,letters1);
                ArrayList<String> temp = new ArrayList<>();
                temp.add(strs[i]);

                for (int j = i + 1; j < strs.length; j++){
                    if (!isAdd[j]){
                        initLetters(letters2);
                        countLetters(strs[j], letters2);
                        if (isLetterSame(letters1, letters2)) {
                            isAdd[j] = true;
                            temp.add(strs[j]);
                        }
                    }
                }
                res.add(temp);
            }
        return res;
    }

    // 字符次数统计数组初始化
    private void initLetters(int[] nums){
        for (int i = 0; i < nums.length; i++)
            nums[i] = 0;
    }

    // 将s中的各个字符统计到数组nums中
    private void countLetters(String s, int[] nums){
        for (int i = 0; i < s.length(); i++)
            nums[s.charAt(i) - 'a']++;
    }

    private boolean isLetterSame(int[] nums1, int[] nums2){
        for (int i = 0; i < nums1.length; i++)
            if (nums1[i] != nums2[i])
                return false;
        return true;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = (new Solution()).groupAnagrams(strs);

        for (int i = 0; i < res.size(); i++){
            System.out.print("[");
            int count = 0;
            for (int j = 0; j < res.get(i).size(); j++){
                count ++;
                System.out.print(res.get(i).get(j));
                if (count != res.get(i).size())
                    System.out.print(", ");
            }
            System.out.println("]");
        }
    }
}
