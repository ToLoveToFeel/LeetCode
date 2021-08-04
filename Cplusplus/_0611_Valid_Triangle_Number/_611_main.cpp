// Created by ToLoveToFeel on 2021/8/4 10:07
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * 执行用时：80 ms, 在所有 C++ 提交中击败了95.97%的用户
 * 内存消耗：12.6 MB, 在所有 C++ 提交中击败了17.80%的用户
 */
class Solution {
public:
    int triangleNumber(vector<int> &nums) {
        sort(nums.begin(), nums.end());
        int res = 0;
        for (int i = 0; i < nums.size(); i++)
            for (int j = i - 1, k = 0; j >= 0 && k < j; j--) {
                while (k < j && nums[k] + nums[j] <= nums[i]) k++;
                res += j - k;
            }
        return res;
    }
};

int main() {

    vector<int> nums = {2, 2, 3, 4};
    cout << Solution().triangleNumber(nums) << endl;  // 3

    return 0;
}
