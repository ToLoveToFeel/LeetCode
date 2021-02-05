// Created by WXX on 2021/2/5 8:13
#include <iostream>

using namespace std;

/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了79.74%的用户
 * 内存消耗：7.9 MB, 在所有 C++ 提交中击败了34.26%的用户
 */
class Solution {
public:
    int equalSubstring(string s, string t, int maxCost) {

        int n = s.size();
        int cost[n];
        for (int i = 0; i < n; i++) cost[i] = abs(s[i] - t[i]);

        int res = 0;
        for (int i = 0, j = 0, sum = 0; i < n; i++) {  // [j, i]
            sum += cost[i];
            while (sum > maxCost) sum -= cost[j++];
            res = max(res, i - j + 1);
        }
        return res;
    }
};

int main() {

    cout << Solution().equalSubstring("abcd", "bcdf", 3) << endl;  // 3
    return 0;
}
