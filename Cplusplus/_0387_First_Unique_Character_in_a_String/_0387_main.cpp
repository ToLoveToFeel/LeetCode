// Created by WXX on 2021/5/30 10:03
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：24 ms, 在所有 C++ 提交中击败了81.07%的用户
 * 内存消耗：10.3 MB, 在所有 C++ 提交中击败了84.86%的用户
 */
class Solution {
public:
    int firstUniqChar(string s) {
        vector<int> f(26, 0);
        for (auto c : s) f[c - 'a']++;
        for (int i = 0; i < s.size(); i++)
            if (f[s[i] - 'a'] == 1)
                return i;
        return -1;
    }
};

int main() {


    return 0;
}
