package _1598_Crawler_Log_Folder;

/**
 * Date: 2020/10/3 10:44
 * Content:
 */
public class Solution {
    private static final String parentFolder = "../";
    private static final String currentFolder = "./";

    public int minOperations(String[] logs) {
        int res = 0;
        for (String log : logs) {
            if (log.equals(currentFolder))
                continue;
            if (log.equals(parentFolder) && res > 0)
                res--;
            else if (!log.equals(parentFolder))
                res++;
        }

        return res;
    }

    public static void main(String[] args) {
//        String[] logs = {"d1/", "d2/", "../", "d21/", "./"};  // 2
//        String[] logs = {"d1/", "d2/", "./", "d3/", "../", "d31/"};  // 3
//        String[] logs = {"d1/", "../", "../", "../"};  // 0
        String[] logs = {"./", "../", "./"};  // 0
        System.out.println((new Solution()).minOperations(logs));
    }
}
