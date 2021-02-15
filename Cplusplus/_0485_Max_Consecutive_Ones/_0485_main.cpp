// Created by WXX on 2021/2/15 9:20
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：32 ms, 在所有 C++ 提交中击败了96.09%的用户
 * 内存消耗：32.6 MB, 在所有 C++ 提交中击败了83.38%的用户
 */
class Solution {
public:
    int findMaxConsecutiveOnes(vector<int> &nums) {
        int res = 0;
        for (int i = 0, cnt = 0; i < nums.size(); i++) {
            if (nums[i] == 1) cnt++;
            else cnt = 0;
            res = max(res, cnt);
        }
        return res;
    }
};

int main() {

    vector<int> nums = {1, 1, 0, 1, 1, 1};
    cout << Solution().findMaxConsecutiveOnes(nums) << endl;  // 3

    return 0;
}
