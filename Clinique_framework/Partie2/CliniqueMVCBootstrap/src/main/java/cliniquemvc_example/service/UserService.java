package cliniquemvc_example.service;

import java.util.List;

import cliniquemvc_example.model.UserInfo;

public interface UserService {
	 public List<UserInfo> list();
	 
	 public UserInfo findUserByUsername(String username);
	 
	 public void update(String username, String password);
	 
	 public void add(String username, String password);
	 public void addM(String CIN,String full_name,String gender,String age,String date,String place,String phone,String phone2,String address,String specialité,String immatricule,String mail);
	 
	 public boolean userExists(String username);
}
