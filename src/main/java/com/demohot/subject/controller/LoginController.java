package com.demohot.subject.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demohot.subject.mapper.UserMapper;
import com.demohot.subject.model.User;

@Controller
public class LoginController {
	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/user/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("/user/login.jsp");
		return mv;
	}

	@RequestMapping("/user/do_login")
	@ResponseBody
	public ModelAndView dologin(String no, String password, HttpSession session) {
		Map<String, Object> model = new HashMap<>();
		model.put("no", no);
		model.put("password", password);
		boolean validateSuccess = true;
		if (null == no || "".equals(no)) {
			// 学号为空
			model.put("noMessage", "学号不能为空");
			validateSuccess = false;
		}
		if (null == password || "".equals(password)) {
			// 密码为空
			model.put("passwordMessage", "密码不能为空");
			validateSuccess = false;
		}
		if (!validateSuccess) {
			return new ModelAndView("/user/login.jsp", model);
		}
		User user = new User();
		user.setNo(no);
		user.setPassword(password);
		User hasUser = userMapper.getByNoAndPassword(no, password);
		if (null == hasUser) {
			model.put("noMessage", "用户名或密码错误");
			return new ModelAndView("/user/login.jsp", model);
		}
		session.setAttribute("loginUser", hasUser);
		return new ModelAndView("redirect:/user/first");
	}
	@RequestMapping("/user/click")
	public ModelAndView click() {
		ModelAndView mv = new ModelAndView("/user/click.jsp");
		return mv;
	}
}
