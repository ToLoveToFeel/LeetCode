// Created by WXX on 2021/5/18 8:48
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int countTriplets(vector<int> &arr) {

        int n = arr.size();
        vector<int> s(n + 1);
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] ^ arr[i - 1];

        int res = 0;
        for (int i = 0; i <= n; i++)
            for (int k = i + 2; k <= n; k++)
                if ((s[i] ^ s[k]) == 0)
                    res += k - i - 1;
        return res;
    }
};

int main() {

    vector<int> arr = {2, 3, 1, 6, 7};
    cout << Solution().countTriplets(arr) << endl;  // 4

    return 0;
}
