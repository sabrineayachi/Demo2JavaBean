package javabeans;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/**
 *
 * @author <a href="mailto:sabrinee.ayachi@gmail.com">Sabrine AYACHI</a>
 */

public class Compte {
	int numcompte; //=1;
	String proprietaire; //="sabrine";
	float solde; //=1000;
	
	Connection con = null;
	static String url = "jdbc:mysql://localhost:3306/mabase";
	static String user = "root";
	static String pwd = "";
	

	public void connecter(){
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);
			if (con != null)
				System.out.println("connexion effectu�e");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getNumcompte() {
		return numcompte;
	}
	public void setNumcompte(int numcompte) {
		this.numcompte = numcompte;
	}
	public String getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}
	public float getSolde() {
		connecter();
		System.out.println("num="+numcompte);
		try {Statement st= con.createStatement();
		ResultSet rs = st.executeQuery("select * from compte where numcompte = " + numcompte);
				
		while(rs.next()){
			solde = rs.getFloat("solde");
			proprietaire=rs.getString("proprietaire");
			rs.getInt("numcompte");
			System.out.println(solde);
			System.out.println(proprietaire);
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	
		return solde;
	}
	public void setSolde(float solde) {
		this.solde = solde;
	}
	/*<!--<jsp:setProperty name="MonBean" property= "*" /> <br> 
 <jsp:getProperty name="MonBean" property="proprietaire"/>  <br> -->


<!-- est <p> -->
<!--<jsp:getProperty name="MonBean" property="solde"/> <br> 
<jsp:getProperty name="MonBean" property="numcompte"/> <br> -->*/
	
	
	

}
