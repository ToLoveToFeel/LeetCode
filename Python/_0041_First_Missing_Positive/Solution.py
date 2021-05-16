# coding=utf-8

class Solution(object):
    """
        1、由于有时间复杂度O(n)的要求，所以只能进行遍历，不能进行排序。
        2、首先把数组中的正数都拿出来，放到集合里，则数组中没有出现的最、
           小整数只可能比数组中正数的个数n小，所以可以从1到n遍历一下，看
           一下数字是否在集合里即可知道缺失的最小整数。
    """
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 1

        posSet = set()
        for num in nums:
            if num <= 0:
                continue
            posSet.add(num)

        if len(posSet) == 0:
            return 1

        ret = len(posSet) + 1
        for item in range(1, len(posSet)+1):
            if item not in posSet:
                ret = item
                break
        return ret


if __name__ == "__main__":
    # nums = [1, 2, 0]
    nums = [3, 4, -1, 1]
    So = Solution()
    print(So.firstMissingPositive(nums))


