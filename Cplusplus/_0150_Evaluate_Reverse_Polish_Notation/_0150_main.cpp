// Created by WXX on 2021/3/20 9:29
#include <iostream>
#include <vector>
#include <stack>

using namespace std;

/**
 * 执行用时：24 ms, 在所有 C++ 提交中击败了8.70%的用户
 * 内存消耗：12.5 MB, 在所有 C++ 提交中击败了5.02%的用户
 */
class Solution {
public:
    string eval(int a, int b, string op) {

        int res = 0;
        if (op == "+") res = a + b;
        else if (op == "-") res = a - b;
        else if (op == "*") res = a * b;
        else res = a / b;

        return to_string(res);
    }

    int evalRPN(vector<string> &tokens) {

        stack<string> stk;
        for (auto &token : tokens) {
            if (token == "+" || token == "-" || token == "*" || token == "/") {
                int b = stoi(stk.top()); stk.pop();
                int a = stoi(stk.top()); stk.pop();
                stk.push(eval(a, b, token));
            } else {
                stk.push(token);
            }
        }
        return stoi(stk.top());
    }
};

int main() {

//    vector<string> tokens = {"2", "1", "+", "3", "*"};  // 9
    vector<string> tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};  // 22
    cout << Solution().evalRPN(tokens) << endl;

    return 0;
}
