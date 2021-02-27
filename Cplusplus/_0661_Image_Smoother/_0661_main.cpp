// Created by WXX on 2021/2/27 22:20
#include <iostream>
#include <vector>

using namespace std;

// 卷积操作，可以用二维前缀和
class Solution {
public:
    vector<vector<int>> imageSmoother(vector<vector<int>> &M) {

        int n = M.size(), m = M[0].size();
        vector<vector<int>> res = M;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                int s = 0, c = 0;
                for (int x = i - 1; x <= i + 1; x++)
                    for (int y = j - 1; y <= j + 1; y++)
                        if (x >= 0 && x < n && y >= 0 && y < m)
                            s += M[x][y], c++;
                res[i][j] = s / c;
            }
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

    vector<vector<int>> M = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
    };
    OutputBasicArray2D(Solution().imageSmoother(M));

    return 0;
}
