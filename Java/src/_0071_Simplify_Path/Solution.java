package _0071_Simplify_Path;


import java.util.Stack;

public class Solution {
    /*
        1、将原始路径按照"/" split划分，然后将每个元素依次放入栈中，如果当前元素是 "..",则对栈执行pop操作；
        2、将栈中的元素按照规范的格式进行输出
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] pathList = trimBothEndsChars(path, "/").split("/");
        for (String item : pathList){
            if (!(item.equals(".") || item.equals("..") || item.equals("")))
                stack.push(item);
            else if (item.equals("..") && !stack.isEmpty())
                stack.pop();
        }

        return ("/" + String.join("/", stack));
    }

    private static String trimBothEndsChars(String srcStr, String splitter) {
        String regex = "^" + splitter + "*|" + splitter + "*$";  // 前后均匹配
//        String regex = splitter + "*$";  // 只匹配后面
        return srcStr.replaceAll(regex, "");
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).simplifyPath("/home/////foo/"));
    }
}
