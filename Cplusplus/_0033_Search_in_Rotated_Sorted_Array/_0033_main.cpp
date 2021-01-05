#include <iostream>
#include <vector>

using namespace std;

/**
 * 思路：两次二分：第一次二分出分界点，第二次在有序区间中二分出结果
 * 执行用时：8 ms, 在所有 C++ 提交中击败了63.93%的用户
 * 内存消耗：11.3 MB, 在所有 C++ 提交中击败了31.72%的用户
 */
class Solution {
public:
    int search(vector<int> &nums, int target) {

        if (nums.empty()) return -1;
        // 二分出旋转点的位置(如4,5,6,7,0,1,2  则返回7的下标3)
        int l = 0, r = nums.size() - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] >= nums[0]) l = mid;
            else r = mid - 1;
        }

        // 寻找target在哪一有序区间中
        if (target >= nums[0]) l = 0;
        else l = r + 1, r = nums.size() - 1;

        // 二分出结果
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }

        if (nums[r] == target) return r;
        return -1;
    }
};

int main() {

    vector<int> nums = {4, 5, 6, 7, 0, 1, 2};
    cout << Solution().search(nums, 0) << endl;
    cout << Solution().search(nums, 3) << endl;

    return 0;
}
