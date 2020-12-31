#include <iostream>
#include <vector>
#include <deque>

using namespace std;

/**
 * 代码正确
 * heap-buffer-overflow
 */
class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {

        vector<int> res;
        deque<int> q;
        for (int i = 0; i < nums.size(); i++) {
            if (!q.empty() && i - k + 1 > q.front()) q.pop_front();
            while (!q.empty() && nums[q.back()] <= nums[i]) q.pop_back();
            q.push_back(i);
            if (i >= k - 1) res.push_back(nums[q.front()]);
        }

        return res;
    }
};

int main() {

    vector<int> nums = {1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;
//    vector<int> nums = {1};
//    int k = 1;
    vector<int> res = Solution().maxSlidingWindow(nums, k);
    for (int num : res) cout << num << " ";

    return 0;
}
