# coding=utf-8


class Solution:
    def romanToInt(self, s: str) -> int:
        hash = {
            "I": 1, "V": 5, "X": 10,
            "L": 50, "C": 100, "D": 500,
            "M": 1000
        }
        res = 0
        for i in range(len(s)):
            if i + 1 < len(s) and hash[s[i]] < hash[s[i + 1]]:
                res -= hash[s[i]]
            else:
                res += hash[s[i]]
        return res


if __name__ == "__main__":
    print(Solution().romanToInt("III"))  # 3
