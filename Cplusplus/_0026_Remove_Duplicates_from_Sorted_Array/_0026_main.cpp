// Created by WXX on 2021/4/18 10:08
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了90.80%的用户
 * 内存消耗：13.4 MB, 在所有 C++ 提交中击败了33.98%的用户
 */
class Solution {
public:
    const int T = 1;  // T表示最多保留几个相同元素

    int removeDuplicates(vector<int>& nums) {
        int k = 0;
        for (int i = 0; i < nums.size(); i++)
            if (k - T < 0 || nums[i] != nums[k - T])
                nums[k++] = nums[i];
        return k;
    }
};

int main() {

    vector<int> nums = {1, 1, 2};
    cout << Solution().removeDuplicates(nums) << endl;

    return 0;
}
