package py.edu.ucsa.jweb.rest.api.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the pagos_cuotas_socios database table.
 * 
 */
@Entity
@Table(name="pagos_cuotas_socios")
@NamedQuery(name="PagoCuotaSocio.findAll", query="SELECT p FROM PagoCuotaSocio p")
public class PagoCuotaSocio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="anho_cuota")
	private Integer anhoCuota;

	private Boolean exonerado;

	@Column(name="fecha_creacion")
	private Timestamp fechaCreacion;

	@Column(name="mes_cuota")
	private Integer mesCuota;

	@Column(name="monto_cuota")
	private double montoCuota;

	//uni-directional many-to-one association to MovimientoSocio
	@ManyToOne
	@JoinColumn(name="id_movimiento_socio")
	private MovimientoSocio movimientoSocio;

	//uni-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="id_estado")
	private Opcion estado;

	//uni-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="id_motivo_exoneracion")
	private Opcion motivoExoneracion;

	//uni-directional many-to-one association to Socio
	@ManyToOne
	@JoinColumn(name="id_socio")
	private Socio socio;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario_creacion")
	private Usuario usuarioCreacion;

	public PagoCuotaSocio() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnhoCuota() {
		return this.anhoCuota;
	}

	public void setAnhoCuota(Integer anhoCuota) {
		this.anhoCuota = anhoCuota;
	}

	public Boolean getExonerado() {
		return this.exonerado;
	}

	public void setExonerado(Boolean exonerado) {
		this.exonerado = exonerado;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Integer getMesCuota() {
		return this.mesCuota;
	}

	public void setMesCuota(Integer mesCuota) {
		this.mesCuota = mesCuota;
	}

	public double getMontoCuota() {
		return this.montoCuota;
	}

	public void setMontoCuota(double montoCuota) {
		this.montoCuota = montoCuota;
	}

	public MovimientoSocio getMovimientoSocio() {
		return this.movimientoSocio;
	}

	public void setMovimientoSocio(MovimientoSocio movimientoSocio) {
		this.movimientoSocio = movimientoSocio;
	}

	public Opcion getEstado() {
		return this.estado;
	}

	public void setEstado(Opcion estado) {
		this.estado = estado;
	}

	public Opcion getMotivoExoneracion() {
		return this.motivoExoneracion;
	}

	public void setMotivoExoneracion(Opcion motivoExoneracion) {
		this.motivoExoneracion = motivoExoneracion;
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