// Created by WXX on 2021/7/2 9:48
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int maxIceCream(vector<int> &costs, int coins) {
        int n = costs.size();
        sort(costs.begin(), costs.end());
        int cnt = 0;
        while (cnt < n && costs[cnt] <= coins) coins -= costs[cnt++];
        return cnt;
    }
};

int main() {

    vector<int> costs = {1, 3, 2, 4, 1};
    cout << Solution().maxIceCream(costs, 7) << endl;  // 4

    return 0;
}
