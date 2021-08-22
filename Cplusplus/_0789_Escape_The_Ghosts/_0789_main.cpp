// Created by ToLoveToFeel on 2021/8/22 10:01
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了99.07%的用户
 * 内存消耗：10.2 MB, 在所有 C++ 提交中击败了37.04%的用户
 */
class Solution {
public:
    int get_dist(int x1, int y1, int x2, int y2) {
        return abs(x1 - x2) + abs(y1 - y2);
    }

    bool escapeGhosts(vector<vector<int>> &ghosts, vector<int> &target) {
        for (auto g : ghosts)
            if (get_dist(g[0], g[1], target[0], target[1]) <= get_dist(0, 0, target[0], target[1]))
                return false;
        return true;
    }
};

int main() {

    vector<vector<int>> ghosts = {
            {1, 0},
            {0, 3},
    };
    vector<int> target{0, 0};
    cout << Solution().escapeGhosts(ghosts, target) << endl;  // true

    return 0;
}
