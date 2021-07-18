// Created by WXX on 2021/7/18 10:40
#include <iostream>
#include <vector>
#include <stack>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了97.97%的用户
 * 内存消耗：14.7 MB, 在所有 C++ 提交中击败了68.28%的用户
 */
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

    vector<int> pushed = {1, 2, 3, 4, 5}, popped = {4, 5, 3, 2, 1};
    cout << Solution().validateStackSequences(pushed, popped) << endl;  // true

    return 0;
}
