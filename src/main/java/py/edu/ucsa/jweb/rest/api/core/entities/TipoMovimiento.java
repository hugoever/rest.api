package py.edu.ucsa.jweb.rest.api.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipos_movimiento database table.
 * 
 */
@Entity
@Table(name="tipos_movimiento")
@NamedQuery(name="TipoMovimiento.findAll", query="SELECT t FROM TipoMovimiento t")
public class TipoMovimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String codigo;

	private String descripcion;

	private String estado;

	@Column(name="tipo_deb_cred")
	private String tipoDebCred;

	public TipoMovimiento() {
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

	public String getTipoDebCred() {
		return this.tipoDebCred;
	}

	public void setTipoDebCred(String tipoDebCred) {
		this.tipoDebCred = tipoDebCred;
	}

}