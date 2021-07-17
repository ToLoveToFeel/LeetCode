// Created by WXX on 2021/7/17 15:53
#include <iostream>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：6.1 MB, 在所有 C++ 提交中击败了86.34%的用户
 */
class Solution {
public:
    int countSubstrings(string s) {

        int n = s.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 奇数回文串
            int j = i, k = i;
            while (j >= 0 && k < n && s[j] == s[k]) res++, j--, k++;
            // 偶数回文串
            j = i, k = i + 1;
            while (j >= 0 && k < n && s[j] == s[k]) res++, j--, k++;
        }
        return res;
    }
};

int main() {

    cout << Solution().countSubstrings("abc") << endl;  // 3

    return 0;
}
