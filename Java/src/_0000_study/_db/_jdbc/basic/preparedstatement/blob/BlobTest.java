package _0000_study._db._jdbc.basic.preparedstatement.blob;

import _0000_study._db._jdbc.basic.preparedstatement.bean.Customer;
import _0000_study._db._jdbc.util.JDBCUtils;
import org.junit.Test;

import java.io.*;
import java.sql.*;

/**
 * Date: 2020/10/21 16:22
 * Content: 测试使用PreparedStatement操作Blob类型的数据
 * <p>
 * 对于 mediumblob, 图片大于 1MB, 会抛出 PacketTooBigException, 解决方式：
 * 在mysql的安装目录下，找my.ini文件加上如下的配置参数：max_allowed_packet=16M
 */
public class BlobTest {
    // 向数据表customers中插入Blob类型的字段
    @Test
    public void testInsert() throws Exception {
        // 1.获取数据库的连接
        Connection conn = JDBCUtils.getConnection();
        // 2.预编译sql语句，返回PreparedStatement的实例
        String sql = "insert into customers(name,email,birth,photo)values(?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        // 3.填充占位符
        ps.setObject(1, "mice");
        ps.setObject(2, "mice@qq.com");
        ps.setObject(3, "2008-09-08");
        String path = "src/_0000_study/_db/_jdbc/basic/preparedstatement/blob/友情与爱情.jpg";
        FileInputStream is = new FileInputStream(new File(path));
        ps.setBlob(4, is);
        // 4.执行
        ps.execute();
        // 5.资源的关闭
        JDBCUtils.closeResource(conn, ps);
    }

    // 查询数据表customers中Blob类型的字段
    @Test
    public void testQuery() {
        Connection conn = null;
        PreparedStatement ps = null;
        InputStream is = null;
        FileOutputStream fos = null;
        ResultSet rs = null;
        try {
            // 1.获取数据库连接
            conn = JDBCUtils.getConnection();
            // 2.预编译sql语句，返回 PreparedStatement 的实例
            String sql = "select id,name,email,birth,photo from customers where id = ?";
            ps = conn.prepareStatement(sql);
            // 3.填充占位符
            ps.setInt(1, 20);
            // 4.执行,并返回结果集
            rs = ps.executeQuery();
            if (rs.next()) {
//                // 方式一：
//                int id = rs.getInt(1);
//                String name = rs.getString(2);
//                String email = rs.getString(3);
//                Date birth = rs.getDate(4);
                // 方式二：
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date birth = rs.getDate("birth");

                Customer cust = new Customer(id, name, email, birth);
                System.out.println(cust);

                // 将Blob类型的字段下载下来，以文件的方式保存在本地
                Blob photo = rs.getBlob("photo");
                is = photo.getBinaryStream();
                String path = "src/_0000_study/_db/_jdbc/basic/preparedstatement/blob/friendshipAndLove.jpg";
                fos = new FileOutputStream(path);
                byte[] buffer = new byte[1024];
                int len;
                while ((len = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5.资源的关闭
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JDBCUtils.closeResource(conn, ps, rs);
        }
    }
}
