package py.edu.ucsa.jweb.rest.api.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the opciones database table.
 * 
 */
@Entity
@Table(name="opciones")
@NamedQuery(name="Opcion.findAll", query="SELECT o FROM Opcion o")
public class Opcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String codigo;

	private String descripcion;

	private String estado;

	//uni-directional many-to-one association to Dominio
	@ManyToOne
	@JoinColumn(name="id_dominio")
	private Dominio dominio;

	//uni-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="id_opcion_padre")
	private Opcion opcionePadre;

	public Opcion() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Dominio getDominio() {
		return this.dominio;
	}

	public void setDominio(Dominio dominio) {
		this.dominio = dominio;
	}

	public Opcion getOpcionePadre() {
		return this.opcionePadre;
	}

	public void setOpcionePadre(Opcion opcionePadre) {
		this.opcionePadre = opcionePadre;
	}

}