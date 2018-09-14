package com.demohot.subject.model;

public class Lession {
	private Integer id;
	private Integer user_id;
	private Integer teacher_id;
	private Integer classroom_id;
	private String name;
	private Integer type;
	private Integer remain;
	private Integer max_number;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(Integer teacher_id) {
		this.teacher_id = teacher_id;
	}

	public Integer getClassroom_id() {
		return classroom_id;
	}

	public void setClassroom_id(Integer classroom_id) {
		this.classroom_id = classroom_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getRemain() {
		return remain;
	}

	public void setRemain(Integer remain) {
		this.remain = remain;
	}

	public Integer getMax_number() {
		return max_number;
	}

	public void setMax_number(Integer max_number) {
		this.max_number = max_number;
	}
}
