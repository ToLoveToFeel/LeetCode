#include <iostream>
#include <string>

using namespace std;

/**
 * 滑动窗口
 * 时间复杂度: O(len(s))
 * 空间复杂度: O(len(charset))
 */
class Solution {
public:
    int lengthOfLongestSubstring(string s) {

        int freq[256] = {0};

        int l = 0, r = -1; // sliding window: s[l...r]
        int res = 0;

        while(r + 1 < s.size()){
            if( freq[s[r + 1]] == 0 )freq[s[++r]] ++;
            else freq[s[l++]] --;  // freq[s[r+1]] == 1

            res = max(res, r - l + 1);
        }

        return res;
    }
};

int main() {

    cout << Solution().lengthOfLongestSubstring( "abcabcbb" )<<endl; // 1
    cout << Solution().lengthOfLongestSubstring( "pwwkew" )<<endl;   // 3
    cout << Solution().lengthOfLongestSubstring( "c" )<<endl;        // 1
    cout << Solution().lengthOfLongestSubstring( "" )<<endl;         // 0

    return 0;
}
