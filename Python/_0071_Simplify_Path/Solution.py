# coding=utf-8
# @Time : 2020/3/11
# 简化路径

class Solution(object):
    """
        1、将原始路径按照"/" split划分，然后将每个元素依次放入栈中，如果当前元素是 "..",则对栈执行pop操作；
        2、将栈中的元素按照规范的格式进行输出
    """
    def simplifyPath(self, path):
        """
        :type path: str
        :rtype: str
        """
        stack = []
        pathList = path.strip('/').split('/')
        for item in pathList:
            if item not in ('.', '..', ''):
                stack.append(item)
            elif item == '..' and stack:
                stack.pop()
        return '/' + '/'.join(stack)


if __name__ == "__main__":
    print(Solution().simplifyPath("/home/////foo/"))

