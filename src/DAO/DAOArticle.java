package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Bean.Article;
import Bean.Vendeur;
import oracle.jdbc.OracleTypes;

public class DAOArticle extends DAO<Article>{
	public DAOArticle(Connection conn) {
		super(conn);
	}

	@Override
	public String create(Article article) {
		String res="";
		return res;
	}

	public String create(Article article, Vendeur vendeur) {
		String res="";
		try{
			String sql = "{call PKG_ARTICLE.createArticle(?,?,?,?,?)}"; 
			CallableStatement call = connect.prepareCall(sql); 				
			call.setString(1, article.getLibelle());
			call.setDouble(2, article.getPrix());
			call.setString(3, article.getDescriptif());
			call.setString(4, article.getNomImage());
			call.setInt(5,  vendeur.getId());
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
	public Article find(Article obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Article findId(int id) {
		Article article = null;
		try{
			String sql = "{call PKG_ARTICLE.findById(?,?)}"; 
			CallableStatement call = connect.prepareCall(sql); 	
			call.setInt(1, id); 
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
			}
		}
		catch (Exception e){
			e.printStackTrace();  
		}
		return article;
	}
	
	public List<Article> findByIdVendeur(String id) {
		Article article = null;
		int id_vendeur = Integer.parseInt(id);
		
		List<Article> listArticles = new ArrayList<Article>();
		try{
			String sql = "{call PKG_ARTICLE.findItemsVendor(?,?)}"; 
			CallableStatement call = connect.prepareCall(sql); 	
			call.setInt(1, id_vendeur); 
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
		}
		catch (Exception e){
			e.printStackTrace();  
		}
		return listArticles;
	}
	
	public List<Article> findArticleInCommandeByIdVendeur(String id) {
		Article article = null;
		int id_vendeur = Integer.parseInt(id);
		
		List<Article> listArticles = new ArrayList<Article>();
		try{
			String sql = "{call PKG_ARTICLE.findItemsVendu(?,?)}"; 
			CallableStatement call = connect.prepareCall(sql); 	
			call.setInt(1, id_vendeur); 
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
				article.setId_commande(result.getInt("ID_COMMANDE"));
				listArticles.add(article);
			}
		}
		catch (Exception e){
			e.printStackTrace();  
		}
		return listArticles;
	}
	
	public List<Article> findByIdCommande(int id) {
		Article article = null;
		List<Article> listArticles = new ArrayList<Article>();
		try{
			String sql = "{call PKG_ARTICLE.findItemsCommande(?,?)}"; 
			CallableStatement call = connect.prepareCall(sql); 	
			call.setInt(1, id); 
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
		}
		catch (Exception e){
			e.printStackTrace();  
		}
		return listArticles;
	}
	
	public List<Article> findAll() {
		Article article = null;
		List<Article> listArticles = new ArrayList<Article>();
		try{
			String sql = "{call PKG_ARTICLE.FINDALL(?)}"; 
			CallableStatement call = connect.prepareCall(sql); 	
			call.registerOutParameter(1, OracleTypes.CURSOR); 
			call.execute();
			ResultSet  result = (ResultSet)call.getObject(1);
			while (result.next()){
				article = new Article();
				article.setId(result.getInt("ID_ARTICLE"));
				article.setLibelle(result.getString("LIBELLE"));
				article.setPrix(result.getDouble("PRIX"));
				article.setDescriptif(result.getString("DESCRIPTION_ARTICLE"));	
				article.setNomImage(result.getString("NOMIMAGE"));	
				listArticles.add(article);
			}
		}
		catch (Exception e){
			e.printStackTrace();  
		}
		return listArticles;
	}
	
	
	@Override
	public boolean delete(Article article) {
		boolean res=false;
		try{
			String sql = "{call PKG_ARTICLE.deleteArticle(?)}"; 
			CallableStatement call = connect.prepareCall(sql); 				
			call.setInt(1, article.getId());
			call.execute();
			res=true;

		}
		catch (Exception e){
			e.getMessage();
		}
		return res;
	}

	@Override
	public boolean update(Article article) {
		return false;
	}
	
	public String updateArticle(Article article) {
		String res="";
		try{
			String sql = "{call PKG_ARTICLE.updateArticle(?,?,?,?)}"; 
			CallableStatement call = connect.prepareCall(sql); 	
			call.setInt(1, article.getId());
			call.setString(2, article.getLibelle());
			call.setDouble(3, article.getPrix());
			call.setString(4, article.getDescriptif());
			call.execute();
			res = "1";

		}
		catch (Exception e){
			res="-1";
		}
		return res;
	}
}
