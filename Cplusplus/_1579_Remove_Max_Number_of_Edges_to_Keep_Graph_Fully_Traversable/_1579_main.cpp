// Created by WXX on 2021/1/27 9:43
#include <iostream>
#include <vector>

using namespace std;

// 优先保留第三种类型的边，可以让删除的边最多
/**
 * 执行用时：820 ms, 在所有 C++ 提交中击败了75.00%的用户
 * 内存消耗：165.8 MB, 在所有 C++ 提交中击败了13.63%的用户
 */
class Solution {
public:
    int maxNumEdgesToRemove(int n, vector<vector<int>> &edges) {

        int p1[n + 1], p2[n + 1];  // 创建两个并查集，p1对应Alice，p2对应Bob
        for (int i = 1; i <= n; i++) p1[i] = i, p2[i] = i;  // 初始化并查集

        int res = 0;
        int cnt1 = n, cnt2 = n;  // 代表Alice和Bob连通分量的个数
        // 考虑第三种类型的边
        for (auto e : edges) {
            if (e[0] == 3) {
                merge(p1, e[1], e[2]);
                if (merge(p2, e[1], e[2])) cnt1--, cnt2--;
                else res++;
            }
        }

        // 考虑第一、二种类型的边
        for (auto e : edges) {
            if (e[0] == 1) {
                if (merge(p1, e[1], e[2])) cnt1--;
                else res++;
            } else if (e[0] == 2) {
                if (merge(p2, e[1], e[2])) cnt2--;
                else res++;
            }
        }

        if (cnt1 != 1 || cnt2 != 1) return -1;  // 说明Alice或者Bob不连通
        return res;
    }

    int find(int p[], int x) {
        if (p[x] != x) p[x] = find(p, p[x]);
        return p[x];
    }

    bool merge(int p[], int a, int b) {
        a = find(p, a), b = find(p, b);
        if (a != b) {
            p[a] = b;
            return true;
        }
        return false;
    }
};

int main() {

    int n = 4;
    vector<vector<int>> edges = {{3, 1, 2}, {3, 2, 3}, {1, 1, 3}, {1, 2, 4}, {1, 1, 2}, {2, 3, 4}};
    cout << Solution().maxNumEdgesToRemove(n, edges) << endl;  // 2

    return 0;
}
