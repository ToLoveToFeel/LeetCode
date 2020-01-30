package _0752_Open_the_Lock;

import java.util.*;

public class Solution {
    public int openLock(String[] deadends, String target) {

        // 将deadends放入deadset中，方便在O(1)的时间查找
        HashSet<String> deadset = new HashSet<>();
        for (String s : deadends)
            deadset.add(s);

        if (deadset.contains(target))
            return -1;
        if (deadset.contains("0000"))
            return -1;
        if (target.equals("0000"))
            return 0;

        // BFS
        Queue<String> queue = new LinkedList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();  // 记录到达 String 需要的步骤，不存在在hashMap里代表没访问到
        queue.add("0000");
        hashMap.put("0000", 0);

        while (!queue.isEmpty()){
            String curString = queue.remove();
            char[] curArray = curString.toCharArray();

            // 模拟拨动密码，一共8中情况
            ArrayList<String> nexts = new ArrayList<>();
            for (int i = 0; i < 4; i++){
                char c = curArray[i];
                // 加一
                curArray[i] = Character.forDigit((curArray[i] - '0' + 1) % 10, 10);
                nexts.add(new String(curArray));
                curArray[i] = c;
                // 减一
                curArray[i] = Character.forDigit((curArray[i] - '0' + 9) % 10, 10);
                nexts.add(new String(curArray));
                curArray[i] = c;
            }

            for (String s : nexts)
                if (!deadset.contains(s) && !hashMap.containsKey(s)){
                    queue.add(s);
                    hashMap.put(s, hashMap.get(curString) + 1);
                    if (s.equals(target))
                        return hashMap.get(s);
                }
        }

        return -1;
    }

    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";

        System.out.println((new Solution()).openLock(deadends, target));
    }
}
