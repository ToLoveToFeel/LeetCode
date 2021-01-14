#include <iostream>
#include <vector>

using namespace std;

/**
 * 秦九韶算法
 * 执行用时：8 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：13.1 MB, 在所有 C++ 提交中击败了99.77%的用户
 */
class Solution {
public:
    vector<bool> prefixesDivBy5(vector<int> &A) {

        vector<bool> res;
        int t = 0;
        for (auto num : A) {
            t = (t * 2 + num) % 5;
            res.push_back(!t);
        }
        return res;
    }
};

void OutputBasicArray1D(vector<bool> &nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    vector<int> A = {0, 1, 1, 1, 1, 1};
    vector<bool> res = Solution().prefixesDivBy5(A);
    OutputBasicArray1D(res);

    return 0;
}