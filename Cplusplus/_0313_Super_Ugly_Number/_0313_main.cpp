// Created by WXX on 2021/1/31 22:52
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

// 多路归并
/**
 * 执行用时：84 ms, 在所有 C++ 提交中击败了92.67%的用户
 * 内存消耗：8.5 MB, 在所有 C++ 提交中击败了94.34%的用户
 */
class Solution {
public:
    int nthSuperUglyNumber(int n, vector<int>& primes) {

        // (指针对应的数 * 该指针指向的质数，指针下标)
        // 比如：初始，指针都指向0，q[0] = 1, (q[0]*x, 0)
        typedef pair<int, int> PII;
        priority_queue<PII, vector<PII>, greater<PII>> heap;  // 小顶堆
        // 刚开始primes.size()个指针下标都指向0
        for (int x : primes) heap.push({x, 0});

        vector<int> q(n);
        q[0] = 1;
        for (int i = 1; i < n;) {
            auto t = heap.top(); heap.pop();
            if (t.first != q[i - 1]) q[i++] = t.first;
            int idx = t.second, p = t.first / q[idx];
            heap.push({p * q[idx + 1], idx + 1});
        }
        return q[n - 1];
    }
};

int main() {

    int n = 12;
    vector<int> primes = {2, 7, 13, 19};
    cout << Solution().nthSuperUglyNumber(n, primes) << endl;  // 32

    return 0;
}
