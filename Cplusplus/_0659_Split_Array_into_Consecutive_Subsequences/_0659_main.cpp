// Created by WXX on 2021/2/27 22:02
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

/**
 * 执行用时：100 ms, 在所有 C++ 提交中击败了99.51%的用户
 * 内存消耗：57 MB, 在所有 C++ 提交中击败了81.69%的用户
 */
class Solution {
public:
    bool isPossible(vector<int> &nums) {
        // cnt1存储每个数出现的次数, cnt2存储存不存在以某个数结尾的链
        unordered_map<int, int> cnt1, cnt2;
        for (auto x : nums) cnt1[x]++;
        for (auto x : nums) {
            if (!cnt1[x]) continue;
            if (cnt2[x - 1]) {
                cnt2[x - 1]--;
                cnt2[x]++;
                cnt1[x]--;
            } else if (cnt1[x + 1] && cnt1[x + 2]) {  // 新开一个链，消耗三个数
                cnt2[x + 2]++;
                cnt1[x]--, cnt1[x + 1]--, cnt1[x + 2]--;
            } else return false;
        }
        return true;
    }
};

int main() {

    vector<int> nums = {1, 2, 3, 3, 4, 5};
    cout << Solution().isPossible(nums) << endl;  // true

    return 0;
}
