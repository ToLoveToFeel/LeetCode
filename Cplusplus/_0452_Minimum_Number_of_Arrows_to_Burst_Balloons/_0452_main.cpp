// Created by WXX on 2021/6/4 9:59
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int findMinArrowShots(vector<vector<int>> &p) {
        if (p.empty()) return 0;
        sort(p.begin(), p.end(), [](vector<int> a, vector<int> b) {
            return a[1] < b[1];
        });
        int res = 1, r = p[0][1];
        for (int i = 1; i < p.size(); i++)
            if (p[i][0] > r) {
                res++;
                r = p[i][1];
            }
        return res;
    }
};

int main() {

    vector<vector<int>> p = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
    cout << Solution().findMinArrowShots(p) << endl;  // 2

    return 0;
}
