<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<div>
		<form action="/user/do_update" method="post">
			<span>旧密码：</span> 
			<input id="txt_oldPassword" name="oldPassword"	type="password" value="${oldPassword}"> 
			<span>${oldPasswordMessage}</span><br />
			<span>新密码:</span> 
			<input id="txt_newPassword" name="newPassword"	type="password" value="${newPassword}"> 
			<span>${newPassword}</span><br />
			<span>确认新密码:</span> 
			<input id="txt_newPassword_confirm"	name="newPassword_confirm" type="password"	value="${newPassword_confirm}"> 
			<span>${newPassword_confirm}</span><br/>
			<input id="txt_amend" type="submit" value="确认修改" style="color:blue; width:80px ;height:25px"> 
		</form>
	</div>
</body>
<script type="text/javascript" src="/js/update.js"></script>
</html>