// Created by WXX on 2021/1/27 16:23
#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

/**
 * 执行用时：420 ms, 在所有 C++ 提交中击败了33.44%的用户
 * 内存消耗：8.5 MB, 在所有 C++ 提交中击败了81.73%的用户
 */
class Solution {
public:
    struct Node {
        int id;
        Node *son[26];

        Node() {
            id = -1;
            for (int i = 0; i < 26; i++) son[i] = NULL;
        }
    } *root;

    unordered_set<int> ids;  // 存储能被搜到的单词的id
    vector<vector<char>> g;
    int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};

    void insert(string &s, int id) {
        auto p = root;
        for (auto c : s) {
            int u = c - 'a';
            if (!p->son[u]) p->son[u] = new Node();
            p = p->son[u];
        }
        p->id = id;
    }

    vector<string> findWords(vector<vector<char>> &board, vector<string> &words) {

        g = board;
        // 将单词放入trie中，方便之后判断单词是否存在
        root = new Node();
        for (int i = 0; i < words.size(); i++) insert(words[i], i);

        for (int i = 0; i < g.size(); i++) {
            for (int j = 0; j < g[0].size(); j++) {
                int u = g[i][j] - 'a';
                if (root->son[u])
                    dfs(i, j, root->son[u]);
            }
        }

        vector<string> res;
        for (auto id : ids) res.push_back(words[id]);
        return res;
    }

    // 从board[x][y]开始搜索以p为根的trie树中的单词
    void dfs(int x, int y, Node *p) {
        if (p->id != -1) ids.insert(p->id);
        char t = g[x][y];
        g[x][y] = '.';
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a >= 0 && a < g.size() && b >= 0 && b < g[0].size() && g[a][b] != '.') {
                int u = g[a][b] - 'a';
                if (p->son[u]) dfs(a, b, p->son[u]);
            }
        }
        g[x][y] = t;
    }
};

void OutputBasicArray1D(vector<string> &nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    vector<vector<char>> board = {{'o', 'a', 'a', 'n'},
                                  {'e', 't', 'a', 'e'},
                                  {'i', 'h', 'k', 'r'},
                                  {'i', 'f', 'l', 'v'}};
    vector<string> words = {"oath", "pea", "eat", "rain"};
    vector<string> res = Solution().findWords(board, words);
    OutputBasicArray1D(res);

    return 0;
}
