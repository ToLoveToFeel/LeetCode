// Created by WXX on 2021/3/2 18:34
#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

const int N = 10010;

int son[N][26], idx;
bool is_end[N];

class MagicDictionary {
public:
    void insert(string &s) {
        int p = 0;
        for (auto c : s) {
            int u = c - 'a';
            if (!son[p][u]) son[p][u] = ++idx;
            p = son[p][u];
        }
        is_end[p] = true;
    }

    /** Initialize your data structure here. */
    MagicDictionary() {
        memset(son, 0, sizeof son);
        idx = 0;
        memset(is_end, 0, sizeof is_end);
    }

    void buildDict(vector<string> dictionary) {
        for (auto &s : dictionary) insert(s);
    }

    // p: 在trie中的节点编号；u: 当前字符串的下标；c: 当前有多少字符不相同
    bool dfs(string &s, int p, int u, int c) {
        if (is_end[p] && u == s.size() && c == 1) return true;
        if (c > 1 || u == s.size()) return false;

        for (int i = 0; i < 26; i++) {
            if (!son[p][i]) continue;
            if (dfs(s, son[p][i], u + 1, c + (s[u] - 'a' != i)))
                return true;
        }
        return false;
    }

    bool search(string searchWord) {
        return dfs(searchWord, 0, 0, 0);
    }
};

int main() {

    MagicDictionary* t = new MagicDictionary();
    t->buildDict({"hello", "leetcode"});
    cout << t->search("hello") << endl;  // false
    cout << t->search("hhllo") << endl;  // true
    cout << t->search("hhll") << endl;  // false
    cout << t->search("leetcoded") << endl;  // false

    return 0;
}
