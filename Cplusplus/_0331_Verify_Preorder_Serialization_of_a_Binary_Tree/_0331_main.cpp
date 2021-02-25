// Created by WXX on 2021/2/25 10:55
#include <iostream>

using namespace std;

class Solution {
public:
    int k;
    string s;

    bool isValidSerialization(string _s) {
        k = 0;
        s = _s + ',';
        if (!dfs()) return false;
        return k == s.size();  // 判断最后是否有多余的元素9,#,#,1
    }

    bool dfs() {
        if (k == s.size()) return false;  // 如果遍历进来，就意味着这个点有东西
        if (s[k] == '#') return k += 2, true;
        while (s[k] != ',') k++;
        k++;
        return dfs() && dfs();
    }
};

int main() {

//    cout << Solution().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#") << endl;  // true
    cout << Solution().isValidSerialization("1,#") << endl;  // false
    cout << Solution().isValidSerialization("9,#,#,1") << endl;  // false

    return 0;
}
