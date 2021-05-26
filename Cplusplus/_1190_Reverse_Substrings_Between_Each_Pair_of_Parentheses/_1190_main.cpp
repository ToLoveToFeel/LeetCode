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

//class Solution {
//public:
//    string reverseParentheses(string s) {
//        int n = s.size();
//        stack<int> stk;
//        //i 会跳到其 ne[i]的位置
//        vector<int> ne(n);
//        for (int i = 0; i < n; ++i) {
//            if (s[i] == '(') stk.push(i);
//            else if (s[i] == ')') {
//                int j = stk.top();
//                stk.pop();
//                ne[i] = j;
//                ne[j] = i;
//            }
//        }
//
//        string ans;
//        for (int i = 0, dir = 1; i < n; i += dir) {
//            if (s[i] == '(' || s[i] == ')') {
//                i = ne[i];
//                dir = -dir; //变换遍历方向
//            } else ans += s[i];
//        }
//        return ans;
//    }
//};

int main() {

    cout << Solution().reverseParentheses("(a(bc(def)g)h)") << endl;

    return 0;
}
