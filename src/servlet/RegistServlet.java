package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import dao.UserDao;
@WebServlet("/RegistServlet")

public class RegistServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username==null||username.trim().isEmpty()){
			request.setAttribute("registError", "用户名不能为空");
			request.getRequestDispatcher("regist.jsp").forward(request, response);
			return;
		}
		if(password==null||password.trim().isEmpty()){
			request.setAttribute("registError", "密码不能为空");
			request.getRequestDispatcher("regist.jsp").forward(request, response);
			return;
		}
		
		User user = new User();
		UserDao userdao = new UserDao();
		if(userdao.selectByUsername(username)!=null){
            request.setAttribute("registError", "注册失败，该用户名已存在");
            request.getRequestDispatcher("regist.jsp").forward(request, response);
        }else {
            if(userdao.insert(user)){
                response.sendRedirect("index.jsp");
            }else {
                request.setAttribute("registError", "注册失败，发生未知错误");
                request.getRequestDispatcher("regist.jsp").forward(request, response);
            }
		
	}
		
	}
}
