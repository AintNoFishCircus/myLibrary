package kunde;


public class Kunde {

	private int customerID;
	private String name;
	private String vorname;
	private String strasse;
	private String plz;
	private String ort;
	private String tel;
	private String mobil;
	private String mail;
	private Kunde next;
	
	public Kunde(){
		
	}
	
	public Kunde(String name, String vorname, String strasse, String plz, String ort){
		setName(name);
		setVorname(vorname);
		setStrasse(strasse);
		setPlz(plz);
		setOrt(ort);
	}
	
	public Kunde (int cid, String name, String vorname, String strasse, String plz, String ort){
		setCustomerID(cid);
		setName(name);
		setVorname(vorname);
		setStrasse(strasse);
		setPlz(plz);
		setOrt(ort);
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	public Kunde getNext(){
		return next;
	}
	public void setNext(Kunde next){
		this.next = next;
	}
	
	
}
