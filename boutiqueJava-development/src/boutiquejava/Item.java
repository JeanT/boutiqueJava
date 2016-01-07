/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boutiquejava;

import java.sql.Connection;

/**
 *
 * @author jeantonnerre
 */
public class Item {
	
	private Connection c;
	
	private int idFacture;
	private int idProduit;
	private int quantite;
	
	public Item(Connection co) {
		c = co;
	};
	
	public int getIdFacture() {
		return idFacture;
	}
	public void setIdFacture(int lIdFacture) {
		idFacture = lIdFacture;
	}
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int lIdProduit) {
		idProduit = lIdProduit;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int laQuantite) {
        quantite = laQuantite;
    }
	
	public void insererDansBD (int idFacture, int idProduit, int quantite) {
		String concat;
		// statement
		try {
			// insertion sql
			try (Statement stmt = c.createStatement()) {
				// insertion sql
				concat = "'" + idFacture + "','" + idProduit + "','" + quantite;
				stmt.executeUpdate("insert into item (idFacture,idProduit,quantite) values (" + concat + ");") ;
			}
		} catch (SQLException ex) {
			Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
