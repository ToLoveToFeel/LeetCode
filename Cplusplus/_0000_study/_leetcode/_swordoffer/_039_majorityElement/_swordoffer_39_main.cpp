// Created by WXX on 2021/7/19 15:17
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int r = 0, c = 0;
        for (int x : nums) {
            if (!c) r = x, c = 1;
            else if (x == r) c++;
            else c--;
        }
        return r;
    }
};

int main() {

    vector<int> nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
    cout << Solution().majorityElement(nums) << endl;  // 2

    return 0;
}
