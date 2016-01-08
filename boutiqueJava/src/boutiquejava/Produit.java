/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boutiquejava;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeantonnerre
 */
public class Produit {
	
	private Connection c;
	
	private int id;
	private String ref;
	private String titre;
	private String image;
	private int prix;
	private int stock;
	
	public Produit(Connection co) {
		c = co;
	};

	public int getId() {
		return id;
	}
	public String getRef() {
		return ref;
	}
	public void setNom(String laref) {
        ref = laref;
    }
	public String getTitre() {
		return titre;
	}
	public void setPrenom(String letitre) {
        titre = letitre;
    }
	public String getImage() {
		return image;
	}
	public void setRue(String limage) {
        image = limage;
    }
	public int getPrix() {
		return prix;
	}
	public void setVille(int leprix) {
        prix = leprix;
    }
	public int getStock() {
		return stock;
	}
	public void setStock(int lestock) {
        stock = lestock;
    }
	public void insererDansBD (String ref, String titre, String image, int prix, int stock) {
		String concat;
		// statement
		try {
			// insertion sql
			try (Statement stmt = c.createStatement()) {
				// insertion sql
				concat = "'" + ref + "','" + titre + "','" + image + "'," + prix + "," + stock ;
				stmt.executeUpdate("insert into produit (ref,titre,image,prix,stock) values (" + concat + ");") ;
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
}
