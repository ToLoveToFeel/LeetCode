// Created by WXX on 2021/4/22 20:05
#include <iostream>
#include <stack>

using namespace std;

class Solution {
public:
    bool isValid(string s) {

        stack<int> stk;
        for (auto c : s) {
            if (c == '(' || c == '[' || c == '{') stk.push(c);
            else {
                if (stk.size() && abs(stk.top() - c) <= 2) stk.pop();
                else return false;
            }
        }
        return stk.empty();
    }
};

int main() {

    cout << Solution().isValid("[()]{}") << endl;

    return 0;
}
