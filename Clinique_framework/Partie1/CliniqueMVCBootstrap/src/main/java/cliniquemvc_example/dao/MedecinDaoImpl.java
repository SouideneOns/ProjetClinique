package cliniquemvc_example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import cliniquemvc_example.form.maladeForm;
import cliniquemvc_example.model.Medecin;


@Repository
public class MedecinDaoImpl implements MedecinDao{
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}
	@Autowired
	public void setNamedParameterJdbcTemplate (NamedParameterJdbcTemplate namedParameterJdbcTemplate ) throws DataAccessException {
		this.namedParameterJdbcTemplate=namedParameterJdbcTemplate;
	}
	public List<Medecin> listAllMedecin(){
		String sql = "SELECT id,full_name,CIN,gender,date,age,place,phone,phone2,mail,address,specialité,immatricule FROM medecin";
		List<Medecin> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new MedecinMapper()) ;
		return list;
	}

	
	
	
	public Medecin findMedecinById(int id) {
		String sql = "SELECT * FROM medecin WHERE id= :id";
		Medecin medecin = namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(id), new MedecinMapper()) ;
		return medecin;
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
	
	
	private SqlParameterSource getSqlParameterByModel(Medecin medecin) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if(medecin !=null)
		{
			paramSource.addValue("id", medecin.getId());
			paramSource.addValue("full_name", medecin.getFull_name());
			paramSource.addValue("CIN", medecin.getCIN());
			paramSource.addValue("gender", medecin.getGender());
			paramSource.addValue("date", medecin.getDate());
			paramSource.addValue("age", medecin.getAge());
			paramSource.addValue("place", medecin.getPlace());
			paramSource.addValue("phone", medecin.getPhone());
			paramSource.addValue("phone2", medecin.getPhone2());
			paramSource.addValue("mail", medecin.getMail());
			paramSource.addValue("address", medecin.getAddress());
			paramSource.addValue("specialité", medecin.getSpecialité());
			paramSource.addValue("immatricule", medecin.getImmatricule());
		}
		return paramSource;
	}
	
	private static final class MedecinMapper implements RowMapper<Medecin>{
		public Medecin mapRow(ResultSet rs, int rowNum) throws SQLException{
			Medecin medecin = new Medecin();
			medecin.setId(rs.getInt("id"));
			medecin.setFull_name(rs.getString("full_name"));
			medecin.setCIN(rs.getString("CIN"));
			medecin.setGender(rs.getString("gender"));
			medecin.setDate(rs.getString("date"));
			medecin.setAge(rs.getString("age"));
			medecin.setPlace(rs.getString("place"));
			medecin.setPhone(rs.getString("phone"));
			medecin.setPhone2(rs.getString("phone2"));
			medecin.setMail(rs.getString("mail"));
			medecin.setAddress(rs.getString("address"));
			medecin.setSpecialité(rs.getString("specialité"));
			medecin.setImmatricule(rs.getString("immatricule"));
			return medecin;
		}
	}
	
	private static final class MaladeMapper implements RowMapper<maladeForm>{
		public maladeForm mapRow(ResultSet rs, int rowNum) throws SQLException{
			maladeForm maladeForm = new maladeForm();
			
			
			maladeForm.setCIN(rs.getString("CIN"));
			maladeForm.setFull_name(rs.getString("full_name"));
			maladeForm.setGender(rs.getString("gender"));
			maladeForm.setDate_place(rs.getString("date_place"));
			maladeForm.setAge(rs.getString("age"));
			maladeForm.setPhone1(rs.getString("phone1"));
			maladeForm.setPhone2(rs.getString("phone2"));
			maladeForm.setAddress(rs.getString("address"));
			maladeForm.setGrs(rs.getString("grs"));
			maladeForm.setMaladies(rs.getString("maladies"));
			maladeForm.setTraitements(rs.getString("traitements"));
			maladeForm.setQuestion(rs.getString("question"));
			maladeForm.setNum_dossier(rs.getString("num_dossier"));
			
			return maladeForm;
		}
	}

	public List<Medecin> searchmedecin(String des) {

		String sql = "SELECT id,full_name,CIN,gender,date,age,place,phone,phone2,mail,address,specialité,immatricule FROM medecin WHERE specialité LIKE concat(\"%\",:des,\"%\") OR full_name LIKE concat(\"%\",:des,\"%\") OR phone LIKE concat(\"%\",:des,\"%\")  ";
		List<Medecin> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModeldes(des), new MedecinMapper()) ;
		
		return list;
		
	}
	public List<maladeForm> listAllMalade() {
		String sql = "SELECT CIN,full_name,gender,date_place,age,phone1,phone2,address,grs,maladies,traitements,question,num_dossier FROM malade";
		List<maladeForm> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new MaladeMapper()) ;
		return list;
	}
	public List<maladeForm> searchmalade(String des) {
		String sql = "SELECT CIN,full_name,gender,date_place,age,phone1,phone2,address,grs,maladies,traitements,question,num_dossier FROM malade WHERE num_dossier LIKE concat(\"%\",:des,\"%\")";
		List<maladeForm> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModeldes(des), new MaladeMapper()) ;
		
		return list;
	}

	

	}
