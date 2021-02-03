package cliniquemvc_example.service;

import java.util.List;

import cliniquemvc_example.model.RendezVous;



public interface RendezVousService {
	public List<RendezVous> listAllRendezVous();

	public void addRendezVous(RendezVous rendezVous);

	public void deleteRendezVous(int id);

	public void updateRendezVous(RendezVous rendezVous);

	public RendezVous findRendezVousById(int id);

	public List<RendezVous> searchRendezVous(String des);
}
