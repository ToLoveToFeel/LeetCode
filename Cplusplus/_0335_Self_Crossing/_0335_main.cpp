// Created by WXX on 2021/2/25 20:15
#include <iostream>
#include <vector>

using namespace std;

// 找规律
class Solution {
public:
    bool isSelfCrossing(vector<int> &x) {

        int n = x.size();
        if (n <= 3) return false;
        for (int i = 3; i < n; i++) {
            // 4条连续线才相交
            if (x[i - 1] <= x[i - 3] && x[i] >= x[i - 2]) return true;
            // 5条连续线才相交
            if (i >= 4 && x[i - 3] == x[i - 1] && x[i] + x[i - 4] >= x[i - 2]) return true;
            // 6条连续线才相交
            if (i >= 5 && x[i - 3] >= x[i - 1] && x[i - 1] + x[i - 5] >= x[i - 3]
                && x[i - 2] >= x[i - 4] && x[i - 4] + x[i] >= x[i - 2])
                return true;
        }
        return false;
    }
};

int main() {

    vector<int> x = {2, 1, 1, 2};
    cout << Solution().isSelfCrossing(x) << endl;  // true

    return 0;
}
