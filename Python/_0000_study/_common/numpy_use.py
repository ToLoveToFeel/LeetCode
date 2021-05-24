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
    pass


if __name__ == "__main__":
    test05()
