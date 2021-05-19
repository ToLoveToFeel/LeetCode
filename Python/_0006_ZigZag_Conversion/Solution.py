# coding=utf-8


# 执行用时：88 ms, 在所有 Python3 提交中击败了20.39%的用户
# 内存消耗：14.9 MB, 在所有 Python3 提交中击败了83.26%的用户
class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1:
            return s
        d = 2 * numRows - 2  # 公差
        res = ""
        for i in range(numRows):
            if i == 0 or i == numRows - 1:
                for j in range(i, len(s), d):
                    res += s[j]
            else:
                j = i; k = d - i
                while j < len(s) or k < len(s):
                    if j < len(s):
                        res += s[j]
                        j += d
                    if k < len(s):
                        res += s[k]
                        k += d
        return res


if __name__ == "__main__":
    print(Solution().convert("PAYPALISHIRING", 3))
