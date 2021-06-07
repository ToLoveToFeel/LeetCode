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
    # 双端队列中插入、删除元素
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


# set
def test5():
    """
    有序的集合：SortedSet
    网址：http://www.grantjenks.com/docs/sortedcontainers/sortedset.html
    """
    from sortedcontainers import SortedSet
    # 创建 SortedSet
    ss = SortedSet([3, 1, 2, 5, 4])
    print(ss)  # SortedSet([1, 2, 3, 4, 5])
    from operator import neg
    ss1 = SortedSet([3, 1, 2, 5, 4], neg)
    print(ss1)  # SortedSet([5, 4, 3, 2, 1], key=<built-in function neg>)
    # SortedSet 转为 list/tuple/set
    print(list(ss))  # SortedSet转为list    [1, 2, 3, 4, 5]
    print(tuple(ss))  # SortedSet转为tuple    (1, 2, 3, 4, 5)
    print(set(ss))  # SortedSet转为set    {1, 2, 3, 4, 5}
    # 插入、删除元素
    ss.discard(-1)  # 删除不存在的元素不报错
    ss.remove(1)  # 删除不存在的元素报错, KeyError
    ss.discard(3)  # SortedSet([1, 2, 4, 5])
    ss.add(-10)  # SortedSet([-10, 1, 2, 4, 5])
    # 返回第一个和最后一个元素
    print(ss[0])  # -10
    print(ss[-1])  # 5
    # 遍历 set
    for e in ss:
        print(e, end=", ")  # -10, 2, 4, 5,
    print()
    # set 中判断某元素是否存在
    print(2 in ss)  # True
    # bisect_left() / bisect_right()
    print(ss.bisect_left(4))  # 返回大于等于4的最小元素对应的下标    2
    print(ss.bisect_right(4))  # 返回大于4的最小元素对应的下标    3
    # 清空 set
    ss.clear()
    print(len(ss))  # 0
    print(len(ss) == 0)  # True

    """
    无序的集合: set
    """
    # 集合的定义：集合是不可变的，因此集合中元素不能是list
    A = {"hi", 2, ("we", 24)}
    B = set()  # 空集合的定义，不能使用B = {}定义集合，这样是字典的定义
    # 集合间的操作, 下面的运算法符都可以写成 op= 的形式
    print("---------------------------------------")
    S = {1, 2, 3}
    T = {3, 4, 5}
    print(S & T)  # 交集，返回一个新集合，包括同时在集合S和T中的元素
    print(S | T)  # 并集，返回一个新集合，包括在集合S和T中的所有元素
    print(S - T)  # 差集，返回一个新集合，包括在集合S但不在T中的元素
    print(S ^ T)  # 补集，返回一个新集合，包括集合S和T中的非相同元素
    # 集合的包含关系
    print("---------------------------------------")
    C = {1, 2}
    D = {1, 2}
    print(C <= D)  # C是否是D的子集  True
    print(C < D)  # C是否是D的真子集  False
    print(C >= D)  # D是否是C的子集  True
    print(C > D)  # D是否是C的真子集  False
    # 集合的处理方法
    print("---------------------------------------")
    S = {1, 2, 3, 5, 6}
    S.add(4)  # 如果x不在集合S中，将x增加到S
    S.discard(1)  # 移除S中元素x，如果x不在集合S中，不报错
    S.remove(2)  # 移除S中元素x，如果x不在集合S中，产生KeyError异常
    for e in S:  # 遍历
        print(e, end=",")
    print()
    print(S.pop())  # 从S中随机弹出一个元素，S长度减1，若S为空产生KeyError异常
    print(S.copy())  # 返回集合S的一个副本, 对该副本的操作不会影响S
    print(len(S))  # 返回集合S的元素个数
    print(5 in S)  # 判断S中元素x， x在集合S中，返回True，否则返回False
    print(5 not in S)  # 判断S中元素x， x在集合S中，返回True，否则返回False
    S.clear()  # 移除S中所有元素


# SortedList: 类似于C++中的multiset
def _test5():
    """
    网址：http://www.grantjenks.com/docs/sortedcontainers/sortedlist.html
    """
    from sortedcontainers import SortedList
    # 定义
    sl = SortedList(key=lambda x: -x)  # 降序
    sl = SortedList([3, 1, 2, 1, 5, 4])  # 升序
    print(sl)  # SortedList([1, 1, 2, 3, 4, 5])
    # 插入、删除元素
    sl.add(3)
    sl.add(3)
    sl.discard(2)  # SortedList([1, 1, 3, 3, 3, 4, 5])
    print(sl)
    # 统计某个元素出现的次数
    print(sl.count(3))  # 3
    # 返回第一个和最后一个元素
    print(sl[0])  # 1
    print(sl[-1])  # 5
    # 遍历 set
    for e in sl:
        print(e, end=", ")  # 1, 1, 3, 3, 3, 4, 5,
    print()
    # 判断某元素是否存在
    print(2 in sl)  # False
    # bisect_left() / bisect_right()
    print(sl.bisect_left(3))  # 返回大于等于3的最小元素对应的下标    2
    print(sl.bisect_right(3))  # 返回大于3的最小元素对应的下标    5
    # 清空
    sl.clear()
    print(len(sl))  # 0
    print(len(sl) == 0)  # True


