package com.demohot.subject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demohot.subject.mapper.ClassroomMapper;
import com.demohot.subject.model.Classroom;
import com.demohot.subject.utils.StringUtils;

@Controller
public class ClassroomController {
	@Autowired
	private ClassroomMapper classroomMapper;

	@RequestMapping(value = "/classroom/getClassroomList", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getClassroomList() {
		List<Classroom> list = classroomMapper.list();
		return StringUtils.toJsonString(list);
	}
}
