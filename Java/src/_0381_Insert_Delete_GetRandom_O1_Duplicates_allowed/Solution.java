package _0381_Insert_Delete_GetRandom_O1_Duplicates_allowed;

import java.util.*;

/**
 * Date: 2020/10/31 15:40
 * Content:
 */
public class Solution {

    public static void main(String[] args) {
//        RandomizedCollection rc = new RandomizedCollection();
//        rc.insert(1);
//        rc.insert(1);
//        rc.insert(2);
//        System.out.println(rc.getRandom());
//        rc.remove(1);
//        System.out.println(rc.getRandom());
//        RandomizedCollection rc = new RandomizedCollection();
//        rc.insert(4);
//        rc.insert(3);
//        rc.insert(4);
//        rc.insert(2);
//        rc.insert(4);
//        System.out.println(rc.remove(4));
//        System.out.println(rc.remove(3));
//        System.out.println(rc.remove(4));
//        System.out.println(rc.remove(4));
        RandomizedCollection rc = new RandomizedCollection();
        rc.insert(0);
        rc.remove(0);
        rc.insert(-1);
        rc.remove(0);
        System.out.println(rc.getRandom());
    }
}

class RandomizedCollection {

    private final Map<Integer, Set<Integer>> map;  // (数字, (该数字出现在list中的索引集合))
    private final List<Integer> list;
    private final Random random;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        Set<Integer> set = map.get(val);
        if (set == null)
            set = new HashSet<>();
        set.add(list.size());  // 添加索引
        list.add(val);  // 添加数据
        map.put(val, set);  // 更新map
        return set.size() == 1;
    }

    private void swap(List<Integer> list, int index1, int index2) {
        int temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))  // 不包含该数据
            return false;
        // 此时应该删除，将val和list中最后一个数据交换位置，同时更新map
        int indexLast = list.size() - 1;  // 最后一个数据对应的索引
        Set<Integer> setLast = map.get(list.get(indexLast));  // 获取最后一个数据对应的索引集合

        Set<Integer> setCur = map.get(val);  // 获取当前待删除元素对应索引集合
        int indexCur = setCur.iterator().next();  // 随机获取一个索引

        swap(list, indexLast, indexCur);

        setCur.remove(indexCur);  // 更新setCur, 必须先更新setCur, 因为setCur和setLast可能是同一个

        // 更新map, 之后必须先更新map,例如insert(0),remove(0), 因为setCur和setLast可能是同一个，会导致无法删除该set
        if (setCur.size() == 0)
            map.remove(val);

        setLast.remove(indexLast);  // 最后更新setLast
        setLast.add(indexCur);

        list.remove(indexLast);

        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

