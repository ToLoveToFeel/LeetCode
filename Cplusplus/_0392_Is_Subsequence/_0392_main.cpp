// Created by WXX on 2021/2/2 20:45
#include <iostream>

using namespace std;

// 考点：双指针
/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了42.30%的用户
 * 内存消耗：6.2 MB, 在所有 C++ 提交中击败了88.21%的用户
 */
class Solution {
public:
    bool isSubsequence(string s, string t) {

        int k = 0;
        for (auto c : t)
            if (k < s.size() && c == s[k])
                k++;
        return k == s.size();
    }
};

int main() {

    cout << Solution().isSubsequence("abc", "ahbgdc") << endl;  // true
    cout << Solution().isSubsequence("abc", "abcd") << endl;  // true
    cout << Solution().isSubsequence("axc", "ahbgdc") << endl;  // false

    return 0;
}
