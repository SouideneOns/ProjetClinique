package cliniquemvc_example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import cliniquemvc_example.model.RendezVous;

@Repository
public class RendezVousDaoImpl implements RendezVousDao {
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public List<RendezVous> listAllRendezVous() {
		String sql = "SELECT id,full_name,date,heure,etat FROM rendezvous";
		List<RendezVous> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new RendezVousMapper());
		return list;
	}

	

	public void deleteRendezVous(int id) {
		String sql = "DELETE FROM rendezvous WHERE id = :id";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(id));
	}

	public void updateRendezVous(RendezVous rendezvous) {
		String sql = "UPDATE rendezvous SET full_name = :full_name,date = :date,heure = :heure,etat = :etat WHERE id = :id";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(rendezvous));

	}

	public RendezVous findRendezVousById(int id) {
		String sql = "SELECT * FROM rendezvous WHERE id= :id";

		RendezVous rendezvous = namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(id), new RendezVousMapper());
		return rendezvous;
	}

	public List<RendezVous> searchRendezVous(String des) {
		String sql = "SELECT id,full_name,date,heure,etat FROM rendezvous WHERE date LIKE concat(\"%\",:des,\"%\") OR heure LIKE concat(\"%\",:des,\"%\")";
		List<RendezVous> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModeldes(des), new RendezVousMapper()) ;
		
		return list;
	}
	private SqlParameterSource getSqlParameterByModel(int id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", id);
		return paramSource;
	}
	private SqlParameterSource getSqlParameterByModeldes (String des) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("des", des);
		return paramSource;
	}

	private SqlParameterSource getSqlParameterByModel(RendezVous rendezvous) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (rendezvous != null) {
			paramSource.addValue("id", rendezvous.getId());
			
			paramSource.addValue("full_name", rendezvous.getFull_name());
			paramSource.addValue("date", rendezvous.getDate());
			paramSource.addValue("heure", rendezvous.getHeure());
			paramSource.addValue("etat", rendezvous.getEtat());
			paramSource.addValue("naissance", rendezvous.getNaissance());
			paramSource.addValue("type_rd", rendezvous.getType_rd());
			paramSource.addValue("nom_doc", rendezvous.getNom_doc());
			paramSource.addValue("question", rendezvous.getQuestion());
			paramSource.addValue("CIN", rendezvous.getCIN());
		}
		return paramSource;
	}

	private static final class RendezVousMapper implements RowMapper<RendezVous> {
		public RendezVous mapRow(ResultSet rs, int rowNum) throws SQLException {
			RendezVous rendezvous = new RendezVous();
			rendezvous.setId(rs.getInt("id"));
			rendezvous.setFull_name(rs.getString("full_name"));
			rendezvous.setDate(rs.getString("date"));
			rendezvous.setHeure(rs.getString("heure"));
			rendezvous.setEtat(rs.getString("etat"));
			
			return rendezvous;
		}
	}

	public void addRendezVous(RendezVous rendezVous) {
		String sql = "INSERT INTO rendezVous(full_name,date,heure,etat,naissance,type_rd,nom_doc,question,CIN) VALUES (:full_name,:date,:heure,:etat,:naissance,:type_rd,:nom_doc,:question,:CIN)";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(rendezVous));
		
	}

	
	

	
}
