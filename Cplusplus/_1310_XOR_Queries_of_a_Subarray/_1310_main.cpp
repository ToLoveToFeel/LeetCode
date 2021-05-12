// Created by WXX on 2021/5/12 10:04
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：80 ms, 在所有 C++ 提交中击败了63.53%的用户
 * 内存消耗：32 MB, 在所有 C++ 提交中击败了32.15%的用户
 */
class Solution {
public:
    vector<int> xorQueries(vector<int> &arr, vector<vector<int>> &queries) {
        int n = arr.size();
        vector<int> s(n + 1, 0);
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] ^ arr[i - 1];

        vector<int> res;
        for (int i = 0; i < queries.size(); i++) {
            int l = queries[i][0] + 1, r = queries[i][1] + 1;
            res.push_back(s[r] ^ s[l - 1]);
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

    vector<int> arr = {1, 3, 4, 8};
    vector<vector<int>> queries = {
            {0, 1},
            {1, 2},
            {0, 3},
            {3, 3},
    };
    OutputBasicArray1D(Solution().xorQueries(arr, queries));  // [2, 7, 14, 8]

    return 0;
}
