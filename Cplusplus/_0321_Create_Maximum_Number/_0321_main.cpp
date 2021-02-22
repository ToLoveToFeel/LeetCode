// Created by WXX on 2021/2/22 20:58
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：184 ms, 在所有 C++ 提交中击败了25.88%的用户
 * 内存消耗：20.7 MB, 在所有 C++ 提交中击败了50.67%的用户
 */
class Solution {
public:
    vector<int> maxNumber(vector<int> &nums1, vector<int> &nums2, int k) {

        int n = nums1.size(), m = nums2.size();
        vector<int> res(k, INT_MIN);
        for (int i = max(0, k - m); i <= min(k, n); i++) {  // i: 从 nums1 中选出i个数字
            auto a = maxArray(nums1, i);
            auto b = maxArray(nums2, k - i);
            auto c = merge(a, b);
            res = max(res, c);
        }
        return res;
    }

    vector<int> merge(vector<int> &a, vector<int> &b) {
        vector<int> c;
        while (a.size() && b.size())
            if (a > b) c.push_back(a[0]), a.erase(a.begin());
            else c.push_back(b[0]), b.erase(b.begin());
        while (a.size()) c.push_back(a[0]), a.erase(a.begin());
        while (b.size()) c.push_back(b[0]), b.erase(b.begin());
        return c;
    }

    vector<int> maxArray(vector<int> &nums, int k) {
        vector<int> res(k);
        int n = nums.size();
        for (int i = 0, j = 0; i < nums.size(); i++) {  // j : res中已经插入数据的个数
            // nums[i...n) 一共剩余 n-i 个元素需要考察
            int x = nums[i];
            while (j && res[j - 1] < x && j + n - i > k) j--;
            if (j < k) res[j++] = x;
        }
        return res;
    }
};

void OutputBasicArray1D(vector<int> nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

//    vector<int> nums1 = {3, 4, 6, 5}, nums2 = {9, 1, 2, 5, 8, 3};  // [9, 8, 6, 5, 3]
//    int k = 5;
    vector<int> nums1 = {4, 9, 5}, nums2 = {8, 7, 4};  // [9, 8, 7]
    int k = 3;
    OutputBasicArray1D(Solution().maxNumber(nums1, nums2, k));

    return 0;
}
