<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	
	<span>类&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</span>
	<td><select id="type" name="type" class="input-medius">     
     	    <option value="0">-请选择-</option>     
	 		<option value="1">文学类</option>
 	     	<option value="2">理学类</option>
 		    <option value="3">体育类</option>
 		    <option value="4">音乐类</option>
		 </select>
	</br>
	<span>课&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;程</span>
	<input id="txt_name" type="text">
	</br>
	<span>任课教师</span>
	<td><select id="teacher_id" name="teacher_id" class="input-medium">
    		<option value="">--请选择--</option>
		</select>
	</br>
	<span>上课教室</span>
	<td><select id="classroom_id" name="classroom_id" class="input-medium">
    		<option value="">--请选择--</option>
		</select>
	</br>
	<span>上课人数</span>
	<input id="txt_max_number" type="text">
	</br>
	<span>剩余人数</span>
	<input id="txt_remain" type="text">
	</br>
	<input id="btn_insert" type="submit" value="确认加课" />
</body>
<script type="text/javascript" src="/js/insert.js"></script>
</html>