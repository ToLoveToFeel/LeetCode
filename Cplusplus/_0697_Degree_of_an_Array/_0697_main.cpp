// Created by WXX on 2021/2/20 9:15
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

// 哈希表记录：(数值，(出现次数，第一次出现的位置，最后一次出现的位置))
/**
 * 执行用时：36 ms, 在所有 C++ 提交中击败了95.77%的用户
 * 内存消耗：25 MB, 在所有 C++ 提交中击败了59.63%的用户
 */
class Solution {
public:
    int findShortestSubArray(vector<int> &nums) {

        unordered_map<int, vector<int>> hash;
        for (int i = 0; i < nums.size(); i++) {
            if (!hash.count(nums[i])) hash[nums[i]] = {1, i, i};
            else hash[nums[i]][0]++, hash[nums[i]][2] = i;
        }

        int max = 0, res = 0;  // max记录出现次数最大的数据对应的次数
        for (auto &[k, v] : hash) {
            if (max < v[0]) max = v[0], res = v[2] - v[1] + 1;
            else if (max == v[0]) res = min(res, v[2] - v[1] + 1);
        }
        return res;
    }
};

int main() {

    vector<int> nums = {1, 2, 2, 3, 1};
    cout << Solution().findShortestSubArray(nums) << endl;  // 2

    return 0;
}
