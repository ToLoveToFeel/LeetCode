// Created by WXX on 2021/3/10 18:42
#include <iostream>
#include <vector>
#include <stack>

using namespace std;

/**
 * 执行用时：12 ms, 在所有 C++ 提交中击败了75.61%的用户
 * 内存消耗：10.3 MB, 在所有 C++ 提交中击败了16.03%的用户
 */
class Solution {
public:
    int n;  // 边数
    vector<bool> st1;  // 表示每条边是否在环中  (环)
    vector<bool> st2;  // 表示当前边是不是某个点的两条入边之一
    vector<bool> st;  // 找环的时候的判重数组  (环)
    vector<bool> in_stk;  // 找环过程中表示某个点是否在栈里  (环)
    vector<bool> in_cycle;  // 表示某个点是否在环里  (环)
    vector<vector<int>> g;  // 邻接矩阵
    stack<int> stk;  // 记录当前深搜经过的点  (环)

    bool dfs(int u) {
        st[u] = true;  // u已经被遍历过了
        stk.push(u), in_stk[u] = true;  // 将u加入栈中

        for (int x : g[u]) {
            if (!st[x]) {
                if (dfs(x)) return true;
            } else if (in_stk[x]) {  // 说明找到了环，找出环中所有的点
                while (stk.top() != x) {
                    in_cycle[stk.top()] = true;
                    stk.pop();
                }
                in_cycle[x] = true;  // x也在环里
                return true;
            }
        }

        stk.pop(), in_stk[u] = false;  // 将u弹出栈
        return false;  // 说明没有找到环
    }

    void work1(vector<vector<int>> &edges) {  // 找环中的边
        for (auto &e : edges) {  // 创建邻接矩阵
            int a = e[0], b = e[1];
            g[a].push_back(b);
        }
        for (int i = 1; i <= n; i++)
            if (!st[i] && dfs(i))
                break;  // 找到环

        for (int i = 0; i < n; i++) {
            int a = edges[i][0], b = edges[i][1];
            if (in_cycle[a] && in_cycle[b])  // 如果顶点a,b都在环内，则edges[i]在环内
                st1[i] = true;
        }
    }

    void work2(vector<vector<int>> &edges) {  // 找某个点对应的两条入边
        vector<int> p(n + 1, -1);
        for (int i = 0; i < n; i++) {
            int a = edges[i][0], b = edges[i][1];
            if (p[b] != -1) {
                // 表示第p[b]条边和第i条边指向同一个点b
                st2[p[b]] = st2[i] = true;
                break;
            } else {
                p[b] = i;  // 到点b的入边为第i条边
            }
        }
    }

    vector<int> findRedundantDirectedConnection(vector<vector<int>> &edges) {

        n = edges.size();
        // 一旦被赋值，比如st1[0]=true，地址就不相同了
        st1 = st2 = st = in_stk = in_cycle = vector<bool>(n + 1);
        g.resize(n + 1);
        work1(edges);  // 找环中的边
        work2(edges);  // 找某个点对应的两条入边

        for (int i = n - 1; i >= 0; i--)
            if (st1[i] && st2[i])
                return edges[i];
        for (int i = n - 1; i >= 0; i--)
            if (st1[i] || st2[i])
                return edges[i];
        return {};
    }
};

void OutputBasicArray1D(vector<int> nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    vector<vector<int>> edges = {{4, 2}, {2, 3}, {3, 4}, {1, 2}, {3, 5}, {1, 6}, {6, 7}};
    OutputBasicArray1D(Solution().findRedundantDirectedConnection(edges));

    return 0;
}
