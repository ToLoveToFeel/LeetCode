// Created by WXX on 2021/1/26 16:48
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int rob(vector<int> &nums) {

        int n = nums.size();
        vector<int> f(n + 1), g(n + 1);  // 从1开始，表示第1家店
        for (int i = 1; i <= n; i++) {
            f[i] = g[i - 1] + nums[i - 1];
            g[i] = max(g[i - 1], f[i - 1]);
        }
        return max(f[n], g[n]);
    }
};

int main() {

    vector<int> nums = {2, 7, 9, 3, 1};
    cout << Solution().rob(nums) << endl;  // 12

    return 0;
}
