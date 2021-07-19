// Created by WXX on 2021/7/19 10:11
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:

    int maxFrequency(vector<int> &nums, int k) {
        typedef long long LL;
        int n = nums.size();
        sort(nums.begin(), nums.end());
        vector<LL> s(n + 1);
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] + nums[i - 1];

        int res = 0;
        for (int i = 1; i <= n; i++) {  // 枚举区间结束端点:i-1
            int l = 1, r = i, cnt = 0;
            while (l < r) {  // 满足操作次数小于等于k的最左侧位置
                int mid = l + r >> 1;
                LL t = (LL) (i - mid + 1) * nums[i - 1] - (s[i] - s[mid - 1]);  // mid~i -> nums[mid-1]~nums[i-1]
                if (t <= k) r = mid;
                else l = mid + 1;
            }
            cnt = max(cnt, i - l + 1);
            res = max(res, cnt);
        }
        return res;
    }
};

int main() {

    vector<int> nums = {1, 2, 4};
    cout << Solution().maxFrequency(nums, 5) << endl;  // 3

    return 0;
}
