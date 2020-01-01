class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        freq = [0 for _ in range(256)]
        l = 0
        r = -1
        res = 0

        while l < len(s):
            if r + 1 < len(s) and freq[ord(s[r + 1])] == 0:
                r += 1
                freq[ord(s[r])] += 1
            else:
                freq[ord(s[l])] -= 1
                l += 1
            res = max(res, r - l + 1)

        return res


if __name__ == "__main__":
    So = Solution()
    print(So.lengthOfLongestSubstring("abcabcbb"))