# map
def test6():
    """
    有序的map: SortedDict
    网址: http://www.grantjenks.com/docs/sortedcontainers/sorteddict.html
    """
    from sortedcontainers import SortedDict
    sd = SortedDict()
    # 插入、删除元素
    sd["wxx"] = 21
    sd["hh"] = 18
    sd["other"] = 20
    print(sd)  # SortedDict({'hh': 18, 'other': 20, 'wxx': 21})
    print(sd["wxx"])  # 访问不存在的键会报错, KeyError
    print(sd.get("c"))  # 访问不存在的键会返回None     None
    # SortedDict转dict
    print(dict(sd))  # {'hh': 18, 'other': 20, 'wxx': 21}
    # 返回最后一个元素和最后一个元素
    print(sd.peekitem(0))  # 类型tuple, 返回第一个元素    ('hh', 18)
    print(sd.peekitem())  # 类型tuple, 返回最后一个元素    ('wxx', 21)
    # 遍历
    for k, v in sd.items():
        print(k, ':', v, sep="", end=", ")  # sep取消每行输出之间的空格
    print()
    for k in sd:  # 遍历键k, 等价于for k in d.keys:
        print(str(k) + ":" + str(sd[k]), end=", ")
    print()
    for v in sd.values():  # 遍历值v
        print(v, end=", ")
    print()
    # 返回Map中的一个键
    print(sd.peekitem()[0])
    # 返回Map中的一个值
    print(sd.peekitem()[1])
    # 中判断某元素是否存在
    print("wxx" in sd)  # True
    # bisect_left() / bisect_right()
    sd["a"] = 1
    sd["c1"] = 2
    sd["c2"] = 4
    print(sd)  # SortedDict({'a': 1, 'c1': 2, 'c2': 4, 'hh': 18, 'other': 20, 'wxx': 21})
    print(sd.bisect_left("c1"))  # 返回键大于等于"c1"的最小元素对应的下标    1
    print(sd.bisect_right("c1"))  # 返回键大于"c1"的最小元素对应的下标    2
    # 清空
    sd.clear()
    print(len(sd))  # 0
    print(len(sd) == 0)  # True

    """
    无序的map: dict
    """
    print("---------------------------------------")
    d = {"c1": 2, "c2": 4, "hh": 18, "wxx": 21, 13: 14, 1: 0}
    print(d["wxx"])  # 21
    print(d[13])  # 14
    d[13] += 1
    print(d[13])  # 15
    d["future"] = "wonderful"  # 字典中添加键值对
    del d[1]  # 删除字典d中键1对应的数据值
    print("wxx" in d)  # 判断键"wxx"是否在字典d中，如果在返回True，否则False
    print(d.keys())  # 返回字典d中所有的键信息  dict_keys(['c1', 'c2', 'hh', 'wxx', 13])
    print(d.values())  # 返回字典d中所有的值信息  dict_values([2, 4, 18, 21, 14])
    print(d.items())  # dict_items([('c1', 2), ('c2', 4), ('hh', 18), ('wxx', 21), (13, 14)])
    for k, v in d.items():  # 遍历 k, v
        print(k, ':', v)
    for k in d:  # 遍历键k, 等价于for k in d.keys:
        print(str(k) + ":" + str(d[k]), end=", ")
    print()
    for v in d.values():  # 遍历值v
        print(v, end=", ")
    print()
    # 字典类型操作函数和方法
    print("---------------------------------------")
    d = {"中国": "北京", "美国": "华盛顿", "法国": "巴黎"}
    print(len(d))  # 返回字典d中元素的个数  3
    print(d.get("中国", "不存在"))  # 键k存在，则返回相应值，不在则返回<default>值  北京
    print(d.get("中", "不存在"))  # 不存在
    print(d.get("中"))  # None
    d["美国"] = "Washington"  # 修改键对应的值
    print(d.pop("美国"))  # 键k存在，则返回相应值，并将其从dict中删除
    print(d.popitem())  # 随机从字典d中取出一个键值对，以元组形式返回，并将其从dict中删除
    d.clear()  # 删除所有的键值对


if __name__ == "__main__":
    test6()
