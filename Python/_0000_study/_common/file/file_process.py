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
    # csv的读取
    # 最基本做法
    filename = "test4.csv"
    data = []
    with open(filename, 'r') as f:
        for line in f.readlines()[1:]:  # [1:]是为了过滤掉表头
            data.append(line.strip("\n").split(","))
    print(data)  # list
    # 使用csv处理
    print("---------------------------------------")
    import csv
    with open(filename, 'r') as f:
        reader = csv.reader(f)
        data = [row for row in reader]
        data = data[1:]
    print(data)  # list, data[0]也是list
    # 使用pandas
    print("---------------------------------------")
    import pandas as pd
    import numpy as np
    df = pd.read_csv(filename)  # 默认第一行为表头，自动生成索引, dataFrame类型
    print(df)
    '''
       Sepal.Length  Sepal.Width  Petal.Length  Petal.Width     Species
    0           5.1          3.5           1.4          0.2      setosa
    1           4.9          3.0           1.4          0.2      setosa
    2           7.0          3.2           4.7          1.4  versicolor
    3           6.4          3.2           4.5          1.5  versicolor
    4           6.3          3.3           6.0          2.5   virginica
    5           5.8          2.7           5.1          1.9   virginica
    '''
    a = df.values  # a是numpy类型
    print(a)
    '''
    [[5.1 3.5 1.4 0.2 'setosa']
     [4.9 3.0 1.4 0.2 'setosa']
     [7.0 3.2 4.7 1.4 'versicolor']
     [6.4 3.2 4.5 1.5 'versicolor']
     [6.3 3.3 6.0 2.5 'virginica']
     [5.8 2.7 5.1 1.9 'virginica']]
    '''
    print(a.dtype)  # object
    print(type(a[0][0]))  # <class 'float'>
    print(type(a[0][4]))  # <class 'str'>
    # data = a[:, :-1]  # dtype 仍然为 object
    data = np.array(a[:, :-1], dtype=float)  # dtype 为 float64
    print(data)
    '''
    [[5.1 3.5 1.4 0.2]
     [4.9 3.0 1.4 0.2]
     [7.0 3.2 4.7 1.4]
     [6.4 3.2 4.5 1.5]
     [6.3 3.3 6.0 2.5]
     [5.8 2.7 5.1 1.9]]
    '''
    labels = a[:, -1].tolist()
    print(type(labels))  # list类型    <class 'list'>
    print(labels)
    '''
    ['setosa' 'setosa' 'versicolor' 'versicolor' 'virginica' 'virginica']
    '''

    # 写入csv文件: 将list写入csv文件
    print("---------------------------------------")
    import csv
    headers = ['class', 'name', 'sex', 'height', 'year']
    rows = [
        [1, 'xiaoming', 'male', 168, 23],
        [1, 'xiaohong', 'female', 162, 22],
        [2, 'xiaozhang', 'female', 163, 21],
        [2, 'xiaoli', 'male', 158, 21]
    ]
    with open('test5.csv', 'w', newline="") as f:  # newline="" 是为了去掉行与行之间的空格
        writer = csv.writer(f)
        writer.writerow(headers)
        writer.writerows(rows)


# excel文件的处理
def test04():
    import pandas as pd
    filename = "test6.xlsx"
    df = pd.read_excel(filename, engine='openpyxl')
    print(df)
    '''
       Sepal.Length  Sepal.Width  Petal.Length  Petal.Width     Species
    0           5.1          3.5           1.4          0.2      setosa
    1           4.9          3.0           1.4          0.2      setosa
    2           7.0          3.2           4.7          1.4  versicolor
    3           6.4          3.2           4.5          1.5  versicolor
    4           6.3          3.3           6.0          2.5   virginica
    5           5.8          2.7           5.1          1.9   virginica
    '''
    # 之后和test03()一样

    # 写入excel文件：将list写入excel
    print("---------------------------------------")
    import xlsxwriter  # xlsxwriter只支持写入
    filename = "test7.xlsx"
    headers = ['class', 'name', 'sex', 'height', 'year']
    rows = [
        [1, 'xiaoming', 'male', 168, 23],
        [1, 'xiaohong', 'female', 162, 22],
        [2, 'xiaozhang', 'female', 163, 21],
        [2, 'xiaoli', 'male', 158, 21]
    ]
    data = [headers] + rows
    print(data)
    # 新建excel表
    workbook = xlsxwriter.Workbook(filename, {'nan_inf_to_errors': True})
    # 创建sheet，默认名称sheet1
    worksheet = workbook.add_worksheet()
    # 数据写入excel
    for i in range(len(data)):
        worksheet.write_row("A{}".format(i + 1), data[i])
    # 将excel文件保存关闭，如果没有这一行运行代码会报错
    workbook.close()


if __name__ == "__main__":
    test04()
