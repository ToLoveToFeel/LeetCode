// Created by WXX on 2021/1/30 17:49
#include <iostream>
#include <vector>

using namespace std;

// 此题可以转化成lc上的142题(环形链表II)，即快慢指针
// 建图方式：索引指向元素，即i -> nums[i]
/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：10.7 MB, 在所有 C++ 提交中击败了85.23%的用户
 */
class Solution {
public:
    int findDuplicate(vector<int> &nums) {

        int a = 0, b = 0;  // a为慢指针，b为快指针
        while (true) {
            a = nums[a];
            b = nums[nums[b]];
            if (a == b) {
                a = 0;
                while (a != b) {
                    a = nums[a];
                    b = nums[b];
                }
                return a;
            }
        }
    }
};

int main() {

    vector<int> nums = {1, 3, 4, 2, 2};
    cout << Solution().findDuplicate(nums) << endl;

    return 0;
}
