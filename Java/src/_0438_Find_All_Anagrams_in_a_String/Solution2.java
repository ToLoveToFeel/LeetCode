package _0438_Find_All_Anagrams_in_a_String;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    // 时间复杂度：O(len(p)+len(s))
    // 空间复杂度：O(1)
    public List<Integer> findAnagrams(String s, String p) {
        int[] map = new int[26];
        List<Integer> ans = new ArrayList<>();
        if(s.length() < p.length()) return ans;
        //initialize map
        for(int i = 0; i < p.length(); i++){
            map[p.charAt(i) - 'a']++;
            map[s.charAt(i) - 'a']--;
        }
        for(int i = 0, j = i + p.length();; i++,j++){
            Boolean isAna = true;
            for(int n : map){
                if(n != 0) {
                    isAna = false;
                    break;
                }
            }
            if(isAna) ans.add(i);
            if(j >= s.length()) break;
            map[s.charAt(i) - 'a']++;
            map[s.charAt(j) - 'a']--;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> res = (new Solution2()).findAnagrams(s, p);
        for (Integer element:res)
            System.out.println(element);
    }
}
