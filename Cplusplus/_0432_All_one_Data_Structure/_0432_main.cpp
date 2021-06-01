// Created by WXX on 2021/6/1 18:27
#include <iostream>
#include <unordered_set>
#include <unordered_map>

using namespace std;

/**
 * 执行用时：40 ms, 在所有 C++ 提交中击败了91.47%的用户
 * 内存消耗：26.5 MB, 在所有 C++ 提交中击败了25.12%的用户
 */
class AllOne {
public:

    struct Node {
        Node *left, *right;
        int val;
        unordered_set<string> S;

        Node(int _val) {
            val = _val;
            left = right = NULL;
        }
    } *head, *tail;

    unordered_map<string, Node *> hash;

    /** Initialize your data structure here. */
    AllOne() {
        head = new Node(INT_MIN), tail = new Node(INT_MAX);
        head->right = tail, tail->left = head;
    }

    // 辅助函数：在node右侧插入值为val的节点，如果右侧存在值为val的节点，则将key插入对应节点中的集合中
    Node *add_to_right(Node *node, string key, int val) {
        if (node->right->val == val) node->right->S.insert(key);
        else {
            // 在node和node->right中间插入一个节点t
            auto t = new Node(val);
            t->S.insert(key);
            t->right = node->right, node->right->left = t;
            t->left = node, node->right = t;
        }
        return node->right;
    }

    // 辅助函数：在node左侧插入值为val的节点，如果左侧存在值为val的节点，则将key插入对应节点中的集合中
    Node *add_to_left(Node *node, string key, int val) {
        if (node->left->val == val) node->left->S.insert(key);
        else {
            // 在node和node->right中间插入一个节点t
            auto t = new Node(val);
            t->S.insert(key);
            t->left = node->left, node->left->right = t;
            t->right = node, node->left = t;
        }
        return node->left;
    }

    // 辅助函数：删除节点node
    void remove(Node *node) {
        node->left->right = node->right;
        node->right->left = node->left;
        delete node;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    void inc(string key) {
        if (hash.count(key) == 0) hash[key] = add_to_right(head, key, 1);
        else {
            auto t = hash[key];
            t->S.erase(key);
            hash[key] = add_to_right(t, key, t->val + 1);
            if (t->S.empty()) remove(t);  // 节点没有任何字符串的需要删除该节点
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    void dec(string key) {
        if (hash.count(key) == 0) return;
        else {
            auto t = hash[key];
            t->S.erase(key);
            if (t->val > 1) {
                hash[key] = add_to_left(t, key, t->val - 1);
            } else {  // t->val == 1
                hash.erase(key);
            }
            if (t->S.empty()) remove(t);  // 节点没有任何字符串的需要删除该节点
        }
    }

    /** Returns one of the keys with maximal value. */
    string getMaxKey() {
        if (tail->left != head) return *tail->left->S.begin();
        return "";
    }

    /** Returns one of the keys with Minimal value. */
    string getMinKey() {
        if (head->right != tail) return *head->right->S.begin();
        return "";
    }
};

int main() {

    AllOne *t = new AllOne();
    t->inc("hello");
    t->inc("world");
    t->inc("world");
    cout << t->getMaxKey() << endl;  // world
    t->dec("world");
    t->dec("world");
    cout << t->getMaxKey() << endl;  // hello
    cout << t->getMinKey() << endl;  // hello

    return 0;
}
