package DAO;

import java.sql.Connection;

import Bean.Vendeur;

public class DAOVendeur extends Idao<Vendeur>{
	public DAOVendeur(Connection conn) {
		super(conn);
	}

	@Override
	public String create(Vendeur obj) {
		// TODO Auto-generated method stub
		return null;
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
