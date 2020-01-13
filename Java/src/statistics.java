import java.io.File;

public class statistics {

    static int count = 0;
    /*
    * 方法名：getDirectoryCount
    * 作用：统计当前文件所在文件夹 文件夹个数
    */
    public static int getDirectoryCount(File srcFile){
        // 判断传入的文件是不是为空
        if (srcFile == null) {
            throw new NullPointerException();
        }
        // 把所有目录、文件放入数组
        File[] files = srcFile.listFiles();

        // 遍历数组每一个元素
        for (File f : files)
            // 判断元素是不是文件夹，是文件夹就增1（递归）
            if (f.isDirectory())
                count ++;

        // 返回文件夹个数
        return count;
    }
    public static void main(String[] args) {
        File file = new File("src");   // 需要查找的文件目录
        System.out.println("一共解决了" + getDirectoryCount(file) + "问题:)"); //调用方法
    }
}
