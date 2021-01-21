#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

const int N = 1010;

int p[N];  // 并查集

int find(int x) {
    if (p[x] != x) p[x] = find(p[x]);
    return p[x];
}

/**
 * 执行用时：72 ms, 在所有 C++ 提交中击败了73.13%的用户
 * 内存消耗：10 MB, 在所有 C++ 提交中击败了100.00%的用户
 */
class Solution {
public:
    vector<vector<int>> findCriticalAndPseudoCriticalEdges(int n, vector<vector<int>> &edges) {

        for (int i = 0; i < n; i++) p[i] = i;  // 并查集初始化

        int m = edges.size();  // 边数
        for (int i = 0; i < m; i++) edges[i].push_back(i);  // 记录边所在的索引
        // kruskal算法，得到mst权值之和
        sort(edges.begin(), edges.end(), [](auto &a, auto &b) {
            return a[2] < b[2];
        });
        int min_cost = 0;  // mst权值之和
        for (int i = 0; i < m; i++) {
            int a = edges[i][0], b = edges[i][1], w = edges[i][2];

            a = find(a), b = find(b);
            if (a != b) {
                p[a] = b;
                min_cost += w;
            }
        }

        // 依次考察每条边，得到结果
        vector<vector<int>> res(2);
        for (int i = 0; i < m; i++) {
            /**
             * 判断是否为关键边：将这条边从路径中去除，然后利用最小生成树算法求路径和，
             * 如果不连通 或者 路径和大于min_cost，那么这条边就是关键边
             */
            for (int j = 0; j < n; j++) p[j] = j;  // 重新初始化并查集
            int cost = 0, cnt = 0;  // cost记录去掉边edges[i]得到的mst权值之和，cnt记录mst中 点数
            for (int j = 0; j < m; j++) {
                if (j == i) continue;  // 去掉边edges[i]
                int a = edges[j][0], b = edges[j][1], w = edges[j][2];
                a = find(a), b = find(b);
                if (a != b) {
                    p[a] = b;
                    cost += w;
                    cnt++;
                }
            }
            // 去掉edge[i]后不连通 或者 路径和大于min_cost
            if (cnt != n - 1 || (cnt == n - 1 && cost > min_cost)) {
                res[0].push_back(edges[i][3]);
                continue;  // 说明这条边是关键边，不用再判断是否为非关键边
            }

            /**
             * 判断是否是非关键边：首先调用上面判断其是不是关键边，如果删掉edge[i]之后路径和不变，则说明其可以没有。(可无)
             * 那么怎么判断edge[i]可能会出现在某些最小生成树呢?
             * 只需要一开始将就edge[i]加入到最小生成树中，然后使用算法求路径和。如果路径和等于min_cost，则其就是
             * 伪关键边(可有)，否则就不是。(另外注意：如果能运行下面内容，说明cost == min_cost)
             */
            for (int j = 0; j < n; j++) p[j] = j;  // 重新初始化并查集
            cost = 0, cnt = 0;  // cost记录首先就加入edges[i]得到的mst权值之和，cnt记录mst中 点数
            // 首先加入edges[i]
            int a = edges[i][0], b = edges[i][1], w = edges[i][2];
            p[find(a)] = find(b);
            cost += w, cnt++;
            for (int j = 0; j < m; j++) {
                a = edges[j][0], b = edges[j][1], w = edges[j][2];
                a = find(a), b = find(b);
                if (a != b) {
                    p[a] = b;
                    cost += w;
                    cnt++;
                }
            }
            if (cost == min_cost) res[1].push_back(edges[i][3]);
        }

        return res;
    }
};

void OutputBasicArray2D1(vector<vector<int>> &nums) {

    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        if (i > 0 && i < nums.size()) cout << ' ';
        cout << "[";
        for (int j = 0; j < nums[i].size(); j++) {
            cout << nums[i][j];
            if (j != nums[i].size() - 1) cout << ", ";
        }
        cout << "]";
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    // [[0, 1],  [2, 3, 4, 5]]
    int n = 5;
    vector<vector<int>> edges = {{0, 1, 1}, {1, 2, 1}, {2, 3, 2}, {0, 3, 2}, {0, 4, 3}, {3, 4, 3}, {1, 4, 6}};
    vector<vector<int>> res = Solution().findCriticalAndPseudoCriticalEdges(n, edges);
    OutputBasicArray2D1(res);

//    // [[],  [0, 1, 2, 3]]
//    int n = 4;
//    vector<vector<int>> edges = {{0, 1, 1}, {1, 2, 1}, {2, 3, 1}, {0, 3, 1}};
//    vector<vector<int>> res = Solution().findCriticalAndPseudoCriticalEdges(n, edges);
//    OutputBasicArray2D1(res);

    return 0;
}