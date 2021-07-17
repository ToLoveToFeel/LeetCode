// Created by WXX on 2021/7/17 15:22
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

/**
 * 执行用时：56 ms, 在所有 C++ 提交中击败了94.81%的用户
 * 内存消耗：33.7 MB, 在所有 C++ 提交中击败了17.10%的用户
 */
class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        unordered_map<int, int> hash;
        for (auto c : tasks) hash[c]++;
        int maxc = 0, cnt = 0;
        for (auto &[k, v] : hash) maxc = max(maxc, v);
        for (auto &[k, v] : hash)
            if (maxc == v)
                cnt++;
        return max((int)tasks.size(), (maxc - 1) * (n + 1) + cnt);
    }
};

int main() {

    vector<char> tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
    cout << Solution().leastInterval(tasks, 2) << endl;  // 8

    return 0;
}
