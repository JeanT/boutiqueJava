/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boutiquejava;

import static java.lang.Boolean.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeantonnerre
 */
public class Utilisateur {
	
	private Connection c;
	
	private int id;
	private String nom;
	private String prenom;
	private String rue;
	private String ville;
	private int codePostal;
	private String mail;
	
	public Utilisateur(Connection co) {
		c = co;
	};
	
	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String lenom) {
        nom = lenom;
    }
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String leprenom) {
        prenom = leprenom;
    }
	public String getRue() {
		return rue;
	}
	public void setRue(String larue) {
        rue = larue;
    }
	public String getVille() {
		return ville;
	}
	public void setVille(String laville) {
        ville = laville;
    }
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int lecodePostal) {
        codePostal = lecodePostal;
    }
	public String getMail() {
		return mail;
	}
	public void setMail(String lemail) {
        mail = lemail;
    }
	
	public void insererDansBD (String nom, String prenom, String rue, String ville, int codePostal, String mail) {
		String concat;
		// statement
		try {
			// insertion sql
			try (Statement stmt = c.createStatement()) {
				// insertion sql
				concat = "'" + nom + "','" + prenom + "','" + rue + "','" + ville + "','" + codePostal + "','" + mail + "'";
				stmt.executeUpdate("insert into utilisateur (nom,prenom,rue,ville,codePostal,mail) values (" + concat + ");") ;
			}
		} catch (SQLException ex) {
			Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	/*
	public void requeteDansBD(String requeteSQL) {
		// statement
		try {
			Statement stmt=c.createStatement();
			// insertion sql
			stmt.executeUpdate(requeteSQL);
			stmt.close();
		} catch (SQLException ex) {
			Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	*/
	public void lesFactures() {
		// statement
		try {
			try (Statement stmt = c.createStatement()) {
				// requête sql
				ResultSet rs = stmt.executeUpdate("select * from facture where facture.idUtilisateur = " + this.id;) ;
				while(rs.next()) {
					System.out.println("Facture du " + rs.getInt("date") + "");
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
