package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Pelicula;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class AppGibbonsRegistro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtDuracion;
	private JTextField txtDirector;
	private JTextField txtOrigen;
	private JTextField txtCalificacion;
	private JComboBox <String> cbCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppGibbonsRegistro frame = new AppGibbonsRegistro();
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
	public AppGibbonsRegistro() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrar();
				limpiar();
			}
		});
		btnRegistrar.setBounds(335, 11, 89, 23);
		getContentPane().add(btnRegistrar);
		
		JLabel lblCodPelicula = new JLabel("Id Pelicula");
		lblCodPelicula.setBounds(10, 20, 65, 14);
		getContentPane().add(lblCodPelicula);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 54, 46, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblDuracion = new JLabel("Duracion");
		lblDuracion.setBounds(10, 88, 65, 14);
		getContentPane().add(lblDuracion);
		
		JLabel lblDirector = new JLabel("Director");
		lblDirector.setBounds(10, 122, 46, 14);
		getContentPane().add(lblDirector);
		
		JLabel lblOrigen = new JLabel("Origen");
		lblOrigen.setBounds(10, 156, 46, 14);
		getContentPane().add(lblOrigen);
		
		JLabel lblCalificacion = new JLabel("Calificacion");
		lblCalificacion.setBounds(10, 190, 80, 14);
		getContentPane().add(lblCalificacion);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(85, 15, 86, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(85, 50, 122, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDuracion = new JTextField();
		txtDuracion.setBounds(85, 85, 65, 20);
		getContentPane().add(txtDuracion);
		txtDuracion.setColumns(10);
		
		txtDirector = new JTextField();
		txtDirector.setBounds(85, 120, 134, 20);
		getContentPane().add(txtDirector);
		txtDirector.setColumns(10);
		
		txtOrigen = new JTextField();
		txtOrigen.setBounds(85, 155, 80, 20);
		getContentPane().add(txtOrigen);
		txtOrigen.setColumns(10);
		
		txtCalificacion = new JTextField();
		txtCalificacion.setBounds(85, 190, 80, 20);
		getContentPane().add(txtCalificacion);
		txtCalificacion.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(10, 224, 65, 14);
		getContentPane().add(lblCategoria);
		
		cbCategoria = new JComboBox <String>();
		cbCategoria.setModel(new DefaultComboBoxModel<String>(new String[] {"ACCION", "SUSPENSO", "FICCION"}));
		cbCategoria.setBounds(84, 221, 135, 22);
		getContentPane().add(cbCategoria);

	}
	
	int leerCategoria() {
		return cbCategoria.getSelectedIndex();
	}
	
	int estableceCat() {
		switch(leerCategoria()) {
		case 0:
			return 1001;
		case 1:
			return 1002;
		default:
			return 1003;
		}
	}
	
	void registrar() {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql8");
		EntityManager em = fabrica.createEntityManager();
		
		String codigo = txtCodigo.getText();
		String nombre = txtNombre.getText();
		int duracion = Integer.parseInt(txtDuracion.getText());
		String director = txtDirector.getText();
		String origen = txtOrigen.getText();
		String calificacion = txtCalificacion.getText();
		int categoria = estableceCat();
				
		Pelicula p = new Pelicula();
		p.setCodigo(codigo);
		p.setNombre(nombre);
		p.setDuracion(duracion);
		p.setDirector(director);
		p.setOrigen(origen);
		p.setCalificacion(calificacion);
		p.setCategoria(categoria);
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		
		em.close();
	}
	
	void limpiar() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtDuracion.setText("");
		txtDirector.setText("");
		txtOrigen.setText("");
		txtCalificacion.setText("");
		cbCategoria.setSelectedIndex(0);
	}
}
