// Created by WXX on 2021/7/15 9:51
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * 执行用时：84 ms, 在所有 C++ 提交中击败了99.38%的用户
 * 内存消耗：50.2 MB, 在所有 C++ 提交中击败了5.81%的用户
 */
class Solution {
public:
    int maximumElementAfterDecrementingAndRearranging(vector<int> &arr) {
        int n = arr.size();
        sort(arr.begin(), arr.end());
        arr[0] = 1;
        for (int i = 1; i < n; i++)
            if (arr[i] > arr[i - 1] + 1)
                arr[i] = arr[i - 1] + 1;
        return arr[n - 1];
    }
};

int main() {

    vector<int> arr = {2, 2, 1, 2, 1};
    cout << Solution().maximumElementAfterDecrementingAndRearranging(arr) << endl;  // 2

    return 0;
}
