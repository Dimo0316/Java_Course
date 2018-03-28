<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome to login</title>

<script type="text/javascript">              <!--验证文本框内是否为空-->
         function check() {
             var username = document.getElementById("username");
             var userInfo = document.getElementById("usernameInfo");
             userInfo.innerHTML = "";
             if(username.value == "") {
                 userInfo.innerHTML = "用户名不能为空！";
                 username.focus();
                return false;
             }
             var password = document.getElementById("password");
             var passinfo = document.getElementById("pwd");
             passinfo.innerHTML = "";
            if(password.value == "") {
                passinfo.innerHTML = "密码不能为空！";
                password.focus();
                return false;
             }
            return true;
         }
     </script>

</head>
<body background="1.jpg">
	<!-- 背景图片 -->
	<center>
		<h1>用户登录</h1>
	</center>
	<br>
	<center>
		<form name="form2" action="loginServlet" method="post"
			onsubmit="return check()">
			<table border="0">
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="username" id="username"></td>
					<td><span id="usernameInfo"></span></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="password" id="password"></td>
					<td><span id="pwd"></span></td>
				</tr>
			</table>
			<br> <input type="submit" value="登录" style="color: #BC8F8F">

		</form>
	</center>

</body>
</html>