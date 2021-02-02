// Created by WXX on 2021/2/2 20:45
#include <iostream>

using namespace std;

class Solution {
public:
    bool isSubsequence(string s, string t) {

        int k = 0;
        for (auto c : t)
            if (k < t.size() && c == s[k])
                k++;
        return k == s.size();
    }
};

int main() {

    cout << Solution().isSubsequence("abc", "ahbgdc") << endl;  // true
    cout << Solution().isSubsequence("axc", "ahbgdc") << endl;  // false

    return 0;
}
