// Created by ToLoveToFeel on 2021/8/14 09:40
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

/**
 * 执行用时：156 ms, 在所有 C++ 提交中击败了26.67%的用户
 * 内存消耗：44 MB, 在所有 C++ 提交中击败了21.67%的用户
 */
class Solution {
public:
    int unhappyFriends(int n, vector<vector<int>>& preferences, vector<vector<int>>& pairs) {
        vector<unordered_map<int, int>> pos(n);
        for (int i = 0;  i < n; i++) {
            auto &p = preferences[i];
            for (int j = 0; j < p.size(); j++) pos[i][p[j]] = j;
        }

        vector<bool> st(n, false);
        for (int i = 0; i < n / 2; i++)
            for (int j = 0; j < n / 2; j++)
                if (i != j) {
                    int x = pairs[i][0], y = pairs[i][1];
                    int u = pairs[j][0], v = pairs[j][1];
                    if (pos[x][u] < pos[x][y] && pos[u][x] < pos[u][v] || pos[x][v] < pos[x][y] && pos[v][x] < pos[v][u]) st[x] = true;
                    if (pos[y][u] < pos[y][x] && pos[u][y] < pos[u][v] || pos[y][v] < pos[y][x] && pos[v][y] < pos[v][u]) st[y] = true;
                }

        int res = 0;
        for (int i = 0; i < n; i++) res += st[i];

        return res;
    }
};

int main() {


    return 0;
}
