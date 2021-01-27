// Created by WXX on 2021/1/27 15:53
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：156 ms, 在所有 C++ 提交中击败了48.30%的用户
 * 内存消耗：103.1 MB, 在所有 C++ 提交中击败了13.41%的用户
 */
class WordDictionary {
public:
    struct Node {
        bool is_end;
        Node *son[26];

        Node() {
            is_end = false;
            for (int i = 0; i < 26; i++)
                son[i] = NULL;
        }
    } *root;

    /** Initialize your data structure here. */
    WordDictionary() {
        root = new Node();
    }

    void addWord(string word) {
        auto p = root;
        for (auto c : word) {
            int u = c - 'a';
            if (!p->son[u]) p->son[u] = new Node();
            p = p->son[u];
        }
        p->is_end = true;
    }

    bool search(string word) {
        return dfs(root, word, 0);
    }

    // 返回以p为根的trie树中是否存在字符串word[i...)
    bool dfs(Node *p, string word, int i) {
        if (i == word.size()) return p->is_end;
        if (word[i] != '.') {
            int u = word[i] - 'a';
            if (!p->son[u]) return false;
            return dfs(p->son[u], word, i + 1);
        } else {
            for (int j = 0; j < 26; j++)
                if (p->son[j] && dfs(p->son[j], word, i + 1))
                    return true;
            return false;
        }
    }
};

int main() {

    WordDictionary *w = new WordDictionary();
    w->addWord("bad");
    w->addWord("dad");
    w->addWord("mad");
    cout << w->search("pad") << endl;  // return False
    cout << w->search("bad") << endl;  // return True
    cout << w->search(".ad") << endl;  // return True
    cout << w->search("b..") << endl;  // return True

    return 0;
}
