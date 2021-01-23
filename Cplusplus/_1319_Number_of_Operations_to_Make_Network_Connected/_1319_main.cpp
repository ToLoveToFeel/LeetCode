// Created by WXX on 2021/1/23 9:10
#include <iostream>
#include <vector>

using namespace std;

const int N = 100010;

int p[N];

int find(int x) {
    if (p[x] != x) p[x] = find(p[x]);
    return p[x];
}

/**
 * 本质：求连通分量个数
 * 执行用时：104 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：36.3 MB, 在所有 C++ 提交中击败了99.84%的用户
 */
class Solution {
public:
    int makeConnected(int n, vector<vector<int>>& connections) {

        for (int i = 0; i < n; i++) p[i] = i;  // 初始化并查集
        int m = connections.size();
        if (m < n - 1) return -1;

        int cnt = n;  // 记录连通分量的个数
        for (int i = 0; i < m; i++) {
            int a = connections[i][0], b = connections[i][1];
            a = find(a), b = find(b);
            if (a != b) {
                p[a] = b;
                cnt--;
            }
        }
        return cnt == 1 ? 0 : cnt - 1;
    }
};

int main() {

//    // 1
//    int n = 4;
//    vector<vector<int>> connections = {{0, 1}, {0, 2}, {1, 2}};
//    cout << Solution().makeConnected(n, connections) << endl;

    // 2
    int n = 6;
    vector<vector<int>> connections = {{0, 1}, {0, 2}, {0, 3},{1, 2},  {1, 3}};
    cout << Solution().makeConnected(n, connections) << endl;

    return 0;
}