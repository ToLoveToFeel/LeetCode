package _0804_Unique_Morse_Code_Words;
import java.util.HashSet;

public class Solution2 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> hashSet = new HashSet<>();

        for (String word:words) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i=0; i<word.length(); i++){
                stringBuffer.append(codes[word.charAt(i)-'a']);
            }
            hashSet.add(stringBuffer.toString());
        }
        return hashSet.size();
    }

    public static void main(String[] args) {
        String [] words = {"gin", "zen", "gig", "msg"};
        System.out.println((new Solution2()).uniqueMorseRepresentations(words));
    }
}
