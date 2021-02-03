package cliniquemvc_example.dao;

import java.util.List;

import cliniquemvc_example.form.maladeForm;
import cliniquemvc_example.form.rendezForm;
import cliniquemvc_example.model.Medecin;

import cliniquemvc_example.model.UserInfo;

public interface UserDao {
	

	 
	 public void update(String username, String password);
	 
	 public void add(String username, String password);
	 public void addM(String CIN, String full_name ,String gender,String date_place,String age,String phone1,String phone2,String address,String grs,String maladies,String traitements,String question);

	 public void addR(String CIN,String full_name,String naissance,String type_rd,String nom_doc,String date,String heure,String question,String etat);
	 public boolean userExists(String username);
	 
	 public List<rendezForm> listAllRdv();
	 public List<rendezForm> searchRdv(String des);
	 
	 public void deleteRdv(int id);
	 public rendezForm findRdvById(int id);
    
	
}
