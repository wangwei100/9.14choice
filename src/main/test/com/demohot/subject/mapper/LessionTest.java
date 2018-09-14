package com.demohot.subject.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.demohot.subject.model.Classroom;
import com.demohot.subject.model.Lession;
import com.demohot.subject.model.Teacher;

@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath:app-context.xml" })
public class LessionTest {
	@Autowired
	private LessionMapper lessionMapper;
	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private ClassroomMapper classroomMapper;

	@Test
	public void testInsert() {
		Teacher teacher = new Teacher();
		teacher.setName("张丹");
		teacher.setNo("21");
		teacher.setPassword("111111");
		Classroom classroom = new Classroom();
		classroom.setName("133");
		Lession lession = new Lession();
		lession.setType(1);
		lession.setName("大学语文");
		lession.setMax_number(90);
		lession.setRemain(90);
		teacherMapper.insert(teacher);
		classroomMapper.insert(classroom);
		lessionMapper.insert(lession);
	}
}
