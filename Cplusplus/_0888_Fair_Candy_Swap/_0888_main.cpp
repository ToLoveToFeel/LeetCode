// Created by WXX on 2021/2/1 0:14
#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

// A、B交换x,y后，要达到 sumA - x + y = sumB + x - y
// 所以：x = y + (sumA - sumB) / 2
/**
 * 执行用时：116 ms, 在所有 C++ 提交中击败了93.77%的用户
 * 内存消耗：45.6 MB, 在所有 C++ 提交中击败了50.63%的用户
 */
class Solution {
public:
    vector<int> fairCandySwap(vector<int> &A, vector<int> &B) {

        typedef long long LL;
        // 计算各自总和
        LL sumA = 0, sumB = 0;
        for (int x : A) sumA += x;
        for (int y : B) sumB += y;
        // 将A中数据放入哈希表中，方便查找
        unordered_set<int> hash;
        for (auto x : A) hash.insert(x);
        // 遍历B中元素，检查A中是否存在可以交换的元素
        for (auto y : B) {
            int t = y + (sumA - sumB) / 2;
            if (hash.count(t))
                return {t, y};
        }
        return {};
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

    vector<int> A = {1, 1}, B = {2, 2};
    OutputBasicArray1D(Solution().fairCandySwap(A, B));  // [1, 2]

    return 0;
}
