// Created by WXX on 2021/7/19 16:26
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int countDigitOne(int n) {

        if (n <= 0) return 0;
        vector<int> nums;
        while (n) nums.push_back(n % 10), n /= 10;
        reverse(nums.begin(), nums.end());  // 为了让nums[0]对应最高位
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            int d = nums[i];
            int left = 0, right = 0, p = 1;  // p存储10的次幂
            for (int j = 0; j < i; j++) left = left * 10 + nums[j];
            for (int j = i + 1; j < nums.size(); j++) {
                right = right * 10 + nums[j];
                p *= 10;
            }
            if (d == 0) res += left * p;
            else if (d == 1) res += left * p + right + 1;
            else res += (left + 1) * p;
        }
        return res;
    }
};

int main() {

    cout << Solution().countDigitOne(1000000000) << endl;  // 900000001

    return 0;
}
