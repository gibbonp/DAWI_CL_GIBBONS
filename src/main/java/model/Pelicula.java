package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_pelicula")
@Getter
@Setter
@ToString
public class Pelicula {
	
	@Id
	@Column(name = "cod_pelicula")
	private String codigo;
	
	@Column(name = "nom_pelicula")
	private String nombre;
	
	@Column(name = "duracion")
	private int duracion;

	@Column(name = "director")
	private String director;
	
	@Column(name = "origen")
	private String origen;
	
	@Column(name = "calificacion")
	private String calificacion;
	
	@Column(name = "cod_categoria")
	private int categoria;
}