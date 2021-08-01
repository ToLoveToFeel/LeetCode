// Created by WXX on 2021/8/1 11:12
#include <iostream>
#include <vector>
#include <stack>

using namespace std;

class Solution {
public:
    bool validateStackSequences(vector<int> &pushed, vector<int> &popped) {
        stack<int> stk;
        for (int i = 0, j = 0; i < pushed.size(); i++) {
            stk.push(pushed[i]);
            while (stk.size() && stk.top() == popped[j]) stk.pop(), j++;
        }
        return stk.empty();
    }
};

int main() {

    vector<int> pushed = {1, 2, 3, 4, 5}, poped = {4, 5, 3, 2, 1};
    cout << Solution().validateStackSequences(pushed, poped);  // true

    return 0;
}
