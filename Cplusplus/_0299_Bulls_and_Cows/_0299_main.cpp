// Created by WXX on 2021/1/30 21:24
#include <iostream>
#include <unordered_map>

using namespace std;

class Solution {
public:
    string getHint(string secret, string guess) {

        unordered_map<char, int> hash;
        for (auto c : secret) hash[c]++;
        int tot = 0;
        for (auto c : guess)
            if (hash[c]) {
                tot++;
                hash[c]--;
            }

        int bulls = 0;
        for (int i = 0; i < secret.size(); i++)
            if (secret[i] == guess[i])
                bulls++;

        return to_string(bulls) + "A" + to_string(tot - bulls) + "B";
    }
};

int main() {

    cout << Solution().getHint("1807", "7810") << endl;  // 1A3B
    cout << Solution().getHint("1123", "0111") << endl;  // 1A1B

    return 0;
}
