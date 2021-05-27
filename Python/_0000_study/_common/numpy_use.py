# coding=utf-8
# Date: 2021/5/24 20:10
import numpy as np


# 为什么需要使用numpy?
# 因为python中的list效率比较低（需要检查每个元素类型）
# import array 中的array很多函数没提供，不方便

# numpy的基本使用
def test01():
    arr1 = np.array([i for i in range(5)])  # [0 1 2 3 4]
    arr1[3] = 7.8  # 小数点会直接去掉,向下取整    [0 1 2 7 4]
    print(arr1.dtype)  # 输出存储的数据类型    int32

    arr2 = np.array([1, 2, 3.0])  # [1. 2. 3.]
    print(arr2.dtype)  # float64

    # ndarray数组的创建方法
    print("---------------------------------------")
    print(np.array([0, 1, 2, 3]))  # 从列表类型创建
    print(np.array((4, 5, 6, 7)))  # 从元组类型创建
    print(np.array([[1, 2], [3, 4], (5.0, 6)]))  # 从列表和元组混合类型创建
    print("---------------------------------------")
    print(np.arange(5))  # [0 1 2 3 4]
    print(np.ones((2, 3)))  # 等价于 print(np.ones([2, 3]))
    '''
    [[1. 1. 1.]
     [1. 1. 1.]]
    '''
    print(np.zeros([2, 3]))  # 等价于 print(np.zeros((2, 3)))
    '''
    [[0. 0. 0.]
     [0. 0. 0.]]
    '''
    print(np.full((2, 3), 5.20))
    '''
    [[5.2 5.2 5.2]
     [5.2 5.2 5.2]]
    '''
    print(np.eye(3))  # 生成一个3x3的单位阵
    '''
    [[1. 0. 0.]
     [0. 1. 0.]
     [0. 0. 1.]]
    '''
    print("---------------------------------------")
    a = np.array([[1, 2, 3, 4],
                  [5, 6, 7, 8]])
    print(np.ones_like(a))  # 生成一个形状和a相同的全1的ndarray
    '''
    [[1 1 1 1]
     [1 1 1 1]]
    '''
    print(np.zeros_like(a))  # 生成一个形状和a相同的全0的ndarray
    '''
    [[0 0 0 0]
     [0 0 0 0]]
    '''
    print(np.full_like(a, 5))  # 生成一个形状和a相同的全5的ndarray
    '''
    [[5 5 5 5]
     [5 5 5 5]]
    '''
    print("---------------------------------------")
    print(np.linspace(1, 10, 4))  # [1~10]生成4个数，且是等差数列
    '''
    [ 1.  4.  7. 10.]
    '''
    print(np.linspace(1, 10, 4, endpoint=False))  # [1~10]生成5个数，且是等差数列，取前4个数
    '''
    [1.   3.25 5.5  7.75]
    '''

    # ndarray数组的维度变换
    print("---------------------------------------")
    a = np.arange(12)
    print(a.reshape((3, 4)))  # a不会改变
    '''
    [[ 0  1  2  3]
     [ 4  5  6  7]
     [ 8  9 10 11]]
    '''
    a.resize((3, 4))
    print(a)  # a会被改变
    '''
    [[ 0  1  2  3]
     [ 4  5  6  7]
     [ 8  9 10 11]]
    '''
    print(a.flatten())  # 按行折叠成一维数组，原数组不变
    print(a.swapaxes(0, 1))  # 将数组n个维度中前两个维度进行调换, 这里等价于 print(a.T)
    '''
    [[ 0  4  8]
     [ 1  5  9]
     [ 2  6 10]
     [ 3  7 11]]
    '''

    # ndarray数组的类型变换
    print("---------------------------------------")
    a = np.arange(12).reshape((2, 6))
    print(a)
    '''
    [[ 0  1  2  3  4  5]
     [ 6  7  8  9 10 11]]
    '''
    b = a.astype(np.double)  # 一定会创建新的数组（原始数据的一个拷贝），即使两个类型一致
    print(b)
    '''
    [[ 0.  1.  2.  3.  4.  5.]
     [ 6.  7.  8.  9. 10. 11.]]
    '''
    print(a.tolist())  # numpy -> list
    '''
    [[0, 1, 2, 3, 4, 5], [6, 7, 8, 9, 10, 11]]
    '''


