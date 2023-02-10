package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class userDB {
	    /**
	     * 数据库驱动
	     */
	    private static  final  String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	    /**
	     * 数据库连接地址
	     */
	    private static  final  String URL = "jdbc:mysql://localhost:3306/labuser?serverTimezone=Asia/Shanghai&user=root&password=123456&useUnicode=true&characterEncoding=GB2312";
	    /**
	     * 数据库用户名
	     */
	    public static Connection getConnection(){
	        Connection connection = null;
	        try {
	            Class.forName(DRIVER_NAME);
	            connection = DriverManager.getConnection(URL);
	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println("数据库连接获取失败，请检查数据库配置");
	            e.printStackTrace();
	        }
	        if(connection == null){
	            System.out.println("数据库连接获取失败，请检查数据库配置");
	        }
	        return connection;
	    }

	    /**
	     * 关闭JDBC连接
	     * @param con 连接实例
	     * @param pstmt PreparedStatement实例
	     */
	    public static void close(Connection con, PreparedStatement pstmt){
	        try {
	            if(pstmt!=null) {
	                pstmt.close();
	            }
	            if(con!=null) {
	                con.close();
	            }
	        }catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}


