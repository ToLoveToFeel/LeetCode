// Created by ToLoveToFeel on 2021/3/31 11:07 下午
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：12 ms, 在所有 C++ 提交中击败了44.02%的用户
 * 内存消耗：11.6 MB, 在所有 C++ 提交中击败了59.55%的用户
 */
class Solution {
public:
    vector<int> grayCode(int n) {
        vector<int> res(1, 0);
        while (n--) {
            for (int i = res.size() - 1; i >= 0; i--) {
                res[i] *= 2;
                res.push_back(res[i] + 1);
            }
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

    OutputBasicArray1D(Solution().grayCode(2));

    return 0;
}
