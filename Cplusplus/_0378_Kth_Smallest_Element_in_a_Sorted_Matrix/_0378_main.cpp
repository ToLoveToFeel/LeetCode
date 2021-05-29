// Created by WXX on 2021/5/29 15:42
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：28 ms, 在所有 C++ 提交中击败了87.71%的用户
 * 内存消耗：12.8 MB, 在所有 C++ 提交中击败了46.96%的用户
 */
class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        int l = INT_MIN, r = INT_MAX;
        while (l < r) {
            int mid = (long long)l + r >> 1;
            int i = matrix[0].size() - 1, cnt = 0;  // 统计小于mid的数的数量
            for (int j = 0; j < matrix.size(); j++) {  // 第j行有多少元素小于mid
                while (i >= 0 && matrix[j][i] > mid) i--;
                cnt += i + 1;
            }
            if (cnt >= k) r = mid;
            else l = mid + 1;
        }
        return r;
    }
};

int main() {

    vector<vector<int>> matrix = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15},
    };
    cout << Solution().kthSmallest(matrix, 8) << endl;  // 13

    return 0;
}
