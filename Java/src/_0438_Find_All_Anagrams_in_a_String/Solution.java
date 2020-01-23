package _0438_Find_All_Anagrams_in_a_String;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 时间复杂度：O(len(p)+len(s))
    // 空间复杂度：O(1)
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res= new ArrayList<>();

        if (s.length() == 0 || p.length() > s.length())
            return res;

        int[] freq_p = new int[26];
        for (int i = 0; i < p.length(); i++)
            freq_p[p.charAt(i) - 'a']++;
        int[] freq_s = new int[26];

        int l = 0, r = -1;  // 滑动窗口[l...r]
        while (r+1 < s.length()){
            r ++;
            freq_s[s.charAt(r) - 'a']++;
            if (r - l + 1 > p.length())
                freq_s[s.charAt(l++) - 'a']--;

            if (r - l + 1 == p.length() && same(freq_p, freq_s))
                res.add(l);
        }
        return res;
    }

    private boolean same(int[] freq_p, int[] freq_s){
        for (int i = 0; i < 26; i++)
            if (freq_p[i] != freq_s[i])
                return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> res = (new Solution()).findAnagrams(s, p);
        for (Integer element:res)
            System.out.println(element);
    }
}
