package cliniquemvc_example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import cliniquemvc_example.dao.RendezVousDao;
import cliniquemvc_example.model.RendezVous;
@Service
public class RendezVousServiceImpl implements RendezVousService{
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

	RendezVousDao rendezVousDao;

	@Autowired
	public void setMaladeDao(RendezVousDao rendezVousDao) {
		this.rendezVousDao = rendezVousDao;
	}

	public List<RendezVous> listAllRendezVous() {
		return rendezVousDao.listAllRendezVous();
	}

	public void addRendezVous(RendezVous rendezVous) {
		rendezVousDao.addRendezVous(rendezVous);
		
	}

	public void deleteRendezVous(int id) {
		rendezVousDao.deleteRendezVous(id);
		
	}

	public void updateRendezVous(RendezVous rendezVous) {
		rendezVousDao.updateRendezVous(rendezVous);
		
	}

	public RendezVous findRendezVousById(int id) {
		return rendezVousDao.findRendezVousById(id);
	}

	public List<RendezVous> searchRendezVous(String des) {
		return rendezVousDao.searchRendezVous(des);
	}

}
