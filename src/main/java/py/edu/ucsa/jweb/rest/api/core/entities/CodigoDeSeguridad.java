package py.edu.ucsa.jweb.rest.api.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the codigo_de_seguridad database table.
 * 
 */
@Entity
@Table(name="codigo_de_seguridad")
@NamedQuery(name="CodigoDeSeguridad.findAll", query="SELECT c FROM CodigoDeSeguridad c")
public class CodigoDeSeguridad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String codigo;

	@Column(name="hora_peticion")
	private Timestamp horaPeticion;

	@Column(name="tipo_activacion")
	private Integer tipoActivacion;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public CodigoDeSeguridad() {
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

	public Timestamp getHoraPeticion() {
		return this.horaPeticion;
	}

	public void setHoraPeticion(Timestamp horaPeticion) {
		this.horaPeticion = horaPeticion;
	}

	public Integer getTipoActivacion() {
		return this.tipoActivacion;
	}

	public void setTipoActivacion(Integer tipoActivacion) {
		this.tipoActivacion = tipoActivacion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}