package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class userDB {
	    /**
	     * ���ݿ�����
	     */
	    private static  final  String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	    /**
	     * ���ݿ����ӵ�ַ
	     */
	    private static  final  String URL = "jdbc:mysql://localhost:3306/labuser?serverTimezone=Asia/Shanghai&user=root&password=123456&useUnicode=true&characterEncoding=GB2312";
	    /**
	     * ���ݿ��û���
	     */
	    public static Connection getConnection(){
	        Connection connection = null;
	        try {
	            Class.forName(DRIVER_NAME);
	            connection = DriverManager.getConnection(URL);
	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println("���ݿ����ӻ�ȡʧ�ܣ��������ݿ�����");
	            e.printStackTrace();
	        }
	        if(connection == null){
	            System.out.println("���ݿ����ӻ�ȡʧ�ܣ��������ݿ�����");
	        }
	        return connection;
	    }

	    /**
	     * �ر�JDBC����
	     * @param con ����ʵ��
	     * @param pstmt PreparedStatementʵ��
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


