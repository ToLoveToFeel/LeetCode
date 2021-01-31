// Created by WXX on 2021/1/31 23:16
#include <iostream>
#include <vector>

using namespace std;

// 树状数组
class Solution {
public:
    int n = 20001;
    vector<int> tr;

    int lowbit(int x) {
        return x & -x;
    }

    void add(int x, int v) {
        for (int i = x; i <= n; i += lowbit(i)) tr[i] += v;
    }

    int query(int x) {
        int res = 0;
        for (int i = x; i; i -= lowbit(i)) res += tr[i];
        return res;
    }

    vector<int> countSmaller(vector<int> &nums) {
        tr.resize(n + 1);

        vector<int> res(nums.size());
        for (int i = nums.size() - 1; i >= 0; i--) {
            int x = nums[i] + 10001;
            res[i] = query(x - 1);
            add(x, 1);
        }
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

    vector<int> nums = {5, 2, 6, 1};
    OutputBasicArray1D(Solution().countSmaller(nums));  // [2, 1, 1, 0]

    return 0;
}
