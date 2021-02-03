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
import cliniquemvc_example.form.medecinForm;
import cliniquemvc_example.model.Contact;
import cliniquemvc_example.model.Malade;

@Repository
public class MaladeDaoImpl implements MaladeDao {
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public List<Malade> listAllMalade() {
		String sql = "SELECT id,CIN,full_name,gender,date_place,age,phone1,phone2,address,grs,maladies,traitements,question FROM malade";
		List<Malade> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new MaladeMapper());
		return list;
	}

	public void addMalade(Malade malade) {

		String sql = "INSERT INTO malade(CIN,full_name,gender,date_place,age,phone1,phone2,address,grs,maladies,traitements,question) VALUES (:CIN,:full_name,:gender,:date_place,:age,:phone1,:phone2,:address,:grs,:maladies,:traitements,:question)";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(malade));
	}

	public void deleteMalade(int id) {
		String sql = "DELETE FROM malade WHERE id = :id";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(id));
	}

	public void updateMalade(Malade malade) {
		String sql = "UPDATE malade SET CIN = :CIN,full_name = :full_name,gender = :gender,date_place = :date_place,age = :age,phone1 = :phone1,phone2 = :phone2,address = :address,grs = :grs,maladies = :maladies,traitements = :traitements,question = :question WHERE id = :id";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(malade));
	}

	public Malade findMaladeById(int id) {
		String sql = "SELECT * FROM malade WHERE id= :id";

		Malade malade = namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(id), new MaladeMapper());
		return malade;

	}

	private SqlParameterSource getSqlParameterByModel(int id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", id);
		return paramSource;
	}

	private SqlParameterSource getSqlParameterByModeldes(String des) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("des", des);
		return paramSource;
	}

	private SqlParameterSource getSqlParameterByModel(Malade malade) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (malade != null) {
			paramSource.addValue("id", malade.getId());
			paramSource.addValue("CIN", malade.getCIN());
			paramSource.addValue("full_name", malade.getFull_name());
			paramSource.addValue("gender", malade.getGender());
			paramSource.addValue("date_place", malade.getDate_place());
			paramSource.addValue("age", malade.getAge());
			paramSource.addValue("phone1", malade.getPhone1());
			paramSource.addValue("phone2", malade.getPhone2());
			paramSource.addValue("address", malade.getAddress());
			paramSource.addValue("grs", malade.getGrs());
			paramSource.addValue("maladies", malade.getMaladies());
			paramSource.addValue("traitements", malade.getTraitements());
			paramSource.addValue("question", malade.getQuestion());
		}
		return paramSource;
	}

	private static final class MaladeMapper implements RowMapper<Malade> {
		public Malade mapRow(ResultSet rs, int rowNum) throws SQLException {
			Malade malade = new Malade();
			malade.setId(rs.getInt("id"));
			malade.setCIN(rs.getString("CIN"));
			malade.setFull_name(rs.getString("full_name"));
			malade.setGender(rs.getString("gender"));
			malade.setDate_place(rs.getString("date_place"));
			malade.setAge(rs.getString("age"));
			malade.setPhone1(rs.getString("phone1"));
			malade.setPhone2(rs.getString("phone2"));
			malade.setAddress(rs.getString("address"));
			malade.setGrs(rs.getString("grs"));
			malade.setMaladies(rs.getString("maladies"));
			malade.setTraitements(rs.getString("traitements"));
			malade.setQuestion(rs.getString("question"));
			return malade;
		}
	}

	public List<Malade> searchmalade(String des) {
		String sql = "SELECT id,CIN,full_name,gender,date_place,age,phone1,phone2,address,grs,maladies,traitements,question FROM malade WHERE full_name LIKE concat(\"%\",:des,\"%\") OR CIN LIKE concat(\"%\",:des,\"%\")";
		List<Malade> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModeldes(des), new MaladeMapper());

		return list;
	}
	
	public List<medecinForm> searchmedecin(String des) {
		String sql = "SELECT id,CIN,full_name,gender,date,place,age,phone,phone2,address,mail,specialité,immatricule FROM medecin WHERE immatricule LIKE concat(\"%\",:des,\"%\")";
		List<medecinForm> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModeldes(des), new MedecinMapper());

		return list;
	}

	public List<medecinForm> listAllMedecin() {
		String sql = "SELECT id,CIN,full_name,gender,date,place,age,phone,phone2,address,mail,specialité,immatricule FROM medecin ";
		List<medecinForm> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModeldes(null), new MedecinMapper());

		return list;
	}
	
	private static final class MedecinMapper implements RowMapper<medecinForm> {
		public medecinForm mapRow(ResultSet rs, int rowNum) throws SQLException {
			medecinForm medecinForm = new medecinForm();
			medecinForm.setId(rs.getInt("id"));
			medecinForm.setCIN(rs.getString("CIN"));
			medecinForm.setFull_name(rs.getString("full_name"));
			medecinForm.setGender(rs.getString("gender"));
			medecinForm.setDate(rs.getString("date"));
			medecinForm.setAge(rs.getString("age"));
			medecinForm.setPlace(rs.getString("place"));
			medecinForm.setPhone(rs.getString("phone"));
			medecinForm.setPhone2(rs.getString("phone2"));
			medecinForm.setAddress(rs.getString("address"));
			medecinForm.setMail(rs.getString("mail"));
			medecinForm.setSpecialité(rs.getString("specialité"));
			medecinForm.setImmatricule(rs.getString("immatricule"));
			return medecinForm;
		}
	}

	public List<Contact> listAllContact() {
		String sql = "SELECT id,nom,num FROM contact";
		List<Contact> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new ContactMapper()) ;
		return list;
	}

	public List<Contact> searchcontact(String des) {
		String sql = "SELECT id,nom,num FROM contact WHERE nom LIKE concat(\"%\",:des,\"%\")";
		List<Contact> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModeldes(des), new ContactMapper()) ;
		
		return list;
	}
	
	private static final class ContactMapper implements RowMapper<Contact> {
		public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
			Contact contact = new Contact();
			contact.setId(rs.getInt("id"));
			contact.setNom(rs.getString("nom"));
			contact.setNum(rs.getString("num"));
			return contact;
		}
	}
}
