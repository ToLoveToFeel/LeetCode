# coding=utf-8
# Date: 2021/6/17 10:20


# 执行用时：56 ms, 在所有 Python3 提交中击败了22.83%的用户
# 内存消耗：15 MB, 在所有 Python3 提交中击败了47.64%的用户
class Solution:
    def isNumber(self, s: str) -> bool:
        s = s.strip(' ')
        if len(s) == 0:
            return False
        if s[0] == '+' or s[0] == '-':
            s = s[1:]
        if s[0] == '.' and (len(s) == 1 or s[1] == 'e' or s[1] == 'E'):
            return False

        dot = 0
        e = 0
        i = 0
        while i < len(s):
            if s[i] == '.':
                if dot > 0 or e > 0:
                    return False
                dot += 1
            elif s[i] == 'e' or s[i] == 'E':
                if i == 0 or i + 1 == len(s) or e > 0:
                    return False
                if s[i + 1] == '+' or s[i + 1] == '-':
                    if i + 2 == len(s):
                        return False
                    i += 1
                e += 1
            elif s[i] < '0' or s[i] > '9':
                return False
            i += 1
        return True


if __name__ == "__main__":
    print(Solution().isNumber("0"))  # True
    print(Solution().isNumber("005047e+6"))  # True
