// Created by WXX on 2021/5/11 20:19
#include <iostream>
#include <vector>
#include <set>

using namespace std;

typedef long long LL;
LL INF = 1e18;
typedef pair<LL, LL> PLL;

#define x first
#define y second

class SummaryRanges {
public:
    /** Initialize your data structure here. */
    set<PLL> S;

    SummaryRanges() {
        S.insert({-INF, -INF}), S.insert({INF, INF});
    }

    void addNum(int x) {
        auto r = S.upper_bound({x, INT_MAX});  // INT_MAX原因: 存在相等的x，不认为pair相同
        auto l = r;
        l--;
        if (l->y >= x) return;
        if (l->y == x - 1 && r->x == x + 1) {
            S.insert({l->x, r->y});
            S.erase(l), S.erase(r);
        } else if (l->y == x - 1) {
            S.insert({l->x, x});
            S.erase(l);
        } else if (r->x == x + 1) {
            S.insert({x, r->y});
            S.erase(r);
        } else {
            S.insert({x, x});
        }
    }

    vector<vector<int>> getIntervals() {
        vector<vector<int>> res;
        for (auto &p : S)
            if (p.x != -INF && p.x != INF)
                res.push_back({(int) p.x, (int) p.y});
        return res;
    }
};

void OutputBasicArray2D1(vector<vector<int>> nums) {

    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << "[";
        for (int j = 0; j < nums[i].size(); j++) {
            cout << nums[i][j];
            if (j != nums[i].size() - 1) cout << ", ";
        }
        cout << "]";
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    SummaryRanges *t = new SummaryRanges();
    t->addNum(1);
    t->addNum(3);
    t->addNum(7);
    t->addNum(2);
    t->addNum(6);
    OutputBasicArray2D1(t->getIntervals());  // [[1, 3], [6, 7]]

    return 0;
}
