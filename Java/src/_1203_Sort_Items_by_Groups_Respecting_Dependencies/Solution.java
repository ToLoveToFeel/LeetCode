package _1203_Sort_Items_by_Groups_Respecting_Dependencies;

import _0000_study._common.Output;

import java.util.*;

/**
 * Date: 2021/1/12 16:44
 * Content: 拓扑排序
 * 分为组间拓扑排序 和 组内拓扑排序，先组间后组内
 * https://leetcode-cn.com/problems/sort-items-by-groups-respecting-dependencies/solution/chao-xiang-xi-shuang-ceng-tuo-bu-pai-xu-5cyuc/
 * 执行用时：48 ms, 在所有 Java 提交中击败了46.58%的用户
 * 内存消耗：58.7 MB, 在所有 Java 提交中击败了52.17%的用户
 */
public class Solution {

    // deg : 入度， items : 图中的点， g : 图
    private List<Integer> topoSort(int[] deg, List<Integer> items, List<List<Integer>> g) {

        Queue<Integer> q = new LinkedList<>();
        for (Integer id : items) {
            if (deg[id] == 0)
                q.add(id);
        }

        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.remove();
            res.add(u);
            for (int v : g.get(u))
                if (--deg[v] == 0)
                    q.add(v);
        }

        // 如果所有点都入队了，说明存在拓扑序列；否则不存在拓扑序列。
        return res.size() == items.size() ? res : new ArrayList<>();
    }

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {

        List<List<Integer>> groupItem = new ArrayList<>();  // 项目分组
        for (int i = 0; i < n + m; i++) groupItem.add(new ArrayList<>());  // 初始化小组

        int t = m;  // 新的组号从m开始，不会和原来的组号(0~m-1)冲突
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) group[i] = t++;  // 说明项目i 单独一组
            groupItem.get(group[i]).add(i);  // 同一组的放在一起
        }

        List<List<Integer>> in = new ArrayList<>();  // 组内拓扑关系
        List<List<Integer>> out = new ArrayList<>();  // 组间拓扑关系
        for (int i = 0; i < n; i++) in.add(new ArrayList<>());  // 组内项目编号(0~n-1)
        for (int i = 0; i < n + m; i++) out.add(new ArrayList<>());  // 组间编号最大到 n+m-1

        // 拓扑排序需要的入度
        int[] degIn = new int[n];  // 组内入度
        int[] degOut = new int[n + m];  // 组间入度

        // 建图、求入度
        for (int to = 0; to < beforeItems.size(); to++) {
            List<Integer> before = beforeItems.get(to);  // 项目to所依赖的项目
            int toId = group[to];  // 当前项目to所属的组id
            for (Integer from : before) {
                if (group[from] == toId) {  // 同一组内拓扑排序
                    degIn[to]++;
                    in.get(from).add(to);  // 组内建图，添加边(from, to)
                } else {
                    degOut[toId]++;
                    out.get(group[from]).add(toId);  // 组间建图，添加边(group[from], toId)
                }
            }
        }

        List<Integer> groupId = new ArrayList<>();  // 所有组id，可能组内没有顶点
        for (int i = 0; i < n + m; i++) groupId.add(i);
        List<Integer> outSort = topoSort(degOut, groupId, out);
        if (outSort.size() == 0) return new int[0];  // 组间无法拓扑排序

        int[] res = new int[n];
        int index = 0;
        for (Integer gid : outSort) {  // 遍历排序后的所有小组id
            List<Integer> items = groupItem.get(gid);  // 根据小组id 拿到这一小组中的所有成员
            if (items.size() == 0) continue;  // 说明这组里面没有节点
            List<Integer> inSort = topoSort(degIn, items, in);
            if (inSort.size() == 0) return new int[0];  // 组间无法拓扑排序
            for (Integer i : inSort) res[index++] = i;
        }

        return res;
    }

    private static List<List<Integer>> build(int[][] source) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < source.length; i++) {
            List<Integer> e = new ArrayList<>();
            for (int j = 0; j < source[i].length; j++) e.add(source[i][j]);
            res.add(e);
        }
        return res;
    }

    public static void main(String[] args) {

        int n = 8, m = 2;
        int[] group = {-1, -1, 1, 0, 0, 1, 0, -1};
        int[][] source = {{}, {6}, {5}, {6}, {3, 6}, {}, {}, {}};
        List<List<Integer>> beforeItems = build(source);

        int[] res = (new Solution()).sortItems(n, m, group, beforeItems);
        Output.OutputBasicArray1D(res);
    }
}
