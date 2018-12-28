package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;

import Bean.Article;

public class DAOArticle extends Idao<Article>{
	public DAOArticle(Connection conn) {
		super(conn);
	}

	@Override
	public String create(Article article) {
		String res="";
		try{
			String sql = "{call PKG_ARTICLE.createArticle(?,?,?,?)}"; 
			CallableStatement call = connect.prepareCall(sql); 				
			call.setString(1, article.getLibelle());
			call.setDouble(2, article.getPrix());
			call.setString(3, article.getDescriptif());
			call.setString(4, article.getNomImage());
			//call.setString(5, "11".toString());
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

	@Override
	public boolean delete(Article obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Article obj) {
		// TODO Auto-generated method stub
		return false;
	}
}
