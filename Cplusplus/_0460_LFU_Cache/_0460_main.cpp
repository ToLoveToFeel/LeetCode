// Created by WXX on 2021/6/5 18:11
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

/**
 * 执行用时：108 ms, 在所有 C++ 提交中击败了89.10%的用户
 * 内存消耗：40.2 MB, 在所有 C++ 提交中击败了74.84%的用户
 */
class LFUCache {
public:

    // Block中都是Node, 相当于LC146中的Node
    struct Node {
        Node *left, *right;
        int key, val;

        Node(int _key, int _val) {
            key = _key, val = _val;
            left = right = NULL;
        }
    };

    // 相当于LC432中的Node
    struct Block {
        Block *left, *right;
        Node *head, *tail;
        int cnt;  // Block中对应的Node被访问了cnt次

        Block(int _cnt) {
            cnt = _cnt;
            left = right = NULL;
            head = new Node(-1, -1), tail = new Node(-1, -1);  // 哨兵
            head->right = tail, tail->left = head;
        }

        ~Block() {
            delete head;
            delete tail;
        }

        // 在该Block中的head后插入p
        void insert(Node *p) {
            p->right = head->right;
            p->left = head;
            head->right->left = p;
            head->right = p;
        }

        // 在该Block中删除p
        void remove(Node *p) {
            p->left->right = p->right;
            p->right->left = p->left;
        }

        bool empty() {
            return head->right == tail;
        }
    } *head, *tail;

    int n;  // 最大容量
    unordered_map<int, Block *> hash_block;
    unordered_map<int, Node *> hash_node;

    LFUCache(int capacity) {
        n = capacity;
        head = new Block(0), tail = new Block(INT_MAX);
        head->right = tail, tail->left = head;
    }

    void insert(Block *p) {  // 在p的右侧插入新块，cnt是p->cnt + 1
        auto cur = new Block(p->cnt + 1);
        cur->left = p;
        cur->right = p->right;
        p->right->left = cur;
        p->right = cur;
    }

    void remove(Block *p) {
        p->right->left = p->left;
        p->left->right = p->right;
        delete p;
    }

    int get(int key) {
        if (!hash_block.count(key)) return -1;
        auto block = hash_block[key];
        auto node = hash_node[key];
        // 将node放到cnt等于block->cnt+1对应Block中
        block->remove(node);
        if (block->right->cnt != block->cnt + 1) insert(block);  // 不存在则创建
        block->right->insert(node);
        hash_block[key] = block->right;
        if (block->empty()) remove(block);  // Block中没有数据就应该删除,这样head->right一定是访问次数最少的Block
        return node->val;
    }

    void put(int key, int value) {
        if (n == 0) return;
        if (hash_block.count(key)) {
            hash_node[key]->val = value;
            get(key);  // 相当于让key对应的访问次数加一
        } else {
            if (hash_block.size() == n) {  // 移除访问次数最少且最久未使用的Node
                auto p = head->right->tail->left;
                head->right->remove(p);
                if (head->right->empty()) remove(head->right);
                hash_block.erase(p->key);
                hash_node.erase(p->key);
                delete p;
            }
            auto p = new Node(key, value);
            if (head->right->cnt > 1) insert(head);
            head->right->insert(p);
            hash_block[key] = head->right;
            hash_node[key] = p;
        }
    }
};

int main() {

    LFUCache *t = new LFUCache(2);
    t->put(1, 1);
    t->put(2, 2);
    cout << t->get(1) << endl;  // 1
    t->put(3, 3);  // 此时删除(2, 2)
    cout << t->get(2) << endl;  // -1
    cout << t->get(3) << endl;  // 3
    t->put(4, 4);  // 此时删除(1, 1)
    cout << t->get(1) << endl;  // -1
    cout << t->get(3) << endl;  // 3
    cout << t->get(4) << endl;  // 4

    return 0;
}
