// Created by WXX on 2021/4/4 9:18
#include <iostream>
#include <vector>

using namespace std;

// 如果有t只兔子回答num, 则需要加 (t / (num+1))上取整后乘以(num+1)
/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：7.9 MB, 在所有 C++ 提交中击败了98.80%的用户
 */
class Solution {
public:
    int numRabbits(vector<int>& answers) {

        int cnt[1000] = {0};
        for (int x : answers) cnt[x]++;

        int res = 0;
        for (int i = 0; i <= 999; i++)
            res += (cnt[i] + i) / (i + 1) * (i + 1);
        return res;
    }
};

int main() {

    vector<int> answers = {1, 1, 2};
    cout << Solution().numRabbits(answers) << endl;  // 5

    return 0;
}
