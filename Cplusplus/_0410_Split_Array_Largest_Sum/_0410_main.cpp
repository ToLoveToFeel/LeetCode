// Created by WXX on 2021/5/31 16:58
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了61.64%的用户
 * 内存消耗：7.1 MB, 在所有 C++ 提交中击败了40.38%的用户
 */
class Solution {
public:
    bool check(vector<int> &nums, int mid, int m) {
        int s = 0, cnt = 0;
        for (auto x : nums) {
            if (x > mid) return false;  // 这一个数字都无法放进去
            if (s + x > mid) {
                s = x;
                cnt++;
            } else s += x;
        }
        if (s) cnt++;
        return cnt <= m;
    }

    int splitArray(vector<int> &nums, int m) {
        int l = 0, r = INT_MAX;
        while (l < r) {
            int mid = (long long) l + r >> 1;
            if (check(nums, mid, m)) r = mid;
            else l = mid + 1;
        }
        return r;
    }
};

int main() {


    return 0;
}
