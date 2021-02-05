package _0284_Peeking_Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Date: 2021/2/5 8:45
 * Content:
 * 执行用时：5 ms, 在所有 Java 提交中击败了98.52%的用户
 * 内存消耗：38.6 MB, 在所有 Java 提交中击败了29.55%的用户
 */
public class PeekingIterator implements Iterator<Integer> {

    private int cur;
    private boolean has_next;
    private Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> _iterator) {
        // initialize any member here.
        iterator = _iterator;
        has_next = iterator.hasNext();
        if (has_next) cur = iterator.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return cur;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int t = cur;
        has_next = iterator.hasNext();
        if (has_next) cur = iterator.next();
        return t;
    }

    @Override
    public boolean hasNext() {
        return has_next;
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> it = list.iterator();
        PeekingIterator t = new PeekingIterator(it);
        System.out.println(t.next());  // 1
        System.out.println(t.peek());  // 2
        System.out.println(t.next());  // 2
        System.out.println(t.next());  // 3
        System.out.println(t.hasNext());  // false
    }
}
