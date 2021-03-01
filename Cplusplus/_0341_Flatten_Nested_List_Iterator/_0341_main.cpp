// Created by WXX on 2021/2/25 21:17
#include <vector>

using namespace std;

class NestedInteger {
public:
    // Return true if this NestedInteger holds a single integer, rather than a nested list.
    bool isInteger() const;

    // Return the single integer that this NestedInteger holds, if it holds a single integer
    // The result is undefined if this NestedInteger holds a nested list
    int getInteger() const;

    // Return the nested list that this NestedInteger holds, if it holds a nested list
    // The result is undefined if this NestedInteger holds a single integer
    const vector<NestedInteger> &getList() const;
};

// 分为两步：(1) 将数据遍历存入vector中；(2) 从vector中获取数据
/**
 * 执行用时：20 ms, 在所有 C++ 提交中击败了39.24%的用户
 * 内存消耗：13.4 MB, 在所有 C++ 提交中击败了45.43%的用户
 */
class NestedIterator {
public:
    vector<int> q;
    int k = 0;

    NestedIterator(vector<NestedInteger> &nestedList) {
        k = 0;
        for (auto &l : nestedList) dfs(l);
    }

    void dfs(NestedInteger &l) {
        if (l.isInteger()) q.push_back(l.getInteger());
        else {
            for (auto v : l.getList()) dfs(v);
        }
    }

    int next() {
        return q[k++];
    }

    bool hasNext() {
        return k < q.size();
    }
};
