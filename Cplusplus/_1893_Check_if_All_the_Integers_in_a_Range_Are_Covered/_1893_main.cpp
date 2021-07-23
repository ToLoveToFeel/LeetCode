// Created by WXX on 2021/7/23 8:56
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：8.6 MB, 在所有 C++ 提交中击败了36.51%的用户
 */
class Solution {
public:
    bool isCovered(vector<vector<int>> &ranges, int left, int right) {
        vector<int> cnt(60);  // 差分数组
        for (auto &range : ranges) cnt[range[0]]++, cnt[range[1] + 1]--;
        for (int i = 1, sum = 0; i <= 50; i++) {
            sum += cnt[i];
            if (i >= left && i <= right && sum <= 0) return false;
        }
        return true;
    }
};

int main() {

    vector<vector<int>> ranges = {
            {1, 2},
            {3, 4},
            {5, 6},
    };
    cout << Solution().isCovered(ranges, 2, 5) << endl;  // true

    return 0;
}
