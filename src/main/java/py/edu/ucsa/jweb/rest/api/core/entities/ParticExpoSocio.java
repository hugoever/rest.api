package py.edu.ucsa.jweb.rest.api.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the partic_expo_socios database table.
 * 
 */
@Entity
@Table(name="partic_expo_socios")
@NamedQuery(name="ParticExpoSocio.findAll", query="SELECT p FROM ParticExpoSocio p")
public class ParticExpoSocio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="cancelo_participacion")
	private Boolean canceloParticipacion;

	@Column(name="fecha_cancelacion")
	private Timestamp fechaCancelacion;

	@Column(name="fecha_creacion")
	private Timestamp fechaCreacion;

	//uni-directional many-to-one association to Exposicion
	@ManyToOne
	@JoinColumn(name="id_exposicion")
	private Exposicion exposicion;

	//uni-directional many-to-one association to Socio
	@ManyToOne
	@JoinColumn(name="id_socio")
	private Socio socio;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario_creacion")
	private Usuario usuarioCreacion;

	public ParticExpoSocio() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getCanceloParticipacion() {
		return this.canceloParticipacion;
	}

	public void setCanceloParticipacion(Boolean canceloParticipacion) {
		this.canceloParticipacion = canceloParticipacion;
	}

	public Timestamp getFechaCancelacion() {
		return this.fechaCancelacion;
	}

	public void setFechaCancelacion(Timestamp fechaCancelacion) {
		this.fechaCancelacion = fechaCancelacion;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Exposicion getExposicion() {
		return this.exposicion;
	}

	public void setExposicion(Exposicion exposicion) {
		this.exposicion = exposicion;
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