# numpy的基本操作
def test02():
    # 向量
    x = np.arange(10)
    print(x)  # [0 1 2 3 4 5 6 7 8 9]
    print(x.ndim)  # 输出维度数目    1
    print(x.shape)  # 矩阵对应的形状    (10,)
    print(x.size)  # 元素个数    10
    # 向量数据访问
    print(x[0])  # 0
    print(x[-1])  # 9
    print(x[:5])  # 访问前5个数据    [0 1 2 3 4]
    print(x[5:])  # 访问下标为5后面的所有数据（包括下标为5的数据）    [5 6 7 8 9]
    print(x[::2])  # 访问下标为偶数的所有数据    [0 2 4 6 8]
    print(x[::-1])  # 将整个向量倒序    [9 8 7 6 5 4 3 2 1 0]

    # 矩阵
    print("---------------------------------------")
    X = np.arange(15).reshape(3, 5)
    print(X)
    '''
    [[ 0  1  2  3  4]
     [ 5  6  7  8  9]
     [10 11 12 13 14]]
    '''
    print(X.ndim)  # 输出维度数目    2
    print(X.shape)  # 矩阵对应的形状    (3, 5)
    print(X.size)  # 元素个数    15
    # 矩阵数据访问
    print(X[2][2])  # 不推荐这种写法    12
    print(X[2, 2])  # 推荐这种写法    12
    print(X[:2, :3])  # 访问前两行前三列的数据
    '''
    [[0 1 2]
     [5 6 7]]
    '''
    print(X[:2][:3])  # 这个不是访问前两行前三列的数据!!!
    '''
    [[0 1 2 3 4]
     [5 6 7 8 9]]
    '''
    print(X[:2, ::2])  # 访问前两行，所有下标为偶数列的数据
    '''
    [[0 2 4]
     [5 7 9]]
    '''
    print(X[::-1, ::-1])  # 将整个矩阵倒序
    '''
    [[14 13 12 11 10]
     [ 9  8  7  6  5]
     [ 4  3  2  1  0]]
    '''
    print(X[0, :])  # 访问第一行的元素，也可以写成 print(X[0])
    '''
    [0 1 2 3 4]
    '''
    print(X[:, 0])  # 访问第一列的数据
    '''
    [ 0  5 10]
    '''
    # 注意点：截取出的子数据和原数组数据是共用的
    subX1 = X[:2, :3]
    subX1[0, 0] = 100
    print(X[0, 0])  # 对subX的修改会影响到X, 对X的修改也会影响subX    100
    subX2 = X[:2, :3].copy()  # 这样对subX2的修改不会影响到X，反之亦然
    subX2[1, 1] = 520
    print(X[1, 1])  # 6

    # reshape
    print("---------------------------------------")
    print(x.reshape(2, 5))  # 对x没有影响
    '''
    [[0 1 2 3 4]
     [5 6 7 8 9]]
    '''
    A = x.reshape(1, 10)
    print(A)  # [[0 1 2 3 4 5 6 7 8 9]]
    print(A.shape)  # (1, 10)
    B = x.reshape(2, -1)  # 第二维由电脑计算得出
    print(B)
    '''
    [[0 1 2 3 4]
     [5 6 7 8 9]]
    '''
    # C = x.reshape(3, -1)  # ValueError


