package _0649_Dota2_Senate;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 2020/12/11 10:07
 * Content:
 * 执行用时：12 ms, 在所有 Java 提交中击败了47.29%的用户
 * 内存消耗：39.1 MB, 在所有 Java 提交中击败了49.61%的用户
 */
public class Solution {

    public String predictPartyVictory(String senate) {

        int n = senate.length();
        if (n == 1)
            return senate.equals("R") ? "Radiant" : "Dire";

        // 第一步：将两组议员分别存入队列，队列中存储的是有权利的议员
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R')
                radiant.add(i);
            else
                dire.add(i);
        }

        // 第二步：根据前后顺序，禁止对方行使权力
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            // 双方出队队首
            int rIndex = radiant.remove();
            int dIndex = dire.remove();

            if (rIndex < dIndex)
                radiant.add(rIndex + n);  // 重新入队，加n表示该议员会参与下一轮的投票
            else
                dire.add(dIndex + n);
        }

        return !radiant.isEmpty() ? "Radiant" : "Dire";
    }

    public static void main(String[] args) {

//        String senate = "R";  // Radiant
//        String senate = "RD";  // Radiant
        String senate = "RDD";  // Dire
//        String senate = "DRDRR";  // Dire
//        String senate = "DRRDRDRDRDDRDRDR";  // Radiant
        System.out.println((new Solution()).predictPartyVictory(senate));
    }
}

/*
如下方式是错误的！！！
应该去禁止下一个最早需要投票的对方议员
public class Solution {

    public String predictPartyVictory(String senate) {

        int n = senate.length();
        if (n == 1)
            return senate.equals("R") ? "Radiant" : "Dire";

        char[] senateArray = senate.toCharArray();
        // 存储当前议员是否还有权利
        boolean[] right = new boolean[n];
        Arrays.fill(right, true);

        // 第一步：存储两院中有权利投票的人员所在的位置
        Map<Character, LinkedList<Integer>> map = new HashMap<>();
        map.put('R', new LinkedList<>());
        map.put('D', new LinkedList<>());

        for (int i = 0; i < n; i++) {
            if (senateArray[i] == 'R') {
                map.get('R').add(i);
            } else {
                map.get('D').add(i);
            }
        }

        // 第二步：循环决策，R去禁止D，D去禁止R
        while ((map.get('R').size() != 0) && (map.get('D').size() != 0)) {

            for (int i = 0; i < n; i++) {

                if (right[i]) {
                    if (senateArray[i] == 'R') {  // R做决策
                        LinkedList<Integer> list = map.get('D');
                        if (list.size() > 1) {  // 如果 list.size() == 1，这次禁止之后，下次 R 就赢了
                            int index = list.getFirst();  // 获取去最前面有权利的人员
                            right[index] = false;  // 禁止其权利
                            list.removeFirst();  // 删除已经被禁止权利的人员
                        } else {
                            return "Radiant";  // 说明 D 都没有权利
                        }
                    } else {  // D做决策
                        LinkedList<Integer> list = map.get('R');
                        if (list.size() > 1) {  // 如果 list.size() == 1，这次禁止之后，下次 D 就赢了
                            int index = list.getFirst();  // 获取去最前面有权利的人员
                            right[index] = false;  // 禁止其权利
                            list.removeFirst();  // 删除已经被禁止权利的人员
                        } else {
                            return "Dire";  // 说明 R 都没有权利
                        }
                    }
                }
            }
        }

        return map.get('R').size() != 0 ? "Radiant" : "Dire";
    }

    public static void main(String[] args) {

//        String senate = "R";  // Radiant
//        String senate = "RD";  // Radiant
//        String senate = "RDD";  // Dire
//        String senate = "DRDRR";  // Dire
        String senate = "DRRDRDRDRDDRDRDR";  // Radiant
        System.out.println((new Solution()).predictPartyVictory(senate));
    }
}
 */