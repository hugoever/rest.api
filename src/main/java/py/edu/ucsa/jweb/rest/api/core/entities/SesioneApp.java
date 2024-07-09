package py.edu.ucsa.jweb.rest.api.core.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the sesiones_app database table.
 * 
 */
@Entity
@Table(name="sesiones_app")
@NamedQuery(name="SesioneApp.findAll", query="SELECT s FROM SesioneApp s")
public class SesioneApp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="cantidad_sesiones")
	private Long cantidadSesiones;

	@Column(name="nombre_app")
	private String nombreApp;

	public SesioneApp() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getCantidadSesiones() {
		return this.cantidadSesiones;
	}

	public void setCantidadSesiones(Long cantidadSesiones) {
		this.cantidadSesiones = cantidadSesiones;
	}

	public String getNombreApp() {
		return this.nombreApp;
	}

	public void setNombreApp(String nombreApp) {
		this.nombreApp = nombreApp;
	}

}