#include <iostream>
#include <stack>

using namespace std;

/**
 * https://www.bilibili.com/video/BV1PK4y147uk  14:00
 * 思路：如果某段中右括号比左括号多一个，则可以将该段切分开，最长的有效括号不会跨越该段
 * 执行用时：8 ms, 在所有 C++ 提交中击败了52.63%的用户
 * 内存消耗：7.4 MB, 在所有 C++ 提交中击败了61.19%的用户
 */
class Solution {
public:
    int longestValidParentheses(string s) {

        stack<int> stk;

        int res = 0;
        for (int i = 0, start = -1; i < s.size(); i++) {
            if (s[i] == '(') stk.push(i);
            else {
                if (stk.size()) {
                    stk.pop();
                    if (stk.size()) res = max(res, i - stk.top());
                    else res = max(res, i - start);
                } else {
                    start = i;
                }
            }
        }

        return res;
    }
};

int main() {

    cout << Solution().longestValidParentheses("(()") << endl;
    cout << Solution().longestValidParentheses(")()())") << endl;
    cout << Solution().longestValidParentheses("") << endl;

    return 0;
}