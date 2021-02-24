#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：240 ms, 在所有 C++ 提交中击败了97.90%的用户
 * 内存消耗：114.1 MB, 在所有 C++ 提交中击败了88.81%的用户
 */
class Solution {
public:
    vector<int> maxSlidingWindow(vector<int> &nums, int k) {
        int n = nums.size();
        int q[n];
        int hh = 0, tt = -1;
        vector<int> res;
        for (int i = 0; i < nums.size(); i++) {
            if (hh <= tt && i - k + 1 > q[hh]) hh++;
            while (hh <= tt && nums[q[tt]] <= nums[i]) tt--;
            q[++tt] = i;
            if (i >= k - 1) res.push_back(nums[q[hh]]);
        }
        return res;
    }
};

void OutputBasicArray1D(vector<int> nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    vector<int> nums = {1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;
    OutputBasicArray1D(Solution().maxSlidingWindow(nums, k));

    return 0;
}
