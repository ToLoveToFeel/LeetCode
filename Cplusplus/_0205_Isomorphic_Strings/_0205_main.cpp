// Created by WXX on 2021/1/27 14:35
#include <iostream>
#include <unordered_map>

using namespace std;

// 双射
/**
 * 执行用时：12 ms, 在所有 C++ 提交中击败了69.68%的用户
 * 内存消耗：6.9 MB, 在所有 C++ 提交中击败了97.11%的用户
 */
class Solution {
public:
    bool isIsomorphic(string s, string t) {

        unordered_map<char, char> st, ts;
        for (int i = 0; i < s.size(); i++) {
            int a = s[i], b = t[i];
            if (st.count(a) && st[a] != b) return false;
            st[a] = b;
            if (ts.count(b) && ts[b] != a) return false;
            ts[b] = a;
        }
        return true;
    }
};

int main() {

    cout << Solution().isIsomorphic("egg", "add") << endl;  // true
    cout << Solution().isIsomorphic("foo", "bar") << endl;  // false

    return 0;
}
