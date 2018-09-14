<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<span style="color: red;">${message}</span>
	<div></div>
	<table border="1px">
		<tr>
			<th>课程名称</th>
			<th>任课教师</th>
			<th>上课教室</th>
			<th>上课人数</th>
			<th>未选人数</th>
			<td>操作1</td>
			<td>操作2</td>
		</tr>
		<c:forEach items="${lessionPage.list}" var="lession">
			<tr>
				<td>${lession.name}</td>
				<td>${lession.teacher_name}</td>
				<td>${lession.classroom_name}</td>
				<td>${lession.max_number}</td>
				<td>${lession.remain}</td>
				<td><a href="/lession/do_choice?lession_id=${lession.id}&teacher_id=${teacher_id}&classroom_id=${classroom_id}">选择</a></td>
				<td><a href="/lession/insert">增加课程</a>
			</tr>
		</c:forEach>
	</table>
	<div>
		<c:forEach var="i" begin="1" end="${lessionPage.totalPage}" step="1">
			<a href="/lession/choice?type=${type}&pageNum=${i}">${i}</a>&nbsp;
		</c:forEach>
	</div>
</body>
<script type="text/javascript" src="/js/insert.js"></script>
</html>