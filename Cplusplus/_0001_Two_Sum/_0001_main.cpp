#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

/**
 * 执行用时：16 ms, 在所有 C++ 提交中击败了71.49%的用户
 * 内存消耗：9.1 MB, 在所有 C++ 提交中击败了71.40%的用户
 */
class Solution {
public:
    vector<int> twoSum(vector<int> &nums, int target) {

        unordered_map<int, int> hash;  // (元素，元素对应下标)
        for (int i = 0; i < nums.size(); ++i) {
            int r = target - nums[i];
            if (hash.count(r)) return {hash[r], i};
            hash[nums[i]] = i;
        }

        return {};
    }
};

int main() {

    vector<int> nums = {2, 7, 11, 15};
    int target = 9;
    vector<int> res = Solution().twoSum(nums, target);
    for (int index : res) cout << index << " ";

    return 0;
}