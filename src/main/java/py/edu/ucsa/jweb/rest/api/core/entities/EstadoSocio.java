package py.edu.ucsa.jweb.rest.api.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the estados_socios database table.
 * 
 */
@Entity
@Table(name="estados_socios")
@NamedQuery(name="EstadoSocio.findAll", query="SELECT e FROM EstadoSocio e")
public class EstadoSocio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="fecha_creacion")
	private Timestamp fechaCreacion;

	@Column(name="fecha_estado")
	private Timestamp fechaEstado;

	private String observacion;

	//uni-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="id_estado")
	private Opcion estado;

	//uni-directional many-to-one association to Socio
	@ManyToOne
	@JoinColumn(name="id_socio")
	private Socio socio;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario_creacion")
	private Usuario usuarioCreacion;

	public EstadoSocio() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaEstado() {
		return this.fechaEstado;
	}

	public void setFechaEstado(Timestamp fechaEstado) {
		this.fechaEstado = fechaEstado;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Opcion getEstado() {
		return this.estado;
	}

	public void setEstado(Opcion estado) {
		this.estado = estado;
	}

	public Socio getSocio() {
		return this.socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Usuario getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(Usuario usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

}