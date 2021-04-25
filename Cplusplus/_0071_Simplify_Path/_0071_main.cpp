// Created by WXX on 2021/4/25 21:03
#include <iostream>

using namespace std;

class Solution {
public:
    string simplifyPath(string path) {

        string res, name;  // name是两个/之间的内容
        if (path.back() != '/') path += '/';  // 为了方便处理最后一个目录
        for (auto c : path) {
            if (c != '/') name += c;
            else {
                if (name == "..") {  // 例如/a/bc/..
                    while (res.size() && res.back() != '/') res.pop_back();  // 去掉bc
                    if (res.size()) res.pop_back();  // 去掉/
                } else if (name != "." && name != "") {
                    res += '/' + name;
                }
                name.clear();
            }
        }

        if (res.empty()) res = "/";  // "/../"
        return res;
    }
};

int main() {

    cout << Solution().simplifyPath("/home//foo/") << endl;

    return 0;
}
