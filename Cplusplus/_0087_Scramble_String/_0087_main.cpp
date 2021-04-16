// Created by WXX on 2021/4/16 9:24
#include <iostream>
#include <algorithm>

using namespace std;

// TLE
/**
 * 时间复杂度推导，设为f(n)，则f(n) = 4(f(1)+f(2)+..+f(n-1))，则：
 * f(n) = 4(f(1)+f(2)+..+f(n-1))        (1)
 * f(n-1) = 4(f(1)+f(2)+..+f(n-2))      (2)
 * (1)-(2)得到：f(n)-f(n-1) = 4f(n-1) ==> f(n) = 5f(n-1)，因此
 * f(n) = 5^n
 */
class Solution {
public:
    bool isScramble(string s1, string s2) {

        if (s1 == s2) return true;
        string bs1 = s1, bs2 = s2;
        sort(bs1.begin(), bs1.end()), sort(bs2.begin(), bs2.end());
        if (bs1 != bs2) return false;

        int n = s1.size();
        for (int i = 1; i <= n - 1; i++) {  // 遍历分割成的第一个字符串的长度
            // 情况1：没有交换两个子字符串
            if (isScramble(s1.substr(0, i), s2.substr(0, i)) &&
                isScramble(s1.substr(i), s2.substr(i))) return true;
            // 情况2：交换两个子字符串
            if (isScramble(s1.substr(0, i), s2.substr(n - i)) &&
                isScramble(s1.substr(i), s2.substr(0, n - i))) return true;
        }
        return false;
    }
};

int main() {

    cout << Solution().isScramble("great", "rgeat") << endl;  // true

    return 0;
}
