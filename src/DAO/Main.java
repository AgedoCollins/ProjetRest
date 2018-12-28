package DAO;

import java.util.Date;

import Bean.Client;
import Bean.Utilisateur;

public class Main {

	public static void main(String[] args) {
		System.out.println(ConnectDB.getConnection());

		Idao<Utilisateur> utilisateurDAO = new DAOUtilisateur(ConnectDB.getConnection());
		
		System.out.println(ConnectDB.getConnection().toString());
		
		DAOClient daoClient = new DAOClient(ConnectDB.getConnection());
		
		System.out.println(daoClient.create(new Client("testtt", "test", "18/02/1994", "+32474747474", "a@a.com", "aaaa")));
		
		/*for(int i = 1; i < 2; i++){
	Utilisateur utilisateur = utilisateurDAO.find_id(i);
	System.out.println(utilisateur.toJson());
System.out.println("Utilisateur N°" + utilisateur.getId() + " - " + utilisateur.getNom() + " " + utilisateur.getPrenom() + " " + utilisateur.getDateNaiss() + " " + utilisateur.getTel() + " " + utilisateur.getEmail() +  " " + utilisateur.getPassword());
		}*/
		/*Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom("Agedo");
		utilisateur.setPrenom("Collins");
		utilisateur.setDateNaiss(new Date(1996-01-01));
		utilisateur.setTel("+3271717171");
		utilisateur.setEmail("collins.agedo@condorcet.be");
		utilisateur.setPassword("aaaa");
		utilisateurDAO.create(utilisateur);*/

		
	}

}
