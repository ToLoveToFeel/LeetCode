package _0000_study._common;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

/**
 * Date: 2020/12/30 15:24
 * Content:
 */
public class JavaSTL {

    // ArrayList
    @Test
    public void test01() {

        List<Integer> list = new ArrayList<>();
        list.size();  // 返回元素个数
        list.isEmpty();  // 返回是否为空
        list.clear();  // 清空
        for (int i = 1; i <= 10; i++) list.add(i);
        // 获取首尾元素
        list.get(0);
        list.get(list.size() - 1);
        // 删除首尾元素
        list.remove(0);
        list.remove(list.size() - 1);
    }

    // Pair
    @Test
    public void test02() {

        Pair<Integer, Integer> pair = new Pair<>(1, 1);
        pair.getKey();
        pair.getValue();
    }

    // String
    @Test
    public void test03() {

        String s = "Hello world";
        s.length();  // 返回s的长度
        s.isEmpty();  // 返回是否为空
        s.substring(1, 2);  // [起始下标，终止下标)
    }

    // Queue队列
    @Test
    public void test04() {

        Queue<Integer> q = new LinkedList<>();
        q.size();
        q.isEmpty();
        q.clear();
        q.add(1);  // 向队尾插入一个元素
        q.remove();  // 弹出队头元素
        q.peek();  // 返回队头元素
    }

    // PriorityQueue 优先队列，默认小根堆
    @Test
    public void test05() {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.size();
        pq.isEmpty();
        pq.clear();
        pq.add(1);  // 插入一个元素
        pq.remove();  // 删除堆顶元素
        pq.peek();  // 返回堆顶元素
        // 定义大顶堆的方式
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    // 栈
    @Test
    public void test06() {

        Deque<Integer> stack = new ArrayDeque<>();
        stack.size();
        stack.isEmpty();
        stack.clear();
        stack.push(1);  // 向栈顶插入一个元素
        stack.peek();  // 返回栈顶元素
        stack.pop();  // 删除栈顶元素
    }

    // 双端队列
    @Test
    public void test07() {

        Deque<Integer> deque = new ArrayDeque<>();
        deque.size();
        deque.isEmpty();
        deque.clear();
        // 向队尾插入和删除元素
        deque.addLast(1);
        deque.removeLast();
        // 向队首插入和删除元素
        deque.addFirst(4);
        deque.removeFirst();
        // 返回队首和队尾元素
        deque.peekFirst();
        deque.peekLast();
    }

    // 有序集合
    @Test
    public void test08() {

        TreeSet<Integer> set = new TreeSet<>();
        set.size();
        set.isEmpty();
        set.clear();
        set.contains(1);
        for (int i = 1; i <= 10; i++) set.add(i);
        set.remove(3);
        set.lower(4);  // 返回Set中小于e的最大元素
        set.floor(4);  // 返回Set中小于/等于e的最大元素

        set.higher(4);  // 返回Set中大于e的最小元素
        set.ceiling(4);  // 返回Set中大于/等于e的最小元素
    }

    // 无序集合
    @Test
    public void test09() {

        Set<Integer> set = new HashSet<>();
        set.size();
        set.isEmpty();
        set.clear();
        set.contains(1);
        set.add(1);
        set.remove(2);
    }

    // 有序Map
    @Test
    public void test10() {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.size();
        map.isEmpty();
        map.clear();
        map.containsKey(1);
        for (int i = 1; i <= 10; i++) map.put(i, i + 102);
        map.remove(3);
        map.lowerKey(4);  // 返回Map中小于e的最大键值对对应的键
        map.floorKey(4);  // 返回Map中小于/等于e的最大键值对对应的键

        map.higherKey(4);  // 返回Map中大于e的最小键值对对应的键
        map.ceilingKey(4);  // 返回Map中大于/等于e的最小键值对对应的键
    }

    // 无序Map
    @Test
    public void test11() {

        Map<Integer, Integer> map = new HashMap<>();
        map.size();
        map.isEmpty();
        map.clear();
        map.containsKey(1);
        map.put(2, 103);
        map.remove(1);
    }

    // Bitset
    // https://www.runoob.com/java/java-bitset-class.html
    @Test
    public void test12() {

        BitSet b = new BitSet(10000);  // 10000bit
        System.out.println(b.size());  // 返回此 BitSet 表示位值时实际使用空间的位数。
    }

}
