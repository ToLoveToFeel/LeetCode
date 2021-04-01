// Created by WXX on 2021/4/1 9:46
#include <iostream>
#include <stack>

using namespace std;

/**
 * 执行用时：12 ms, 在所有 C++ 提交中击败了7.88%的用户
 * 内存消耗：7.1 MB, 在所有 C++ 提交中击败了10.30%的用户
 */
class Solution {
public:
    stack<int> stk;

    int clumsy(int N) {

        stk.push(N);
        for (int i = N - 1, ops = 0; i; i--, ops = (ops + 1) % 4) {
            if (ops == 3) {  // -
                stk.push(-i);
                continue;
            }
            int t = stk.top();
            stk.pop();
            if (ops == 0) stk.push(t * i);  // *
            else if (ops == 1) stk.push(t / i);  // /
            else if (ops == 2) stk.push(t + i);  // +
        }

        int res = 0;
        while (stk.size()) {
            res += stk.top();
            stk.pop();
        }
        return res;
    }
};

int main() {

    cout << Solution().clumsy(4) << endl;  // 7
    cout << Solution().clumsy(10) << endl;  // 12

    return 0;
}
