package cliniquemvc_example.form;

public class ContactForm {
	private Integer id;
	 public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	private String nom;
	 private String num;
	public ContactForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContactForm(Integer id, String nom, String num) {
		super();
		this.id = id;
		this.nom = nom;
		this.num = num;
	} 
	 
}
