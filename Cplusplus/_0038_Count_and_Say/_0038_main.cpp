#include <iostream>

using namespace std;

/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了67.12%的用户
 * 内存消耗：6.9 MB, 在所有 C++ 提交中击败了39.26%的用户
 */
class Solution {
public:
    string countAndSay(int n) {

        string s = "1";
        for (int i = 0; i < n - 1; i++) {
            string t;
            for (int j = 0; j < s.size();) {
                int k = j + 1;
                while (k < s.size() && s[k] == s[j]) k++;
                t += to_string(k - j) + s[j];
                j = k;
            }
            s = t;
        }
        return s;
    }
};

int main() {

    cout << Solution().countAndSay(2) << endl;  // 11
    cout << Solution().countAndSay(4) << endl;  // 1211

    return 0;
}