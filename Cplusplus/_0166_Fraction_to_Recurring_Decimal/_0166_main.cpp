// Created by WXX on 2021/1/22 20:32
#include <iostream>
#include <unordered_map>

using namespace std;

class Solution {
public:
    string fractionToDecimal(int numerator, int denominator) {

        typedef long long LL;
        LL x = numerator, y = denominator;
        if (x % y == 0) return to_string(x / y);

        string res;
        if ((x < 0) ^ (y < 0)) res += '-';
        x = abs(x), y = abs(y);
        res += to_string(x / y) + '.', x %= y;
        unordered_map<LL, int> hash;  // (余数，余数*10 除以除数后的结果)
        while (x) {
            hash[x] = res.size();
            x *= 10;
            res += to_string(x / y), x %= y;
            if (hash.count(x)) {
                res = res.substr(0, hash[x]) + '(' + res.substr(hash[x]) + ')';
                break;
            }
        }
        return res;
    }
};

int main() {

    cout << Solution().fractionToDecimal(2, 3) << endl;
    cout << Solution().fractionToDecimal(100, 23) << endl;

    return 0;
}
