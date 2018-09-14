package com.demohot.subject.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demohot.subject.mapper.UserMapper;
import com.demohot.subject.model.User;

@Controller
public class UserController {
	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/user/first")
	public ModelAndView first(Integer id, HttpSession session) {
		// 判断用户登录
		User hasUser = (User) session.getAttribute("loginUser");
		if (null == hasUser) {
			return new ModelAndView("redirect:/user/login");
		}
		ModelAndView mv = new ModelAndView("/user/first.jsp");
		return mv;
	}

	@RequestMapping("/user/do_first")
	public ModelAndView doFirst(Integer id, HttpSession session) {
		// 判断用户登录
		User hasUser = (User) session.getAttribute("loginUser");
		if (null == hasUser) {
			return new ModelAndView("redirect:/user/login");
		}
		Map<String, Object> model = new HashMap<>();
		User user = userMapper.get(id);
		model.put("user", user);
		return new ModelAndView("/user/update.jsp", model);
	}

	@RequestMapping("/user/second")
	public ModelAndView second(Integer id, HttpSession session) {
		// 判断用户登录
		User hasUser = (User) session.getAttribute("loginUser");
		if (null == hasUser) {
			return new ModelAndView("redirect:/user/login");
		}
		ModelAndView mv = new ModelAndView("/user/second.jsp");
		return mv;
	}

	@RequestMapping("/user/do_second")
	public ModelAndView doSecond(Integer id, HttpSession session) {
		// 判断用户登录
		User hasUser = (User) session.getAttribute("loginUser");
		if (null == hasUser) {
			return new ModelAndView("redirect:/user/login");
		}
		Map<String, Object> model = new HashMap<>();
		User user = userMapper.get(id);
		model.put("user", user);
		return new ModelAndView("/user/choiced.jsp");
	}

	@RequestMapping("/user/update")
	public ModelAndView update(Integer id, HttpSession session) {
		// 判断用户登录
		User hasUser = (User) session.getAttribute("loginUser");
		if (null == hasUser) {
			return new ModelAndView("redirect:/user/login");
		}
		ModelAndView mv = new ModelAndView("/user/update.jsp");
		return mv;
	}

	@RequestMapping("/user/do_update")
	public ModelAndView doUpdate(String oldPassword, String newPassword, HttpSession session) {
		// 判断用户登录
		User loginUser = (User) session.getAttribute("loginUser");
		if (null == loginUser) {
			return new ModelAndView("redirect:/user/login");
		}
		Map<String, Object> model = new HashMap<>();
		model.put("oldPassword", oldPassword);
		model.put("newPassword", newPassword);
		boolean validateSuccess = true;
		if (null == oldPassword || "".equals(oldPassword)) {
			// 老密码为空
			model.put("oldPasswordMessage", "老密码不能为空");
			validateSuccess = false;
		}
		String no = loginUser.getNo();
		User hasUser = userMapper.getByNoAndPassword(no, oldPassword);
		if (null == hasUser) {
			// 老密码错误
			model.put("oldPasswordMessage", "老密码错误");
			validateSuccess = false;
		}
		if (!validateSuccess) {
			return new ModelAndView("/user/update.jsp", model);
		}
		String s1 = new String("newPassword");
		String s2 = new String("newPassword_confirm");
		if (null == newPassword || "".equals(newPassword)) {
			// 新密码为空
			model.put("newPasswordMessage", "新密码不能为空");
			validateSuccess = false;
		}
		if (s1 == s2) {
			// 新密码不一致
			model.put("newPasswordMessage", "新密码不一致");
			validateSuccess = false;
		}
		if (!validateSuccess) {
			return new ModelAndView("/user/update.jsp", model);
		}
		User userUpdate = new User();
		userUpdate.setId(loginUser.getId());
		userUpdate.setPassword(newPassword);
		userMapper.update(userUpdate);
		session.removeAttribute("loginUser");
		return new ModelAndView("redirect:/user/login");
	}
}
