// Created by WXX on 2021/5/3 18:16
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

/**
 * 执行用时：52 ms, 在所有 C++ 提交中击败了73.43%的用户
 * 内存消耗：21.1 MB, 在所有 C++ 提交中击败了51.73%的用户
 */
class Solution {
public:
    int leastBricks(vector<vector<int>>& wall) {
        unordered_map<int, int> hash;
        for (auto &line : wall) {
            for (int i = 0, s = 0; i < line.size() - 1; i++) {
                s += line[i];
                hash[s]++;
            }
        }

        int res = 0;
        for (auto [k, v] : hash) res = max(res, v);
        return wall.size() - res;
    }
};

int main() {

    vector<vector<int>> wall = {
            {1, 2, 2, 1},
            {3, 1, 2},
            {1, 3, 2},
            {2, 4},
            {3, 1, 2},
            {1, 3, 1, 1},
    };
    cout << Solution().leastBricks(wall) << endl;  // 2


    return 0;
}
