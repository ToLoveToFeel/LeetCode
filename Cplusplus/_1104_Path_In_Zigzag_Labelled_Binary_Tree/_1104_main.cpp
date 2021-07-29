// Created by WXX on 2021/7/29 9:36
#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：6.4 MB, 在所有 C++ 提交中击败了9.01%的用户
 */
class Solution {
public:
    vector<int> pathInZigZagTree(int t) {
        int p[25];  // 存储2^i
        p[0] = 1;
        for (int i = 1; i < 25; i++) p[i] = p[i - 1] * 2;

        int n = log(t) / log(2) + 1;  // 当前t位于第n层
        vector<int> res(1, t);
        while (n > 1) {
            t = p[n - 2] + p[n - 1] - 1 - t / 2;
            res.push_back(t);
            n--;
        }
        reverse(res.begin(), res.end());
        return res;
    }
};

int main() {

    OutputBasicArray1D(Solution().pathInZigZagTree(14));  // [1, 3, 4, 14]

    return 0;
}
