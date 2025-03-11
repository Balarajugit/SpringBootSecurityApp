package com.example.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.bean.Student;
@Repository
public class StudentRepoImpl implements StudentRepo {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String saveStudent(Student s) {
		String res=null;
		try {
			String sql="Insert into STUDENT(NAME,MAILID,BRANCH,BIRTHDATE,GENDER) values(?,?,?,?,?)";
			int update = jdbcTemplate.update(sql, s.getName(),s.getMailId(),s.getBranch(),s.getDateOfBirth(),s.getGender());
			if(update>0) 
				res=s.getName()+" Student Record Inserted sucessfully";
			else
				res="Record not Inserted";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

}
