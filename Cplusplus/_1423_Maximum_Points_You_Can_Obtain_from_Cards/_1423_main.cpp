// Created by WXX on 2021/2/6 8:46
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：68 ms, 在所有 C++ 提交中击败了87.28%的用户
 * 内存消耗：41.3 MB, 在所有 C++ 提交中击败了92.33%的用户
 */
class Solution {
public:
    int maxScore(vector<int> &c, int k) {

        int n = c.size();
        int sum = 0, minSum = 0;
        for (int i = 0; i < n - k; i++) minSum += c[i];
        sum = minSum;
        for (int i = n - k; i < n; i++) {
            sum = sum + c[i] - c[i - (n - k)];
            minSum = min(sum, minSum);
        }
        int res = -minSum;
        for (int i = 0; i < n; i++) res += c[i];
        return res;
    }
};

int main() {

    vector<int> c = {1, 2, 3, 4, 5, 6, 1};
    cout << Solution().maxScore(c, 3) << endl;  // 12

    return 0;
}
