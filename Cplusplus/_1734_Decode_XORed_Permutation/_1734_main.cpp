// Created by WXX on 2021/5/11 10:05
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：204 ms, 在所有 C++ 提交中击败了14.34%的用户
 * 内存消耗：95.6 MB, 在所有 C++ 提交中击败了93.63%的用户
 */
class Solution {
public:
    vector<int> decode(vector<int> &encoded) {

        int n = encoded.size() + 1;
        vector<int> res(n);
        for (int i = 1; i <= n; i++) res[0] ^= i;
        for (int i = 1; i < n - 1; i += 2) res[0] ^= encoded[i];

        for (int i = 1; i < n; i++) res[i] = res[i - 1] ^ encoded[i - 1];
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

    vector<int> encoded = {6, 5, 4, 6};
    OutputBasicArray1D(Solution().decode(encoded));

    return 0;
}
