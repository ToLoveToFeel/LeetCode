// Created by WXX on 2021/2/14 8:50
#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：7.1 MB, 在所有 C++ 提交中击败了78.35%的用户
 */
class Solution {
public:

    vector<int> p;

    int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    int minSwapsCouples(vector<int>& row) {
        int n = row.size() / 2;
        for (int i = 0; i < n; i++) p.push_back(i);

        int cnt = n;
        for (int i = 0; i < n * 2; i += 2) {
            int a = row[i] / 2, b = row[i + 1] / 2;
            if (find(a) != find(b)) {
                p[find(a)] = find(b);
                cnt--;  // 子图减少一个
            }
        }
        return n - cnt;
    }
};

int main() {

//    vector<int> row = {0, 2, 1, 3};
//    cout << Solution().minSwapsCouples(row) << endl;  // 1
    vector<int> row = {5, 4, 2, 6, 3, 1, 0, 7};
    cout << Solution().minSwapsCouples(row) << endl;  // 2

    return 0;
}
