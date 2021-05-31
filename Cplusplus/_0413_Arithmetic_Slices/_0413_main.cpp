// Created by WXX on 2021/5/31 19:16
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：7.1 MB, 在所有 C++ 提交中击败了82.24%的用户
 */
class Solution {
public:
    int numberOfArithmeticSlices(vector<int> &A) {
        for (int i = A.size() - 1; i > 0; i--) A[i] -= A[i - 1];
        int res = 0;
        for (int i = 1; i < A.size(); i++) {
            int j = i;
            while (j < A.size() && A[j] == A[i]) j++;
            int k = j - i;
            res += k * (k - 1) / 2;
            i = j - 1;
        }
        return res;
    }
};

int main() {

    vector<int> A = {1, 2, 3, 4};
    cout << Solution().numberOfArithmeticSlices(A) << endl;  // 3

    return 0;
}
