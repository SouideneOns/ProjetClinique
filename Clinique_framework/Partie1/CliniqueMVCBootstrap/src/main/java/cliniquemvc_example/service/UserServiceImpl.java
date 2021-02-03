package cliniquemvc_example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cliniquemvc_example.dao.UserDao;
import cliniquemvc_example.form.maladeForm;
import cliniquemvc_example.form.rendezForm;
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



 public void update(String username, String password) {
  userDao.update(username, passwordEncoder.encode(password));
 }

 public void add(String username, String password) {
  userDao.add(username, passwordEncoder.encode(password));
 }
 
 public void addM(String CIN, String full_name ,String gender,String date_place,String age,String phone1,String phone2,String address,String grs,String maladies,String traitements,String question) {
	  userDao.addM(CIN,full_name,gender,date_place,age,phone1,phone2,address,grs,maladies,traitements,question);
	 }
 
 public void addR(String CIN,String full_name, String naissance, String type_rd, String nom_doc, String date, String heure,
			String question, String etat) {
	  userDao.addR(CIN,full_name,naissance,type_rd,nom_doc,date,heure,question,etat);
	 }

 public boolean userExists(String username) {
  return userDao.userExists(username);
 }

 public List<rendezForm> listAllRdv() {
		return userDao.listAllRdv();
		
	}

	public List<rendezForm> searchRdv(String des) {
		return userDao.searchRdv(des);
	}



	public void deleteRdv(int id) {
		userDao.deleteRdv(id);
		
	}



	public rendezForm findRdvById(int id) {
		return userDao.findRdvById(id);
	}


}