package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Controller

public class StudentController {
	
	@Autowired
	StudentRepository repo; 
	
	@RequestMapping("/Home")
	public String show()
	{
		return "Home.jsp";
	}
	
	
	@RequestMapping(value="/create",method = RequestMethod.POST) 
	@ResponseBody
	public Student create1(@RequestBody Student student){  
		
		System.out.println("created0");
		System.out.println(student);
        repo.save(student);   
        return student;       
    } 
	
	
	
	
//	
//	@RequestMapping(value="/create",method = RequestMethod.POST) 
//	@ResponseBody
//	public Student create1(HttpServletRequest request, HttpServletResponse response) throws Exception {
//	System.out.println("created");	
//	Student s = new Student();
//	int id = Integer.parseInt(request.getParameter("id"));
//	String name = request.getParameter("name");
//	String city = request.getParameter("city");
//	
//	
//	s.setId(id);
//	s.setName(name);
//	s.setCity(city);
//	repo.save(s);
//    return s;       
//
//	}

	
	
	
	
	
	
	//@GetMapping("/getStudent")
	@GetMapping("/get/Student")

	@ResponseBody
	public List<Student> getStudent()
	{
	return repo.findAll();
	}

}
