package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Bean.Article;
import Bean.Vendeur;
import oracle.jdbc.OracleTypes;

public class DAOVendeur extends DAO<Vendeur> {
	public DAOVendeur(Connection conn) {
		super(conn);
	}

	public Vendeur login(String email, String password) {
		Vendeur vendeur = null;
		try {
			String sql = "{call PKG_UTILISATEUR.loginUtilisateur(?,?,?)}";
			CallableStatement call = connect.prepareCall(sql);
			call.setString(1, email);
			call.setString(2, password);
			call.registerOutParameter(3, OracleTypes.CURSOR);
			call.execute();
			ResultSet result = (ResultSet) call.getObject(3);
			while (result.next()) {
				if (result.getString("TYPE_UTILISATEUR").equals("vendeur")) {
					vendeur = new Vendeur();
					vendeur.setId(result.getInt("ID_UTILISATEUR"));
					vendeur.setNom(result.getString("NOM"));
					vendeur.setPrenom(result.getString("PRENOM"));
					vendeur.setDateNaissance(result.getString("DATENAISSANCE"));
					vendeur.setTelephone(result.getString("TELEPHONE"));
					vendeur.setEmail(email);
					vendeur.setPassword(password);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vendeur;
	}

	@Override
	public String create(Vendeur vendeur) {
		String res = "";
		try {
			String sql = "{call PKG_Utilisateur.createUtilisateur(?,?,?,?,?,?,?)}";
			CallableStatement call = connect.prepareCall(sql);
			call.setString(1, vendeur.getNom());
			call.setString(2, vendeur.getPrenom());
			call.setString(3, vendeur.getDateNaissance());
			call.setString(4, vendeur.getTelephone());
			call.setString(5, vendeur.getEmail());
			call.setString(6, vendeur.getPassword());
			call.setString(7, "vendeur");
			call.execute();
			res = "1";
		} catch (Exception e) {
			res = "-111";
		}
		return res;
	}

	@Override
	public Vendeur find(Vendeur obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Article> findArticlesByVendeur(Vendeur vendeur) {
		Article article = null;
		List<Article> listArticles = new ArrayList<Article>();
		try{
			String sql = "{call PKG_ARTICLE.findItemsVendor(?,?)}"; 
			CallableStatement call = connect.prepareCall(sql); 	
			call.setInt(1, vendeur.getId()); 
			call.registerOutParameter(2, OracleTypes.CURSOR); 
			call.execute();
			ResultSet  result = (ResultSet)call.getObject(2);
			while (result.next()){
				article = new Article();
				article.setId(result.getInt("ID_ARTICLE"));
				article.setLibelle(result.getString("LIBELLE"));
				article.setPrix(result.getDouble("PRIX"));
				article.setDescriptif(result.getString("DESCRIPTION_ARTICLE"));	
				article.setNomImage(result.getString("NOMIMAGE"));	
				listArticles.add(article);
			}
			vendeur.setListArticles(listArticles);
		}
		catch (Exception e){
			e.printStackTrace();  
		}
		return listArticles;
	}

	public List<Vendeur> findAll() {
		Vendeur vendeur = null;
		List<Vendeur> listVendeurs = new ArrayList<Vendeur>();
		try{
			String sql = "{call PKG_UTILISATEUR.findAll(?)}"; 
			CallableStatement call = connect.prepareCall(sql); 	
			call.registerOutParameter(1, OracleTypes.CURSOR); 
			call.execute();
			ResultSet  result = (ResultSet)call.getObject(1);
			while (result.next()){
				vendeur = new Vendeur();
				vendeur.setId(result.getInt("ID_UTILISATEUR"));
				vendeur.setNom(result.getString("NOM"));
				vendeur.setPrenom(result.getString("PRENOM"));
				vendeur.setDateNaissance(result.getString("DATENAISSANCE"));	
				vendeur.setTelephone(result.getString("TELEPHONE"));	
				vendeur.setEmail(result.getString("EMAIL"));	
				vendeur.setPassword(result.getString("PASS"));	
				listVendeurs.add(vendeur);
			}
		}
		catch (Exception e){
			e.printStackTrace();  
		}
		return listVendeurs;
	}
	
	@Override
	public boolean delete(Vendeur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Vendeur obj) {
		// TODO Auto-generated method stub
		return false;
	}
}
