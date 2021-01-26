// Created by WXX on 2021/1/26 19:40
#include <iostream>
#include <vector>

using namespace std;

// 线性筛法
/**
 * 执行用时：80 ms, 在所有 C++ 提交中击败了67.75%的用户
 * 内存消耗：9 MB, 在所有 C++ 提交中击败了45.33%的用户
 */
class Solution {
public:
    int countPrimes(int n) {

        vector<bool> st(n);  // i为合数的话st[i]=true
        vector<int> p;
        for (int i = 2; i < n; i++) {
            if (!st[i]) p.push_back(i);
            for (int j = 0; i * p[j] <= n - 1; j++) {
                st[i * p[j]] = true;
                if (i % p[j] == 0) break;
            }
        }
        return p.size();
    }
};

int main() {

    cout << Solution().countPrimes(10) << endl;  // 4
    cout << Solution().countPrimes(100) << endl;  // 25

    return 0;
}
