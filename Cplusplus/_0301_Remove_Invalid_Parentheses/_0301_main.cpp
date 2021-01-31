// Created by WXX on 2021/1/31 19:39
#include <iostream>
#include <vector>

using namespace std;

/**
 * 合法的括号要满足如下两个条件：
 * (1) 左右括号数量相同
 * (2) 任意一个前缀中，左括号数量 >= 右括号数量
 */
class Solution {
public:

    vector<string> ans;

    vector<string> removeInvalidParentheses(string s) {
        int l = 0;  // l：当前左括号数量减去右括号数量
        int r = 0;  // r：当前要删除多少右括号
        for (auto x : s)
            if (x == '(') l++;
            else if (x == ')') {
                if (l == 0) r++;
                else l--;
            }

        dfs(s, 0, "", 0, l, r);
        return ans;
    }

    /**
     * @param s 考察的字符串
     * @param u 枚举到字符串的第几个字符
     * @param path 当前删完括号后剩余的字符串是什么
     * @param cnt 当前左括号减去右括号的数量
     * @param l 当前还可以删除多少左括号
     * @param r 当前还可以删除多少右括号
     */
    void dfs(string &s, int u, string path, int cnt, int l, int r) {
        if (u == s.size()) {
            if (!cnt) ans.push_back(path);  // 说明当前左右括号数量相同
            return;
        }
        if (s[u] != '(' && s[u] != ')') dfs(s, u + 1, path + s[u], cnt, l, r);
        else if (s[u] == '(') {
            int k = u;
            while (k < s.size() && s[k] == '(') k++;
            l -= (k - u);
            // 存在多个连续的左括号时，枚举选几个，这样就可以避免重复
            // 首先全部删除，然后再一个个加回来
            for (int i = k - u; i >= 0; i--) {
                if (l >= 0) dfs(s, k, path, cnt, l, r);
                path += '(';
                cnt++, l++;
            }
        } else if (s[u] == ')') {
            int k = u;
            while (k < s.size() && s[k] == ')') k++;
            r -= (k - u);
            // 存在多个连续的右括号时，枚举选几个，这样就可以避免重复
            for (int i = k - u; i >= 0; i--) {
                if (cnt >= 0 && r >= 0) dfs(s, k, path, cnt, l, r);
                path += ')';
                cnt--, r++;
            }
        }
    }
};

void OutputBasicArray1D(vector<string> nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    OutputBasicArray1D(Solution().removeInvalidParentheses("()())()"));  // [(())(), ()()()]
    OutputBasicArray1D(Solution().removeInvalidParentheses("(a)())()"));  // [(a())(), (a)()()]
    OutputBasicArray1D(Solution().removeInvalidParentheses(")("));  // []

    return 0;
}
