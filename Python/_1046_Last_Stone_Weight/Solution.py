# coding=utf-8
# Date: 2021/6/8 10:11
from typing import List


# 执行用时：44 ms, 在所有 Python3 提交中击败了46.56%的用户
# 内存消耗：14.8 MB, 在所有 Python3 提交中击败了73.62%的用户
# python中只有小顶堆，需要将数据转为负数实现大顶堆操作
class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        from queue import PriorityQueue
        heap = PriorityQueue()
        for x in stones:
            heap.put(-x)
        while heap.qsize() > 1:
            y = heap.get(); x = heap.get()
            if x == y:
                continue
            heap.put(y - x)
        return -heap.queue[0] if heap.qsize() == 1 else 0


if __name__ == "__main__":
    print(Solution().lastStoneWeight([2, 7, 4, 1, 8, 1]))
