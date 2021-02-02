// Created by WXX on 2021/2/2 20:15
#include <iostream>

using namespace std;

class Solution {
public:
    char findTheDifference(string s, string t) {

        int x = 0;
        for (auto c : s) x ^= c;
        for (auto c : t) x ^= c;
        return x;
    }
};

int main() {

    cout << Solution().findTheDifference("abcd", "abcde") << endl;  // e
    cout << Solution().findTheDifference("", "y") << endl;  // y
    cout << Solution().findTheDifference("a", "aa") << endl;  // a
    cout << Solution().findTheDifference("ae", "aea") << endl;  // a

    return 0;
}
