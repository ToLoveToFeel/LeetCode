// Created by WXX on 2021/7/25 10:06
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

/**
 * 执行用时：356 ms, 在所有 C++ 提交中击败了96.64%的用户
 * 内存消耗：109.8 MB, 在所有 C++ 提交中击败了81.88%的用户
 */
class Solution {
public:
    vector<int> restoreArray(vector<vector<int>> &aps) {
        unordered_map<int, vector<int>> hash;
        for (auto &e : aps) {
            hash[e[0]].push_back(e[1]);
            hash[e[1]].push_back(e[0]);
        }

        int n = aps.size() + 1;  // 数组中元素的个数
        vector<int> res(n);
        for (auto &[k, v] : hash)
            if (v.size() == 1) {
                res[0] = k;
                break;
            }
        res[1] = hash[res[0]][0];
        for (int i = 2; i < n; i++) {
            // t : res[i - 1] -> {res[i-2], res[i]}
            auto t = hash[res[i - 1]];
            if (res[i - 2] == t[0]) res[i] = t[1];
            else res[i] = t[0];
        }
        return res;
    }
};

void OutputBasicArray1D(vector<int> nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    vector<vector<int>> aps = {
            {2, 1},
            {3, 4},
            {3, 2}
    };
    OutputBasicArray1D(Solution().restoreArray(aps));  // [4, 3, 2, 1]

    return 0;
}
