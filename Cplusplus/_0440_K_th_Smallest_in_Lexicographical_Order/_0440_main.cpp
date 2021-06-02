// Created by WXX on 2021/6/2 19:24
#include <iostream>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：5.8 MB, 在所有 C++ 提交中击败了55.44%的用户
 */
class Solution {
public:
    int findKthNumber(int n, int k) {
        int prefix = 1;
        while (k > 1) {
            int cnt = f(prefix, n);
            if (k > cnt) {
                k -= cnt;
                prefix++;
            } else {
                k--;
                prefix *= 10;
            }
        }
        return prefix;
    }

    // 可以返回 1~n 中前缀是 prefix 数的个数
    int f(int prefix, int n) {
        string A = to_string(n), B = to_string(prefix);
        int dt = A.size() - B.size();
        long long p = 1;
        int res = 0;
        for (int i = 0; i < dt; i++) {
            res += p;
            p *= 10;
        }
        A = A.substr(0, B.size());
        if (A == B) res += n - prefix * p + 1;
        else if (A > B) res += p;
        return res;
    }
};

int main() {

    cout << Solution().findKthNumber(13, 2) << endl;  // 10

    return 0;
}
