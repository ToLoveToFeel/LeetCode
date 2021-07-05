// Created by WXX on 2021/7/5 9:50
#include <iostream>
#include <vector>
#include <map>

using namespace std;

typedef map<string, int> MPSI;

class Solution {
public:
    string countOfAtoms(string formula) {
        int u = 0;
        auto t = dfs(formula, u);
        string res;
        for (auto &[x, y] : t) {
            res += x;
            if (y > 1) res += to_string(y);
        }
        return res;
    }

    MPSI dfs(string &s, int &u) {
        MPSI res;
        while (u < s.size()) {
            if (s[u] == '(') {
                u++;  // 跳过左括号
                auto t = dfs(s, u);
                u++;  // 跳过右括号
                int cnt = 1, k = u;  // cnt存储该子结构出现次数
                while (k < s.size() && isdigit(s[k])) k++;
                if (k > u) {
                    cnt = stoi(s.substr(u, k - u));
                    u = k;
                }
                for (auto &[x, y] : t) res[x] += y * cnt;
            } else if (s[u] == ')') {  // 遇到右括号，返回上一层，在上一层跳过右括号
                break;
            } else {
                int k = u + 1;  // s[u]是大写字母
                while (k < s.size() && s[k] >= 'a' && s[k] <= 'z') k++;
                auto key = s.substr(u, k - u);
                u = k;
                int cnt = 1;
                while (k < s.size() && isdigit(s[k])) k++;
                if (k > u) {
                    cnt = stoi(s.substr(u, k - u));
                    u = k;
                }
                res[key] += cnt;
            }
        }
        return res;
    }
};

int main() {

    cout << Solution().countOfAtoms("H2O") << endl;  // H2O
    cout << Solution().countOfAtoms("Mg(OH)2") << endl;  // H2MgO2
    cout << Solution().countOfAtoms("K4(ON(SO3)2)2") << endl;  // K4N2O14S4

    return 0;
}
