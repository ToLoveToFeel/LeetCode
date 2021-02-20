// Created by WXX on 2021/2/2 21:07
#include <iostream>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：6.4 MB, 在所有 C++ 提交中击败了83.58%的用户
 */
class Solution {
public:
    string decodeString(string s) {

        int u = 0;
        return dfs(s, u);
    }

    // &u：目的是为了让在递归的过程中使用同一个u
    string dfs(string &s, int &u) {
        string res;
        while (u < s.size() && s[u] != ']') {  // 这里s[u] != ']'是为了过滤掉最后一个右括号
            if ((s[u] >= 'a' && s[u] <= 'z') || (s[u] >= 'A' && s[u] <= 'Z')) res += s[u++];
            else if (s[u] >= '0' && s[u] <= '9') {
                int k = u;
                while (s[k] >= '0' && s[k] <= '9') k++;
                int x = stoi(s.substr(u, k - u));
                u = k + 1;  // 过滤掉左括号
                string y = dfs(s, u);
                u++;  // 过滤掉右括号
                while (x--) res += y;
            }
        }
        return res;
    }
};

int main() {

    cout << Solution().decodeString("3[a]2[bc]") << endl;  // aaabcbc
    cout << Solution().decodeString("3[a2[c]]") << endl;  // accaccacc
    cout << Solution().decodeString("2[abc]3[cd]ef") << endl;  // abcabccdcdcdef
    cout << Solution().decodeString("abc3[cd]xyz") << endl;  // abccdcdcdxyz

    return 0;
}
