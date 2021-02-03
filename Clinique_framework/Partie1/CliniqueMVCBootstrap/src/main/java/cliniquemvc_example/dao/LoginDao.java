package cliniquemvc_example.dao;

import java.util.List;

import cliniquemvc_example.model.UserInfo;

public interface LoginDao {

	UserInfo findUserInfo(String username);
	List<String> getUserRoles(String Username);
}
