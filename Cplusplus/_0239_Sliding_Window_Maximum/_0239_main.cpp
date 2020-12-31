#include <iostream>
#include <vector>

using namespace std;

const int N = 100010;
int q[N];
int hh = 0, tt = -1;

/**
 * 执行用时：516 ms, 在所有 C++ 提交中击败了35.59%的用户
 * 内存消耗：116.3 MB, 在所有 C++ 提交中击败了22.09%的用户
 */
class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {

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

int main() {

//    vector<int> nums = {1, 3, -1, -3, 5, 3, 6, 7};
//    int k = 3;
    vector<int> nums = {1};
    int k = 1;
    vector<int> res = Solution().maxSlidingWindow(nums, k);
    for (int num : res) cout << num << " ";

    return 0;
}
