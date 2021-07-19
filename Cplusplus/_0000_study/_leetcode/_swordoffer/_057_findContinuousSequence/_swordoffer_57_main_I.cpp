// Created by WXX on 2021/7/19 21:45
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：6.6 MB, 在所有 C++ 提交中击败了41.65%的用户
 */
class Solution {
public:
    vector<vector<int>> findContinuousSequence(int target) {
        vector<vector<int>> res;
        for (int i = 1, j = 1, s = 1; i <= target / 2; i++) {
            while (s < target) s += ++j;
            if (s == target && j - i > 0) {
                vector<int> line;
                for (int k = i; k <= j; k++) line.push_back(k);
                res.push_back(line);
            }
            s -= i;
        }
        return res;
    }
};

void OutputBasicArray2D1(vector<vector<int>> nums) {

    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << "[";
        for (int j = 0; j < nums[i].size(); j++) {
            cout << nums[i][j];
            if (j != nums[i].size() - 1) cout << ", ";
        }
        cout << "]";
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    OutputBasicArray2D1(Solution().findContinuousSequence(15));

    return 0;
}
