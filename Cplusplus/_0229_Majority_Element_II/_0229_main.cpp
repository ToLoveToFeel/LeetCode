// Created by WXX on 2021/5/4 16:54
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> majorityElement(vector<int> &nums) {

        int r1, r2, c1 = 0, c2 = 0;  // r存储值, c存储值出现次数
        for (auto x : nums) {
            if (c1 && r1 == x) c1++;
            else if (c2 && r2 == x) c2++;
            else if (!c1) r1 = x, c1++;
            else if (!c2) r2 = x, c2++;
            else c1--, c2--;  // 两个仓库都非空，并且存储的值都不等于x
        }

        c1 = 0, c2 = 0;  // 使用c统计r出现的次数
        for (auto x : nums) {
            if (x == r1) c1++;
            else if (x == r2) c2++;
        }

        vector<int> res;
        int n = nums.size();
        if (c1 > n / 3) res.push_back(r1);
        if (c2 > n / 3) res.push_back(r2);

        return res;
    }
};

void OutputBasicArray1D(vector<int> nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    vector<int> nums = {3, 2, 3};
    OutputBasicArray1D(Solution().majorityElement(nums));  // [3]

    return 0;
}
