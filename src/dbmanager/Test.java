package dbmanager;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException{
		// TODO Auto-generated method stub

		DBConnector dbc = new DBConnector("rootgeek.org", "3306", "company", "dbmanager", "Astartes00");
		dbc.connect();
		dbc.update("UPDATE customer SET vorname = 'Gerhard' WHERE cid = 2744;"); 
		
		
		dbc.disconnect();
	}

}
