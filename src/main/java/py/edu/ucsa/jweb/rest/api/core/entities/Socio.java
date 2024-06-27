package py.edu.ucsa.jweb.rest.api.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the socios database table.
 * 
 */
@Entity
@Table(name="socios")
@NamedQuery(name="Socio.findAll", query="SELECT s FROM Socio s")
public class Socio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String apellidos;

	private String email;

	@Column(name="fecha_creacion")
	private Timestamp fechaCreacion;

	@Column(name="fecha_estado_actual")
	private Timestamp fechaEstadoActual;

	@Column(name="fecha_ingreso")
	private Timestamp fechaIngreso;

	private Boolean fundador;

	private String nombres;

	@Column(name="nro_cedula")
	private Long nroCedula;

	@Column(name="nro_socio")
	private Integer nroSocio;

	private byte[] socioproponente;

	private byte[] usuariocreacion;

	//uni-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="id_estado_actual")
	private Opcion estadoActual;

	//uni-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="id_tipo_socio")
	private Opcion tipoSocio;

	//uni-directional many-to-one association to Socio
	@ManyToOne
	@JoinColumn(name="id_socio_proponente")
	private Socio socioProponente;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario_creacion")
	private Usuario usuarioCreacion;

	public Socio() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaEstadoActual() {
		return this.fechaEstadoActual;
	}

	public void setFechaEstadoActual(Timestamp fechaEstadoActual) {
		this.fechaEstadoActual = fechaEstadoActual;
	}

	public Timestamp getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Timestamp fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Boolean getFundador() {
		return this.fundador;
	}

	public void setFundador(Boolean fundador) {
		this.fundador = fundador;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Long getNroCedula() {
		return this.nroCedula;
	}

	public void setNroCedula(Long nroCedula) {
		this.nroCedula = nroCedula;
	}

	public Integer getNroSocio() {
		return this.nroSocio;
	}

	public void setNroSocio(Integer nroSocio) {
		this.nroSocio = nroSocio;
	}

	public byte[] getSocioproponente() {
		return this.socioproponente;
	}

	public void setSocioproponente(byte[] socioproponente) {
		this.socioproponente = socioproponente;
	}

	public byte[] getUsuariocreacion() {
		return this.usuariocreacion;
	}

	public void setUsuariocreacion(byte[] usuariocreacion) {
		this.usuariocreacion = usuariocreacion;
	}

	public Opcion getEstadoActual() {
		return this.estadoActual;
	}

	public void setEstadoActual(Opcion estadoActual) {
		this.estadoActual = estadoActual;
	}

	public Opcion getTipoSocio() {
		return this.tipoSocio;
	}

	public void setTipoSocio(Opcion tipoSocio) {
		this.tipoSocio = tipoSocio;
	}

	public Socio getSocioProponente() {
		return this.socioProponente;
	}

	public void setSocioProponente(Socio socioProponente) {
		this.socioProponente = socioProponente;
	}

	public Usuario getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(Usuario usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

}