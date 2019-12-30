package _0804_Unique_Morse_Code_Words;
import java.util.TreeSet;

public class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        TreeSet<String> treeSet = new TreeSet<>();

        for (String word:words) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i=0; i<word.length(); i++){
                stringBuffer.append(codes[word.charAt(i)-'a']);
            }
            treeSet.add(stringBuffer.toString());
        }
        return treeSet.size();
    }

    public static void main(String[] args) {
        String [] words = {"gin", "zen", "gig", "msg"};
        System.out.println((new Solution()).uniqueMorseRepresentations(words));
    }
}
