package _0752_Open_the_Lock;

import java.util.*;

/**
 * 执行用时：122 ms, 在所有 Java 提交中击败了35.05%的用户
 * 内存消耗：43.8 MB, 在所有 Java 提交中击败了69.46%的用户
 */
public class Solution {

    public int openLock(String[] deadends, String target) {

        // 将deadends放入deadset中，方便在O(1)的时间查找
        HashSet<String> deadset = new HashSet<>();
        Collections.addAll(deadset, deadends);

        if (deadset.contains("0000")) return -1;
        if (target.equals("0000")) return 0;

        // BFS
        Queue<String> q = new LinkedList<>();
        HashMap<String, Integer> dist = new HashMap<>();  // 记录到达 String 需要的步数，不存在在hashMap里代表没访问到
        q.add("0000");
        dist.put("0000", 0);

        while (!q.isEmpty()){
            String cur = q.remove();
            char[] curArray = cur.toCharArray();

            // 模拟拨动密码，一共8中情况
            ArrayList<String> nexts = new ArrayList<>();
            for (int i = 0; i < 4; i++){
                char c = curArray[i];
                // 加一
                curArray[i] = (char) ((c - '0' + 1) % 10 + '0');
                nexts.add(new String(curArray));
                // 减一
                curArray[i] = (char) ((c - '0' + 9) % 10 + '0');
                nexts.add(new String(curArray));
                curArray[i] = c;
            }

            for (String s : nexts)
                if (!deadset.contains(s) && !dist.containsKey(s)){
                    q.add(s);
                    dist.put(s, dist.get(cur) + 1);
                    if (s.equals(target)) return dist.get(s);
                }
        }

        return -1;
    }

    public static void main(String[] args) {

        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println((new Solution()).openLock(deadends, target));  // 6
    }
}
