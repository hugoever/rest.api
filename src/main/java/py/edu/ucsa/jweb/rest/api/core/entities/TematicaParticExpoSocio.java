package py.edu.ucsa.jweb.rest.api.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tematica_partic_expo_socios database table.
 * 
 */
@Entity
@Table(name="tematica_partic_expo_socios")
@NamedQuery(name="TematicaParticExpoSocio.findAll", query="SELECT t FROM TematicaParticExpoSocio t")
public class TematicaParticExpoSocio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="cancelo_partic_tematica")
	private Boolean canceloParticTematica;

	@Column(name="fecha_cancelacion")
	private Timestamp fechaCancelacion;

	@Column(name="fecha_creacion")
	private Timestamp fechaCreacion;

	@Column(name="tematica_especifica")
	private String tematicaEspecifica;

	//uni-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="id_tematica_general")
	private Opcion tematicaGeneral;

	//uni-directional many-to-one association to ParticExpoSocio
	@ManyToOne
	@JoinColumn(name="id_partic_expo_socios")
	private ParticExpoSocio particExpoSocio;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario_creacion")
	private Usuario usuarioCreacion;

	public TematicaParticExpoSocio() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getCanceloParticTematica() {
		return this.canceloParticTematica;
	}

	public void setCanceloParticTematica(Boolean canceloParticTematica) {
		this.canceloParticTematica = canceloParticTematica;
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

	public String getTematicaEspecifica() {
		return this.tematicaEspecifica;
	}

	public void setTematicaEspecifica(String tematicaEspecifica) {
		this.tematicaEspecifica = tematicaEspecifica;
	}

	public Opcion getTematicaGeneral() {
		return this.tematicaGeneral;
	}

	public void setTematicaGeneral(Opcion tematicaGeneral) {
		this.tematicaGeneral = tematicaGeneral;
	}

	public ParticExpoSocio getParticExpoSocio() {
		return this.particExpoSocio;
	}

	public void setParticExpoSocio(ParticExpoSocio particExpoSocio) {
		this.particExpoSocio = particExpoSocio;
	}

	public Usuario getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(Usuario usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

}