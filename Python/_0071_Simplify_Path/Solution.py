# coding=utf-8


class Solution:
    def simplifyPath(self, path: str) -> str:
        sl = path.split('/')
        stk = []
        for s in sl:
            if s != '.' and s != ".." and s != "":
                stk.append(s)
            elif s == ".." and len(stk) != 0:
                stk.pop(len(stk) - 1)
        return "/" + "/".join(stk)


if __name__ == "__main__":
    print(Solution().simplifyPath("/home/////foo/"))  # /home/foo
