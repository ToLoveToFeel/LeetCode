#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

/**
 * 执行用时：28 ms, 在所有 C++ 提交中击败了98.35%的用户
 * 内存消耗：26.8 MB, 在所有 C++ 提交中击败了45.98%的用户
 */
class Solution {
public:
    vector<int> addToArrayForm(vector<int> &A, int K) {

        vector<int> res;
        int t = 0, i = A.size() - 1;
        while (i >= 0 || K || t) {
            if (i >= 0) t += A[i--];
            if (K) t += K % 10, K /= 10;
            res.push_back(t % 10);
            t /= 10;
        }
        reverse(res.begin(), res.end());

        return res;
    }
};

void OutputBasicArray1D(vector<int> &nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

//    // [1, 2, 3, 4]
//    vector<int> A = {1, 2, 0, 0};
//    int K = 34;
//    vector<int> res = Solution().addToArrayForm(A, K);
//    OutputBasicArray1D(res);

//    // [4, 5, 5]
//    vector<int> A = {2, 7, 4};
//    int K = 181;
//    vector<int> res = Solution().addToArrayForm(A, K);
//    OutputBasicArray1D(res);

    // [1, 0, 2, 1]
    vector<int> A = {2, 1, 5};
    int K = 806;
    vector<int> res = Solution().addToArrayForm(A, K);
    OutputBasicArray1D(res);

//    // [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//    vector<int> A = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
//    int K = 1;
//    vector<int> res = Solution().addToArrayForm(A, K);
//    OutputBasicArray1D(res);

    return 0;
}