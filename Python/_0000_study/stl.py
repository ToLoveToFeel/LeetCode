# coding=utf-8


# list: 属于序列类型
def test1():
    # list创建
    s = [1, 2, "hi", (2, 3)]  # 或者 s = list([1, 2, "hi", (2, 3)])
    t = [[i + j for j in range(3)] for i in range(2)]
    # 序列类型通用操作符
    print("hi" in s)  # True
    print("hi" not in s)  # False
    print(s + t)  # [1, 2, 'hi', (2, 3), [0, 1, 2], [0, 1, 2]]
    print(2 * s)  # [1, 2, 'hi', (2, 3), 1, 2, 'hi', (2, 3)]
    print(s[2])  # hi
    print(s[1:3])  # 切片的详细信息请参考字符串    [2, 'hi']
    # 序列类型通用函数和方法
    print("---------------------------------------")
    print(len(s))  # 4
    print(min(t))  # 返回序列s的最小元素， s中元素需要可比较    [0, 1, 2]
    print(max(t))  # 返回序列s的最大元素， s中元素需要可比较    [1, 2, 3]
    print(s.index(2, 1, 3))  # 返回序列s从1开始到3位置中第一次出现元素2的位置，不存在产生ValueError异常
    print(s.count(12))  # 返回序列s中出现12的总次数    0

    # 列表类型操作函数和方法
    print("---------------------------------------")
    lt = []  # 定义空列表lt
    lt += [1, 2, 3, 4, 5]  # 向lt新增5个元素
    lt[2] = 6  # 修改lt中第2个元素  [1, 2, 6, 4, 5]
    lt.insert(2, 7)  # 向lt中第2个位置增加一个元素  [1, 2, 7, 6, 4, 5]
    del lt[1]  # [1, 7, 6, 4, 5]
    del lt[1:4]  # [1, 5]
    print(0 in lt)  # 判断lt中是否包含数字0  False
    lt.append(0)  # 向lt新增数字0  [1, 5, 0]
    print(lt.index(0))  # 返回数字0所在lt中的索引，不存在产生ValueError异常
    print(len(lt))  # lt的长度  3
    print(max(lt))  # lt中最大元素  5
    for x in lt:  # 遍历
        print(x, end=", ")
    print()
    for i, x in enumerate(lt):  # lt[i] = x
        print(i, x)
    lt.clear()  # 清空lt  []
    print("---------------------------------------")
    t = [i for i in range(5)]  # [0, 1, 2, 3, 4]
    t.pop(0)  # 删除列表中的头元素  [1, 2, 3, 4]
    t.append(3)  # 在列表的尾部添加元素3  [1, 2, 3, 4, 3]
    t.reverse()  # 反转列表  [3, 4, 3, 2, 1]
    t.remove(3)  # 删除第一个3，不存在产生ValueError异常  [4, 3, 2, 1]
    t.extend(["xyz", 'abc', 123])  # 追加一个列表  [4, 3, 2, 1, 'hi', 'k', 122]


# queue
def test2():
    # queue: 使用list模拟队列
    q = []  # 定义队列
    q.append(4)  # 入队  [4]
    q.append(3)  # 入队  [4, 3]
    q.append(7)  # 入队  [4, 3, 7]
    q.pop(0)  # 队首出队  [3, 7]
    print(q[0])  # 获得队首元素  3
    q.clear()  # 清空队列
    print(len(q))  # 获取队列中元素个数  0
    print(len(q) == 0)  # 判断队列是否为空  True

    # PriorityQueue: 默认小顶堆，是基于heapq实现的
    print("---------------------------------------")
    from queue import PriorityQueue
    heap = PriorityQueue()
    heap.put((2, 'hi'))
    heap.put((1, 'hello'))
    heap.put((3, 'world'))
    print(heap.queue)  # 输出堆中所有元素
    print(heap.queue[0])  # 输出堆顶元素, 不删除
    print(heap.get())  # 输出堆顶元素, 并删除堆顶元素
    print(heap.qsize())
    # python3中不能向PriorityQueue添加参数变为大顶堆，需要自己封装一个，可以参考下述网址
    # https://stackoverflow.com/questions/14189540/python-topn-max-heap-use-heapq-or-self-implement
    # 当做算法题使用到大顶堆是，不建议使用python
    import heapq
    class MaxHeap(object):
        def __init__(self, x):
            self.heap = [-e for e in x]
            heapq.heapify(self.heap)
        def put(self, value):
            heapq.heappush(self.heap, -value)
        def get(self):
            return -heapq.heappop(self.heap)


# stk
def test3():
    # python是没有栈的，我们可以列表模拟一个栈
    stk = []
    stk.append(20)  # 入队
    stk.append(10)
    stk.append(30)
    stk.pop(len(stk) - 1)  # 出队
    stk.clear()  # 清空队列
    print(len(stk))  # 获取队列中元素个数  0
    print(len(stk) == 0)  # 判断队列是否为空  True


# deque
def test4():
    from collections import deque
    # 定义 deque
    d = deque()
    # // 双端队列中插入、删除元素
    d.append(20)  # 队尾插入一个元素  deque([20])
    d.append(10)  # 队尾插入一个元素  deque([20, 10])
    d.pop()  # 弹出一个尾部数据  deque([20])
    d.appendleft(40)  # 队首插入一个元素  deque([40, 20])
    d.appendleft(30)  # 队首插入一个元素  deque([30, 40, 20])
    d.popleft()  # 弹出一个队首数据  deque([40, 20])
    # 遍历
    for x in d:
        print(x, end=", ")
    print()
    # 返回队首和队尾元素
    print(d[0])  # 队首元素  40
    print(d[len(d) - 1])  # 队尾元素  20
    # 清空 deque
    d.clear()
    print(len(d))  # 0
    print(len(d) == 0)  # True


# 内部有序的set?
def test5():
    pass


# OrderedDict: 是有序的，有序体现在，先添加的排在前面，后添加的排在后面
def test6():
    from collections import OrderedDict
    d = OrderedDict({"c2": 2, "c1": 4, "wxx": 21, "hh": 18})
    print(d)
    print(d.popitem())


if __name__ == "__main__":
    test6()
