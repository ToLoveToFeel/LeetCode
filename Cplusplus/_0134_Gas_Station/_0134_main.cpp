// Created by WXX on 2021/1/25 22:50
#include <iostream>
#include <vector>

using namespace std;

// 核心：只要最终剩余的油量大于等于0就有解
//      出发的位置是在过程中油量最低的位置的下一个站台
/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了90.63%的用户
 * 内存消耗：9.6 MB, 在所有 C++ 提交中击败了98.60%的用户
 */
class Solution {
public:
    int canCompleteCircuit(vector<int> &gas, vector<int> &cost) {

        int left = 0;  // left: 最终剩余油量
        int minLeft = INT_MAX, index;  // index: 剩余油量最小的站台索引，minLeft: 在此站台剩余油量
        for (int i = 0; i < gas.size(); i++) {
            left += gas[i] - cost[i];
            if (left < minLeft) minLeft = left, index = i;
        }
        return left < 0 ? -1 : (index + 1) % gas.size();
    }
};

int main() {

//    vector<int> gas = {1, 2, 3, 4, 5};
//    vector<int> cost = {3, 4, 5, 1, 2};
//    cout << Solution().canCompleteCircuit(gas, cost) << endl;  // 3

    vector<int> gas = {4, 5, 1, 2, 3};
    vector<int> cost = {1, 2, 3, 4, 5};
    cout << Solution().canCompleteCircuit(gas, cost) << endl;  // 0

    return 0;
}
