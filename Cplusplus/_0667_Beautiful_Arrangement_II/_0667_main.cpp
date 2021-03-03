// Created by WXX on 2021/2/27 23:28
#include <iostream>
#include <vector>

using namespace std;

// 这是一个构造题目
/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了26.61%的用户
 * 内存消耗：7.3 MB, 在所有 C++ 提交中击败了86.64%的用户
 */
class Solution {
public:
    vector<int> constructArray(int n, int k) {

        vector<int> res(n);
        for (int i = 0; i < n - k - 1; i++) res[i] = i + 1;
        int u = n - k - 1;
        int i = n - k, j = n;
        while (u < n) {
            res[u++] = i++;
            if (u < n) res[u++] = j--;
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

    OutputBasicArray1D(Solution().constructArray(3, 1));  // [1, 2, 3]
    OutputBasicArray1D(Solution().constructArray(3, 2));  // [1, 3, 2]

    return 0;
}
