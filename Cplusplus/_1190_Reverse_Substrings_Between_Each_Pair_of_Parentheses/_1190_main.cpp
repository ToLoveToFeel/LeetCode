// Created by WXX on 2021/5/26 9:18
#include <iostream>
#include <stack>
#include <algorithm>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了42.13%的用户
 * 内存消耗：6.4 MB, 在所有 C++ 提交中击败了47.11%的用户
 */
class Solution {
public:
    string reverseParentheses(string s) {

        int n = s.size();
        stack<string> stk;
        string res;
        for (auto c : s) {
            if (c == '(') {
                stk.push(res);
                res = "";
            } else if (c == ')') {
                reverse(res.begin(), res.end());
                res = stk.top() + res;
                stk.pop();
            } else res += c;
        }
        return res;
    }
};

int main() {

    cout << Solution().reverseParentheses("(u(love)i)") << endl;
    cout << Solution().reverseParentheses("(a(bc(def)g)h)") << endl;
    cout << Solution().reverseParentheses("a(bcdefghijkl(mno)p)q") << endl;

    return 0;
}
