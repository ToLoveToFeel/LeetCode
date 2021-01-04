#include <iostream>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：6.2 MB, 在所有 C++ 提交中击败了51.00%的用户
 */
class Solution {
public:
    int fib(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;

        int pp = 0, p = 1, res = 0;
        for (int i = 2; i <= n; i++) {
            res = pp + p;
            pp = p;
            p = res;
        }

        return res;
    }
};

int main() {

    cout << Solution().fib(2) << endl;  // 1
    cout << Solution().fib(3) << endl;  // 2

    return 0;
}
