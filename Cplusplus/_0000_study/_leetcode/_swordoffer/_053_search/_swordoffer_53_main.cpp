// Created by WXX on 2021/7/16 9:41
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int search(vector<int> &nums, int target) {
        if (nums.empty()) return 0;

        int n = nums.size();
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }

        if (nums[l] != target) return 0;
        int L = l;
        l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) l = mid;
            else r = mid - 1;
        }
        return r - L + 1;
    }
};

int main() {

    vector<int> nums = {5, 7, 7, 8, 8, 10};
    cout << Solution().search(nums, 10) << endl;  // 2

    return 0;
}
