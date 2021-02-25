// Created by WXX on 2021/1/30 16:58
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：12 ms, 在所有 C++ 提交中击败了89.97%的用户
 * 内存消耗：10.2 MB, 在所有 C++ 提交中击败了70.59%的用户
 */
class Solution {
public:
    int lengthOfLIS(vector<int> &nums) {

        vector<int> q;  // q[k]表示长度为k的上升子序列的结尾最小值
        for (auto x : nums) {
            if (q.empty() || x > q.back()) q.push_back(x);
            else {
                if (x <= q[0]) q[0] = x;
                else {
                    // 找到小于x最大的数据
                    int l = 0, r = q.size() - 1;
                    while (l < r) {
                        int mid = l + r + 1 >> 1;
                        if (q[mid] < x) l = mid;
                        else r = mid - 1;
                    }
                    q[r + 1] = x;
                }
            }
        }
        return q.size();
    }
};

int main() {

//    vector<int> nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};  // 6
    vector<int> nums = {7, 7};  // 1
    cout << Solution().lengthOfLIS(nums) << endl;

    return 0;
}
