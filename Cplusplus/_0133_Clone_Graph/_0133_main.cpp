// Created by WXX on 2021/1/25 22:39
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Node {
public:
    int val;
    vector<Node *> neighbors;

    Node() {
        val = 0;
        neighbors = vector<Node *>();
    }

    Node(int _val) {
        val = _val;
        neighbors = vector<Node *>();
    }

    Node(int _val, vector<Node *> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};

class Solution {
public:

    unordered_map<Node *, Node *> hash;  // 存储原图和复制出来的图的节点的对应关系

    Node *cloneGraph(Node *node) {
        if (!node) return NULL;
        // 复制所有点
        dfs(node);

        // 复制所有边
        for (auto [s, d] : hash) {  // (s, ver) --> (d, hash[ver])
            for (auto ver : s->neighbors)
                d->neighbors.push_back(hash[ver]);
        }
    }

    void dfs(Node *node) {

        hash[node] = new Node(node->val);
        for (auto ver : node->neighbors)
            if (hash.count(ver) == 0)
                dfs(ver);
    }
};
