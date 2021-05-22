// Created by WXX on 2021/5/22 20:14
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int jump(vector<int> &nums) {
        int n = nums.size();
        vector<int> f(n);
        f[0] = 0;
        for (int i = 1, j = 0; i < n; i++) {  // 这里的j代表上一段，i代表下一段
            while (j + nums[j] < i) j++;  // 条件满足时，说明j跳不到i，需要j++
            f[i] = f[j] + 1;
        }
        return f[n - 1];
    }
};

int main() {

    vector<int> nums = {2, 3, 1, 1, 4};
    cout << Solution().jump(nums) << endl;  // 2

    return 0;
}
