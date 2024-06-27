package py.edu.ucsa.jweb.rest.api.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the mensajes_enviados_socios database table.
 * 
 */
@Entity
@Table(name="mensajes_enviados_socios")
@NamedQuery(name="MensajeEnviadoSocio.findAll", query="SELECT m FROM MensajeEnviadoSocio m")
public class MensajeEnviadoSocio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="fecha_creacion")
	private Timestamp fechaCreacion;

	//uni-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="id_mensaje")
	private Opcion mensaje;

	//uni-directional many-to-one association to Socio
	@ManyToOne
	@JoinColumn(name="id_socio_destino")
	private Socio socioDestino;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario_creacion")
	private Usuario usuarioCreacion;

	public MensajeEnviadoSocio() {
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

	public Opcion getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(Opcion mensaje) {
		this.mensaje = mensaje;
	}

	public Socio getSocioDestino() {
		return this.socioDestino;
	}

	public void setSocioDestino(Socio socioDestino) {
		this.socioDestino = socioDestino;
	}

	public Usuario getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(Usuario usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

}