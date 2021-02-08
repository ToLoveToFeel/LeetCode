// Created by WXX on 2021/2/8 15:39
#include <iostream>
#include <vector>

using namespace std;

// 使用DP解决，也可以使用滑动窗口解决
/**
 * 执行用时：72 ms, 在所有 C++ 提交中击败了98.50%的用户
 * 内存消耗：39.4 MB, 在所有 C++ 提交中击败了80.36%的用户
 */
class Solution {
public:
    int maxTurbulenceSize(vector<int> &arr) {

        int res = 1;
        int f0 = 1, f1 = 1;  // f0记录arr[i-1]>arr[i]的数组的长度
        for (int i = 1; i < arr.size(); i++) {
            if (arr[i - 1] > arr[i]) f0 = f1 + 1, f1 = 1;
            else if (arr[i - 1] < arr[i]) f1 = f0 + 1, f0 = 1;
            else f0 = 1, f1 = 1;
            res = max(res, max(f0, f1));
        }
        return res;
    }
};

int main() {

    vector<int> arr = {9, 4, 2, 10, 7, 8, 8, 1, 9};
    cout << Solution().maxTurbulenceSize(arr) << endl;

    return 0;
}
