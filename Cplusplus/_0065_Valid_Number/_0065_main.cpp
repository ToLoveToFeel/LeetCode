// Created by WXX on 2021/6/17 9:43
#include <iostream>

using namespace std;

class Solution {
public:
    bool isNumber(string s) {
        int l = 0, r = s.size() - 1;
        while (l <= r && s[l] == ' ') l++;
        while (l <= r && s[r] == ' ') r--;
        if (l > r) return false;  // 说明全是空格
        s = s.substr(l, r - l + 1);
        if (s[0] == '+' || s[0] == '-') s = s.substr(1);
        if (s.empty()) return false;  // 说明s是"+"或者"-"

        if (s[0] == '.' && (s.size() == 1 || s[1] == 'e' || s[1] == 'E'))  // 说明s是"."或者".e"或者".E"
            return false;

        int dot = 0, e = 0;  // 记录小数点和e(或者E)的数量
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '.') {
                if (dot > 0 || e > 0) return false;  // 说明：出现多个小数点 或者 e后面出现小数点
                dot++;
            } else if (s[i] == 'e' || s[i] == 'E') {
                if (!i || i + 1 == s.size() || e > 0) return false;  // 说明：e前面没内容 或者 e后面没内容 或者 出现多个e
                if (s[i + 1] == '+' || s[i + 1] == '-') {
                    if (i + 2 == s.size()) return false;  // 说明正负号后面没有内容
                    i++;
                }
                e++;
            } else if (s[i] < '0' || s[i] > '9') return false;  // 说明出现非法字母
        }
        return true;
    }
};

int main() {

    cout << Solution().isNumber("0") << endl;  // true
    cout << Solution().isNumber("   ") << endl;
    cout << Solution().isNumber("+") << endl;
    cout << Solution().isNumber(".") << endl;
    cout << Solution().isNumber(".e") << endl;
    cout << Solution().isNumber("1.e1") << endl;  // true
    cout << Solution().isNumber("1.1.1e2") << endl;
    cout << Solution().isNumber("2e2.5") << endl;
    cout << Solution().isNumber("2e") << endl;
    cout << Solution().isNumber("e2") << endl;
    cout << Solution().isNumber("2e2e") << endl;
    cout << Solution().isNumber("2e+") << endl;
    cout << Solution().isNumber("2e 3") << endl;

    return 0;
}
