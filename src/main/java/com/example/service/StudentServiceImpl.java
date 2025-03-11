package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.Student;
import com.example.repo.StudentRepo;
@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepo srepo;
	
	@Override
	public String saveStudent(Student s) {
		// TODO Auto-generated method stub
		return srepo.saveStudent(s);
	}

}
