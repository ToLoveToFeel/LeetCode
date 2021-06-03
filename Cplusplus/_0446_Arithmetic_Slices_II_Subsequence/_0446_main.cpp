// Created by WXX on 2021/6/3 9:43
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

/**
 * 执行用时：1552 ms, 在所有 C++ 提交中击败了13.68%的用户
 * 内存消耗：278.5 MB, 在所有 C++ 提交中击败了5.66%的用户
 */
class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& a) {
        #define LL long long
        int n = a.size();
        vector<unordered_map<LL, int>> f(n);
        int res = 0;
        for (int i = 0; i < n; i++)
            for (int k = 0; k < i; k++) {
                LL j = (LL)a[i] - a[k];
                res += f[k][j];
                f[i][j] += f[k][j] + 1;
            }
        return res;
    }
};
// 优化上述代码常数
/**
 * 执行用时：892 ms, 在所有 C++ 提交中击败了59.43%的用户
 * 内存消耗：151.2 MB, 在所有 C++ 提交中击败了22.64%的用户
 */
/*
class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& a) {
        #define LL long long
        int n = a.size();
        vector<unordered_map<LL, int>> f(n);
        int res = 0;
        for (int i = 0; i < n; i++)
            for (int k = 0; k < i; k++) {
                LL j = (LL)a[i] - a[k];
                auto it = f[k].find(j);
                int t = 0;
                if (it != f[k].end()) {
                    t = it->second;
                    res += t;
                }
                f[i][j] += t + 1;
            }
        return res;
    }
};
*/

int main() {

    vector<int> a = {2, 4, 6, 8, 10};
    cout << Solution().numberOfArithmeticSlices(a) << endl;  // 7

    return 0;
}
