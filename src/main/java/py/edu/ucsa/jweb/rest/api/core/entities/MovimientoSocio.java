package py.edu.ucsa.jweb.rest.api.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the movimientos_socios database table.
 * 
 */
@Entity
@Table(name="movimientos_socios")
@NamedQuery(name="MovimientoSocio.findAll", query="SELECT m FROM MovimientoSocio m")
public class MovimientoSocio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="fecha_creacion")
	private Timestamp fechaCreacion;

	@Column(name="fecha_pago")
	private Timestamp fechaPago;

	private BigDecimal monto;

	//uni-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="id_estado")
	private Opcion estado;

	//uni-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="id_medio_pago")
	private Opcion medioPago;

	//uni-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="id_concepto")
	private Opcion concepto;

	//uni-directional many-to-one association to Socio
	@ManyToOne
	@JoinColumn(name="id_socio")
	private Socio socio;

	//uni-directional many-to-one association to TipoMovimiento
	@ManyToOne
	@JoinColumn(name="id_tipo_movimiento")
	private TipoMovimiento tipoMovimiento;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario_creacion")
	private Usuario usuarioCreacion;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario_aprobacion")
	private Usuario usuarioAprobacion;

	public MovimientoSocio() {
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

	public Opcion getConcepto() {
		return this.concepto;
	}

	public void setConcepto(Opcion concepto) {
		this.concepto = concepto;
	}

	public Socio getSocio() {
		return this.socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public TipoMovimiento getTipoMovimiento() {
		return this.tipoMovimiento;
	}

	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public Usuario getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(Usuario usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public Usuario getUsuarioAprobacion() {
		return this.usuarioAprobacion;
	}

	public void setUsuarioAprobacion(Usuario usuarioAprobacion) {
		this.usuarioAprobacion = usuarioAprobacion;
	}

}