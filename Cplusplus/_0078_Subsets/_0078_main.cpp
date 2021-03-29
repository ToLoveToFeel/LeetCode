// Created by WXX on 2021/3/29 15:28
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了49.04%的用户
 * 内存消耗：6.9 MB, 在所有 C++ 提交中击败了83.30%的用户
 */
// 使用一个二进制数表示每个数据选择与否
class Solution {
public:
    vector<vector<int>> subsets(vector<int> &nums) {

        vector<vector<int>> res;
        int n = nums.size();
        for (int mask = 0; mask < (1 << n); mask++) {
            vector<int> p;
            for (int i = 0; i < n; i++)
                if (mask & (1 << i))
                    p.push_back(nums[i]);
            res.push_back(p);
        }
        return res;
    }
};

void OutputBasicArray2D(vector<vector<int>> nums) {

    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        if (i > 0 && i < nums.size()) cout << ' ';
        cout << "[";
        for (int j = 0; j < nums[i].size(); j++) {
            cout << nums[i][j];
            if (j != nums[i].size() - 1) cout << ", ";
        }
        cout << "]";
        if (i != nums.size() - 1) cout << ", " << endl;
    }
    cout << "]" << endl;
}

int main() {

    vector<int> nums = {1, 2, 3};
    OutputBasicArray2D(Solution().subsets(nums));

    return 0;
}
