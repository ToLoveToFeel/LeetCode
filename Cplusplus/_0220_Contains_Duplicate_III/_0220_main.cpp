// Created by WXX on 2021/4/17 16:31
#include <iostream>
#include <vector>
#include <set>

using namespace std;

/**
 * 执行用时：68 ms, 在所有 C++ 提交中击败了9.35%的用户
 * 内存消耗：18.2 MB, 在所有 C++ 提交中击败了7.09%的用户
 */
class Solution {
public:
    typedef long long LL;

    bool containsNearbyAlmostDuplicate(vector<int> &nums, int k, int t) {

        multiset<LL> S;
        for (int i = 0; i < nums.size(); i++) {
            LL x = (LL) nums[i] - t;
            LL y = (LL) nums[i] + t;
            if (S.lower_bound(x) != S.end() && *S.lower_bound(x) <= y) return true;
            S.insert(nums[i]);
            if (S.size() == k + 1) S.erase(S.find(nums[i - k]));
        }
        return false;
    }
};

int main() {

    vector<int> nums = {-2147483648, -2147483647};
    cout << Solution().containsNearbyAlmostDuplicate(nums, 3, 3) << endl;  // 1

    return 0;
}
