// Created by WXX on 2021/7/20 17:25
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：6.2 MB, 在所有 C++ 提交中击败了12.96%的用户
 */
class Solution {
public:
    int sumNums(int n) {
        int res = n;
        n > 0 && (res += sumNums(n - 1));
        return res;
    }
};

int main() {

    cout << Solution().sumNums(3) << endl;  // 6
    cout << Solution().sumNums(9) << endl;  // 45

    return 0;
}
