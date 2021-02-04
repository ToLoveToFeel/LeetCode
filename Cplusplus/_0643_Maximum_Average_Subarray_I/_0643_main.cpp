// Created by WXX on 2021/2/4 8:41
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：144 ms, 在所有 C++ 提交中击败了88.18%的用户
 * 内存消耗：69.8 MB, 在所有 C++ 提交中击败了95.10%的用户
 */
class Solution {
public:
    double findMaxAverage(vector<int> &nums, int k) {

        double res = -1e9;
        for (int i = 0, j = 0, sum = 0; i < nums.size(); i++) {
            sum += nums[i];
            if (i - j + 1 > k) sum -= nums[j++];
            if (i >= k - 1) res = max(res, 1.0 * sum / k);
        }
        return res;
    }
};

int main() {

    vector<int> nums = {1, 12, -5, -6, 50, 3};
    cout << Solution().findMaxAverage(nums, 4) << endl;  // 12.75

    return 0;
}
