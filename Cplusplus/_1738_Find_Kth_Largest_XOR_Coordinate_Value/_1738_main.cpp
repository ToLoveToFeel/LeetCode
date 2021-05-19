// Created by WXX on 2021/5/19 9:01
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class Solution {
public:
    int kthLargestValue(vector<vector<int>> &matrix, int k) {

        int n = matrix.size(), m = matrix[0].size();
        vector<vector<int>> s(n + 1, vector<int>(m + 1));
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                s[i][j] = s[i - 1][j] ^ s[i][j - 1] ^ s[i - 1][j - 1] ^ matrix[i - 1][j - 1];

        priority_queue<int, vector<int>, greater<int>> heap;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                heap.push(s[i][j]);
                if (heap.size() > k) heap.pop();
            }
        return heap.top();
    }
};

int main() {

    vector<vector<int>> matrix = {
            {5, 2},
            {1, 6},
    };
    cout << Solution().kthLargestValue(matrix, 1) << endl;  // 7
    cout << Solution().kthLargestValue(matrix, 2) << endl;  // 5
    cout << Solution().kthLargestValue(matrix, 3) << endl;  // 4
    cout << Solution().kthLargestValue(matrix, 4) << endl;  // 0

    return 0;
}
