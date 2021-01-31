// Created by WXX on 2021/1/31 21:13
#include <iostream>
#include <vector>

using namespace std;

// 树状数组
/**
 * 执行用时：468 ms, 在所有 C++ 提交中击败了17.98%的用户
 * 内存消耗：147.2 MB, 在所有 C++ 提交中击败了13.26%的用户
 */
class NumArray {
public:
    int n;
    vector<int> tr, nums;

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

    NumArray(vector<int> &_nums) {

        nums = _nums;
        n = nums.size();
        tr.resize(n + 1);

        // 线性初始化
        for (int i = 1; i <= n; i++) {
            tr[i] = nums[i - 1];
            for (int j = i - 1; j > i - lowbit(i); j -= lowbit(j))
                tr[i] += tr[j];
        }
    }

    void update(int i, int val) {
        add(i + 1, val - nums[i]);
        nums[i] = val;
    }

    int sumRange(int i, int j) {
        i++, j++;
        return query(j) - query(i - 1);
    }
};

int main() {

    vector<int> nums = {1, 3, 5};
    NumArray t = NumArray(nums);
    cout << t.sumRange(0, 2) << endl;  // 9
    t.update(1, 2);
    cout << t.sumRange(0, 2) << endl;  // 8

    return 0;
}
