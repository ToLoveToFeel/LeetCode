# coding=utf-8
# Date: 2021/6/1 20:25

# 执行用时：36 ms, 在所有 Python3 提交中击败了82.12%的用户
# 内存消耗：14.9 MB, 在所有 Python3 提交中击败了22.74%的用户
class Solution:
    def countSegments(self, s: str) -> int:
        return len(s.split())


if __name__ == "__main__":
    # print(Solution().countSegments(""))  # 0
    print(Solution().countSegments("Hello,     my name is John   "))  # 5
