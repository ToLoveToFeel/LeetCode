package _0000_study._db._jdbc.basic.exercise;

import _0000_study._db._jdbc.util.JDBCUtils;

import java.util.Scanner;

/**
 * Date: 2020/10/21 11:13
 * Content:
 */
public class Exercise2 {

    /*
     * 字段：
     *  Type, IDCard, ExamCard, StudentName, Location, Grade
     */
    public static void main(String[] args) {
//        // 子问题 1：向examstudent表中添加一条记录
//        testInsert();

//        // 子问题2：根据身份证号或者准考证号查询学生成绩信息
//        queryWithIDCardOrExamCard();

        // 子问题3：根据考号删除指定的学生信息
        testDeleteByExamCard1();
    }

    // 子问题 1：向examstudent表中添加一条记录
    public static void testInsert() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("四级/六级：");
        int type = scanner.nextInt();
        System.out.print("身份证号：");
        String IDCard = scanner.next();
        System.out.print("准考证号：");
        String examCard = scanner.next();
        System.out.print("学生姓名：");
        String studentName = scanner.next();
        System.out.print("所在城市：");
        String location = scanner.next();
        System.out.print("考试成绩：");
        int grade = scanner.nextInt();

        String sql = "insert into examstudent(type,IDCard,examCard,studentName,location,grade) values(?,?,?,?,?,?)";
        int insertCount = JDBCUtils.updateRow(sql, type, IDCard, examCard, studentName, location, grade);
        if (insertCount > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    // 子问题2：根据身份证号或者准考证号查询学生成绩信息
    public static void queryWithIDCardOrExamCard() {
        System.out.println("请选择您要输入的类型：");
        System.out.println("a.准考证号");
        System.out.println("b.身份证号");
        Scanner scanner = new Scanner(System.in);
        String selection = scanner.next();
        if ("a".equalsIgnoreCase(selection)) {  // if(selection.equalsIgnoreCase("a")) 这样写可能导致空指针异常
            System.out.println("请输入准考证号：");
            String examCard = scanner.next();
            String sql = "select FlowID flowID,Type type,IDCard,ExamCard examCard,StudentName name,Location location,Grade grade from examstudent where examCard = ?";

            Student student = JDBCUtils.getInstance(Student.class, sql, examCard);
            if (student != null) {
                System.out.println(student);
            } else {
                System.out.println("输入的准考证号有误！");
            }

        } else if ("b".equalsIgnoreCase(selection)) {
            System.out.println("请输入身份证号：");
            String IDCard = scanner.next();
            String sql = "select FlowID flowID,Type type,IDCard,ExamCard examCard,StudentName name,Location location,Grade grade from examstudent where IDCard = ?";

            Student student = JDBCUtils.getInstance(Student.class, sql, IDCard);
            if (student != null) {
                System.out.println(student);
            } else {
                System.out.println("输入的身份证号有误！");
            }
        } else {
            System.out.println("您的输入有误，请重新进入程序。");
        }
    }

    // 子问题3：根据考号删除指定的学生信息
    public static void testDeleteByExamCard() {
        System.out.println("请输入学生的考号：");
        Scanner scanner = new Scanner(System.in);
        String examCard = scanner.next();
        // 查询指定准考证号的学生
        String sql = "select FlowID flowID,Type type,IDCard,ExamCard examCard,StudentName name,Location location,Grade grade from examstudent where examCard = ?";
        Student student = JDBCUtils.getInstance(Student.class, sql, examCard);
        if (student == null) {
            System.out.println("查无此人，请重新输入");
        } else {
            String sql1 = "delete from examstudent where examCard = ?";
            int deleteCount = JDBCUtils.updateRow(sql1, examCard);
            if (deleteCount > 0) {
                System.out.println("删除成功");
            }
        }
    }

    // 子问题3：根据考号删除指定的学生信息, 优化
    public static void testDeleteByExamCard1() {
        System.out.println("请输入学生的考号：");
        Scanner scanner = new Scanner(System.in);
        String examCard = scanner.next();
        String sql = "delete from examstudent where examCard = ?";
        int deleteCount = JDBCUtils.updateRow(sql, examCard);
        if (deleteCount > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("查无此人，请重新输入");
        }
    }
}
