// Created by WXX on 2021/3/10 9:50
#include <iostream>
#include <stack>

using namespace std;

/**
 * 执行用时：24 ms, 在所有 C++ 提交中击败了41.60%的用户
 * 内存消耗：8.9 MB, 在所有 C++ 提交中击败了53.07%的用户
 */
class Solution {
public:
    stack<int> num;  // 存储数字
    stack<char> ops;  // 存储运算符和括号

    void eval() {
        auto b = num.top(); num.pop();
        auto a = num.top(); num.pop();
        auto c = ops.top(); ops.pop();
        int r;
        if (c == '+') r = a + b;
        else r = a - b;
        num.push(r);
    }

    int calculate(string s) {

        if (s[0] == '-') s = '0' + s;
        for (int i = 0; i < s.size(); i++) {
            auto c = s[i];
            if (c == ' ') continue;
            if (isdigit(c)) {
                int j = i, t = 0;
                while (j < s.size() && isdigit(s[j])) t = t * 10 + (s[j++] - '0');
                i = j - 1;
                num.push(t);
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (ops.top() != '(') eval();
                ops.pop();
            } else {
                while (ops.size() && ops.top() != '(') eval();
                ops.push(c);
            }
        }
        while (ops.size()) eval();
        return num.top();
    }
};

int main() {

    cout << Solution().calculate("1 + 1") << endl;  // 2
    cout << Solution().calculate(" 2-1 + 2 ") << endl;  // 3
    cout << Solution().calculate("(1+(4+5+2)-3)+(6+8)") << endl;  // 23
    cout << Solution().calculate("-2+ 1") << endl;  // -1

    return 0;
}
