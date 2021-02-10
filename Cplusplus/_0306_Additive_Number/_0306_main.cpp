// Created by WXX on 2021/1/31 20:52
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了51.42%的用户
 * 内存消耗：6.5 MB, 在所有 C++ 提交中击败了34.75%的用户
 */
class Solution {
public:
    bool isAdditiveNumber(string num) {

        for (int i = 0; i < num.size(); i++)
            for (int j = i + 1; j + 1 < num.size(); j++) {
                int a = -1, b = i, c = j;  // 第一个数：num[a+1,b]；第二个数：num[b+1,c]
                while (true) {
                    if ((b - a > 1 && num[a + 1] == '0') || (c - b > 1 && num[b + 1] == '0')) break;  // 有前导0
                    auto x = num.substr(a + 1, b - a), y = num.substr(b + 1, c - b);
                    auto z = add(x, y);
                    if (num.substr(c + 1, z.size()) != z) break;  // 下一个数不匹配
                    a = b, b = c, c += z.size();
                    if (c + 1 == num.size()) return true;
                }
            }
        return false;
    }

    string add(string x, string y) {
        vector<int> A, B, C;
        for (int i = x.size() - 1; i >= 0; i--) A.push_back(x[i] - '0');
        for (int i = y.size() - 1; i >= 0; i--) B.push_back(y[i] - '0');

        for (int i = 0, t = 0; i < A.size() || i < B.size() || t; i++) {
            if (i < A.size()) t += A[i];
            if (i < B.size()) t += B[i];
            C.push_back(t % 10);
            t /= 10;
        }
        string z;
        for (int i = C.size() - 1; i >= 0; i--) z += to_string(C[i]);
        return z;
    }
};

int main() {

    cout << Solution().isAdditiveNumber("112358") << endl;  // true
    cout << Solution().isAdditiveNumber("199100199") << endl;  // true

    return 0;
}
