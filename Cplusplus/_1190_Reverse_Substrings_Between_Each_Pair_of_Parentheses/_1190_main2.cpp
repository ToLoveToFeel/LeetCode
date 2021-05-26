// Created by WXX on 2021/5/26 9:18
#include <iostream>
#include <vector>
#include <stack>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：6.2 MB, 在所有 C++ 提交中击败了72.63%的用户
 */
class Solution {
public:
    string reverseParentheses(string s) {
        int n = s.size();
        stack<int> stk;
        //i 会跳到其 ne[i]的位置
        vector<int> ne(n);
        for (int i = 0; i < n; ++i) {
            if (s[i] == '(') stk.push(i);
            else if (s[i] == ')') {
                int j = stk.top();
                stk.pop();
                ne[i] = j;
                ne[j] = i;
            }
        }

        string res;
        for (int i = 0, dir = 1; i < n; i += dir)
            if (s[i] == '(' || s[i] == ')') i = ne[i], dir = -dir;
            else res += s[i];
        return res;
    }
};

int main() {

    cout << Solution().reverseParentheses("(a(bc(def)g)h)") << endl;

    return 0;
}
