package cliniquemvc_example.model;

public class RendezVous {
	private Integer id;
	private String full_name;
	private String date;
	private String heure;
	private String etat;
	private String naissance;
	private String type_rd;
	private String nom_doc;
	private String question;
	private String CIN;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getNaissance() {
		return naissance;
	}
	public void setNaissance(String naissance) {
		this.naissance = naissance;
	}
	public String getType_rd() {
		return type_rd;
	}
	public void setType_rd(String type_rd) {
		this.type_rd = type_rd;
	}
	public String getNom_doc() {
		return nom_doc;
	}
	public void setNom_doc(String nom_doc) {
		this.nom_doc = nom_doc;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	}
	public RendezVous(Integer id, String full_name, String date, String heure, String etat, String naissance,
			String type_rd, String nom_doc, String question, String cIN) {
		super();
		this.id = id;
		this.full_name = full_name;
		this.date = date;
		this.heure = heure;
		this.etat = etat;
		this.naissance = naissance;
		this.type_rd = type_rd;
		this.nom_doc = nom_doc;
		this.question = question;
		CIN = cIN;
	}
	public RendezVous() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
