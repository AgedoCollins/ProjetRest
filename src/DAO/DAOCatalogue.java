package DAO;

import java.sql.Connection;

import Bean.Catalogue;

public class DAOCatalogue extends DAO<Catalogue>{
	public DAOCatalogue(Connection conn) {
		super(conn);
	}

	@Override
	public String create(Catalogue obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Catalogue find(Catalogue obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Catalogue obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Catalogue obj) {
		// TODO Auto-generated method stub
		return false;
	}
}
