// Created by WXX on 2021/5/29 14:34
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

/**
 * 执行用时：1720 ms, 在所有 C++ 提交中击败了5.38%的用户
 * 内存消耗：281.4 MB, 在所有 C++ 提交中击败了5.06%的用户
 */
class Solution {
public:
    int subarraySum(vector<int> &nums, int target) {
        int n = nums.size();
        vector<int> s(n + 1);
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] + nums[i - 1];
        unordered_map<int, int> hash;
        hash[0] = 1;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += hash[s[i] - target];
            hash[s[i]]++;
        }
        return res;
    }

    int numSubmatrixSumTarget(vector<vector<int>> &matrix, int target) {
        int n = matrix.size(), m = matrix[0].size();
        int res = 0;
        for (int i = 0; i < n; i++) {  // 枚举上边界
            vector<int> nums(m);
            for (int j = i; j < n; j++) {  // 枚举下边界
                for (int k = 0; k < m; k++)
                    nums[k] += matrix[j][k];
                res += subarraySum(nums, target);
            }
        }
        return res;
    }
};

int main() {

    vector<vector<int>> matrix = {
            {0, 1, 0},
            {1, 1, 1},
            {0, 1, 0},
    };
    cout << Solution().numSubmatrixSumTarget(matrix, 0) << endl;

    return 0;
}
