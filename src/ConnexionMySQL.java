package src;
import java.sql.*;

public class ConnexionMySQL {
	private Connection mysql=null;
	private boolean connecte=false;
	public ConnexionMySQL() throws ClassNotFoundException, SQLException{
		Class.forName("org.mariadb.jdbc.Driver");
	}

	public void connecter() throws SQLException {
		try{
			mysql = DriverManager.getConnection("jdbc:mysql://servinfo-maria:3306/DBtbrossier","tbrossier","tbrossier");
			this.connecte=this.mysql!=null;
		}
		catch (SQLException ex){
			System.out.println("Msg:"+ex.getMessage()+ex.getErrorCode());
		}

	}
	public void close() throws SQLException {
		this.mysql.close();
		this.connecte=false;
	}

	public boolean isConnecte() { return this.connecte;}
	
	public Statement createStatement() throws SQLException {
		return this.mysql.createStatement();
	}

	public PreparedStatement prepareStatement(String requete) throws SQLException{
		return this.mysql.prepareStatement(requete);
	}
	
}