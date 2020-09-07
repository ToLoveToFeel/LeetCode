package _0077_Combinations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {  // 剪枝
    // 时间复杂度：O(n^k)
    // 空间复杂度：O(k)
    private ArrayList<List<Integer>> res;

    // 求解C(n,k)，当前已经找到的组合存储在c中，需要从start开始搜索新的元素
    private void generateCombinations(int n, int k, int start, LinkedList<Integer> c){
        if (c.size() == k){
            res.add((LinkedList<Integer>)c.clone());
            return;
        }

        // 还有k-c.size()个空位，所以[i...n]中至少k-c.size()个元素
        // 所以 n-i+1 >= k-c.size()，所以 i <= n-(k-c.size())+1
        for (int i = start; i <= n - (k - c.size()) + 1; i++){
            c.addLast(i);
            generateCombinations(n, k, i+1, c);
            c.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if (n <= 0 || k <= 0 || k > n)
            return res;

        LinkedList<Integer> c = new LinkedList<>();
        generateCombinations(n, k, 1, c);

        return res;
    }

    private static void printList(List<Integer> list){
        for (Integer e:list)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        List<List<Integer>> res = (new Solution2()).combine(n, k);
        for (List<Integer> list : res)
            printList(list);
    }
}
