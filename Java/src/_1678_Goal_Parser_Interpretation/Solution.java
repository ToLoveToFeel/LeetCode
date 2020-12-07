package _1678_Goal_Parser_Interpretation;

/**
 * Date: 2020/12/7 10:08
 * Content:
 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.9 MB, 在所有 Java 提交中击败了100.00%的用户
 */
public class Solution {

    public String interpret(String command) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < command.length(); i++) {

            if (command.charAt(i) == 'G')
                sb.append('G');
            else if (command.substring(i, Math.min(command.length(), i + 4)).equals("(al)")) {
                sb.append("al");
                i += 3;
            } else {
                sb.append('o');
                i++;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String command = "(al)G(al)()()G";
        System.out.println((new Solution()).interpret(command));
    }
}
