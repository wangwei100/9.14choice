package com.demohot.subject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demohot.subject.model.Teacher;

public interface TeacherMapper {
	void insert(Teacher teacher);

	void delete(Teacher teacher);

//	void update(Teacher teacher);

	Teacher get(@Param("id") Integer id);

	List<Teacher> list();
}
