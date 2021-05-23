# coding=utf-8
# Date: 2021/5/23 21:42
from typing import List


# 执行用时：52 ms, 在所有 Python3 提交中击败了89.55%的用户
# 内存消耗：18.2 MB, 在所有 Python3 提交中击败了25.69%的用户
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        hash = {}
        for str in strs:
            s = tuple(sorted(str))
            if s not in hash:
                hash[s] = [str]
            else:
                hash[s].append(str)
        return [v for v in hash.values()]


if __name__ == "__main__":
    strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    print(Solution().groupAnagrams(strs))
