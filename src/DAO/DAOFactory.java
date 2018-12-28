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

	public Idao<Utilisateur> getDaoUtilisateur() {
		return new DAOUtilisateur(conn);
	}

	public Idao<Vendeur> getDaoVendeur() {
		return new DAOVendeur(conn);
	}
	
	public Idao<Client> getDaoClient() {
		return new DAOClient(conn);
	}

	public Idao<Article> getDaoArticle() {
		return new DAOArticle(conn);
	}

	public Idao<Commande> getDaoCommande() {
		return new DAOCommande(conn);
	}
	
	public Idao<Panier> getDaoPanier() {
		return new DAOPanier(conn);
	}
	
	public Idao<Catalogue> getDaoCatalogue() {
		return new DAOCatalogue(conn);
	}
}