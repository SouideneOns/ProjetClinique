package cliniquemvc_example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import cliniquemvc_example.model.UserInfo;

@Repository
public class UserDaoImpl implements UserDao {
 
 NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 
 @Autowired
 public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
  this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
 }

 public List<UserInfo> list() {
  String sql = "select username from admins";
  
  List<UserInfo> list = namedParameterJdbcTemplate.query(sql, getSqlParameterSource(null, null), new UserMapper());
  
  return list;
 }
 
 private SqlParameterSource getSqlParameterSource(String username, String password){
  MapSqlParameterSource parameterSource = new MapSqlParameterSource();
  if(username != null){
   parameterSource.addValue("username", username);
  }
  if(password != null){
   parameterSource.addValue("password", password);
  }
  
  return parameterSource;
 }
 
 private SqlParameterSource getSqlParameterSource(String CIN,String full_name,String gender,String age,String date,String place,String phone,String specialité,String address,String immatricule,String phone2,String mail){
	  MapSqlParameterSource parameterSource = new MapSqlParameterSource();
	  if(full_name != null){
	   parameterSource.addValue("full_name", full_name);
	  }
	  if(CIN != null){
	   parameterSource.addValue("CIN", CIN);
	  }
	  
	  if(gender != null){
		   parameterSource.addValue("gender", gender);
		  }
	  if(age != null){
		   parameterSource.addValue("age", age);
		  }
		  if(date != null){
		   parameterSource.addValue("date", date);
		  }
		  
		  if(place != null){
			   parameterSource.addValue("place", place);
			  }
			  if(phone != null){
			   parameterSource.addValue("phone", phone);
			  }
			  
			  if(specialité != null){
				   parameterSource.addValue("specialité", specialité);
				  }
				  if(address != null){
				   parameterSource.addValue("address", address);
				  }
				  
				  if(immatricule != null){
					   parameterSource.addValue("immatricule", immatricule);
					  }
					  if(phone2 != null){
					   parameterSource.addValue("phone2", phone2);
					  }
					  if(mail != null){
						   parameterSource.addValue("mail", mail);
						  }
	  
	  return parameterSource;
	 }
 
 private static final class UserMapper implements RowMapper{

  public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
   UserInfo user = new UserInfo();
   user.setUsername(rs.getString("username"));
   
   return user;
  }
  
 }

 public UserInfo findUserByUsername(String username) {
  String sql = "select username from admins where username = :username";
  
  List<UserInfo> list = namedParameterJdbcTemplate.query(sql, getSqlParameterSource(username, null), new UserMapper());
  
  return list.get(0);
 }

 public void update(String username, String password) {
  String sql = "update admins set password = :password where username = :username";
  
  namedParameterJdbcTemplate.update(sql, getSqlParameterSource(username, password));
  
 }

 public void add(String username, String password) {
  String sql = "insert into admins(username, password) values(:username, :password)";
  namedParameterJdbcTemplate.update(sql, getSqlParameterSource(username, password));
  
  sql = "insert into admin_roles(username, role) values(:username, 'ROLE_admins')";
  namedParameterJdbcTemplate.update(sql, getSqlParameterSource(username, password));
 }
 
 public void addM(String CIN,String full_name,String gender,String age,String date,String place,String phone,String phone2,String address,String specialité,String immatricule,String mail) {
	  String sql = "insert into medecin(full_name,CIN,gender,age,date,place,phone,address,specialité,immatricule,phone2,mail) values(:full_name,:CIN,:gender,:age,:date,:place,:phone,:address,:specialité,:immatricule,:phone2,:mail)";
	  namedParameterJdbcTemplate.update(sql, getSqlParameterSource(full_name,CIN,gender,age,date,place,phone,address,specialité,immatricule,phone2,mail));
	  
	 }


 public boolean userExists(String username) {
  String sql = "select * from admins where username = :username";
  
  List<UserInfo> list = namedParameterJdbcTemplate.query(sql, getSqlParameterSource(username, null), new UserMapper());
  
  if(list.size() > 0){
   return true;
  }
  
  return false;
 }



}