# coding=utf-8


class Solution:
    def addBinary(self, a: str, b: str) -> str:
        A = []; B = []
        for i in range(len(a) - 1, -1, -1):
            A.append(int(a[i]))
        for i in range(len(b) - 1, -1, -1):
            B.append(int(b[i]))

        C = []
        i = 0; t = 0
        while i < len(a) or i < len(b) or t:
            if i < len(a):
                t += A[i]
            if i < len(b):
                t += B[i]
            C.append(str(t % 2))
            t //= 2
            i += 1
        return "".join(C[::-1])


if __name__ == "__main__":
    print(Solution().addBinary("11", "1"))
