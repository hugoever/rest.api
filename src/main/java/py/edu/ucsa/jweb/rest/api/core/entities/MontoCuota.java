package py.edu.ucsa.jweb.rest.api.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the montos_cuota database table.
 * 
 */
@Entity
@Table(name="montos_cuota")
@NamedQuery(name="MontoCuota.findAll", query="SELECT m FROM MontoCuota m")
public class MontoCuota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String estado;

	@Column(name="fecha_creacion")
	private Timestamp fechaCreacion;

	@Column(name="fecha_fin_vigencia")
	private Timestamp fechaFinVigencia;

	@Column(name="fecha_inactivacion")
	private Timestamp fechaInactivacion;

	@Column(name="fecha_inicio_vigencia")
	private Timestamp fechaInicioVigencia;

	private double monto;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario_inactivacion")
	private Usuario usuarioInactivacion;

	public MontoCuota() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaFinVigencia() {
		return this.fechaFinVigencia;
	}

	public void setFechaFinVigencia(Timestamp fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}

	public Timestamp getFechaInactivacion() {
		return this.fechaInactivacion;
	}

	public void setFechaInactivacion(Timestamp fechaInactivacion) {
		this.fechaInactivacion = fechaInactivacion;
	}

	public Timestamp getFechaInicioVigencia() {
		return this.fechaInicioVigencia;
	}

	public void setFechaInicioVigencia(Timestamp fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}

	public double getMonto() {
		return this.monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Usuario getUsuarioInactivacion() {
		return this.usuarioInactivacion;
	}

	public void setUsuarioInactivacion(Usuario usuarioInactivacion) {
		this.usuarioInactivacion = usuarioInactivacion;
	}

}