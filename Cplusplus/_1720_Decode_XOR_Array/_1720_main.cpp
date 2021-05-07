// Created by WXX on 2021/5/6 8:50
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：32 ms, 在所有 C++ 提交中击败了72.93%的用户
 * 内存消耗：25.4 MB, 在所有 C++ 提交中击败了31.65%的用户
 */
class Solution {
public:
    vector<int> decode(vector<int>& encoded, int first) {
        vector<int> res;
        res.push_back(first);
        for (int x : encoded) res.push_back(res.back() ^ x);
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

    vector<int> encoded = {1, 2, 3};
    OutputBasicArray1D(Solution().decode(encoded, 1));  // [1, 0, 2, 1]

    return 0;
}
