package fr.fms.bdd;

import java.sql.Connection;
import java.util.ArrayList;

public interface Dao {

	public interface TestDao<T> {
		// Requêtes enregistrées dans la BDD + connexion
		public Connection connection = TestJdbc.getConnection();
		public void create(T obj);
		public T read(int id);
		public boolean update(T obj);
		public boolean delete(T obj);
		public ArrayList<T> readAll();
		
	}
}
