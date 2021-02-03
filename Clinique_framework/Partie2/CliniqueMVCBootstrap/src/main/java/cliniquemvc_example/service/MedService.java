package cliniquemvc_example.service;

import java.util.List;
import cliniquemvc_example.form.medecinForm;
import cliniquemvc_example.model.Contact;
import cliniquemvc_example.model.Malade;

public interface MedService {
	public List<Malade> listAllMalade();

	public void addMalade(Malade malade);

	public void deleteMalade(int id);

	public void updateMalade(Malade malade);

	public Malade findMaladById(int id);

	public List<Malade> searchmalade(String des);
	
	public List<medecinForm> listAllMedecin();
	public List<medecinForm> searchmedecin(String des);
	
	public List<Contact> listAllContact();
	public List<Contact> searchcontact(String des);
}
