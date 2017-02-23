package kunde;

import java.sql.SQLException;
import java.sql.ResultSet;
import dbmanager.DBConnector;

public class Kundenliste {

	private Kunde head;
	private Kunde tail;
	private int size;
	
	private DBConnector dbc = new DBConnector("rootgeek.org","3306","company","dbmanager","Astartes00");
	
	public Kundenliste(){
		this.head = null;
		this.tail = null;
		size = 0;
	}
	
	public void init(){
		head = null;
		tail = null;
		size = 0;
	}
	
	public void add(int cid, String name, String vorname, String strasse, String plz, String ort){
		Kunde k = new Kunde(cid, name, vorname, strasse, plz, ort);
		k.setCustomerID(cid);
		k.setName(name);
		k.setVorname(vorname);
		k.setStrasse(strasse);
		k.setPlz(plz);
		k.setOrt(ort);
		
		if(head == null){
			k.setNext(k);
			head = k;
			tail = k;	
			size++;
		}else{
			k.setNext(head.getNext());
			head.setNext(k);
			tail = head;
			head = k;
			size++;
		}
	}
	
	public void add(String name, String vorname, String strasse, String plz, String ort){
		Kunde k = new Kunde(name, vorname, strasse, plz, ort);
		k.setName(name);
		k.setVorname(vorname);
		k.setStrasse(strasse);
		k.setPlz(plz);
		k.setOrt(ort);
		
		if(head == null){
			k.setNext(k);
			head = k;
			tail = k;	
			size++;
		}else{
			k.setNext(head.getNext());
			head.setNext(k);
			tail = head;
			head = k;
			size++;
			}
	}
	
	public void delete(){
		if (head == null){
			
		}
		
		if(head == tail){
			this.init();
		}else{
			tail.setNext(head.getNext());
			head = head.getNext();
			size--;
		}
	}
	
	public void iterate(){
		if(head!=null){
			tail = head;
			head = head.getNext();
		}
	}
	
	public Kunde showData(){
		if(head == null){
			return null;
		}else{
			return head;
		}
	}
	
	public void showAll(){
		int sizetmp = size;
		while(size > 0){
			System.out.println(head.getCustomerID() + ": " + "Name: " + head.getName() + ", " + "Vorname: " + head.getVorname());
			System.out.println("Adresse: " + head.getStrasse() + " " + head.getPlz() + ", " + head.getOrt());
			iterate();
			size--;
		}
		size = sizetmp;
	}
	
	public void uploadData()throws ClassNotFoundException{
		dbc.connect();
		int sizetmp = size;
		while(size > 0 && head != null){
			String name = head.getName();
			String vorname = head.getVorname();
			String strasse = head.getStrasse();
			String plz = head.getPlz();
			String ort = head.getOrt();
			iterate();
			size--;
			dbc.insert("INSERT INTO customer (name, vorname, strasse, plz, ort) VALUES("
					+ "'" + name + "'" + ", " + "'" + vorname + "'" + ", " + "'" + strasse + "'" + ", " + "'" + plz + "'" + ", " + "'" + ort +"'" + ")"); 
		}
		javax.swing.JOptionPane.showMessageDialog(null, "Insert complete");
		dbc.disconnect();
		size = sizetmp;	
		
	}
	
	public void saveData()throws ClassNotFoundException{
		dbc.connect();
		String name = head.getName();
		String vorname = head.getVorname();
		String strasse = head.getStrasse();
		String plz = head.getPlz();
		String ort = head.getOrt();
		
		dbc.insert("INSERT INTO customer (name, vorname, strasse, plz, ort) VALUES("
				+ "'" + name + "'" + ", " + "'" + vorname + "'" + ", " + "'" + strasse + "'" + ", " + "'" + plz + "'" + ", " + "'" + ort +"'" + ")");
		javax.swing.JOptionPane.showMessageDialog(null, "Data saved");
		dbc.disconnect();
	}
	
	public void downloadData()throws ClassNotFoundException{
		this.init();
		dbc.connect();
		ResultSet res;
		
		try{
			res = dbc.createResultSet("SELECT * FROM customer");
			while(res.next()){
				
				this.add(res.getInt("cid"),res.getString("name"),res.getString("vorname")
						, res.getString("strasse"),res.getString("plz"), res.getString("ort"));
			}
			
			javax.swing.JOptionPane.showMessageDialog(null, "Data fetched");
			dbc.disconnect();
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}
	}
}
