#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * 执行用时：56 ms, 在所有 C++ 提交中击败了90.60%的用户
 * 内存消耗：27 MB, 在所有 C++ 提交中击败了78.11%的用户
 */
class Solution {
public:
    int maximumProduct(vector<int> &nums) {

        sort(nums.begin(), nums.end());
        int n = nums.size();
        return max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);
    }
};

int main() {

    vector<int> nums = {1, 2, 3, 4};
    cout << Solution().maximumProduct(nums) << endl;

    return 0;
}