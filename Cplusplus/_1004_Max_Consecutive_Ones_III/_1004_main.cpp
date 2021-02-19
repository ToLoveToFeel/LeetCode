// Created by WXX on 2021/2/19 9:26
#include <iostream>
#include <vector>

using namespace std;

// 滑动窗口：确定右边界l，找到满足条件的最左边界r
/**
 * 执行用时：92 ms, 在所有 C++ 提交中击败了40.52%的用户
 * 内存消耗：50.3 MB, 在所有 C++ 提交中击败了41.64%的用户
 */
class Solution {
public:
    int longestOnes(vector<int> &A, int K) {

        int res = 0;
        int lsum = 0, rsum = 0;  // 记录[0...j-1]中0的个数，记录[0...i]中0的个数
        for (int i = 0, j = 0; i < A.size(); i++) {
            rsum += 1 - A[i];
            while (rsum - lsum > K) lsum += 1 - A[j++];
            res = max(res, i - j + 1);
        }
        return res;
    }
};

int main() {

    vector<int> A = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
    cout << Solution().longestOnes(A, 3) << endl;  // 10

    return 0;
}
