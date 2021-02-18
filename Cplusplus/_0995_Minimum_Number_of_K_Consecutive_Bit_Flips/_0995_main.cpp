// Created by WXX on 2021/2/18 9:22
#include <iostream>
#include <vector>

using namespace std;

// 考点：递推、差分
/**
 * 执行用时：92 ms, 在所有 C++ 提交中击败了87.76%的用户
 * 内存消耗：73.6 MB, 在所有 C++ 提交中击败了28.57%的用户
 */
class Solution {
public:
    int minKBitFlips(vector<int> &A, int K) {

        int n = A.size();
        vector<int> B(n + 1);  // 表示翻转次数的差分数组，B[0]+...+B[i]表示A[i]的翻转次数
        int res = 0;
        for (int i = 0, sum = 0; i < n; i++) {
            sum += B[i];
            if ((A[i] + sum) % 2 == 0) {
                if (i + K > n) return -1;  // i + K - 1 > n - 1 剩余元素不够翻转
                res++;
                sum++;  // B[i] += 1 会导致sum++
                B[i + K] -= 1;
            }
        }
        return res;
    }
};

int main() {

    vector<int> A = {0, 1, 0};
    cout << Solution().minKBitFlips(A, 1) << endl;

    return 0;
}
