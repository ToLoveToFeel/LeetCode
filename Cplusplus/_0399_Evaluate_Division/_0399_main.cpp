#include <iostream>
#include <vector>
#include <unordered_set>
#include <unordered_map>

using namespace std;

/**
 * https://www.acwing.com/activity/content/code/content/524881/  Floyd算法
 * 执行用时：8 ms, 在所有 C++ 提交中击败了13.76%的用户
 * 内存消耗：8.5 MB, 在所有 C++ 提交中击败了28.53%的用户
 */
class Solution {
public:
    vector<double> calcEquation(vector<vector<string>> &equations,
                                vector<double> &values,
                                vector<vector<string>> &queries) {

        unordered_set<string> vers;  // 存储顶点
        unordered_map<string, unordered_map<string, double>> d;  // 存储无向有权图

        for (int i = 0; i < equations.size(); ++i) {
            auto a = equations[i][0], b = equations[i][1];
            auto c = values[i];
            d[a][b] = c, d[b][a] = 1 / c;
            vers.insert(a), vers.insert(b);
        }

        // Floyd
        for (auto k : vers)
            for (auto i : vers)
                for (auto j : vers)
                    if (d[i][k] && d[j][k])
                        d[i][j] = d[i][k] * d[k][j];

        vector<double> res;
        for (auto q : queries) {
            auto a = q[0], b = q[1];
            if (d[a][b]) res.push_back(d[a][b]);
            else res.push_back(-1);
        }

        return res;
    }
};

void OutputBasicArray1D(vector<double> &nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    vector<vector<string>> equations = {{"a",  "b"},
                                        {"b",  "c"},
                                        {"bc", "cd"}};
    vector<double> values = {1.5, 2.5, 5.0};
    vector<vector<string>> queries = {{"a",  "c"},
                                      {"c",  "b"},
                                      {"bc", "cd"},
                                      {"cd", "bc"}};
    vector<double> res = Solution().calcEquation(equations, values, queries);
    OutputBasicArray1D(res);

    return 0;
}
