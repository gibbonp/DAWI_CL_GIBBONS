package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Pelicula;

public class RegistrarPelicula {
	public static void name() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql8");
		EntityManager em = fabrica.createEntityManager();
		
		Pelicula p = new Pelicula();
		
		
		
		
		
		
		
		
	}

}
