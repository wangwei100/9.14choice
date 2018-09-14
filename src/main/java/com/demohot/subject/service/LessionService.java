package com.demohot.subject.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demohot.subject.model.Lession;

public interface LessionService {

	void choiceLession(Integer user_id, Integer lession_id);

	List<Lession> getByType(@Param("type") Integer type);

	List<Lession> getByTeacherId(@Param("teacher_id") Integer teacher_id);

	void allCount(@Param("user_id") Integer user_id);
}
