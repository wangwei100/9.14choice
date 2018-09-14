<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1px">
		<tr>
			<th>类别</th>
			<th>课程名称</th>
			<th>任课教师</th>
			<th>上课教室</th>
			<th>上课人数</th>
			<th>剩余人数</th>
			<td>操作1</td>
		</tr>
		<c:forEach items="${LessionList}" var="lession">
			<tr>
				<td>${lession.type}</td>
				<td>${lession.name}</td>
				<td>${lession.teacher_name}</td>
				<td>${lession.classroom_name}</td>
				<td>${lession.max_number}</td>
				<td>${lession.remain}</td>
				<td><a href="/lession/insert?lession_id=${lession.id}&teacher_id=${teacher_id}&classroom_id=${classroom_id}">继续加课</a></td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>