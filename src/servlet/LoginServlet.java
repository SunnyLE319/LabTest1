package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import dao.UserDao;

@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//���ձ���Ϣ
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String verifyc  = request.getParameter("verifycode");
		//���û���
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.setAttribute("verifycode", verifyc);
		//��ȡ��֤��
		String svc =(String) request.getSession().getAttribute("sessionverify");
		//�����û�����ѯ�û�
		User user =new UserDao().selectByUsername(username);
		if(!svc.equalsIgnoreCase(verifyc)){
			request.setAttribute("loginError", "* ��֤�����");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		if(user!=null){
			if(user.getPassword().equals(password)){
				request.getSession().setAttribute("user", user);
				response.sendRedirect("index.jsp");
			}else {
				request.setAttribute("loginError", "* �������");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("loginError", "* �û�������");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
