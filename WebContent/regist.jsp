<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
  <body>
	<div class="signinpanel">
		<div class="signin-desc">
		</div>
		<div class="signin-info">
			<div style="text-align:center;">
				<h1 class="signin-title">用户注册</h1>
			</div>
			<form action="${pageContext.request.contextPath}/RegistServlet" method="post">
				<table>
					<tr>
						<td colspan="2">
							<input type="text" name="username" value="${username }" placeholder="请输入用户名"/>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="password" name="password" value="${password }" placeholder="请输入密码"/>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="password" name="rpsw" value="${rpsw }" placeholder="请再次输入密码"/>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<font color="red" size="2"> ${registError }</font>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<button type="submit" class="signin-btn">注册</button>
						</td>
					</tr>
					<tr>
					    <td colspan="2" valign="middle" align="left">
					    	<a href="${pageContext.request.contextPath}/login.jsp" class="signup-link">已有账号？返回登录</a>
					    </td>
					</tr>
				</table>
			</form>
		</div>
	</div>
  </body>
</html>