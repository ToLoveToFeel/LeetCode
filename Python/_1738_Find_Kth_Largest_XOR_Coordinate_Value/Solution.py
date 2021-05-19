# coding=utf-8
from typing import List


# 执行用时：8320 ms, 在所有 Python3 提交中击败了5.80%的用户
# 内存消耗：33.4 MB, 在所有 Python3 提交中击败了84.06%的用户
class Solution:
    def kthLargestValue(self, matrix: List[List[int]], k: int) -> int:
        n = len(matrix)
        m = len(matrix[0])
        s = [[0 for _ in range(m + 1)] for _ in range(n + 1)]
        for i in range(1, n + 1):
            for j in range(1, m + 1):
                s[i][j] = s[i - 1][j] ^ s[i][j - 1] ^ s[i - 1][j - 1] ^ matrix[i - 1][j - 1]

        from queue import PriorityQueue
        heap = PriorityQueue()  # 默认小顶堆，不能通过传参变为大顶堆
        for i in range(1, n + 1):
            for j in range(1, m + 1):
                heap.put(s[i][j])
                if heap.qsize() > k:
                    heap.get()
        return heap.get()


if __name__ == "__main__":
    matrix = [[5, 2], [1, 6]]
    print(Solution().kthLargestValue(matrix, 1))  # 7
    print(Solution().kthLargestValue(matrix, 2))  # 5
    print(Solution().kthLargestValue(matrix, 3))  # 4
    print(Solution().kthLargestValue(matrix, 4))  # 0
