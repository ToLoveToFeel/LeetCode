// Created by WXX on 2021/1/25 9:58
#include <iostream>
#include <vector>

using namespace std;

const int N = 35;

int p[N * N * 4], cnt;

int find(int x) {
    if (p[x] != x) p[x] = find(p[x]);
    return p[x];
}

void merge(int a, int b) {
    a = find(a), b = find(b);
    if (a != b) {
        p[a] = b;
        cnt--;
    }
}

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：9.1 MB, 在所有 C++ 提交中击败了100.00%的用户
 */
class Solution {
public:
    int regionsBySlashes(vector<string> &grid) {

        int n = grid.size();
        // 每个方格可以划分成四个小三角形，上右下左分别编号：0,1,2,3
        cnt = n * n * 4;  // 初始连通分量个数
        for (int i = 0; i < cnt; i++) p[i] = i;  // 初始化并查集

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int id = i * n + j;
                // 处理格子之间的情况
                // 说明不是最后一行，id下方的小三角形可以与 id下面的格子中上方的小三角形连通
                if (i < n - 1) merge(id * 4 + 2, (id + n) * 4 + 0);
                // 说明不是最后一列，id右侧的小三角形可以与 id右边的格子中左侧的小三角形连通
                if (j < n - 1) merge(id * 4 + 1, (id + 1) * 4 + 3);

                // 处理格子内部的情况
                if (grid[i][j] == '/') {
                    merge(id * 4 + 0, id * 4 + 3);  // 上、左
                    merge(id * 4 + 1, id * 4 + 2);  // 右、下
                } else if (grid[i][j] == '\\') {
                    merge(id * 4 + 0, id * 4 + 1);  // 上、右
                    merge(id * 4 + 2, id * 4 + 3);  // 下、左
                } else {
                    merge(id * 4 + 0, id * 4 + 1);  // 上、右
                    merge(id * 4 + 1, id * 4 + 2);  // 右、下
                    merge(id * 4 + 2, id * 4 + 3);  // 下、左
                }
            }
        }
        return cnt;
    }
};

int main() {

//    vector<string> grid = {" /", "/ "};  // 2
//    vector<string> grid = {" /"};  // 1
//    vector<string> grid = {"\\/", "/\\"};  // 4
    vector<string> grid = {"/\\", "\\/"};  // 5
    cout << Solution().regionsBySlashes(grid) << endl;

    return 0;
}