// Created by WXX on 2021/7/18 16:03
#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

class Solution {
public:
    vector<int> printNumbers(int n) {
        vector<int> res;
        long long num = pow(10, n);
        for (int i = 1; i < num; i++) res.push_back(i);
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

    OutputBasicArray1D(Solution().printNumbers(1));

    return 0;
}
