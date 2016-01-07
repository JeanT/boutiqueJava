/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boutiquejava;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeantonnerre
 */
public class BoutiqueJava {
	
	public static void main(String[] args) {
		
		Connexion c = new Connexion();
		Connection conn = null;
		
		System.out.println("Hello");
		c.enregistrerPilote("com.mysql.jdbc.Driver");
		c.connexionBD("jdbc:mysql:", "localhost", "3306", "boutique", "root", "root");
		conn = c.getConn(); //On récupère l'objet Connection pour instancier les différentes classes
		
		Utilisateur user = new Utilisateur(conn);
		//user.insererDansBD("Teaunaire", "Jean", "1 Rue Jean Henri Adema", "Biarritz", 64600, "tonnerrejean@gmail.com");
		//user.requeteDansBD("update utilisateur set nom='Tonnerre' where mail='tonnerrejean@gmail.com'");
		//user.requeteDansBD("DELETE FROM `utilisateur` WHERE `mail`='tonnerrejean@gmail.com'");
		
		// Ajout d'un produit
		Produit product = new Produit(conn);
		product.insererDansBD("TM5000G001", "World War Z", "/Applications/MAMP/htdocs/boutiqueJava/imageSrc/worldwarz.jpg", 16, 56);

		// Création d'une facture
		Facture facture = new Facture(user);
		facture.insererDansBD(product.getId(), "01/12/2015", user.getId());

		// Ajout d'items à la facture
		Item item = new Item();
		item.insererDansBD(facture.getId(), product.getId(), 2);

		// Calcul du montant de la facture
		System.out.println("Le montant de cette facture est de " + facture.montant() + " ! ");
		
		// Consultation des factures de user
		user.lesFactures();
		
		c.close(conn);
	}
	
}
