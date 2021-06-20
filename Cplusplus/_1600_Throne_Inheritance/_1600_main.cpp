// Created by WXX on 2021/6/20 10:42
#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>

using namespace std;

/**
 * 执行用时：604 ms, 在所有 C++ 提交中击败了62.69%的用户
 * 内存消耗：165.1 MB, 在所有 C++ 提交中击败了45.52%的用户
 */
class ThroneInheritance {
public:
    unordered_map<string, vector<string>> edges;
    unordered_set<string> dead;
    string king;

    ThroneInheritance(string kingName) {
        king = kingName;
    }

    void birth(string p, string c) {
        edges[p].push_back(c);
    }

    void death(string name) {
        dead.insert(name);
    }

    vector<string> getInheritanceOrder() {
        vector<string> ans;
        preorder(ans, king);
        return ans;
    }

    void preorder(vector<string> &ans, string name) {
        if (!dead.count(name)) ans.push_back(name);
        for (auto c : edges[name]) preorder(ans, c);
    }
};

void OutputBasicArray1D(vector<string> nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    ThroneInheritance* t= new ThroneInheritance("king");  // 继承顺序：king
    t->birth("king", "andy");  // 继承顺序：king > andy
    t->birth("king", "bob");  // 继承顺序：king > andy > bob
    t->birth("king", "catherine");  // 继承顺序：king > andy > bob > catherine
    t->birth("andy", "matthew");  // 继承顺序：king > andy > matthew > bob > catherine
    t->birth("bob", "alex");  // 继承顺序：king > andy > matthew > bob > alex > catherine
    t->birth("bob", "asha");  // 继承顺序：king > andy > matthew > bob > alex > asha > catherine
    OutputBasicArray1D(t->getInheritanceOrder());  // [king, andy, matthew, bob, alex, asha, catherine]
    t->death("bob");  // 继承顺序：king > andy > matthew > bob（已经去世）> alex > asha > catherine
    OutputBasicArray1D(t->getInheritanceOrder());  // [king, andy, matthew, alex, asha, catherine]

    return 0;
}
