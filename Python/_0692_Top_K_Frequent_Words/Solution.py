# coding=utf-8
from typing import List


# 执行用时：68 ms, 在所有 Python3 提交中击败了67.03%的用户
# 内存消耗：14.9 MB, 在所有 Python3 提交中击败了62.62%的用户
class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        # 统计各个单词出现的次数
        cnt = {}
        for w in words:
            if w not in cnt:
                cnt[w] = 1
            else:
                cnt[w] += 1
        # 将哈希表中的元素存放到ws中
        ws = []
        for key, val in cnt.items():
            ws.append([val, key])
        # 排序: 第一维降序，第二维升序
        ws.sort(key=lambda x: (-x[0], x[1]))
        res = []
        for i in range(k):
            res.append(ws[i][1])
        return res


if __name__ == "__main__":
    words = ["i", "love", "leetcode", "i", "love", "coding"]
    print(Solution().topKFrequent(words, 2))  # ['i', 'love']
