// Created by WXX on 2021/1/24 9:37
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：12 ms, 在所有 C++ 提交中击败了96.64%的用户
 * 内存消耗：10.6 MB, 在所有 C++ 提交中击败了98.16%的用户
 */
class Solution {
public:
    int findLengthOfLCIS(vector<int> &nums) {

        int res = 0;
        for (int i = 0, j = 0; i < nums.size(); i++) {
            j = i;
            while (j + 1 < nums.size() && nums[j] < nums[j + 1]) j++;
            res = max(res, j - i + 1);
            i = j;
        }
        return res;
    }
};

int main() {

//    vector<int> nums = {1, 3, 5, 4, 7};  // 3
    vector<int> nums = {2, 2, 2, 2, 2};  // 1
    cout << Solution().findLengthOfLCIS(nums) << endl;

    return 0;
}