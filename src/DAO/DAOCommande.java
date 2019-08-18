package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Bean.Article;
import Bean.Client;
import Bean.Commande;
import oracle.jdbc.OracleTypes;

public class DAOCommande extends DAO<Commande>{
	public DAOCommande(Connection conn) {
		super(conn);
	}

	@Override
	public String create(Commande obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String create(Commande commande, Client client) {
		String res="";
		try{
			String sql = "{call PKG_COMMANDE.createCommande(?,?,?)}"; 
			CallableStatement call = connect.prepareCall(sql); 				
			call.setString(1, commande.getDateCommande());
			call.setInt(2, client.getId());
			call.setDouble(3, commande.getPrixTotale());
			call.execute();
			res = "1";

		}
		catch (Exception e){
			res="-111";
			res=e.getMessage();
		}
		return res;
	}
	

	public String createLigneCommande(Commande commande, Article article, int quantite) {
		String res="";
		try{
			String sql = "{call PKG_COMMANDE.createLigneCommande(?,?,?)}"; 
			CallableStatement call = connect.prepareCall(sql); 				
			call.setInt(1, commande.getId());
			call.setInt(2, article.getId());
			call.setInt(3, quantite);
			call.execute();
			res = "1";

		}
		catch (Exception e){
			res="-111";
			res=e.getMessage();
		}
		return res;
	}

	@Override
	public Commande find(Commande commande) {
		return commande;
	}
	
	public List<Commande> findAllForLastId() {
		Commande commande = null;
		List<Commande> listCommandes = new ArrayList<>();
		try{
			String sql = "{call PKG_COMMANDE.findAllJustCommande(?)}"; 
			CallableStatement call = connect.prepareCall(sql); 	
			call.registerOutParameter(1, OracleTypes.CURSOR); 
			call.execute();
			ResultSet  result = (ResultSet)call.getObject(1);
			while (result.next()){
				commande = new Commande();
				commande.setId(result.getInt("ID_COMMANDE"));
				commande.setDateCommande(result.getString("DATECOMMANDE"));
				listCommandes.add(commande);
			}
		}
		catch (Exception e){
			e.printStackTrace();  
		}
		return listCommandes;
	}
	
	
	public List<Commande> findCommandeByClient(int id) {
		Commande commande = null;
		List<Commande> listCommandes = new ArrayList<>();
		try{
			String sql = "{call PKG_COMMANDE.findCommandeUtilisateur(?,?)}"; 
			CallableStatement call = connect.prepareCall(sql); 	
			call.setInt(1, id);
			call.registerOutParameter(2, OracleTypes.CURSOR); 
			call.execute();
			ResultSet  result = (ResultSet)call.getObject(2);
			while (result.next()){
				commande = new Commande();
				commande.setId(result.getInt("ID_COMMANDE"));
				commande.setDateCommande(result.getString("DATECOMMANDE"));
				commande.setEtat(result.getString("ETAT"));
				commande.setPrixTotale(result.getDouble("PRIXTOTALE"));
				listCommandes.add(commande);
			}
		}
		catch (Exception e){
			e.printStackTrace();  
		}
		return listCommandes;
	}
	
	@Override
	public boolean delete(Commande obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Commande obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean updateTraite(Article article) {
		boolean res = false;
		try{
			String sql = "{call PKG_COMMANDE.updateEtatArticle(?,?,?)}"; 
			CallableStatement call = connect.prepareCall(sql); 	
			call.setInt(1, article.getId());
			call.setString(2, "TRAITEE");
			call.setInt(3, article.getId_commande());
			call.execute();
			res = true;

		}
		catch (Exception e){
			res = false;
		}
		return res;
	}
}
