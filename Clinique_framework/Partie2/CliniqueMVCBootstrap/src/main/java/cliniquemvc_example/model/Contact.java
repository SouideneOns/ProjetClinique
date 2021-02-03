package cliniquemvc_example.model;

public class Contact {
	private Integer id;
	private String nom;
	private String num;

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

	public Contact(Integer id, String nom, String num) {
		super();
		this.id = id;
		this.nom = nom;
		this.num = num;
	}

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

}
