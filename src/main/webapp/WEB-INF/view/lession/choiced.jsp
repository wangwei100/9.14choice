<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/user/first">首页</a>

	<span>${message}</span>
	<div />
	<span>已选课程</span>
	<table border="1px">
		<tr>
			<th>类别</th>
			<th>课程</th>
			<th>教师</th>
			<th>教室</th>
			<td>操作</td>
		</tr>
		<c:forEach items="${lessionPages.list}" var="lession">
			<tr>
				<td>${lession.type}</td>
				<td>${lession.name}</td>
				<td>${lession.teacher_name}</td>
				<td>${lession.classroom_name}</td>
				<td><a href="/lession/do_delete?lession_id=${lession.id}">退课</a></td>
			</tr>
		</c:forEach>
	</table>

	<div>
		<c:forEach var="i" begin="1" end="${lessionPages.totalPage}" step="1">
			<a href="/lession/choiced?pageNum=${i}">${i}</a>&nbsp;&nbsp;
	</c:forEach>
	</div>

	<tr>
		<td><a href="/user/second">继续选课</a>
		<td><a href="/user/first">返回主页</a>
	</tr>
</body>
</html>