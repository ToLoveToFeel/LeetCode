// Created by WXX on 2021/7/19 15:34
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：24 ms, 在所有 C++ 提交中击败了94.58%的用户
 * 内存消耗：18.7 MB, 在所有 C++ 提交中击败了39.72%的用户
 */
class Solution {
public:
    vector<int> getLeastNumbers(vector<int> &arr, int k) {
        quick_sort(arr, 0, arr.size() - 1, k - 1);
        vector<int> res;
        for (int i = 0; i < k; i++) res.push_back(arr[i]);
        return res;
    }

    void quick_sort(vector<int> &arr, int l, int r, int k) {
        if (l == r) return;  // 说明 l==r==k
        int x = arr[l + r >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            while (arr[++i] < x);
            while (arr[--j] > x);
            if (i < j) swap(arr[i], arr[j]);
        }
        if (k <= j) quick_sort(arr, l, j, k);
        else quick_sort(arr, j + 1, r, k);
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

    vector<int> arr = {3, 2, 1};
    OutputBasicArray1D(Solution().getLeastNumbers(arr, 2));  // [1, 2]

    return 0;
}
