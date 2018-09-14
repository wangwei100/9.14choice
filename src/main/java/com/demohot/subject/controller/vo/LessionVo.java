package com.demohot.subject.controller.vo;

import com.demohot.subject.model.Lession;

public class LessionVo extends Lession {
	private String teacher_name;
	private String classroom_name;

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getClassroom_name() {
		return classroom_name;
	}

	public void setClassroom_name(String classroom_name) {
		this.classroom_name = classroom_name;
	}
}
