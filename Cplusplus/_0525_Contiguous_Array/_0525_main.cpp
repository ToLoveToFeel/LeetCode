// Created by WXX on 2021/6/3 9:24
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

/**
 * 执行用时：192 ms, 在所有 C++ 提交中击败了12.50%的用户
 * 内存消耗：81.8 MB, 在所有 C++ 提交中击败了30.39%的用户
 */
class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        int n = nums.size();
        unordered_map<int, int> hash;  // (1的个数减去0的个数，最小下标)
        hash[0] = 0;
        int res = 0;
        for (int i = 1, one = 0, zero = 0; i <= n; i++) {
            int x = nums[i - 1];
            if (x == 0) zero++;
            else one++;
            int s = one - zero;
            if (hash.count(s)) res = max(res, i - hash[s]);
            else hash[s] = i;
        }
        return res;
    }
};

int main() {



    return 0;
}
