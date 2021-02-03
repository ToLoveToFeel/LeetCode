// Created by WXX on 2021/2/3 10:34
#include <iostream>
#include <vector>
#include <set>

using namespace std;

// multiset中的元素可以重复，默认升序排列，插入删除时间复杂度O(log(n))
/**
 * 执行用时：60 ms, 在所有 C++ 提交中击败了88.21%的用户
 * 内存消耗：17.2 MB, 在所有 C++ 提交中击败了21.45%的用户
 */
class Solution {
public:
    int k;
    multiset<int> left, right;  // left是大根堆，right是小根堆；若窗口内有奇数个数据，规定right多一个

    vector<double> medianSlidingWindow(vector<int> &nums, int _k) {

        // 数据初始化
        k = _k;
        for (int i = 0; i < k; i++) right.insert(nums[i]);
        for (int i = 0; i < k / 2; i++) {
            left.insert(*right.begin());
            right.erase(right.begin());
        }

        vector<double> res;
        res.push_back(get_medium());
        for (int i = k; i < nums.size(); i++) {
            int x = nums[i], y = nums[i - k];  // 添加x，删除y
            if (x >= *right.begin()) right.insert(x);
            else left.insert(x);
            if (y >= *right.begin()) right.erase(right.find(y));  // right.erase(y);会删除所有y
            else left.erase(left.find(y));

            while (left.size() > right.size()) {
                right.insert(*left.rbegin());
                left.erase(left.find(*left.rbegin()));
            }
            while (right.size() > left.size() + 1) {
                left.insert(*right.begin());
                right.erase(right.find(*right.begin()));
            }
            res.push_back(get_medium());
        }
        return res;
    }

    double get_medium() {
        if (k % 2) return *right.begin();
        return ((double) *left.rbegin() + *right.begin()) / 2;
    }
};

void OutputBasicArray1D(vector<double> nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    vector<int> nums = {1, 3, -1, -3, 5, 3, 6, 7};
    OutputBasicArray1D(Solution().medianSlidingWindow(nums, 3));  //

    return 0;
}
