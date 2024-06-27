package py.edu.ucsa.jweb.rest.api.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the pagos_otros_conceptos database table.
 * 
 */
@Entity
@Table(name="pagos_otros_conceptos")
@NamedQuery(name="PagoOtroConcepto.findAll", query="SELECT p FROM PagoOtroConcepto p")
public class PagoOtroConcepto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="fecha_creacion")
	private Timestamp fechaCreacion;

	@Column(name="fecha_pago")
	private Timestamp fechaPago;

	private BigDecimal monto;

	//uni-directional many-to-one association to MovimientoSocio
	@ManyToOne
	@JoinColumn(name="id_movimiento_socio")
	private MovimientoSocio movimientoSocio;

	//uni-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="id_concepto")
	private Opcion concepto;

	//uni-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="id_estado")
	private Opcion estado;

	//uni-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="id_medio_pago")
	private Opcion medioPago;

	//uni-directional many-to-one association to Socio
	@ManyToOne
	@JoinColumn(name="id_socio")
	private Socio socio;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario_creacion")
	private Usuario usuarioCreacion;

	public PagoOtroConcepto() {
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

	public Timestamp getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Timestamp fechaPago) {
		this.fechaPago = fechaPago;
	}

	public BigDecimal getMonto() {
		return this.monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public MovimientoSocio getMovimientoSocio() {
		return this.movimientoSocio;
	}

	public void setMovimientoSocio(MovimientoSocio movimientoSocio) {
		this.movimientoSocio = movimientoSocio;
	}

	public Opcion getConcepto() {
		return this.concepto;
	}

	public void setConcepto(Opcion concepto) {
		this.concepto = concepto;
	}

	public Opcion getEstado() {
		return this.estado;
	}

	public void setEstado(Opcion estado) {
		this.estado = estado;
	}

	public Opcion getMedioPago() {
		return this.medioPago;
	}

	public void setMedioPago(Opcion medioPago) {
		this.medioPago = medioPago;
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