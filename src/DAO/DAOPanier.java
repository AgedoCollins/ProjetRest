package DAO;

import java.sql.Connection;

import Bean.Panier;

public class DAOPanier extends Idao<Panier>{
	public DAOPanier(Connection conn) {
		super(conn);
	}

	@Override
	public String create(Panier obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Panier find(Panier obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Panier obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Panier obj) {
		// TODO Auto-generated method stub
		return false;
	}
}
