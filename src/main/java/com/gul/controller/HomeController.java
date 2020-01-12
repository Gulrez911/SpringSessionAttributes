package com.gul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.gul.entity.Student;
import com.gul.repo.StudentRepository;

@Controller
@SessionAttributes("sss")
public class HomeController {

	@Autowired
	StudentRepository repo;

	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("student", new Student());
		return mav;
	}

	@PostMapping("/authenticate")
	public ModelAndView home(@ModelAttribute("student") Student student, Model model) {
		ModelAndView mav = new ModelAndView("index");
		System.out.println(student);
	Student	student3 = repo.findByEmailAndPassword(student.getEmail(), student.getPassword());
//		model.addAttribute("student", student3);
		mav.addObject("sss", student3);
		System.out.println("Authenticate: " + student.getEmail() + student.getFname() + student.getId());
		Student student2 = new Student();
		mav.addObject("std", student2);
		return mav;
	}

	@PostMapping("register")
	public ModelAndView login(@ModelAttribute("std") Student student) {
		ModelAndView mav = new ModelAndView("success");
		repo.save(student);
		mav.addObject("std", student);
		System.out.println("Test: " + student.getFname() + " : " + student.getLname());
		return mav;
	}

	@GetMapping("test")
	public ModelAndView test(@SessionAttribute("sss") Student student) {
		ModelAndView mav = new ModelAndView("index");
		System.out.println("Test: " + student.getFname() + " : " + student.getLname());
		mav.addObject("std", new Student());
		return mav;
	}
}
