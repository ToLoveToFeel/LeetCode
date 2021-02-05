// Created by WXX on 2021/2/5 8:13
#include <iostream>

using namespace std;

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
