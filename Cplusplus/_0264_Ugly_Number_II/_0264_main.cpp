// Created by WXX on 2021/1/29 20:19
#include <iostream>
#include <vector>

using namespace std;

// 实质：三路归并
// 设丑数的集合为S，则有 S = 2 * S, S = 3 * S, S = 5 * S
/**
 * 执行用时：20 ms, 在所有 C++ 提交中击败了49.56%的用户
 * 内存消耗：9.4 MB, 在所有 C++ 提交中击败了45.12%的用户
 */
class Solution {
public:
    int nthUglyNumber(int n) {

        vector<int> q(1, 1);
        for (int i = 0, j = 0, k = 0; q.size() < n;) {
            int t = min(q[i] * 2, min(q[j] * 3, q[k] * 5));
            q.push_back(t);
            if (q[i] * 2 == t) i++;
            if (q[j] * 3 == t) j++;
            if (q[k] * 5 == t) k++;
        }
        return q.back();
    }
};

int main() {

    cout << Solution().nthUglyNumber(10) << endl;  // 12

    return 0;
}
