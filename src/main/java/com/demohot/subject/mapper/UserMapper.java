package com.demohot.subject.mapper;

import org.apache.ibatis.annotations.Param;

import com.demohot.subject.model.User;

public interface UserMapper {
	
	void insert(User user);

	void delete(User user);

	void update(User user);

	void updatePasswordByNo(@Param("no") String no, @Param("passsword") String password);

	User get(@Param("id") Integer id);

	User getByNo(@Param("no") String no);

	User getByNoAndPassword(@Param("no") String no, @Param("password") String password);
}
