# coding=utf-8
# Date: 2021/8/17 10:25


# 执行用时：32 ms, 在所有 Python3 提交中击败了83.21%的用户
# 内存消耗：15 MB, 在所有 Python3 提交中击败了21.35%的用户
class Solution:
    def checkRecord(self, s: str) -> bool:
        a, l = 0, 0
        i = 0
        while i < len(s):
            if s[i] == 'A':
                a += 1
                i += 1
            elif s[i] == 'L':
                j = i + 1
                while j < len(s) and s[j] == 'L':
                    j += 1
                l = max(l, j - i)
                i = j
            else:
                i += 1
        if a >= 2 or l >= 3:
            return False
        return True


if __name__ == "__main__":
    print(Solution().checkRecord("PPALLP"))  # True
    print(Solution().checkRecord("PPALLL"))  # False
