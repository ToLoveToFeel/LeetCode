// Created by WXX on 2021/1/26 10:17
#include <iostream>
#include <vector>

using namespace std;

// C(n, 2) = 1 + 2 + 3 + ... + (n - 1)
/**
 * 执行用时：48 ms, 在所有 C++ 提交中击败了95.08%的用户
 * 内存消耗：19 MB, 在所有 C++ 提交中击败了37.92%的用户
 */
class Solution {
public:
    int numEquivDominoPairs(vector<vector<int>> &dominoes) {

        int hash[100] = {0};
        int res = 0;
        for (auto d : dominoes) {
            int t = d[0] >= d[1] ? d[0] * 10 + d[1] : d[1] * 10 + d[0];
            res += hash[t];
            hash[t]++;
        }
        return res;
    }
};

int main() {

    vector<vector<int>> dominoes = {{1, 2}, {2, 1}, {3, 4}, {5, 6}};
    cout << Solution().numEquivDominoPairs(dominoes) << endl;  // 1

    return 0;
}
