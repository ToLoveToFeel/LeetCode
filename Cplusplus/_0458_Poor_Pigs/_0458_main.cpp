// Created by WXX on 2021/6/5 15:55
#include <iostream>
#include <cmath>

using namespace std;

/*
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：6.1 MB, 在所有 C++ 提交中击败了23.58%的用户
 */
class Solution {
public:
    int poorPigs(int n, int minutesToDie, int minutesToTest) {
        int k = minutesToTest / minutesToDie;
        return ceil(log(n) / log(k + 1));
    }
};

int main() {

    cout << Solution().poorPigs(1000, 15, 60) << endl;  // 5

    return 0;
}
