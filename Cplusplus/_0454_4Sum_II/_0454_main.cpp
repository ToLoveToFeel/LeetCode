// Created by WXX on 2021/6/4 10:35
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

/**
 * 执行用时：240 ms, 在所有 C++ 提交中击败了70.34%的用户
 * 内存消耗：23.7 MB, 在所有 C++ 提交中击败了66.60%的用户
 */
class Solution {
public:
    int fourSumCount(vector<int>& A, vector<int>& B, vector<int>& C, vector<int>& D) {
        unordered_map<int, int > hash;
        for (auto c : C)
            for (auto d : D)
                hash[c + d]++;
        int res = 0;
        for (int a : A)
            for (int b : B)
                res += hash[-(a + b)];
        return res;
    }
};

int main() {

    vector<int> A = {1, 2}, B = {-2, -1}, C = {-1, 2}, D = {0, 2};
    cout << Solution().fourSumCount(A, B, C, D) << endl;  // 2

    return 0;
}
