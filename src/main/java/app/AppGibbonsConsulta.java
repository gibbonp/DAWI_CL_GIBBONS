package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;

import model.Pelicula;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;


public class AppGibbonsConsulta extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea txtSalida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppGibbonsConsulta frame = new AppGibbonsConsulta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AppGibbonsConsulta() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listar();
			}
		});
		btnConsultar.setBounds(181, 227, 89, 23);
		getContentPane().add(btnConsultar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 205);
		getContentPane().add(scrollPane);
		
		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);
		
	}
	
	void listar() {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql8");
		EntityManager em = fabrica.createEntityManager();
		
		List<Pelicula> lstPelicula = em.createQuery("select p from Pelicula p", Pelicula.class).getResultList();
		txtSalida.setText("<<<Lista de Peliculas>>>\n");
		
		for (Pelicula p : lstPelicula) {
			txtSalida.append(p.getCodigo() + " " + p.getNombre() + " " + p.getDuracion() + " min " + " " + p.getDirector() + " " + 
		p.getOrigen() + " " + p.getCalificacion() + " " + p.getCategoria() + "\n");
		}
		txtSalida.append("------------------------------------------------------\n");
	}
}
