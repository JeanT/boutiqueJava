/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boutiquejava;

/**
 *
 * @author jeantonnerre
 */
public class Facture {
	Utilisateur user;
	
	public Facture(Utilisateur util) {
		user = util;
	};
	
	private int id;
	private String date;
	private int idUtilisateur;
	
	public int getId() {
		return id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String ladate) {
        date = ladate;
	}
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setStock(int lidUtilisateur) {
        idUtilisateur = lidUtilisateur;
    }
	
	
	public void insererDansBD (int idProduit, String date, int idUtilisateur) {
		String concat;
		// statement
		try {
			// insertion sql
			try (Statement stmt = c.createStatement()) {
				// insertion sql
				concat = "'" + idProduit + "','" + date + "','" + idUtilisateur;
				stmt.executeUpdate("insert into facture (idProduit,date,idUtilisateur) values (" + concat + ");") ;
			}
		} catch (SQLException ex) {
			Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public int montant() {
		// prix à retourner
		int prix = 0;
		// statement
		try {
			// insertion sql
			try (Statement stmt = c.createStatement()) {
				// select sql
				ResultSet rs = stmt.executeUpdate("	select idProduit, quantite, produit.prix as price 
													from item
													join produit
													on produit.id = item.idProduit
													where item.idFacture = " + this.getId() + ";");
				while(rs.next()) {
					prix = prix + ( ( rs.getInt("quantite") ) * ( rs.getInt("price") ) );
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
		}

	return(prix);
	}	
}
