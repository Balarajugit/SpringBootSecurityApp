package com.example.repo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.bean.LoginDto;
import com.example.bean.Users;

@Repository
public class UserRepoImpl implements UserRepo{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public String saveUser(Users user) {
		String res=null;
		try {
			String sql="Insert into Users(NAME,USERNAME,MAILID,MOBILENO,GENDER,PASSWORD) values(?,?,?,?,?,?)";
			int update = jdbcTemplate.update(sql, user.getName(),user.getUserName(),user.getMail(),user.getMobileNo(),user.getGender(),user.getPassword());
			if(update>0) 
				res=user.getName()+" Record Inserted sucessfully";
			else
				res="Record not Inserted";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
		
	}
	
	@Override
	public LoginDto getByName(String username) {
		LoginDto u=null;
		try {
			String sql="select USERNAME,PASSWORD from Users where USERNAME=?";
			
			u= jdbcTemplate.queryForObject(sql, new Object[] {username},(rs, rowNum) -> mapUser(rs));
			
		} catch (Exception e) {
			u=null;
		}
		return u;
		
	}
	
	private LoginDto mapUser(ResultSet rs) throws SQLException {
		LoginDto u=new LoginDto();
		u.setUserName(rs.getString("USERNAME"));
		u.setPassword(rs.getString("PASSWORD"));
        return u;
    }

}
