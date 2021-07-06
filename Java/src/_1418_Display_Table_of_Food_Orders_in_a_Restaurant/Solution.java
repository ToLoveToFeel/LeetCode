package _1418_Display_Table_of_Food_Orders_in_a_Restaurant;

import _0000_study._common.Build;

import java.util.*;

/**
 * Date: 2021/7/6 14:51
 * 执行用时：64 ms, 在所有 Java 提交中击败了39.76%的用户
 * 内存消耗：63.3 MB, 在所有 Java 提交中击败了59.04%的用户
 */
public class Solution {

    public List<List<String>> displayTable(List<List<String>> orders) {

        TreeSet<String> foodList = new TreeSet<>();  // 用于记录表头
        TreeMap<Integer, HashMap<String, Integer>> tableList = new TreeMap<>();  // 餐桌对应的食物数量
        for (List<String> e : orders) {
            int id = Integer.parseInt(e.get(1));  // 餐桌编号
            String foodName = e.get(2);  // 食物名称

            foodList.add(foodName);

            if (!tableList.containsKey(id)) tableList.put(id, new HashMap<>());
            tableList.get(id).put(foodName, tableList.get(id).getOrDefault(foodName, 0) + 1);
        }

        List<List<String>> res = new ArrayList<>();
        // 处理表头
        List<String> title = new ArrayList<>();
        title.add("Table");
        title.addAll(foodList);

        res.add(title);
        for (Integer id : tableList.keySet()) {  // 得到餐桌的id
            List<String> t = new ArrayList<>();
            t.add(id + "");
            HashMap<String, Integer> foods = tableList.get(id);  // 得到餐桌上的食物及其数量
            for (String name : foodList) t.add(foods.getOrDefault(name, 0) + "");
            res.add(t);
        }

        return res;
    }

    public static void main(String[] args) {

        String[][] t = {
                {"David",  "3",  "Ceviche"},
                {"Corina", "10", "Beef Burrito"},
                {"David",  "3",  "Fried Chicken"},
                {"Carla",  "5",  "Water"},
                {"Carla",  "5",  "Ceviche"},
                {"Rous",   "3",  "Ceviche"},
        };
        List<List<String>> orders = Build.build(t);
        System.out.println((new Solution()).displayTable(orders));
    }
}
