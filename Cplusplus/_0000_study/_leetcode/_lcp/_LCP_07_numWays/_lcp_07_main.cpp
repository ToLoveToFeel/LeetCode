// Created by WXX on 2021/7/1 10:29
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int numWays(int n, vector<vector<int>> &relation, int k) {
        vector<vector<int>> f(k + 1, vector<int>(n));
        f[0][0] = 1;  // 经过0轮到达0的方案数为1
        for (int i = 1; i <= k; i++)
            for (auto edge : relation)
                f[i][edge[1]] += f[i - 1][edge[0]];
        return f[k][n - 1];
    }
};

int main() {

    vector<vector<int>> relation = {{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
    cout << Solution().numWays(5, relation, 3);  // 3

    return 0;
}
