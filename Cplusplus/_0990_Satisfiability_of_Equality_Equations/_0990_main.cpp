// Created by WXX on 2021/6/6 16:05
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了52.95%的用户
 * 内存消耗：10.7 MB, 在所有 C++ 提交中击败了48.05%的用户
 */
class Solution {
public:

    vector<int> p;

    int find(int x) {
        if (x != p[x]) p[x] = find(p[x]);
        return p[x];
    }

    bool equationsPossible(vector<string> &eq) {
        for (int i = 0; i < 30; i++) p.push_back(i);

        // 第一步：将所有等式对应的字母合并
        for (auto &e : eq)
            if (e.substr(1, 2) == "==") {
                int a = find(e[0] - 'a'), b = find(e[3] - 'a');
                if (a != b) p[a] = b;
            }
        // 检查所有的不等式，看是否存在矛盾
        for (auto &e : eq)
            if (e.substr(1, 2) == "!=") {
                int a = find(e[0] - 'a'), b = find(e[3] - 'a');
                if (a == b) return false;
            }
        return true;
    }
};

int main() {

    vector<string> equations = {"a==b", "b!=a"};
    cout << Solution().equationsPossible(equations) << endl;  // false

    return 0;
}
