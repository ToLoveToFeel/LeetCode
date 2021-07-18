// Created by WXX on 2021/7/18 14:28
#include <iostream>

using namespace std;

class Solution {
public:
    string replaceSpace(string s) {
        string res = "";
        for (auto c : s)
            if (c == ' ') res += "%20";
            else res += c;
        return res;
    }
};

int main() {

    cout << Solution().replaceSpace("We are happy.") << endl;  // We%20are%20happy.

    return 0;
}
