// Created by WXX on 2021/4/19 8:41
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了51.07%的用户
 * 内存消耗：8.5 MB, 在所有 C++ 提交中击败了69.84%的用户
 */
class Solution {
public:
    int removeElement(vector<int> &nums, int val) {

        int k = 0;  // [0, k)
        for (int i = 0; i < nums.size(); i++)
            if (nums[i] != val)
                nums[k++] = nums[i];
        return k;
    }
};

int main() {

    vector<int> nums = {3, 2, 2, 3};
    cout << Solution().removeElement(nums, 2) << endl;

    return 0;
}
