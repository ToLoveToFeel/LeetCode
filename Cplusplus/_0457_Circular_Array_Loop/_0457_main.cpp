// Created by WXX on 2021/6/5 14:59
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：7.1 MB, 在所有 C++ 提交中击败了73.93%的用户
 */
class Solution {
public:
    bool circularArrayLoop(vector<int> &nums) {
        int n = nums.size(), Base = 10000;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= Base) continue;  // 说明当前点所在的子图已经被遍历过了
            int k = i;  // 当前点可以跳到的位置
            int S = Base + i;  // 该子图的标记
            int t = nums[k] > 0;  // 符号，环的方向
            int last = -1;  // 用于判断自环
            do {
                int p = ((k + nums[k]) % n + n) % n;
                last = nums[k], nums[k] = S;
                k = p;
                // 没有遍历到环，当前遍历元素不是重复元素，方向相同
            } while (k != i && nums[k] < Base && (t ^ (nums[k] > 0)) == 0);
            if (last % n && nums[k] == S) return true;  // 不是自环并且存在环
        }
        return false;
    }
};

int main() {

    vector<int> nums = {2, -1, 1, 2, 2};
    cout << Solution().circularArrayLoop(nums) << endl;  // true

    return 0;
}
