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
			<h2>欢迎登陆</h2>
		</div>
		<div class="signin-info">
			<div style="text-align:center;">
				<h1 class="signin-title">用户登录</h1>
				<p>欢迎登录</p>
			</div>
			<form action="${pageContext.request.contextPath}/LoginServlet" method="post">
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
					    <td width="60%" valign="middle">
					    	<input type="text" name="verifycode" value="${verifycode }" placeholder="请输入验证码"/>
					    </td>
					    <td width="40%" valign="middle">
					    	<img src="VerifyCodeServlet" id="verify" onclick="document.getElementById('verify').src='VerifyCodeServlet?'+Math.random();">
					    </td>
					</tr>
					<tr>
						<td colspan="2">
							<font color="red" size="2">${loginError }</font>
						</td>
					</tr>
					<tr>
						<td width="35%" valign="middle" align="right">
							<button type="submit" class="signin-btn">登录</button>						
						</td>
					</tr>
					<tr>
					    <td width="50%" valign="middle" align="right">
					    	<a href="/TestLab/regist.jsp" class="signup-link">账号注册</a>
					    </td>
					</tr>
				</table>
			</form>
		</div>
	</div>
  </body>
</html>
