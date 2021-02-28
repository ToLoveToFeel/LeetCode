// Created by WXX on 2021/2/28 9:59
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：84 ms, 在所有 C++ 提交中击败了58.81%的用户
 * 内存消耗：48.4 MB, 在所有 C++ 提交中击败了61.72%的用户
 */
class Solution {
public:
    bool isMonotonic(vector<int> &A) {

        bool f1 = true, f2 = true;
        for (int i = 1; i < A.size(); i++) {
            if (A[i] < A[i - 1]) f1 = false;  // 不是单增
            if (A[i] > A[i - 1]) f2 = false;  // 不是单减
        }
        return f1 || f2;
    }
};

int main() {

    vector<int> A = {1, 2, 2, 3};
    cout << Solution().isMonotonic(A) << endl;  // true

    return 0;
}
