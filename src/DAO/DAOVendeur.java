package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import Bean.Vendeur;
import oracle.jdbc.OracleTypes;

public class DAOVendeur extends Idao<Vendeur>{
	public DAOVendeur(Connection conn) {
		super(conn);
	}

	public Vendeur login(String email, String password) {
		Vendeur vendeur =null;
		try{
			String sql = "{call PKG_UTILISATEUR.loginUtilisateur(?,?,?)}"; 
			CallableStatement call = connect.prepareCall(sql); 		
			call.setString(1, email);
			call.setString(2,password);
			call.registerOutParameter(3, OracleTypes.CURSOR); 
			call.execute();
			ResultSet  result = (ResultSet)call.getObject(3);
			while (result.next()){
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
		catch (Exception e){
			e.printStackTrace();  
		}
		return vendeur;
	}
	
	@Override
	public String create(Vendeur vendeur) {
		String res="";
		try{
			//if(login(client.getEmail(),client.getPassword())==null){
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
			/*}
			else
				res="0";*/
		}
		catch (Exception e){
			res="-111";
		}
		return res;
	}

	@Override
	public Vendeur find(Vendeur obj) {
		// TODO Auto-generated method stub
		return null;
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
