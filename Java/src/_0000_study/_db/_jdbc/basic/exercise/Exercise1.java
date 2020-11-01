package _0000_study._db._jdbc.basic.exercise;

import _0000_study._db._jdbc.util.JDBCUtils;

import java.util.Scanner;

/**
 * Date: 2020/10/21 11:13
 * Content:
 * 从控制台向数据库的表 customers 中插入一条数据
 */
public class Exercise1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String name = scanner.next();
        System.out.print("请输入邮箱：");
        String email = scanner.next();
        System.out.print("请输入生日：");
        String birthday = scanner.next();  // '1992-09-08'

        String sql = "insert into customers(name, email, birth) values(?, ?, ?)";
        int insertRow = JDBCUtils.updateRow(sql, name, email, birthday);
        if (insertRow > 0)
            System.out.println("添加成功");
        else
            System.out.println("添加失败");
    }
}
