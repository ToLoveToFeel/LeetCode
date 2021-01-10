#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：7 MB, 在所有 C++ 提交中击败了90.21%的用户
 */
class Solution {
public:
    vector<string> summaryRanges(vector<int> &nums) {
        vector<string> res;
        for (int i = 0; i < nums.size(); i++) {
            int j = i + 1;
            while (j < nums.size() && nums[j] == nums[j - 1] + 1) j++;
            if (j == i + 1) res.push_back(to_string(nums[i]));
            else res.push_back(to_string(nums[i]) + "->" + to_string(nums[j - 1]));
            i = j - 1;
        }
        return res;
    }
};

void OutputBasicArray1D(vector<string> &nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    vector<int> nums = {0, 2, 3, 4, 6, 8, 9};  // [0, 2->4, 6, 8->9]
    vector<string> res = Solution().summaryRanges(nums);
    OutputBasicArray1D(res);

    return 0;
}