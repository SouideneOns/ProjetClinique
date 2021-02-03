package cliniquemvc_example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import cliniquemvc_example.dao.MaladeDao;
import cliniquemvc_example.form.medecinForm;
import cliniquemvc_example.model.Contact;
import cliniquemvc_example.model.Malade;

@Service
public class MedServiceImpl implements MedService {
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	MaladeDao maladeDao;

	@Autowired
	public void setMaladeDao(MaladeDao maladeDao) {
		this.maladeDao = maladeDao;
	}
	
	public List<Malade> listAllMalade() {
		return maladeDao.listAllMalade();	
	}
	public void addMalade(Malade malade) {
		maladeDao.addMalade(malade);
	}
	public void deleteMalade(int id) {
		maladeDao.deleteMalade(id);
	}
	public void updateMalade(Malade malade) {
		maladeDao.updateMalade(malade);
	}
	public Malade findMaladById(int id) {
		return maladeDao.findMaladeById(id);
	}
	public List<Malade> searchmalade(String des) {
			return maladeDao.searchmalade(des);
	}
	
	
	
	public List<medecinForm> listAllMedecin() {
		return maladeDao.listAllMedecin();
	}
	public List<medecinForm> searchmedecin(String des) {
		return maladeDao.searchmedecin(des);
	}

	public List<Contact> listAllContact() {
		return maladeDao.listAllContact();
	}

	public List<Contact> searchcontact(String des) {
		return maladeDao.searchcontact(des);
	}
	
	


}


