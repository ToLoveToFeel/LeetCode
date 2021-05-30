// Created by WXX on 2021/5/30 14:32
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

/**
 * 执行用时：152 ms, 在所有 C++ 提交中击败了17.26%的用户
 * 内存消耗：50.6 MB, 在所有 C++ 提交中击败了12.60%的用户
 */
class Solution {
public:

    unordered_map<int, vector<int>> hash;

    Solution(vector<int>& nums) {
        for (int i = 0; i < nums.size(); i++)
            hash[nums[i]].push_back(i);
    }

    int pick(int target) {
        return hash[target][rand() % hash[target].size()];
    }
};

int main() {

    vector<int> nums = {1, 2, 3, 3, 3};
    cout << Solution(nums).pick(3) << endl;
    cout << Solution(nums).pick(3) << endl;
    cout << Solution(nums).pick(3) << endl;

    return 0;
}
