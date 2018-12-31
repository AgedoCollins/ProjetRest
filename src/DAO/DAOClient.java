package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import Bean.Client;
import oracle.jdbc.OracleTypes;

public class DAOClient extends Idao<Client>{
	public DAOClient(Connection conn) {
		super(conn);
	}

	public Client login(String email, String password) {
		Client client =null;
		try{
			String sql = "{call PKG_UTILISATEUR.loginUtilisateur(?,?,?)}"; 
			CallableStatement call = connect.prepareCall(sql); 		
			call.setString(1, email);
			call.setString(2,password);
			call.registerOutParameter(3, OracleTypes.CURSOR); 
			call.execute();
			ResultSet  result = (ResultSet)call.getObject(3);
			while (result.next()){
				if (result.getString("TYPE_UTILISATEUR").equals("client")) {
					client = new Client();
					client.setId(result.getInt("ID_UTILISATEUR"));
					client.setNom(result.getString("NOM"));
					client.setPrenom(result.getString("PRENOM"));
					client.setDateNaissance(result.getString("DATENAISSANCE"));
					client.setTelephone(result.getString("TELEPHONE"));
					client.setEmail(email);
					client.setPassword(password);			
				}
			}
		}
		catch (Exception e){
			e.printStackTrace();  
		}
		return client;
	}
	
	@Override
	public String create(Client client) {
		String res="";
		try{
			//if(login(client.getEmail(),client.getPassword())==null){
				String sql = "{call PKG_Utilisateur.createUtilisateur(?,?,?,?,?,?,?)}"; 
				CallableStatement call = connect.prepareCall(sql); 		
				call.setString(1, client.getNom());
				call.setString(2, client.getPrenom());
				call.setString(3, client.getDateNaissance());
				call.setString(4, client.getTelephone());
				call.setString(5, client.getEmail());
				call.setString(6, client.getPassword());
				call.setString(7, "client");
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
	public Client find(Client obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Client obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Client obj) {
		// TODO Auto-generated method stub
		return false;
	}
}
