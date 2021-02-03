package cliniquemvc_example.model;

public class Malade {
	private Integer id;
	private String CIN;
	private String full_name;
	private String gender;
	private String date_place;
	private String age;
	private String phone1;
	private String phone2;
	private String address;
	private String grs;
	private String maladies;
	private String traitements;
	private String question;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDate_place() {
		return date_place;
	}

	public void setDate_place(String date_place) {
		this.date_place = date_place;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGrs() {
		return grs;
	}

	public void setGrs(String grs) {
		this.grs = grs;
	}

	public String getMaladies() {
		return maladies;
	}

	public void setMaladies(String maladies) {
		this.maladies = maladies;
	}

	public String getTraitements() {
		return traitements;
	}

	public void setTraitements(String traitements) {
		this.traitements = traitements;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Malade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Malade(Integer id, String cIN, String full_name, String gender, String date_place, String age, String phone1,
			String phone2, String address, String grs, String maladies, String traitements, String question) {
		super();
		this.id = id;
		CIN = cIN;
		this.full_name = full_name;
		this.gender = gender;
		this.date_place = date_place;
		this.age = age;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.address = address;
		this.grs = grs;
		this.maladies = maladies;
		this.traitements = traitements;
		this.question = question;
	}

}
