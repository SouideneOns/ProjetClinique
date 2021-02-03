package cliniquemvc_example.dao;

import java.util.List;

import cliniquemvc_example.form.maladeForm;
import cliniquemvc_example.model.Medecin;
public interface MedecinDao {

	public List<Medecin> listAllMedecin();
	public Medecin findMedecinById(int id);
	public List<Medecin> searchmedecin(String des);
	
	public List<maladeForm> listAllMalade();
	public List<maladeForm> searchmalade(String des);
	
}
