package cliniquemvc_example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import cliniquemvc_example.dao.MedecinDao;
import cliniquemvc_example.dao.UserDao;
import cliniquemvc_example.form.maladeForm;
import cliniquemvc_example.model.Medecin;

@Service
public class MedecinServiceImpl implements MedecinService{
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

	MedecinDao medecinDao;


	@Autowired
	public void setMedecinDao(MedecinDao medecinDao) {
		this.medecinDao = medecinDao;
	}

	public List<Medecin> listAllMedecin() {
		return medecinDao.listAllMedecin();
	}
	


	public Medecin findMedecinById(int id) {
		return medecinDao.findMedecinById(id);
	}

	public List<Medecin> searchmedecin(String des) {
		return medecinDao.searchmedecin(des);
	}

	public List<maladeForm> listAllMalade() {
		return medecinDao.listAllMalade();
		
	}

	public List<maladeForm> searchmalade(String des) {
		return medecinDao.searchmalade(des);
	}





	}