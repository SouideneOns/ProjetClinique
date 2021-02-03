package cliniquemvc_example.dao;

import java.util.List;
import cliniquemvc_example.model.RendezVous;

public interface RendezVousDao {
	public List<RendezVous> listAllRendezVous();
	 public void addRendezVous(RendezVous rendezVous);
	 public void deleteRendezVous(int id);
	 public void updateRendezVous(RendezVous rendezvous);
	 public RendezVous findRendezVousById(int id);
	public List<RendezVous> searchRendezVous(String des);
}
