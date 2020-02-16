package _0017_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 时间复杂度：O(2^len(digits))
    // 空间复杂度：O(len(digits))
    private String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };
    private ArrayList<String> res;

    // s中保存了此时的digits[0...index-1]翻译得到的一个字母字符串
    // 寻找和digits[index]匹配的字母，获得digits[0...index]译得到的解
    private void findCombination(String digits, int index, String s){
        if (index == digits.length()){
            res.add(s);
            return;
        }

        Character c = digits.charAt(index);
        assert c.compareTo('0') >= 0 && c.compareTo('9') <= 0 && c.compareTo('1') != 0;

        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++)
            findCombination(digits, index + 1, s + letters.charAt(i));
    }

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();

        if (digits.equals(""))
            return res;

        findCombination(digits, 0, "");

        return res;
    }

    public static void main(String[] args) {
        List<String> list = (new Solution()).letterCombinations("234");
//        list = (new Trie()).letterCombinations("234");
        for (String s:list)
            System.out.println(s);
    }
}
