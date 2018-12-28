package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import Bean.Utilisateur;
import oracle.jdbc.OracleTypes;

public class DAOUtilisateur extends Idao<Utilisateur>{
	public DAOUtilisateur(Connection conn) {
		super(conn);
	}

	public Utilisateur login(String email, String password) {
		Utilisateur utilisateur =null;
		try{
			String sql = "{call PKG_Utilisateur.loginUser(?,?,?)}"; 
			CallableStatement call = connect.prepareCall(sql); 		
			call.setString(1, email);
			call.setString(2,password);
			call.registerOutParameter(3, OracleTypes.CURSOR); 
			call.execute();
			ResultSet  result = (ResultSet)call.getObject(3);
			while (result.next()){
				utilisateur = new Utilisateur();
				utilisateur.setId(result.getInt("ID"));
				utilisateur.setNom(result.getString("NOM"));
				utilisateur.setPrenom(result.getString("PRENOM"));
				utilisateur.setDateNaissance(result.getString("DATENAISSANCE"));
				utilisateur.setTelephone(result.getString("TELEPHONE"));
				utilisateur.setEmail(email);
				utilisateur.setPassword(password);			
			}
		}
		catch (Exception e){
			e.printStackTrace();  
		}
		return utilisateur;
	}
	
	@Override
	public String create(Utilisateur utilisateur) {
		String res="";
		try{
			//if(login(utilisateur.getEmail(),utilisateur.getPassword())==null){
				String sql = "{call PKG_Utilisateur.createUtilisateur(?,?,?,?,?,?)}"; 
				CallableStatement call = connect.prepareCall(sql); 		
				call.setString(1, utilisateur.getNom());
				call.setString(2, utilisateur.getPrenom());
				call.setString(3, utilisateur.getDateNaissance());
				call.setString(4, utilisateur.getTelephone());
				call.setString(5, utilisateur.getEmail());
				call.setString(6, utilisateur.getPassword());
				call.execute();
				res = "1";
			/*}
			else
				res="0";*/

		}
		catch (Exception e){
			res="-111";
			//res=e.getMessage();
		}
		return res;
	}

	@Override
	public Utilisateur find(Utilisateur obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Utilisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Utilisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}
}
