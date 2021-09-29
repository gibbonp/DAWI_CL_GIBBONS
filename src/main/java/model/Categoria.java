package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_categorias")
@Getter
@Setter
@ToString
public class Categoria {

	@Id
	@Column(name = "cod_categoria")
	private int codigo;
	
	@Column(name = "descripcion")
	private String descripcion;
	
}
