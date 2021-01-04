#include <iostream>

using namespace std;

/**
 * 执行用时：16 ms, 在所有 C++ 提交中击败了62.18%的用户
 * 内存消耗：8.3 MB, 在所有 C++ 提交中击败了86.76%的用户
 */
class Solution {
public:
    string convert(string s, int n) {

        string res;
        if (n == 1) return s;
        int d = 2 * n - 2;
        for (int i = 0; i < n; ++i) {
            if (i == 0 || i == n - 1) {
                for (int j = i; j < s.size(); j += d)
                    res += s[j];
            } else {
                for (int j = i, k = d - i; j < s.size() || k < s.size(); j += d, k += d) {
                    if (j < s.size()) res += s[j];
                    if (k < s.size()) res += s[k];
                }
            }
        }

        return res;
    }
};

int main() {

    cout << Solution().convert("LEETCODEISHIRING", 3) << endl;  // LCIRETOESIIGEDHN
    cout << Solution().convert("LEETCODEISHIRING", 4) << endl;  // LDREOEIIECIHNTSG

    return 0;
}
/*
 * 本质上是一个找规律的题目，一共n行
 * 0       6         12
 * 1    5  7     11  13
 * 2  4    8  10     14
 * 3       9         15
 * 第一行和最后一行都是等差数列，公差为 2*n-2
 * 中间的行为两个等差数列的组合，公差均为2*n-2, 第一个等差数列首项为i, 第二个为 2*n-2-i
 */
