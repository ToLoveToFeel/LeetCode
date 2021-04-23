#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * 思路：寻找最后一个严格上升对的前一个元素e，然后寻找e后面大于e的最小的元素x
 * 交换e和x，然后将最后的下降序列翻转即可
 * 执行用时：8 ms, 在所有 C++ 提交中击败了61.56%的用户
 * 内存消耗：12.1 MB, 在所有 C++ 提交中击败了77.73%的用户
 */
class Solution {
public:
    void nextPermutation(vector<int> &nums) {

        int k = nums.size() - 1;
        while (k > 0 && nums[k - 1] >= nums[k]) k--;
        if (k <= 0) {
            reverse(nums.begin(), nums.end());
        } else {
            int t = k;
            while (t < nums.size() && nums[t] > nums[k - 1]) t++;
            swap(nums[t - 1], nums[k - 1]);
            reverse(nums.begin() + k, nums.end());
        }
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

    vector<int> nums = {1, 2, 3};
    Solution().nextPermutation(nums);
    OutputBasicArray1D(nums);

    return 0;
}
