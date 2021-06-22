# coding=utf-8


# 数字类型及操作
def test1():
    # 整数类型: 大小无限制
    a = 1010  # 10进制
    b = 0b101  # 二进制
    c = 0o456  # 八进制
    d = 0x9a  # 十六进制
    print(a, b, c, d, sep=", ")  # 均是以10进制输出
    print("a的二进制表示:", bin(a))
    print("a的八进制表示:", oct(a))
    print("a的十六进制表示:", hex(a))
    # 浮点数类型
    print("---------------------------------------")
    e = 0.1
    f = 0.2
    print(e + f)  # 存在误差，不是错误：0.30000000000000004
    print(e + f == 0.3)  # False
    print(round(e + f, 1) == 0.3)  # True
    print(round(0.00151, 3))  # 保留三位小数，四舍五入：0.002
    g = 1e2
    print(g)  # 100.0
    # 复数类型
    print("---------------------------------------")
    h = 3 + 4.2j
    print(h)  # (3+4.2j)
    print(h.real, h.imag)  # 实部，虚部
    # 数值运算操作符: 下面的运算法符都可以写成 op= 的形式
    print("---------------------------------------")
    x = 13
    y = 3
    print(x + y, x - y, x * y, x / y)  # 加减乘除
    print(x // y)  # 整除: 4
    print(x % y)  # 取余: 1
    print(x ** 0.5)  # x的0.5次方
    # 数值运算函数
    print("---------------------------------------")
    print(abs(-10.01))
    print(divmod(10, 3))  # 输出tuple: (商，余数)
    print(pow(2, 1000, 103))  # 2的1000次方对103取模
    print(round(-4.567, 2))  # 四舍五入，保留两位小数

    print(max(1, 9, 5, 4, 3))  # 可以有小括号或中括号，也可以没有，下面的min同理
    print(min([1, 9, 5, 4, 3]))
    print(sum([1, 9, 5, 4, 3]))  # 需要使用()或者[]，没有的话会执行出错

    import math
    print(math.factorial(10))  # 10!


# 字符串: 属于序列类型
def test2():
    print('--Hello World!--')  # --Hello World!--
    print("--Hello 'World'!--")  # --Hello 'World'!--
    print('''--'Hello' "World"--''')  # --'Hello' "World"--
    # 基础使用
    print("---------------------------------------")
    s = "0123456789"
    print(s[0])  # 获得s[0]  0
    print(s[0:2])  # 截取s[0, 2)的内容  01
    print(s[0:5:2])  # 每个两个截取s[0, 5)的内容  024
    print(s[0:-1])  # 最后一个字符被舍弃  012345678
    print(s[-4:])  # 截取最后四个字符  6789
    print(s[-1000:100])  # 首尾超过有效范围则取到首尾  0123456789
    print(s[::-1])  # 翻转字符串  9876543210
    print(2 * s)  # 复制两次字符串
    if "123" in s:
        print("'123'在字符串s中")
    else:
        print("'123'不在字符串s中")
    # 字符串处理函数
    print("---------------------------------------")
    print(len(s))  # 输出s的长度  10
    print(str("1.23"))
    print(ord('c'))  # unicode -> 数字
    print(chr(8364))  # 数字 -> unicode
    # 字符串处理方法
    print("---------------------------------------")
    t = "One world, one dream!"
    print(t.find("ne"))  # 找到第一次出现ne的位置    1
    print(t.lower())  # 全部转为小写    one world, one dream!
    print(t.upper())  # 全部转为大写    ONE WORLD, ONE DREAM!
    print(t.count("one"))  # 计算某个字符换出现的次数    1
    print(t.replace("world", "life"))  # 将world全部替换为life
    print(t.center(30, "="))  # t居中，两侧用=填充    ====One world, one dream!=====
    print(t.strip("!O"))  # 从str中去掉在其左侧和右侧所列出的字符    ne world, one dream
    print("+".join("1234"))  # 1234用+隔开    1+2+3+4
    tl = t.split(" ")
    print(tl)  # 按空格将字符串拆开    ['One', 'world,', 'one', 'dream!']
    print("-".join(tl))  # One-world,-one-dream!
    # 字符串格式化输出
    print("---------------------------------------")
    print("{0:.2f}".format(12345))  # 保留两位小数（四舍五入）    12345.00


# list: 属于序列类型
def test3():
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


# tuple: 属于序列类型
def test4():
    # 元组是一种序列类型，一旦创建就不能被修改
    t1 = "cat", "dog", "tiger"
    t2 = (0x001100, "blue", t1)
    t3 = ()  # 空元组
    print(t2)
    for i, x in enumerate(t2):  # t2[i] = x
        print(i, x)


# 集合 set
def test5():
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


# dict: 字典类型
def test6():
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


# 数据类型之间的转换
def test7():
    print(int(123.45))  # float -> int
    print(int("123"))  # str -> int  注意: 字符串必须是整数

    print("---------------------------------------")
    print(float(12))  # int -> float
    print(float('12.3'))  # str -> float
    print(float("1.234e3"))  # str -> float

    print("---------------------------------------")
    print(complex(4, 5.1))  # 数字 -> 复数
    print(complex("4"))  # 字符串 -> 复数  注意：不存在两个字符串的参数

    print("---------------------------------------")
    print(str(12.3))  # 数字 -> str
    print(str([1, 2, 4]))  # list -> str
    print(str((1, 2, 4)))  # tuple -> str
    print(str({"wxx": 21, "her": 18}))  # dict -> str

    print("---------------------------------------")
    print(list((1, 2, 4)))  # tuple -> list  [1, 2, 4]
    print(tuple([1, 2, 4]))  # list -> tuple  (1, 2, 4)

    print("---------------------------------------")
    print(ord('c'))  # unicode -> 数字
    print(chr(8364))  # 数字 -> unicode

    print("---------------------------------------")
    print(set(["list", 2, 3]))  # list -> set
    print(set(("tuple", 2, 3)))  # tuple -> set
    print(list({"hi", 4, 5}))  # set -> list
    print(tuple({"hello", 5, 6}))  # set -> tuple


# time
def test8():
    import time
    print(time.time())  # 获取当前时间戳，返回浮点数
    print(time.ctime())  # 获取当前时间并以易读方式表示，返回字符串
    print(time.gmtime())  # 获取当前时间，表示为计算机可处理的时间格式
    # 时间格式化
    t = time.gmtime(162132)
    print(time.strftime("%Y-%m-%d %H:%M:%S", t))  # 1970-01-02 21:02:12
    print(time.strftime("%Y-%B-%d %H:%M:%S", t))  # 1970-January-02 21:02:12
    print(time.strftime("%Y-%b-%d %H:%M:%S", t))  # 1970-Jan-02 21:02:12
    print("---------------------------------------")
    timeStr = '1970-01-02 21:02:12'
    print(time.strptime(timeStr, "%Y-%m-%d %H:%M:%S"))  # 返回计算机可处理的时间格式
    # 计时
    start = time.perf_counter()
    time.sleep(2)  # 睡眠2秒
    end = time.perf_counter()
    print(round(end - start, 1))


# random
def test9():
    import random
    random.seed(10)  # 设置随机种子，只有一次作用
    print(random.random())  # 生成一个[0.0, 1.0)之间的随机小数
    print(random.randint(10, 100))  # 生成一个[10, 100]之间的整数
    print(random.randrange(10, 100, 5))  # 生成一个[10, 100)之间以5为步长的随机整数
    print(random.getrandbits(2))  # 生成一个2比特长的随机整数，数据范围[0, 3]
    print(random.uniform(10, 100))  # 生成一个[10, 100]之间的随机小数
    print(random.choice([1, 2, 3, 4]))  # 从序列seq中随机选择一个元素
    print("---------------------------------------")
    seq = [1, 2, 3, 4, 5]
    random.shuffle(seq)  # 将序列seq中元素随机排列，返回打乱后的序列
    print(seq)


# sort
def test10():
    # list成员函数sort()
    arr = [3, 5, 1, 6, 9, 2]
    arr.sort()  # 作用在arr上
    print(arr)  # [1, 2, 3, 5, 6, 9]
    # list成员函数sort() 自定义比较
    arr = [(2, 2), (3, 4), (4, 1), (1, 3), (4, 2)]
    def cmp(e):
        return e[1]
    arr.sort(reverse=True, key=cmp)  # 根据第二维降序排列
    print(arr)
    arr.sort(key=lambda x: (-x[0], x[1]))  # 第一维降序，第二维升序排列
    print(arr)

    # sorted
    print("---------------------------------------")
    arr = [3, 5, 1, 6, 9, 2]
    print(sorted(arr))  # 返回排序(默认升序)后的list
    print(sorted(arr, reverse=True))  # 返回排序(降序)后的list
    # sorted 自定义比较
    arr = [(2, 2), (3, 4), (4, 1), (1, 3)]
    print(sorted(arr, key=lambda e: -e[1]))  # 根据第二维降序排列

    # sorted对dict排序
    print("---------------------------------------")
    d = {'c': 21, 'a': 24, 'b': 12}
    print(sorted(d))  # 返回list  ['a', 'b', 'c']
    print(sorted(d.items()))  # 返回list  [('a', 24), ('b', 21), ('c', 12)]
    print(sorted(d.items(), key=lambda e: e[1], reverse=True))  # 按照值降序排列

    # 对字符串进行排序
    s = "cbaCBA"
    s = "".join((lambda x: (x.sort(), x)[1])(list(s)))
    print(s)  # ABCabc


if __name__ == "__main__":
    test10()
