package _1078_Occurrences_After_Bigram;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/10/18 11:49
 * Content:
 */
public class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split("\\s+");
        List<String> res = new ArrayList<>();

        for (int i = 0; i < words.length - 2; i++) {
            if (words[i].equals(first)) {
                if (words[i+1].equals(second)) {
                    res.add(words[i+2]);
                }
            }
        }

        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String text = "we will we will rock you";
        String first = "we";
        String second = "will";

        String[] res = (new Solution()).findOcurrences(text, first, second);
        for (String word : res) {
            System.out.println(word);
        }
    }
}
