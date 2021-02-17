// Created by WXX on 2021/2/17 9:06
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> matrixReshape(vector<vector<int>> &nums, int r, int c) {
        int n = nums.size(), m = nums[0].size();
        if (n * m != r * c) return nums;
        vector<vector<int>> res(r, vector<int>(c));
        for (int i = 0; i < n * m; i++)
            res[i / c][i % c] = nums[i / m][i % m];
        return res;
    }
};

void OutputBasicArray2D(vector<vector<int>> nums) {

    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        if (i > 0 && i < nums.size()) cout << ' ';
        cout << "[";
        for (int j = 0; j < nums[i].size(); j++) {
            cout << nums[i][j];
            if (j != nums[i].size() - 1) cout << ", ";
        }
        cout << "]";
        if (i != nums.size() - 1) cout << ", " << endl;
    }
    cout << "]" << endl;
}

int main() {

    vector<vector<int>> nums = {{1, 2},
                                {3, 4}};
    OutputBasicArray2D(Solution().matrixReshape(nums, 1, 4));  // [[1, 2, 3, 4]]

    return 0;
}
