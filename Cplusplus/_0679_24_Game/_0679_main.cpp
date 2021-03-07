// Created by WXX on 2021/3/7 20:00
#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

// 暴搜
class Solution {
public:
    bool judgePoint24(vector<int> &nums) {
        vector<double> a(nums.begin(), nums.end());
        return dfs(a);
    }

    // 返回删除nums[i], nums[j]且添加x后的vector
    vector<double> get(vector<double> nums, int i, int j, double x) {
        vector<double> res;
        for (int k = 0; k < nums.size(); k++)
            if (k != i && k != j)
                res.push_back(nums[k]);
        res.push_back(x);
        return res;
    }

    bool dfs(vector<double> nums) {
        if (nums.size() == 1) return fabs(nums[0] - 24) < 1e-8;
        for (int i = 0; i < nums.size(); i++)
            for (int j = 0; j < nums.size(); j++)
                if (i != j) {
                    double a = nums[i], b = nums[j];
                    if (dfs(get(nums, i, j, a + b))) return true;
                    if (dfs(get(nums, i, j, a - b))) return true;
                    if (dfs(get(nums, i, j, a * b))) return true;
                    if (b && dfs(get(nums, i, j, a / b))) return true;
                }
        return false;
    }
};

int main() {

    vector<int> nums = {4, 1, 8, 7};
    cout << Solution().judgePoint24(nums) << endl;  // true

    return 0;
}
