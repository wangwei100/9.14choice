package com.demohot.subject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demohot.subject.mapper.TeacherMapper;
import com.demohot.subject.model.Teacher;
import com.demohot.subject.utils.StringUtils;

@Controller
public class TeacherController {

	@Autowired
	private TeacherMapper teacherMapper;

	@RequestMapping(value = "/teacher/getTeacherList", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getTeacherList() {
		List<Teacher> list = teacherMapper.list();
		return StringUtils.toJsonString(list);
	}

}
