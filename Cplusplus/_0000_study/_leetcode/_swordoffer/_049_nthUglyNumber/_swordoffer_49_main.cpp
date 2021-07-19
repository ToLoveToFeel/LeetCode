// Created by WXX on 2021/7/19 19:42
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：12 ms, 在所有 C++ 提交中击败了51.63%的用户
 * 内存消耗：9.4 MB, 在所有 C++ 提交中击败了26.36%的用户
 */
class Solution {
public:
    int nthUglyNumber(int n) {
        vector<int> q(1, 1);
        for (int i = 0, j = 0, k = 0; q.size() < n; ) {
            int t = min(q[i] * 2, min(q[j] * 3, q[k] * 5));
            q.push_back(t);
            if (t == q[i] * 2) i++;
            if (t == q[j] * 3) j++;
            if (t == q[k] * 5) k++;
        }
        return q.back();
    }
};

int main() {

    cout << Solution().nthUglyNumber(10) << endl;  // 12

    return 0;
}
