#include <iostream>
#include <vector>

using namespace std;

const int N = 1010;

int p[N];

int find(int x) {
    if (x != p[x]) p[x] = find(p[x]);
    return p[x];
}
/**
 * 执行用时：12 ms, 在所有 C++ 提交中击败了69.40%的用户
 * 内存消耗：8.4 MB, 在所有 C++ 提交中击败了62.15%的用户
 */
class Solution {
public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {

        for (int i = 1; i <= edges.size(); i++) p[i] = i;  // 并查集初始化

        for (vector<int> e : edges) {
            int a = find(e[0]), b = find(e[1]);
            if (a != b) p[a] = b;  // 如果顶点edge[0]和edge[1]不在一个连通分量中，则合并
            else return e;  // 如果顶点edge[0]和edge[1]在一个连通分量中，则说明出现环，返回即可
        }

        return {};
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

//    vector<vector<int>> edges = {{1, 2}, {1, 3}, {2, 3}};  // [2, 3]
    vector<vector<int>> edges = {{4, 2}, {2, 3}, {3, 4}, {1, 2}, {3, 5}, {1, 6}, {6, 7}};  // [3, 4]
    vector<int> res = Solution().findRedundantConnection(edges);
    OutputBasicArray1D(res);

    return 0;
}
