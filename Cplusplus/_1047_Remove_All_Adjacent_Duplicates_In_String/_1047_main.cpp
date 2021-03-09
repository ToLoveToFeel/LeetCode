// Created by WXX on 2021/3/9 8:51
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：16 ms, 在所有 C++ 提交中击败了85.43%的用户
 * 内存消耗：11.1 MB, 在所有 C++ 提交中击败了10.89%的用户
 */
class Solution {
public:
    string removeDuplicates(string S) {
        vector<char> stk;
        for (int i = 0; i < S.size(); i++) {
            stk.push_back(S[i]);
            int p = stk.size() - 1;
            while (stk.size() >= 2 && stk[p] == stk[p - 1]) {
                stk.pop_back(), stk.pop_back();
                p = stk.size() - 1;
            }
        }
        string res;
        for (auto c : stk) res += c;
        return res;
    }
};

int main() {

    cout << Solution().removeDuplicates("abbaca") << endl;

    return 0;
}
