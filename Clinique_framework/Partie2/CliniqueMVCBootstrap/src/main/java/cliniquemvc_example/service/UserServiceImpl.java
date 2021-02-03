package cliniquemvc_example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cliniquemvc_example.dao.UserDao;
import cliniquemvc_example.model.UserInfo;

@Service
public class UserServiceImpl implements UserService {
 
 UserDao userDao;
 
 @Autowired
 private PasswordEncoder passwordEncoder;
 
 @Autowired
 public void setUserDao(UserDao userDao) {
  this.userDao = userDao;
 }

 public List<UserInfo> list() {
  return userDao.list();
 }

 public UserInfo findUserByUsername(String username) {
  return userDao.findUserByUsername(username);
 }

 public void update(String username, String password) {
  userDao.update(username, passwordEncoder.encode(password));
 }

 public void add(String username, String password) {
  userDao.add(username, passwordEncoder.encode(password));
 }
 
 public void addM(String CIN,String full_name,String gender,String age,String date,String place,String phone,String phone2,String address,String specialité,String immatricule,String mail) {
	  userDao.addM(CIN,full_name,gender,age,date,place,phone,phone2,address,specialité,immatricule,mail);
	 }

 public boolean userExists(String username) {
  return userDao.userExists(username);
 }



}