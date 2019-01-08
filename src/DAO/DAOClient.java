package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.Client;
import Bean.Vendeur;
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
	
public boolean update(Client cli) {
		
		
		String sql = "{call PKG_Utilisateur.updateUtilisateur(?,?,?,?,?,?,?)}"; 
		CallableStatement call;
		try {
			call = connect.prepareCall(sql); 		
			call.setInt(1, cli.getId());
			call.setString(2, cli.getNom());
			call.setString(3, cli.getPrenom());
			call.setString(4, cli.getDateNaissance());
			call.setString(5, cli.getTelephone());
			call.setString(6, cli.getEmail());
			call.setString(7, cli.getPassword());
			call.execute();
			return true;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		} 
	}

	@Override
	public Client find(Client obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Client> findAll() {
		Client client = null;
		List<Client> listClients = new ArrayList<Client>();
		try{
			String sql = "{call PKG_UTILISATEUR.findAll(?)}"; 
			CallableStatement call = connect.prepareCall(sql); 	
			call.registerOutParameter(1, OracleTypes.CURSOR); 
			call.execute();
			ResultSet  result = (ResultSet)call.getObject(1);
			while (result.next()){
				client = new Client();
				client.setId(result.getInt("ID_UTILISATEUR"));
				client.setNom(result.getString("NOM"));
				client.setPrenom(result.getString("PRENOM"));
				client.setDateNaissance(result.getString("DATENAISSANCE"));	
				client.setTelephone(result.getString("TELEPHONE"));	
				client.setEmail(result.getString("EMAIL"));	
				client.setPassword(result.getString("PASS"));	
				listClients.add(client);
			}
		}
		catch (Exception e){
			e.printStackTrace();  
		}
		return listClients;
	}
	
	@Override
	public boolean delete(Client obj) {
		// TODO Auto-generated method stub
		return false;
	}
}
