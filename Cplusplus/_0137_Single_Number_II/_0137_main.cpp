// Created by WXX on 2021/1/26 14:24
#include <iostream>
#include <vector>

using namespace std;

// 该类题目套路：真值表化简(数字电路)，了解即可
class Solution {
public:
    int singleNumber(vector<int> &nums) {

        int two = 0, one = 0;
        for (auto x : nums) {
            one = (one ^ x) & ~two;
            two = (two ^ x) & ~one;
        }
        return one;
    }
};

int main() {

    vector<int> nums = {2, 2, 1, 2};
    cout << Solution().singleNumber(nums) << endl;  // 1

    return 0;
}
