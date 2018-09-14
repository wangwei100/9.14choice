package com.demohot.subject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demohot.subject.model.Lession;

public interface LessionMapper {
	void insert(Lession lession);

	void delete(Lession lession);

	Lession get(int id);

	List<Lession> list();

	List<Lession> getByType(@Param("type") Integer type, @Param("offset") Integer offset, @Param("pageSize") Integer pageSize);

	List<Lession> getByUserId(@Param("user_id") Integer userid, @Param("offset") Integer offset, @Param("pageSize") Integer pageSize);

	List<Lession> getByTeacherId(@Param("teacher_id") Integer teacher_id);

	int countByUserId(@Param("user_id") Integer user_id);

	int countByType(@Param("type") Integer type);

	List<Lession> getById(Integer id);

	int reduceRemain(@Param("id") Integer id);

	int addRemain(@Param("id") Integer id);

	
}
