// Created by WXX on 2021/6/4 10:55
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * 执行用时：32 ms, 在所有 C++ 提交中击败了64.80%的用户
 * 内存消耗：17.2 MB, 在所有 C++ 提交中击败了5.28%的用户
 */
class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        int res = 0;
        for (int i = 0, j = 0; i < g.size() && j < s.size(); j++)
            if (g[i] <= s[j]) {
                i++;
                res++;
            }
        return res;
    }
};

int main() {

    vector<int> g = {1, 2, 3}, s = {1, 1};
    cout << Solution().findContentChildren(g, s)  << endl;  // 1

    return 0;
}
