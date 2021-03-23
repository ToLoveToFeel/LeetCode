// Created by WXX on 2021/3/23 10:33
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：14 MB, 在所有 C++ 提交中击败了48.60%的用户
 */
class Solution {
public:
    int trap(vector<int> &height) {

        int n = height.size();
        if (n == 0) return 0;

        vector<int> left_max(n), right_max(n);

        left_max[0] = height[0];
        for (int i = 1; i < n; i++) left_max[i] = max(left_max[i - 1], height[i]);
        right_max[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) right_max[i] = max(right_max[i + 1], height[i]);

        int res = 0;
        for (int i = 0; i < n; i++) res += min(left_max[i], right_max[i]) - height[i];

        return res;
    }
};

int main() {

    vector<int> height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    cout << Solution().trap(height) << endl;  // 6

    return 0;
}
