package com.demohot.subject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demohot.subject.controller.vo.LessionVo;
import com.demohot.subject.mapper.ClassroomMapper;
import com.demohot.subject.mapper.LessionMapper;
import com.demohot.subject.mapper.TeacherMapper;
import com.demohot.subject.mapper.UserLessionMapper;
import com.demohot.subject.model.Classroom;
import com.demohot.subject.model.Lession;
import com.demohot.subject.model.PageBean;
import com.demohot.subject.model.Teacher;
import com.demohot.subject.model.User;
import com.demohot.subject.model.UserLession;
import com.demohot.subject.service.LessionService;
import com.demohot.subject.utils.MyException;

@Controller
public class LessionController {
	@Autowired
	private LessionMapper lessionMapper;
	@Autowired
	private ClassroomMapper classroomMapper;
	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private UserLessionMapper userLessionMapper;
	@Autowired
	private LessionService lessionService;

	@RequestMapping("/lession/choice")
	public ModelAndView choice(@RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "3") Integer pageSize, Integer type, HttpSession session) {
		// 判断用户登录
		User loginUser = (User) session.getAttribute("loginUser");
		if (null == loginUser) {
			return new ModelAndView("redirect:/user/login");
		}
		ModelAndView mv = new ModelAndView();
		int offset = (pageNum - 1) * pageSize;
		List<Lession> lessions = lessionMapper.getByType(type, offset, pageSize);
		int totalRecord = lessionMapper.countByType(type);
		int totalPage = (int) Math.ceil((double) totalRecord / pageSize);
		List<LessionVo> lessionVoList = new ArrayList<>();
		for (Lession lession : lessions) {
			LessionVo lessionVo = new LessionVo();
			lessionVo.setId(lession.getId());
			lessionVo.setType(lession.getType());
			lessionVo.setName(lession.getName());
			lessionVo.setRemain(lession.getRemain());
			lessionVo.setTeacher_id(lession.getTeacher_id());
			lessionVo.setClassroom_id(lession.getClassroom_id());
			lessionVo.setMax_number(lession.getMax_number());

			Teacher teacher = teacherMapper.get(lession.getTeacher_id());
			Classroom classroom = classroomMapper.get(lession.getClassroom_id());
			lessionVo.setClassroom_name(classroom.getName());
			lessionVo.setTeacher_name(teacher.getName());
			lessionVoList.add(lessionVo);
		}
		mv.setViewName("/lession/choice.jsp");
		PageBean<LessionVo> lessionPage = new PageBean<LessionVo>();
		lessionPage.setList(lessionVoList);
		lessionPage.setPageNum(pageNum);
		lessionPage.setPageSize(pageSize);
		lessionPage.setTotalPage(totalPage);
		lessionPage.setTotalRecord(totalRecord);
		mv.addObject("lessionPage", lessionPage);
		mv.addObject("type", type);
		return mv;
	}

	@RequestMapping("/lession/do_choice")
	@ResponseBody
	public ModelAndView doChoice(Integer lession_id, HttpSession session) {
		// 判断用户登录
		User loginUser = (User) session.getAttribute("loginUser");
		if (null == loginUser) {
			return new ModelAndView("redirect:/user/login");
		}

		ModelAndView mv = new ModelAndView();
		try {
			lessionService.allCount(loginUser.getId());
		} catch (MyException e) {
			mv.setViewName("/lession/choice.jsp");
			mv.addObject("message", e.getDescribe());
			return mv;
		} catch (Exception e) {
			mv.setViewName("/lession/choice.jsp");
			mv.addObject("message", "系统错误，系统未知异常");
			return mv;
		}
		try {
			lessionService.choiceLession(loginUser.getId(), lession_id);
		} catch (MyException e) {
			mv.setViewName("/lession/choice.jsp");
			mv.addObject("message", e.getDescribe());
			return mv;
		} catch (Exception e) {
			mv.setViewName("/lession/choice.jsp");
			mv.addObject("message", "系统错误，系统未知异常");
			return mv;
		}
		return new ModelAndView("redirect:/lession/choiced");
	}

	@RequestMapping("/lession/choiced")
	public ModelAndView choiced(@RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "3") Integer pageSize, HttpSession session) {
		// 判断用户登录
		User loginUser = (User) session.getAttribute("loginUser");
		if (null == loginUser) {
			return new ModelAndView("redirect:/user/login");
		}
		ModelAndView mv = new ModelAndView();
		int offset = (pageNum - 1) * pageSize;
		List<Lession> list = lessionMapper.getByUserId(loginUser.getId(), offset, pageSize);
		int totalRecord = lessionMapper.countByUserId(loginUser.getId());
		int totalPage = (int) Math.ceil((double) totalRecord / pageSize);
		List<LessionVo> lessionVoLists = new ArrayList<>();
		for (Lession lession : list) {
			LessionVo lessionVo = new LessionVo();
			lessionVo.setId(lession.getId());
			lessionVo.setName(lession.getName());
			lessionVo.setUser_id(lession.getUser_id());
			lessionVo.setClassroom_id(lession.getClassroom_id());
			lessionVo.setType(lession.getType());
			lessionVo.setTeacher_id(lession.getTeacher_id());

			Teacher teacher = teacherMapper.get(lession.getTeacher_id());
			Classroom classroom = classroomMapper.get(lession.getClassroom_id());
			lessionVo.setClassroom_name(classroom.getName());
			lessionVo.setTeacher_name(teacher.getName());
			lessionVoLists.add(lessionVo);
		}
		mv.setViewName("/lession/choiced.jsp");
		PageBean<LessionVo> lessionPages = new PageBean<LessionVo>();
		lessionPages.setList(lessionVoLists);
		lessionPages.setPageNum(pageNum);
		lessionPages.setPageSize(pageSize);
		lessionPages.setTotalPage(totalPage);
		lessionPages.setTotalRecord(totalRecord);
		mv.addObject("lessionPages", lessionPages);
		return mv;
	}

	@RequestMapping("/lession/do_delete")
	public ModelAndView doDelete(Integer lession_id, HttpSession session) {
		// 判断用户登录
		User loginUser = (User) session.getAttribute("loginUser");
		if (null == loginUser) {
			return new ModelAndView("redirect:/user/login");
		}
		ModelAndView mv = new ModelAndView();
		lessionMapper.addRemain(lession_id);
		UserLession ul = new UserLession();
		ul.setUser_id(loginUser.getId());
		ul.setLession_id(lession_id);
		userLessionMapper.delete(ul);
		mv.setViewName("redirect:/lession/choiced");
		return mv;
	}

	@RequestMapping("/lession/insert")
	public ModelAndView insert(Integer id, HttpSession session) {
		// 判断用户登录
		User loginUser = (User) session.getAttribute("loginUser");
		if (null == loginUser) {
			return new ModelAndView("redirect:/user/login");
		}
		ModelAndView mv = new ModelAndView("/lession/insert.jsp");
		return mv;
	}

	@RequestMapping("/lession/do_insert")
	@ResponseBody
	public ModelAndView doInsert(String name, Integer max_number, Integer remain, String classroom_name,
			Integer teacher_id, Integer classroom_id, Integer type, HttpSession session) {
		// 判断用户登录
		User loginUser = (User) session.getAttribute("loginUser");
		if (null == loginUser) {
			return new ModelAndView("redirect:/user/login");
		}
		ModelAndView mv = new ModelAndView();
		Lession lession = new Lession();
		lession.setName(name);
		lession.setMax_number(max_number);
		lession.setRemain(remain);
		lession.setTeacher_id(teacher_id);
		lession.setType(type);
		lession.setClassroom_id(classroom_id);
		lessionMapper.insert(lession);
		mv.setViewName("redirect:/user/first");
		return mv;
	}
}
