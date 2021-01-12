#include <cstring>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

/**
 * 超出时间限制
 */
class Solution {
public:

    vector<int> topoSort(int deg[], vector<int> items, vector<vector<int>> g) {

        queue<int> q;
        for (int id : items) {
            if (!deg[id])
                q.push(id);
        }

        vector<int> res;
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            res.push_back(u);
            for (int v : g[u])
                if (--deg[v] == 0)
                    q.push(v);
        }

        if (res.size() != items.size()) res.clear();
        return res;
    }

    vector<int> sortItems(int n, int m, vector<int> &group, vector<vector<int>> &beforeItems) {

        vector<vector<int>> groupItem(n + m);  // 项目分组

        int t = m;  // 新的组号从m开始，不会和原来的组号(0~m-1)冲突
        for (int i = 0; i < group.size(); i++) {
            if (group[i] == -1) group[i] = t++;  // 说明项目i 单独一组
            groupItem[group[i]].push_back(i);  // 同一组的放在一起
        }

        vector<vector<int>> in(n);  // 组内拓扑关系
        vector<vector<int>> out(n + m);  // 组间拓扑关系

        // 拓扑排序需要的入度
        int degIn[n];  // 组内入度
        int degOut[n + m];  // 组间入度
        memset(degIn, 0, sizeof(degIn));
        memset(degOut, 0, sizeof(degOut));

        // 建图、求入度
        for (int to = 0; to < beforeItems.size(); ++to) {
            vector<int> before = beforeItems[to];  // 项目to所依赖的项目
            int toId = group[to];  // 当前项目to所属的组id
            for (int from : before) {
                if (group[from] == toId) {  // 同一组内拓扑排序
                    degIn[to]++;
                    in[from].push_back(to);  // 组内建图，添加边(from, to)
                } else {
                    degOut[toId]++;
                    out[group[from]].push_back(toId);  // 组间建图，添加边(group[from], toId)
                }
            }
        }

        vector<int> groupId;
        for (int i = 0; i < n + m; i++) groupId.push_back(i);
        vector<int> outSort = topoSort(degOut, groupId, out);
        if (outSort.empty()) return vector<int>{};

        vector<int> res;
        for (int gid : outSort) {
            vector<int> items = groupItem[gid];
            if (items.empty()) continue;
            vector<int> inSort = topoSort(degIn, items, in);
            if (inSort.empty()) return vector<int>{};
            for (int i : inSort) res.push_back(i);
        }

        return res;
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

    int n = 8, m = 2;
    vector<int> group = {-1, -1, 1, 0, 0, 1, 0, -1};
    vector<vector<int>> beforeItems = {{},
                                       {6},
                                       {5},
                                       {6},
                                       {3, 6},
                                       {},
                                       {},
                                       {}};

    vector<int> res = Solution().sortItems(n, m, group, beforeItems);
    OutputBasicArray1D(res);

    return 0;
}