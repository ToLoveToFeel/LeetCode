// Created by WXX on 2021/6/15 8:40
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：12 ms, 在所有 C++ 提交中击败了72.53%的用户
 * 内存消耗：11.3 MB, 在所有 C++ 提交中击败了23.53%的用户
 */
class Solution {
public:
    int peakIndexInMountainArray(vector<int> &arr) {
        int n = arr.size();
        int l = 1, r = n - 2;
        while (l < r) {
            int mid = l + r >> 1;
            if (arr[mid] > arr[mid + 1]) r = mid;
            else l = mid + 1;
        }
        return l;
    }
};

int main() {

    vector<int> arr = {24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
    cout << Solution().peakIndexInMountainArray(arr) << endl;  // 2

    return 0;
}
