package com.demohot.subject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demohot.subject.model.UserLession;

public interface UserLessionMapper {
	int insert(UserLession ul);

	void delete(UserLession ul);

	int update(UserLession ul);

	UserLession get(@Param("id") Integer id);

	UserLession getByUserIdLessionId(@Param("user_id") Integer userId, @Param("lession_id") Integer lessionId);

	int countByUserId(@Param("user_id") Integer user_id);

	List<UserLession> getById(Integer id);

	int getTotalRecord();

}
