package DAO;

import java.sql.Connection;

public abstract class Idao<T> {
	protected Connection connect = null;

	public Idao(Connection conn) {
		this.connect = conn;
	}

	public abstract String create(T obj);

	public abstract T find(T obj);

	public abstract boolean delete(T obj);

	public abstract boolean update(T obj);
}
