// Created by WXX on 2021/7/7 9:31
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

/**
 * 执行用时：1004 ms, 在所有 C++ 提交中击败了8.00%的用户
 * 内存消耗：177.3 MB, 在所有 C++ 提交中击败了20.34%的用户
 */
class Solution {
public:
    int countPairs(vector<int> &deliciousness) {
        int n = deliciousness.size();
        int mod = 1e9 + 7;

        vector<int> s = vector<int>(22);
        for (int i = 0, p = 1; i < 22; i++) {
            s[i] = p;
            p *= 2;
        }

        int res = 0;
        unordered_map<int, int> hash;  // (数字，出现次数)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 22; j++) {
                int t = s[j] - deliciousness[i];
                res = (res + hash[t]) % mod;
            }
            hash[deliciousness[i]]++;
        }
        return res;
    }
};

int main() {

    vector<int> deliciousness = {1, 3, 5, 7, 9};
    cout << Solution().countPairs(deliciousness) << endl;  // 4

    return 0;
}
