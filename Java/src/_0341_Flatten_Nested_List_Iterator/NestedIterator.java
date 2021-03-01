package _0341_Flatten_Nested_List_Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by WXX on 2021/3/1 9:28
 * 执行用时：3 ms, 在所有 Java 提交中击败了91.14%的用户
 * 内存消耗：40.6 MB, 在所有 Java 提交中击败了88.31%的用户
 */
public class NestedIterator implements Iterator<Integer> {

    List<Integer> q = new ArrayList<>();
    int k = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        for (NestedInteger l : nestedList) dfs(l);
    }

    private void dfs(NestedInteger l) {
        if (l.isInteger()) q.add(l.getInteger());
        else {
            for (NestedInteger v : l.getList()) dfs(v);
        }
    }

    @Override
    public Integer next() {
        return q.get(k++);
    }

    @Override
    public boolean hasNext() {
        return k < q.size();
    }
}
