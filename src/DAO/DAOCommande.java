package DAO;

import java.sql.Connection;

import Bean.Commande;

public class DAOCommande extends Idao<Commande>{
	public DAOCommande(Connection conn) {
		super(conn);
	}

	@Override
	public String create(Commande obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commande find(Commande obj) {
		// TODO Auto-generated method stub
		return null;
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
}
