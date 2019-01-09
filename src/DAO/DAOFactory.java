package DAO;

import java.sql.Connection;

import Bean.Article;
import Bean.Catalogue;
import Bean.Client;
import Bean.Commande;
import Bean.Panier;
import Bean.Utilisateur;
import Bean.Vendeur;

public class DAOFactory {
	protected static final Connection conn = ConnectDB.getConnection();

	public DAO<Utilisateur> getDaoUtilisateur() {
		return new DAOUtilisateur(conn);
	}

	public DAO<Vendeur> getDaoVendeur() {
		return new DAOVendeur(conn);
	}
	
	public DAO<Client> getDaoClient() {
		return new DAOClient(conn);
	}

	public DAO<Article> getDaoArticle() {
		return new DAOArticle(conn);
	}

	public DAO<Commande> getDaoCommande() {
		return new DAOCommande(conn);
	}
	
	public DAO<Panier> getDaoPanier() {
		return new DAOPanier(conn);
	}
	
	public DAO<Catalogue> getDaoCatalogue() {
		return new DAOCatalogue(conn);
	}
}