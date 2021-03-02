// Created by WXX on 2021/2/27 21:14
#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

// 二分+双指针，时间复杂度：O(log(n) + k)
/**
 * 执行用时：28 ms, 在所有 C++ 提交中击败了99.72%的用户
 * 内存消耗：30.8 MB, 在所有 C++ 提交中击败了46.19%的用户
 */
class Solution {
public:
    vector<int> findClosestElements(vector<int> &arr, int k, int T) {

        int l = 0, r = arr.size() - 1;
        while (l < r) {  // 二分出大于等于T的最小的数（如果答案重复，最左侧那个）
            int mid = l + r >> 1;
            if (arr[mid] >= T) r = mid;
            else l = mid + 1;
        }
        if (r) {
            int x = arr[r - 1], y = arr[r];
            if (make_pair(abs(x - T), x) < make_pair(abs(y - T), y)) r--;
        }
        int i = r, j = r;
        for (int u = 0; u < k - 1; u++) {
            if (i - 1 < 0) j++;
            else if (j + 1 >= arr.size()) i--;
            else {
                int x = arr[i - 1], y = arr[j + 1];
                pair<int, int> a(abs(x - T), x), b(abs(y - T), y);
                if (a < b) i--;
                else j++;
            }
        }
        vector<int> res;
        for (int u = i; u <= j; u++) res.push_back(arr[u]);
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

    vector<int> arr = {0, 0, 1, 2, 3, 3, 4, 7, 7, 8};
    OutputBasicArray1D(Solution().findClosestElements(arr, 3, 5));  // [3, 3, 4]

    return 0;
}
