package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Pelicula;

public class RegistrarPelicula {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql8");
		EntityManager em = fabrica.createEntityManager();
		
		Pelicula p = new Pelicula();
		
		p.setCodigo(2004);
		p.setNombre("IT");
		p.setDuracion(90);
		p.setDirector("MUSCHIETTI A.");
		p.setOrigen("USA");
		p.setCalificacion("+17");
		p.setCategoria(1003);
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		
		System.out.println("Pelicula Registrada");
		em.close();
	}
}
