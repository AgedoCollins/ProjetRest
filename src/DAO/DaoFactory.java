package DAO;

import java.sql.Connection;

import Bean.Client;
import Bean.Commande;
import Bean.Panier;
import Bean.Utilisateur;
import Bean.Vendeur;

public class DaoFactory {
	protected static final Connection conn = ConnectDB.getConnection();

	public Idao<Utilisateur> getDaoClient() {
		return new DaoUtilisateur(conn);
	}

	public Idao<Client> getDaoVendeur() {
		return new DaoVendeur(conn);
	}

	public Idao<Vendeur> getDaoArticle() {
		return new DaoArticle(conn);
	}

	public Idao<Commande> getDaoCommande() {
		return new DaoCommande(conn);
	}
	
	public Idao<Panier> getDaoPanier() {
		return new DaoPanier(conn);
	}
	
	public Idao<Catalogue> getDaoCatalogue() {
		return new DaoCatalogue(conn);
	}
}