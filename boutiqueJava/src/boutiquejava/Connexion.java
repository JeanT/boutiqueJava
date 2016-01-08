/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boutiquejava;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mysql.jdbc.Driver.*;

/**
 *
 * @author jeantonnerre
 */
public class Connexion {
	
	private Connection conn = null;

	public Connexion() {
		
	}
	
	public Connection getConn() {
		return conn;
	}
	
	public void enregistrerPilote(String pilote) {
		try {
			Driver drive = (Driver)Class.forName(pilote).newInstance();
			DriverManager.registerDriver(drive);
			System.out.println("* Pilote enregistré *");
		} 
		catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (InstantiationException ex) {
			Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void connexionBD(String protocole, String serveur, String port, String nomBase, String user, String motDePasse) {
		String url = protocole + "//" + serveur + ":" + port + "/" +nomBase;
		try {
			conn = DriverManager.getConnection(url, user, motDePasse) ;
			System.out.println("-------- Connexion à la BD établie --------");
		} catch (SQLException ex) {
			Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void close(Connection conn){
		try {
			conn.close();
			System.out.println("-------- Connexion à la BD fermée --------");
		} catch (SQLException ex) {
			Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public ResultSet select (String objet, String table) {
		ResultSet rs = null;
		String sql =  "select " + objet + " from " + table ;
		return rs;
	}
	
}
