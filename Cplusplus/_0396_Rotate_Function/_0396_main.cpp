// Created by WXX on 2021/2/2 22:32
#include <iostream>
#include <vector>

using namespace std;

/*
 * 设 S = A[0]+A[1]+A[2]+......+A[n-2]+A[n-1]
 * A[0]     A[1]    A[2]    ......      A[n-2]    A[n-1]
 *  0        1       2                    n-2       n-1     F[0]
 *  1        2       3                    n-1       n-n     F[1]     f[1]-f[0]=S-n*A[n-1]
 *  2        3       4                    n-n        1      F[2]     f[2]-f[1]=S-n*A[n-2]
 *  ......
 */
class Solution {
public:
    int maxRotateFunction(vector<int> &A) {

        typedef long long LL;
        LL sum = 0, cur = 0;
        for (auto x : A) sum += x;
        int n = A.size();
        for (int i = 0; i < n; i++) cur += i * A[i];
        LL res = cur;
        for (int i = n - 1; i; i--) {
            cur += sum - (LL) n * A[i];
            res = max(res, cur);
        }
        return res;
    }
};

int main() {

    vector<int> A = {4, 3, 2, 6};
    cout << Solution().maxRotateFunction(A) << endl;  // 26

    return 0;
}
