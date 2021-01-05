#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：16 ms, 在所有 C++ 提交中击败了8.90%的用户
 * 内存消耗：10 MB, 在所有 C++ 提交中击败了12.11%的用户
 */
class Solution {
public:
    int searchInsert(vector<int> &nums, int target) {

        int l = 0, r = nums.size();
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }

        return l;
    }
};

int main() {

    vector<int> nums = {1, 3, 5, 6};
    cout << Solution().searchInsert(nums, 5) << endl;  // 2
    cout << Solution().searchInsert(nums, 2) << endl;  // 1

    return 0;
}
