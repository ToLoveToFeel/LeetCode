// Created by WXX on 2021/2/28 17:13

#ifndef CPLUSPLUS_NODE_H
#define CPLUSPLUS_NODE_H

#include <vector>

using namespace std;

class Node {
public:
    int val;
    vector<Node *> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node *> _children) {
        val = _val;
        children = _children;
    }
};

#endif //CPLUSPLUS_NODE_H