# numpy中的合并操作
def test03():
    # 向量
    x = np.array([1, 2, 3])
    y = np.array([3, 2, 1])
    print(np.concatenate([x, y]))
    '''
    [1 2 3 3 2 1]
    '''
    z = np.array([5, 6, 7])
    print(np.concatenate([x, y, z]))
    '''
    [1 2 3 3 2 1 5 6 7]
    '''

    # 矩阵
    print("---------------------------------------")
    A = np.array([[1, 2, 3],
                  [4, 5, 6]])
    print(np.concatenate([A, A]))  # 也可以放入多于两个矩阵
    '''[[1 2 3]
        [4 5 6]
        [1 2 3]
        [4 5 6]]
    '''
    print(np.concatenate([A, A], axis=1))  # 等价于 print(np.hstack([A, A]))
    '''
    [[1 2 3 1 2 3]
     [4 5 6 4 5 6]]
    '''
    B = np.full((2, 2), 100)
    print(np.hstack([A, B]))
    '''
    [[  1   2   3 100 100]
     [  4   5   6 100 100]]
    '''

    # 矩阵和向量拼接
    print("---------------------------------------")
    print(np.concatenate([A, z.reshape(1, -1)]))  # 等价于 print(np.vstack([A, z]))
    '''
    [[1 2 3]
     [4 5 6]
     [5 6 7]]
    '''
    t = np.array([50, 50])
    print(np.hstack([A, t.reshape(-1, 1)]))  # 不能写成 print(np.hstack([A, t])) 会报错
    '''
    [[1 2 3 50]
     [4 5 6 50]]
    '''


# numpy中的分割操作
def test04():
    # 向量
    x = np.arange(10)
    x1, x2, x3 = np.split(x, [3, 7])  # 分为 x[:3], x[3:7], x[7:]
    print(x1, x2, x3)  # [0 1 2] [3 4 5 6] [7 8 9]

    # 矩阵
    print("---------------------------------------")
    A = np.arange(16).reshape((4, 4))
    '''
    [[ 0  1  2  3]
     [ 4  5  6  7]
     [ 8  9 10 11]
     [12 13 14 15]]
    '''
    A1, A2 = np.split(A, [2])  # 等价于 A1, A2 = np.vsplit(A, [2])
    '''
    [[0 1 2 3]
     [4 5 6 7]]
    '''
    print(A2)
    '''
    [[ 8  9 10 11]
     [12 13 14 15]]
    '''
    A3, A4 = np.split(A, [2], axis=1)  # 等价于 A3, A4 = np.hsplit(A, [2])
    print(A3)
    '''
    [[ 0  1]
     [ 4  5]
     [ 8  9]
     [12 13]]
    '''
    print(A4)
    '''
    [[ 2  3]
     [ 6  7]
     [10 11]
     [14 15]]
    '''

    # 一个例子：给定3x5的数据，每行代表一个样本，前四列代表特征，最后一列是类标
    # 将样本数据和类标分离
    print("---------------------------------------")
    data = np.arange(15).reshape(3, 5)
    print(data)
    '''
    [[ 0  1  2  3  4]
     [ 5  6  7  8  9]
     [10 11 12 13 14]]
    '''
    X, y = np.hsplit(data, [-1])
    y = y[:, 0]
    print(X)
    '''
    [[ 0  1  2  3]
     [ 5  6  7  8]
     [10 11 12 13]]
    '''
    print(y)
    '''
    [ 4  9 14]
    '''


