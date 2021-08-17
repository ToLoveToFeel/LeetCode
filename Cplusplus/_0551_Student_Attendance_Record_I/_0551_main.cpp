// Created by ToLoveToFeel on 2021/8/17 10:18
#include <iostream>

using namespace std;

class Solution {
public:
    bool checkRecord(string s) {
        int a = 0, l = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == 'A') a++;
            else if (s[i] == 'L') {
                int j = i + 1;
                while (j < s.size() && s[j] == 'L') j++;
                l = max(l, j - i);
                i = j - 1;
            }
        }
        if (a >= 2 || l >= 3) return false;
        return true;
    }
};

int main() {

    cout << Solution().checkRecord("PPALLP") << endl;  // true
    cout << Solution().checkRecord("PPALLL") << endl;  // false

    return 0;
}
