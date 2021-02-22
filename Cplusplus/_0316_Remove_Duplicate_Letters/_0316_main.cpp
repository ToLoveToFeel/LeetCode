// Created by WXX on 2021/2/22 15:26
#include <iostream>
#include <unordered_map>

using namespace std;

/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了26.21%的用户
 * 内存消耗：6.5 MB, 在所有 C++ 提交中击败了94.64%的用户
 */
class Solution {
public:
    string removeDuplicateLetters(string s) {

        string stk;
        // in stack : 用于判断某个字符是否在stk中
        unordered_map<char, bool> ins;
        // 用于存储每个字符在 s 中出现的最后位置，方便判断后面是否还有该字符，用哈希表统计次数也可以
        unordered_map<char, int> last;
        for (int i = 0; i < s.size(); i++) last[s[i]] = i;

        for (int i = 0; i < s.size(); i++) {
            if (ins[s[i]]) continue;
            while (stk.size() && stk.back() > s[i] && last[stk.back()] > i) {
                ins[stk.back()] = false;
                stk.pop_back();
            }
            stk += s[i];
            ins[s[i]] = true;
        }
        return stk;
    }
};

int main() {

    cout << Solution().removeDuplicateLetters("a") << endl;  // a
    cout << Solution().removeDuplicateLetters("cbacdcbc") << endl;  // acdb

    return 0;
}
