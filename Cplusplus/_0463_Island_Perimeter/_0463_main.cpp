// Created by WXX on 2021/3/15 21:57
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：164 ms, 在所有 C++ 提交中击败了44.11%的用户
 * 内存消耗：93.7 MB, 在所有 C++ 提交中击败了59.12%的用户
 */
class Solution {
public:
    int islandPerimeter(vector<vector<int>> &grid) {
        int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};
        int res = 0;
        for (int i = 0; i < grid.size(); i++)
            for (int j = 0; j < grid[i].size(); j++)
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k], y = j + dy[k];
                        if (x < 0 || x >= grid.size() || y < 0 || y >= grid[0].size()) res++;
                        else if (grid[x][y] == 0) res++;
                    }
                }
        return res;
    }
};

int main() {

    vector<vector<int>> grid = {
            {0, 1, 0, 0},
            {1, 1, 1, 0},
            {0, 1, 0, 0},
            {1, 1, 0, 0}
    };
    cout << Solution().islandPerimeter(grid) << endl;

    return 0;
}
