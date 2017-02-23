package dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnector {

	private String hostname;
	private String port;
	private String database;
	private String user;
	private String password;
	private final String driver = "com.mysql.jdbc.Driver";
	private Connection con;
	private Statement stmt;
	private ResultSet res;
	
	public DBConnector(String hostname, String port, String database, String user, String password){
		setHostname(hostname);
		setPort(port);
		setDatabase(database);
		setUser(user);
		this.password = password;
	}
	
	public String getHostname(){
		return hostname;
	}
	
	public void setHostname(String hostname){
		this.hostname = hostname;
	}
	
	public String getPort(){
		return hostname;
	}
	
	public void setPort(String port){
		this.port = port;
	}
	
	public String getDatabase(){
		return database;
	}
	
	public void setDatabase(String database){
		this.database = database;
	}
	
	public String getUser(){
		return user;
	}
	
	public void setUser(String user){
		this.user = user;
	}
	
	public void connect()throws ClassNotFoundException{
		Class.forName(driver);
		String url = "jdbc:mysql://" + hostname + ":" + port  + "/" + database + "?" + "user=" + user + "&" + "password=" + password;
		try{
			con = DriverManager.getConnection(url);
			javax.swing.JOptionPane.showMessageDialog(null, "Connection to " + hostname + "/" + database + " established!");
		}catch(SQLException sqle){
			javax.swing.JOptionPane.showMessageDialog(null, "Could not get connection to " + hostname + "/" + database);
		}
	}
	
	public ResultSet createResultSet(String sql) throws SQLException{
		
			stmt = con.createStatement();
			res = stmt.executeQuery(sql);
			return res;
		
		
	}
	
	public void insert(String sql){
		try{
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			
			stmt.close();
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}	
	}
	
	public void update(String sql){
		try{
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			javax.swing.JOptionPane.showMessageDialog(null, "Update complete");
			stmt.close();
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}
	}
	
	public void disconnect(){
		try{
			con.close();
			javax.swing.JOptionPane.showMessageDialog(null, "Disconnected from " + hostname + "/" + database);
		}catch(SQLException sqle){
			sqle.getMessage();
			sqle.printStackTrace();
		}
	}
	
	
}
