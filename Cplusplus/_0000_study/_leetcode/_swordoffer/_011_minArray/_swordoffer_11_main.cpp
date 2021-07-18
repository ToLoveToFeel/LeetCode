// Created by WXX on 2021/7/18 15:09
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int minArray(vector<int> &nums) {
        int l = 0, r = nums.size() - 1;
        while (l < r && nums[l] == nums[r]) r--;
        if (nums[r] > nums[l]) return nums[0];  // 说明原来就是升序数组
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] < nums[0]) r = mid;
            else l = mid + 1;
        }
        return nums[l];
    }
};

int main() {

    vector<int> nums = {2, 2, 2, 0, 1};
    cout << Solution().minArray(nums) << endl;  // 0

    return 0;
}
