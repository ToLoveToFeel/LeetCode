// Created by WXX on 2021/4/6 9:07
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了57.79%的用户
 * 内存消耗：10.6 MB, 在所有 C++ 提交中击败了67.36%的用户
 */
class Solution {
public:
    int removeDuplicates(vector<int> &a) {

        int k = 0;  // [0, k)是需要保留的
        for (int i = 0; i < a.size(); i++)
            if (k - 2 < 0 || a[i] != a[k - 2])
                a[k++] = a[i];
        return k;
    }
};

int main() {

    vector<int> a = {1, 1, 1, 2, 2, 3};
    cout << Solution().removeDuplicates(a) << endl;  // 5

    return 0;
}
