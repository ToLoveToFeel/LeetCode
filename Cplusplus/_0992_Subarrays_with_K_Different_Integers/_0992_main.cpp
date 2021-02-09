// Created by WXX on 2021/2/9 9:20
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

/**
 * 执行用时：184 ms, 在所有 C++ 提交中击败了65.77%的用户
 * 内存消耗：43 MB, 在所有 C++ 提交中击败了58.17%的用户
 */
class Solution {
public:

    // 返回最多包含K个数字的子数组的个数
    int GetMostDistinct(vector<int> &A, int K) {
        unordered_map<int, int> hash;
        int l = 0, r = 0, res = 0;
        while (r < A.size()) {
            hash[A[r++]]++;
            while (hash.size() > K) {
                hash[A[l]]--;
                if (hash[A[l]] == 0) hash.erase(A[l]);
                l++;
            }
            // 如果这里改成 res = max(res, r - l)，那么此函数就是 LeetCode 904 题的解。
            // 这里可以用动态规划的思想来理解 res += r - l
            // r 增加一次，增加的数组个数可以用 r - l 来表示
            res += r - l;
        }
        return res;
    }

    int subarraysWithKDistinct(vector<int> &A, int K) {
        return GetMostDistinct(A, K) - GetMostDistinct(A, K - 1);
    }
};

int main() {

    vector<int> A = {1, 2, 1, 2, 3};
    cout << Solution().subarraysWithKDistinct(A, 2) << endl;  // 7

    return 0;
}
