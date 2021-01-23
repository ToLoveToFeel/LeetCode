package _0071_Simplify_Path;

import java.util.Stack;

/**
 * 1、将原始路径按照"/" split划分，然后将每个元素依次放入栈中，如果当前元素是 "..",则对栈执行pop操作；
 * 2、将栈中的元素按照规范的格式进行输出
 * 执行用时：9 ms, 在所有 Java 提交中击败了28.29%的用户
 * 内存消耗：38.4 MB, 在所有 Java 提交中击败了78.96%的用户
 */
public class Solution {

    public String simplifyPath(String path) {

        Stack<String> stk = new Stack<>();

        String[] pathList = path.split("/");
        for (String e : pathList) {
            if (!(e.equals(".") || e.equals("..") || e.equals(""))) stk.push(e);
            else if (e.equals("..") && !stk.isEmpty()) stk.pop();
        }

        return ("/" + String.join("/", stk));
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).simplifyPath("/home/////foo/"));
        System.out.println((new Solution()).simplifyPath("/a/./b/../../c/"));
    }
}
