// Created by WXX on 2021/2/14 8:50
#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

const int N = 32;  // 最多60个人，30对情侣

int p[N], cnt[N];

int find(int x) {
    if (p[x] != x) p[x] = find(p[x]);
    return p[x];
}

/**
 * 思路：对每组情侣进行编号，那么组编号与情侣的对应关系为：
 * 0 : [0, 1]    1 : [2, 3]    2 : [4, 5]    3 : [6, 7]    4 : [8, 9]    5 : [10, 11] ......
 * 从前向后两两考虑，如果是情侣，直接跳过，如果不是情侣，合并这两个人所在的组。
 * 最后计算每个连通分量情侣组数(设为n)，则该组内交换n-1次就可让所有情侣坐在一起。
 *
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：7.2 MB, 在所有 C++ 提交中击败了69.94%的用户
 */
class Solution {
public:
    int minSwapsCouples(vector<int> &row) {

        int n = row.size() / 2;  // 情侣组数
        for (int i = 0; i < n; i++) p[i] = i, cnt[i] = 1;  // 并查集初始化
        for (int i = 0; i < row.size(); i += 2) {
            int a = row[i] / 2, b = row[i + 1] / 2;
            if (a == b) continue;  // 是情侣，不需要处理
            a = find(a), b = find(b);
            if (a != b) p[a] = b, cnt[b] += cnt[a];
        }

        int res = 0;
        unordered_set<int> hash;  // 为了防止重复计算
        for (int i : row) {
            int r = find(i / 2);
            if (!hash.count(r)) {
                res += cnt[r] - 1;
                hash.insert(r);
            }
        }
        return res;
    }
};

int main() {

//    vector<int> row = {0, 2, 1, 3};
//    cout << Solution().minSwapsCouples(row) << endl;  // 1
    vector<int> row = {5, 4, 2, 6, 3, 1, 0, 7};
    cout << Solution().minSwapsCouples(row) << endl;  // 2

    return 0;
}
