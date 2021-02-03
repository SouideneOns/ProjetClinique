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

import cliniquemvc_example.form.rendezForm;
import cliniquemvc_example.model.Medecin;
import cliniquemvc_example.model.UserInfo;




@Repository
public class UserDaoImpl implements UserDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}



	private SqlParameterSource getSqlParameterSource(String username, String password) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (username != null) {
			parameterSource.addValue("username", username);
		}
		if (password != null) {
			parameterSource.addValue("password", password);
		}

		return parameterSource;
	}

	private SqlParameterSource getSqlParameterSource(String CIN, String full_name, String gender, String date_place,
			String age, String phone1, String phone2, String address, String grs, String maladies, String traitements,
			String question) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (CIN != null) {
			parameterSource.addValue("CIN", CIN);
		}
		if (full_name != null) {
			parameterSource.addValue("full_name", full_name);
		}

		if (gender != null) {
			parameterSource.addValue("gender", gender);
		}
		if (date_place != null) {
			parameterSource.addValue("date_place", date_place);
		}
		if (age != null) {
			parameterSource.addValue("age", age);
		}
		if (phone1 != null) {
			parameterSource.addValue("phone1", phone1);
		}
		if (phone2 != null) {
			parameterSource.addValue("phone2", phone2);
		}

		if (address != null) {
			parameterSource.addValue("address", address);
		}

		if (grs != null) {
			parameterSource.addValue("grs", grs);
		}
		if (maladies != null) {
			parameterSource.addValue("maladies", maladies);
		}
		if (traitements != null) {
			parameterSource.addValue("traitements", traitements);
		}
		if (question != null) {
			parameterSource.addValue("question", question);
		}

		return parameterSource;
	}

	private SqlParameterSource getSqlParameterSource(String CIN,String full_name, String naissance, String type_rd, String nom_doc,
			String date, String heure, String question, String etat) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();

		if (CIN != null) {
			parameterSource.addValue("CIN", CIN);
		}
		if (full_name != null) {
			parameterSource.addValue("full_name", full_name);
		}

		if (naissance != null) {
			parameterSource.addValue("naissance", naissance);
		}
		if (type_rd != null) {
			parameterSource.addValue("type_rd", type_rd);
		}
		if (nom_doc != null) {
			parameterSource.addValue("nom_doc", nom_doc);
		}
		if (date != null) {
			parameterSource.addValue("date", date);
		}
		if (heure != null) {
			parameterSource.addValue("heure", heure);
		}

		if (question != null) {
			parameterSource.addValue("question", question);
		}
		if (etat != null) {
			parameterSource.addValue("etat", etat);
		}

		return parameterSource;
	}

	private static final class UserMapper implements RowMapper {

		public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserInfo user = new UserInfo();
			user.setUsername(rs.getString("username"));

			return user;
		}

	}



	public void update(String username, String password) {
		String sql = "update admins set password = :password where username = :username";

		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(username, password));

	}

	public void add(String username, String password) {
		String sql = "insert into admins(username, password) values(:username, :password)";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(username, password));

		sql = "insert into admin_roles(username, role) values(:username, 'ROLE_admins')";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(username, password));
	}

	public void addM(String CIN, String full_name, String gender, String date_place, String age, String phone1,
			String phone2, String address, String grs, String maladies, String traitements, String question) {
		String sql = "insert into malade(CIN,full_name,gender,date_place,age,phone1,phone2,address,grs,maladies,traitements,question) values(:CIN,:full_name,:gender,:date_place,:age,:phone1,:phone2,:address,:grs,:maladies,:traitements,:question)";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(CIN, full_name, gender, date_place, age, phone1,
				phone2, address, grs, maladies, traitements, question));

	}

	public void addR(String CIN,String full_name, String naissance, String type_rd, String nom_doc, String date, String heure,
			String question, String etat) {
		String sql = "insert into rendezvous(CIN,full_name,naissance,type_rd,nom_doc,date,heure,question,etat) values(:CIN,:full_name,:naissance,:type_rd,:nom_doc,:date,:heure,:question,:etat)";
		namedParameterJdbcTemplate.update(sql,
				getSqlParameterSource(CIN,full_name, naissance, type_rd, nom_doc, date, heure, question, etat));

	}

	public boolean userExists(String username) {
		String sql = "select * from admins where username = :username";

		List<UserInfo> list = namedParameterJdbcTemplate.query(sql, getSqlParameterSource(username, null),
				new UserMapper());

		if (list.size() > 0) {
			return true;
		}

		return false;
	}

	private static final class RdvMapper implements RowMapper<rendezForm>{
		public rendezForm mapRow(ResultSet rs, int rowNum) throws SQLException{
			rendezForm rendezForm = new rendezForm();
			
			rendezForm.setId(rs.getInt("id"));
			rendezForm.setCIN(rs.getString("CIN"));
			rendezForm.setFull_name(rs.getString("full_name"));
			rendezForm.setNaissance(rs.getString("naissance"));
			rendezForm.setType_rd(rs.getString("type_rd"));
			rendezForm.setNom_doc(rs.getString("nom_doc"));
			rendezForm.setDate(rs.getString("date"));
			rendezForm.setHeure(rs.getString("heure"));
			rendezForm.setQuestion(rs.getString("question"));
			rendezForm.setEtat(rs.getString("etat"));
			rendezForm.setResultats(rs.getString("resultats"));
			
			
			return rendezForm;
		}
	}
	
	
	
	private SqlParameterSource getSqlParameterByModel(rendezForm rendezForm) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if(rendezForm !=null)
		{
			paramSource.addValue("id", rendezForm.getId());
			paramSource.addValue("full_name", rendezForm.getFull_name());
			paramSource.addValue("CIN", rendezForm.getCIN());
			paramSource.addValue("naissance", rendezForm.getNaissance());
			paramSource.addValue("type_rd", rendezForm.getDate());
			paramSource.addValue("nom_doc", rendezForm.getNom_doc());
			paramSource.addValue("date", rendezForm.getDate());
			paramSource.addValue("heure", rendezForm.getHeure());
			paramSource.addValue("question", rendezForm.getQuestion());
			paramSource.addValue("etat", rendezForm.getEtat());
			paramSource.addValue("resultats", rendezForm.getResultats());
			
		}
		return paramSource;
	}
	private SqlParameterSource getSqlParameterByModeldes (String des) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("des", des);
		return paramSource;
	}

	public List<rendezForm> listAllRdv() {
		String sql = "SELECT id,CIN,full_name,naissance,type_rd,nom_doc,date,heure,question,etat,resultats FROM rendezvous";
		List<rendezForm> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new RdvMapper()) ;
		return list;
	}
	public List<rendezForm> searchRdv(String des) {
		String sql = "SELECT  id,CIN,full_name,naissance,type_rd,nom_doc,date,heure,question,etat,resultats FROM rendezvous WHERE CIN LIKE concat(\"%\",:des,\"%\")";
		List<rendezForm> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModeldes(des), new RdvMapper()) ;
		
		return list;
	}

	private SqlParameterSource getSqlParameterByModel(int id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", id);
		return paramSource;
	}


	public void deleteRdv(int id) {
		String sql="DELETE FROM rendezvous WHERE id= :id";	
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(id));
		
	}



	public rendezForm findRdvById(int id) {
		String sql = "SELECT * FROM rendezvous WHERE id= :id";
		rendezForm rendezForm = namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(id), new RdvMapper()) ;
		return rendezForm;
	}




	
}