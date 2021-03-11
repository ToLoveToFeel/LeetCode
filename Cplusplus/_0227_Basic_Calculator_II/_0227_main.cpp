// Created by WXX on 2021/3/11 9:24
#include <iostream>
#include <stack>
#include <unordered_map>

using namespace std;

/**
 * 执行用时：20 ms, 在所有 C++ 提交中击败了37.51%的用户
 * 内存消耗：7.9 MB, 在所有 C++ 提交中击败了85.03%的用户
 */
class Solution {
public:
    stack<int> nums;
    stack<char> ops;

    void eval() {
        int b = nums.top();
        nums.pop();
        int a = nums.top();
        nums.pop();
        char c = ops.top();
        ops.pop();

        int r;
        if (c == '+') r = a + b;
        else if (c == '-') r = a - b;
        else if (c == '*') r = a * b;
        else r = a / b;
        nums.push(r);
    }

    int calculate(string s) {
        unordered_map<char, int> pr;  // 记录操作符优先级
        pr['+'] = pr['-'] = 1, pr['*'] = pr['/'] = 2;
        for (int i = 0; i < s.size(); i++) {
            char c = s[i];
            if (c == ' ') continue;
            if (isdigit(c)) {
                int j = i, t = 0;
                while (j < s.size() && isdigit(s[j])) t = t * 10 + (s[j++] - '0');
                nums.push(t);
                i = j - 1;
            } else {
                while (ops.size() && pr[ops.top()] >= pr[c]) eval();
                ops.push(c);
            }
        }
        while (ops.size()) eval();
        return nums.top();
    }
};

int main() {

    cout << Solution().calculate("3+2*2") << endl;  // 7
    cout << Solution().calculate("3/2") << endl;  // 1
    cout << Solution().calculate(" 3+5 / 2 ") << endl;  // 5

    return 0;
}