# numpy中的矩阵运算
def test05():
    # 列表乘法相当于将列表复制多次
    L = [i for i in range(5)]  # [0, 1, 2, 3, 4]
    print(L * 2)  # [0, 1, 2, 3, 4, 0, 1, 2, 3, 4]
    # 将列表中的每个元素都乘以2
    A = [2 * e for e in L]
    print(A)  # [0, 2, 4, 6, 8]

    # numpy
    print("---------------------------------------")
    L = np.arange(5)
    print(L * 2)  # [0 2 4 6 8]
    print(L + 1)  # 向量的操作和下面的矩阵一致，这里不演示了

    # Universal Functions
    print("---------------------------------------")
    X = np.arange(1, 16).reshape(3, 5)
    print(X)
    '''
    [[ 1  2  3  4  5]
     [ 6  7  8  9 10]
     [11 12 13 14 15]]
    '''
    print(X + 1)  # 矩阵中的每个元素都增加1
    print(X - 1)  # 矩阵中的每个元素都减少1
    print(X * 2)  # 矩阵中的每个元素都乘以2
    print(X / 2)  # 矩阵中的每个元素都除以2
    print(X // 2)  # 矩阵中的每个元素都整除以2
    print(X ** 2)  # 矩阵中的每个元素都求平方
    print(X % 2)  # 矩阵中的每个元素都对2取余
    print(1 / X)  # 矩阵中的每个元素都取倒数
    print(np.abs(X))  # 矩阵中的每个元素都取绝对值
    print(np.sin(X))  # 矩阵中的每个元素都取sin
    print(np.cos(X))  # 矩阵中的每个元素都取cos
    print(np.tan(X))  # 矩阵中的每个元素都取tan
    print(np.exp(X))  # 矩阵中的每个元素x都变为e^x
    print(np.power(3, X))  # 矩阵中的每个元素x都变为3^x, 等价于 3**X
    print(np.log(X))  # 矩阵中的每个元素都变取自然对数
    print(np.log2(X))  # 矩阵中的每个元素x都变为log2(x)
    print(np.log10(X))  # 矩阵中的每个元素x都变为log10(x)

    # 矩阵运算
    print("---------------------------------------")
    A = np.arange(4).reshape(2, 2)
    print(A)
    '''
    [[0 1]
     [2 3]]
    '''
    B = np.full((2, 2), 10)
    print(B)
    '''
    [[10 10]
     [10 10]]
    '''
    print(A + B)  # A、B中对应元素相加
    print(A - B)  # A、B中对应元素相加
    print(A * B)  # A、B中对应元素相加
    print(A / B)  # A、B中对应元素相加
    print(A.dot(B))  # 真正的矩阵乘法，必须满足A的第二维和B的第一维相等
    print(A.T)  # 矩阵转置

    # 向量和矩阵的运算
    print("---------------------------------------")
    v = np.array([1, 2])
    A = np.arange(4).reshape(2, 2)
    '''
    [[0 1]
     [2 3]]
    '''
    print(v + A)  # 向量v和A中的每一行做加法，等价于下面两种写法
    print(np.vstack([v] * A.shape[0]) + A)
    print(np.tile(v, (2, 1)) + A)  # (2, 1)表示在行的方向上复制两次，1表示在列的方向上复制一次
    '''
    [[1 3]
     [3 5]]
    '''
    print(v * A)  # 向量v和A中的每一行做乘法, 等价于 print(A * v)
    '''
    [[0 2]
     [2 6]]
    '''
    print(v.dot(A))  # 真正的向量和矩阵的运算, v被看成行向量    [4 7]
    print(A.dot(v))  # 真正的向量和矩阵的运算, v被看成列向量    [2 8]

    # 矩阵的逆
    print("---------------------------------------")
    A = np.arange(4).reshape(2, 2)
    '''
    [[0 1]
     [2 3]]
    '''
    print(np.linalg.inv(A))  # 矩阵的逆
    '''
    [[-1.5  0.5]
     [ 1.   0. ]]
    '''
    X = np.arange(8).reshape((2, -1))
    print(X)
    '''
    [[0 1 2 3]
     [4 5 6 7]]
    '''
    print(np.linalg.pinv(X))  # 矩阵的伪逆
    '''
    [[-0.475  0.175]
     [-0.2    0.1  ]
     [ 0.075  0.025]
     [ 0.35  -0.05 ]]
    '''


# numpy中的聚合运算
def test06():
    # 向量
    L = np.arange(10)
    print(sum(L))  # python自带的sum效率低于np.sum    45
    print(np.sum(L))  # 等价于 print(L.sum())    45
    print(np.min(L))  # 最小值    0
    print(np.max(L))  # 最小值    9

    # 矩阵
    print("---------------------------------------")
    X = np.arange(12).reshape(3, -1)
    print(X)
    '''
    [[ 0  1  2  3]
     [ 4  5  6  7]
     [ 8  9 10 11]]
    '''
    print(np.sum(X))  # 所有元素的和    66
    print(np.sum(X, axis=0))  # 列和（将第一维压缩掉了）    [12 15 18 21]
    print(np.sum(X, axis=1))  # 行和（将第二维压缩掉了）    [ 6 22 38]
    print(np.prod(X))  # 返回X中所有元素的乘积    0
    print(np.mean(X))  # 所有元素对应的均值    5.5
    print(np.var(X))  # 所有元素对应的方差    11.916666666666666
    print(np.std(X))  # 所有元素对应的标准差    3.452052529534663
    print(np.median(X))  # 所有元素对应的中位数    5.5

    # np.
    print("---------------------------------------")
    # arr = np.random.rand(100000)
    arr = np.array([1, 2, 3, 4, 5, 6, 7, 8])
    print(np.percentile(arr, q=50))  # 相当于返回中位数    4.5
    print(np.percentile(arr, q=100))  # 相当于返回最大值    8
    for percent in [0, 25, 50, 75, 100]:
        print(np.percentile(arr, q=percent), end=" ")  # 1.0 2.75 4.5 6.25 8.0


# numpy中的arg运算
def test07():
    # 向量
    x = np.arange(16)
    np.random.seed(666)  # 该种子只对下一句话有作用
    np.random.shuffle(x)  # 此时x已经被改变了
    print(x)  # [11 10  8  5 14 15  0  7  1  3  4  9  6 13  2 12]
    print(np.sort(x))  # 此时x没有改变,使用x.sort()的话会让x变为升序
    print(np.argmin(x))  # 找到x中最小的元素在原数组中的下标    6
    print(np.argmax(x))  # 找到x中最大的元素在原数组中的下标    5
    print(np.argsort(x))  # x升序排列对应的索引    [ 6  8 14  9 10  3 12  7  2 11  1  0 15 13  4  5]
    print(np.partition(x, 3))  # 让x[3]在升序排序后的位置上，左右可以无序
    '''
    [ 0  1  2  3  4  5  6 10  7  8  9 11 15 13 14 12]
    '''
    t = np.argpartition(x, 3)
    print(t)  # t[3]=9, 说明x[9]应该在升序数组中的下标为3的位置
    '''
    [ 6  8 14  9 10  3 12  1  7  2 11  0  5 13  4 15]
    '''

    # 矩阵
    print("---------------------------------------")
    np.random.seed(666)
    X = np.random.randint(10, size=(3, 4))
    print(X)
    '''
    [[2 6 9 4]
     [3 1 0 8]
     [7 5 2 5]]
    '''
    print(np.sort(X))  # 每行都按照升序排列，不影响X，等价于 print(np.sort(X, axis=1))
    '''
    [[2 4 6 9]
     [0 1 3 8]
     [2 5 5 7]]
    '''
    print(np.sort(X, axis=0))  # 每列都按照升序排列
    '''
    [[2 1 0 4]
     [3 5 2 5]
     [7 6 9 8]]
    '''
    print(np.argsort(X))  # 对每行向量进行 argsort 处理, 等价于 print(np.argsort(X, axis=1))
    print(np.argsort(X, axis=0))  # 对每列向量进行 argsort 处理
    print(np.argpartition(X, 2))  # 对每行向量进行 argpartition 处理
    print(np.argpartition(X, 2, axis=0))  # 对每列向量进行 argpartition 处理


# numpy中的 FancyIndexing 和 比较运算
def test08():
    # FancyIndexing
    x = np.arange(1, 17)
    print(x)  # [ 1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16]
    print([x[3], x[5], x[8]])  # 取出x中下标为3、5、8对应的元素    [4, 6, 9]
    ind = [3, 5, 8]
    print(x[ind])  # 取出x中下标为3、5、8对应的元素    [4 6 9]
    ind = np.array([[0, 2],
                    [1, 3]])
    print(x[ind])  # 返回一个二维数组，第一行取出x下标为0、2的数据，第二行取出下标为1、3的数据
    '''
    [[1 3]
     [2 4]]
    '''
    print("---------------------------------------")
    X = np.arange(16).reshape(4, -1)
    print(X)
    '''
    [[ 0  1  2  3]
     [ 4  5  6  7]
     [ 8  9 10 11]
     [12 13 14 15]]
    '''
    row = [0, 1, 2]  # 写成 row = np.array([0, 1, 2])也可以
    col = np.array([1, 2, 3])
    print(X[row, col])  # 返回X[0, 1], X[1, 2], X[2, 3]这三个元素    [ 1  6 11]
    print(X[0, col])  # 返回第0行下标为col的元素    [1 2 3]
    print(X[:2, col])  # 返回前两行下标为col的元素
    '''
    [[1 2 3]
     [5 6 7]]
    '''
    col = [True, False, True, True]
    print(X[1:3, col])  # 返回第1行和第2行中col对应位置为True的元素
    '''
    [[ 4  6  7]
     [ 8 10 11]]
    '''

    # numpy.array 的比较
    print("---------------------------------------")
    x = np.arange(8)
    print(x)  # [0 1 2 3 4 5 6 7]
    print(x < 3)  # [ True  True  True False False False False False]
    print(x >= 3)  # [False False False  True  True  True  True  True]
    print(x == 3)  # [False False False  True False False False False]
    print(x != 3)  # [ True  True  True False  True  True  True  True]
    print(2 * x == 24 - 4 * x)  # [False False False False  True False False False]
    A = np.arange(16).reshape(4, -1)
    print(A < 6)
    '''
    [[ True  True  True  True]
     [ True  True False False]
     [False False False False]
     [False False False False]]
    '''
    print("---------------------------------------")
    print(np.sum(x <= 2))  # 统计x中小于等于2的数据个数    3
    print(np.count_nonzero(x <= 2))  # 等价于上一句话    3
    print(np.any(x == 0))  # 判断x中是否存在0    True
    print(np.any(x < 0))  # 判断x中是否存在元素小于0    False
    print(np.all(x >= 0))  # 判断x中是否所有元素都大于等于0    True
    print(np.sum((x > 3) & (x < 6)))  # 计算x中大于3小于6的数的个数    2
    print(np.sum((x % 2 == 0) | (x >= 7)))  # 计算x中偶数或大于等于7的数的个数    5
    print(np.sum(~(x == 0)))  # 计算x中非零元素的个数    7
    print("---------------------------------------")
    print(np.sum(A % 2 == 0))  # 计算A中偶数的个数    8
    print(np.sum(A % 2 == 0, axis=1))  # 计算A中每行偶数的个数    [2 2 2 2]
    print(np.sum(A % 2 == 0, axis=0))  # 计算A中每列偶数的个数    [4 0 4 0]
    print(np.all(A > 0, axis=1))  # 判断A中每列数据是否都大于0    [False  True  True  True]

    print("---------------------------------------")
    print(x[x < 5])  # 输出x中所有小于5的数    [0 1 2 3 4]
    print(x[x % 2 == 0])  # 输出x中所有偶数    [0 2 4 6]
    print(A[A[:, 3] % 3 == 0, :])  # 输出A中最后一列能被3整除对应的行
    '''
    [[ 0  1  2  3]
     [12 13 14 15]]
    '''


if __name__ == "__main__":
    test01()
