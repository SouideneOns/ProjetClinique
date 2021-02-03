package cliniquemvc_example.dao;

import java.util.List;
import cliniquemvc_example.form.medecinForm;
import cliniquemvc_example.model.Contact;
import cliniquemvc_example.model.Malade;

public interface MaladeDao {
 public List<Malade> listAllMalade();
 public void addMalade(Malade malade);
 public void deleteMalade(int id);
 public void updateMalade(Malade malade);
 public Malade findMaladeById(int id);
public List<Malade> searchmalade(String des);

public List<medecinForm> searchmedecin(String des);
public List<medecinForm> listAllMedecin();


public List<Contact> listAllContact();
public List<Contact> searchcontact(String des);
 
}
