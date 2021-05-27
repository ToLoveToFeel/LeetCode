# coding=utf-8
# Date: 2021/5/27 16:15
from typing import List


# 文本文件的处理: 每行数据不是纯数字
def test01():
    # 读取文件
    filename = r"D:\test1.txt"
    filename = "D:\\test1.txt"  # 这样写也行
    filename = "./test1.txt"  # 文件位于统一文件夹，这样写也行
    filename = "test1.txt"  # 文件位于统一文件夹，这样写也行
    with open(filename, 'r') as f:
        for line in f:
            print(line)
    '''
    id,name,sex,age,salary

    1,tom,male,21,25000.0
    
    2,alice,female,18,12000.0
    '''
    print("---------------------------------------")
    with open(filename, 'r') as f:
        data = f.read()  # str类型
        print(data)
    '''
    id,name,sex,age,salary
    1,tom,male,21,25000.0
    2,alice,female,18,12000.0
    '''
    print("---------------------------------------")
    with open(filename, 'r') as f:
        data = f.readlines()  # list类型
        for line in data:
            line = line.strip("\n")  # 去掉最后的回车
            print(line)
    '''
    id,name,sex,age,salary
    1,tom,male,21,25000.0
    2,alice,female,18,12000.0
    '''
    print("---------------------------------------")
    dict = {}
    with open(filename, 'r') as f:
        for line in f.readlines()[1:]:  # [1:]是为了过滤掉表头
            item = line.strip("\n").split(',')
            id, name, sex, age, salary = item[0], item[1], item[2], int(item[3]), float(item[4])
            dict[id] = [name, sex, age, salary]
    print(dict)
    '''
    {'1': ['tom', 'male', 21, 25000.0], '2': ['alice', 'female', 18, 12000.0]}
    '''

    # 写入文件
    filename = "test2.txt"
    con = ["hello\n", "12.0\n"]
    with open(filename, 'w') as f:
        f.writelines(con)
    # 将dict中的数据写入文件
    print("---------------------------------------")
    with open(filename, 'a') as f:  # 以追加的模式打开文件
        f.write("\n")
        for k, v in dict.items():
            item = str(k) + "," + ",".join([str(x) for x in v]) + "\n"
            f.write(item)
    # test2.txt文件的内容
    '''
    hello
    12.0
    
    1,tom,male,21,25000.0
    2,alice,female,18,12000.0

    '''


# 文本文件的处理: 每行数据是纯数字(除表头)
def test02():
    # 读取文件
    filename = "test3.txt"
    data = []
    with open(filename, 'r') as f:
        for line in f.readlines()[1:]:  # [1:]是为了过滤掉表头
            line = [float(x) for x in line.strip("\n").split(",")]
            data.append(line)
    print(data)  # data是list类型
    import numpy as np
    a = np.array(data)  # list转为numpy类型
    print(a)
    # 写入文件，和test01一致，需要将每行的数据转为字符串写入


# csv文件的处理
def test03():
    # 最基本做法
    filename = "test4.csv"
    data = []
    with open(filename, 'r') as f:
        for line in f.readlines()[1:]:  # [1:]是为了过滤掉表头
            data.append(line.strip("\n").split(","))
    print(data)  # list
    # 使用csv处理
    import csv
    with open(filename, 'r') as f:
        reader = csv.reader(f)
        data = [row for row in reader]
        data = data[1:]
    print(data)  # list, data[0]也是list
    # 使用pandas
    import pandas as pd
    print(pd.read_csv(filename))



if __name__ == "__main__":
    test03()
