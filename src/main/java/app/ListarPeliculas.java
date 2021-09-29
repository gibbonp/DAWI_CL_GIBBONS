package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Pelicula;

public class ListarPeliculas {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql8");
		EntityManager em = fabrica.createEntityManager();
		
		List<Pelicula> lstPelicula = em.createQuery("select p from Pelicula p", Pelicula.class).getResultList();
		System.out.println("Nro de Peliculas : "+ lstPelicula.size());
		for (Pelicula p : lstPelicula) {
			System.out.println(">>> " + p);
		}	
	}
}
