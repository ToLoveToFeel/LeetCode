// Created by WXX on 2021/4/20 9:39
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了62.45%的用户
 * 内存消耗：6.7 MB, 在所有 C++ 提交中击败了61.60%的用户
 */
class Solution {
public:
    int strStr(string haystack, string needle) {
        return haystack.find(needle);
    }
};

int main() {

    cout << Solution().strStr("", "") << endl;  // 0
    cout << Solution().strStr("hello", "ll") << endl;  // 2
    cout << Solution().strStr("aaaaa", "bba") << endl;  // -1
    cout << Solution().strStr("mississippi", "issippi") << endl;  // 4

    return 0;
}
