// Created by WXX on 2021/5/3 17:54
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};

class Solution {
public:
    unordered_map<int, Employee *> hash;  // (id, id对应员工)

    int getImportance(vector<Employee *> employees, int id) {
        for (auto &p : employees) hash[p->id] = p;
        return dfs(id);
    }

    int dfs(int id) {
        auto p = hash[id];
        int res = p->importance;
        for (auto son : p->subordinates)
            res += dfs(son);
        return res;
    }
};

int main() {

    vector<Employee*> employees = {
            new Employee{1, 5, {2, 3}},
            new Employee{2, 3, {}},
            new Employee{3, 3, {}},
            };
    cout << Solution().getImportance(employees, 1) << endl;  // 11

    return 0;
}
