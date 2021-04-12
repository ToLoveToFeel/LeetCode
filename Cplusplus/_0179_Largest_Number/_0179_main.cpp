// Created by WXX on 2021/4/12 10:40
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * 执行用时：12 ms, 在所有 C++ 提交中击败了71.50%的用户
 * 内存消耗：10.8 MB, 在所有 C++ 提交中击败了62.85%的用户
 */
class Solution {
public:
    string largestNumber(vector<int> &nums) {
        sort(nums.begin(), nums.end(), [](int x, int y){
            string a = to_string(x), b = to_string(y);
            return a + b > b + a;
        });
        string res;
        for (auto x : nums) res += to_string(x);
        int k = 0;  // 去掉前导0
        while (k + 1 < res.size() && res[k] == '0') k++;
        return res.substr(k);
    }
};

int main() {

    vector<int> nums = {10, 2};
    cout << Solution().largestNumber(nums) << endl;

    return 0;
}
