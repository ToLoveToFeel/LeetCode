// Created by WXX on 2021/3/2 19:23
#include <iostream>
#include <cstring>

using namespace std;

const int N = 2510;

int son[N][26], idx;
int V[N], S[N];  // V存储当前节点的权值，S存储以该节点对应前缀的子树的权值和

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了79.83%的用户
 * 内存消耗：7.7 MB, 在所有 C++ 提交中击败了93.28%的用户
 */
class MapSum {
public:
    // value: 现在插入的值；last: 旧值，如果不存在则为0
    void add(string &s, int value, int last) {
        int p = 0;
        for (auto c : s) {
            int u = c - 'a';
            if (!son[p][u]) son[p][u] = ++idx;
            p = son[p][u];
            S[p] += value - last;
        }
        V[p] = value;
    }

    int query(string &s) {
        int p = 0;
        for (auto c : s) {
            int u = c - 'a';
            if (!son[p][u]) return 0;
            p = son[p][u];
        }
        return p;
    }

    /** Initialize your data structure here. */
    MapSum() {
        memset(son, 0, sizeof son);
        idx = 0;
        memset(V, 0, sizeof V);
        memset(S, 0, sizeof S);
    }

    void insert(string key, int val) {
        add(key, val, V[query(key)]);
    }

    int sum(string prefix) {
        return S[query(prefix)];
    }
};

int main() {

    MapSum t = MapSum();
    t.insert("apple", 3);
    cout << t.sum("ap") << endl;  // 3
    t.insert("app", 2);
    cout << t.sum("ap") << endl;  // 5

    return 0;
}
