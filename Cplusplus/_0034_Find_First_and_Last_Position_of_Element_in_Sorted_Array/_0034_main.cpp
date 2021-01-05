#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：28 ms, 在所有 C++ 提交中击败了13.47%的用户
 * 内存消耗：13.7 MB, 在所有 C++ 提交中击败了49.80%的用户
 */
class Solution {
public:
    vector<int> searchRange(vector<int> &nums, int target) {

        if (nums.empty()) return {-1, -1};

        // 二分出左端点
        int l = 0, r = nums.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }

        if (nums[r] != target) return {-1, -1};

        // 二分出右端点
        int L = l;
        l = 0, r = nums.size() - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) l = mid;
            else r = mid - 1;
        }

        return {L, r};
    }
};

void OutputBasicArray1D(vector<int> &nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    vector<int> nums = {5, 7, 7, 8, 8, 10};
    vector<int> res = Solution().searchRange(nums, 8);
    OutputBasicArray1D(res);

    return 0;
}
