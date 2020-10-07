import java.io.File;

public class statistics {
    public static void main(String[] args) {
        File file = new File("src");   // 需要查找的文件目录
        System.out.println("一共解决了" + FilesStatistics.getDirectoryCount(file) + "问题:)");  //调用方法
//        FilesStatistics.printSubFile(file);
    }
}

class FilesStatistics {
    /*
     * 方法名：getDirectoryCount
     * 作用：统计当前文件所在文件夹 文件夹个数
     */
    public static int getDirectoryCount(File srcFile) {
        int count = 0;

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
                count++;

        // 返回文件夹个数
        return count;
    }

    // 输出指定文件加下的所有文件（相当于树的遍历，文件是叶子节点）
    public static void printSubFile(File dir) {
        // 打印目录的子文件
        File[] subfiles = dir.listFiles();

        for (File f : subfiles) {
            if (f.isDirectory()) {  // 文件目录
                printSubFile(f);
            } else {  // 文件
                System.out.println(f.getAbsolutePath());
            }

        }
    }

    // 方式二：循环实现
    // 列出file目录的下级内容，仅列出一级的话
    // 使用File类的String[] list()比较简单
    public void listSubFiles(File file) {
        if (file.isDirectory()) {
            String[] all = file.list();
            for (String s : all) {
                System.out.println(s);
            }
        } else {
            System.out.println(file + "是文件！");
        }
    }

    // 拓展1：求指定目录所在空间的大小
    // 求任意一个目录的总大小
    public long getDirectorySize(File file) {
        // file是文件，那么直接返回file.length()
        // file是目录，把它的下一级的所有大小加起来就是它的总大小
        long size = 0;
        if (file.isFile()) {
            size += file.length();
        } else {
            File[] all = file.listFiles();  // 获取file的下一级
            // 累加all[i]的大小
            for (File f : all) {
                size += getDirectorySize(f);  // f的大小;
            }
        }
        return size;
    }

    // 拓展2：删除指定的目录
    public void deleteDirectory(File file) {
        // 如果file是文件，直接delete
        // 如果file是目录，先把它的下一级干掉，然后删除自己
        if (file.isDirectory()) {
            File[] all = file.listFiles();
            // 循环删除的是file的下一级
            for (File f : all) {  // f代表file的每一个下级
                deleteDirectory(f);
            }
        }
        // 删除自己
        file.delete();
    }
}
