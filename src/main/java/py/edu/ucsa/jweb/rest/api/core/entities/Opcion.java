package py.edu.ucsa.jweb.rest.api.core.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import py.edu.ucsa.jweb.rest.api.web.dto.ErrorDTO;
import py.edu.ucsa.jweb.rest.api.web.validators.Validable;
import py.edu.ucsa.jweb.rest.api.web.validators.Validador;


/**
 * The persistent class for the opciones database table.
 * 
 */
@Entity
@Table(name="opciones")
@NamedQuery(name="Opcion.findAll", query="SELECT o FROM Opcion o")
@NamedQuery(name="Opcion.getOpcionesByCodDominio", query="SELECT o FROM Opcion o WHERE o.dominio.codigo = :codigoDominio")
@NamedQuery(name="Opcion.getOpcionesByCodigoYCodDominio", query="SELECT o FROM Opcion o WHERE o.codigo = :codigoOpcion AND o.dominio.codigo = :codigoDominio")
public class Opcion implements Serializable, Validable<Opcion> {

	private static final long serialVersionUID = -6036464063902096235L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String codigo;

	private String descripcion;

	private String estado;

	//uni-directional many-to-one association to Dominio
	@ManyToOne
	@JoinColumn(name="id_dominio")
	private Dominio dominio;

	//uni-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="id_opcion_padre")
	private Opcion opcionPadre;
	
	@JsonIgnore
	@Transient
	private List<Validador<Opcion>> validadores;	

	public List<Validador<Opcion>> getValidadores() {
		if(Objects.isNull(validadores)) {
			validadores = new ArrayList<>();
		}
		return validadores;
	}

	public Opcion() {
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

	public Dominio getDominio() {
		return this.dominio;
	}

	public void setDominio(Dominio dominio) {
		this.dominio = dominio;
	}

	public Opcion getOpcionPadre() {
		return this.opcionPadre;
	}

	public void setOpcionPadre(Opcion opcionPadre) {
		this.opcionPadre = opcionPadre;
	}

	@Override
	public List<ErrorDTO> validar() {
		List<ErrorDTO> errores = new ArrayList<>();
		this.getValidadores().forEach(v -> errores.addAll(v.validar(this)));
		return errores;
	}

	@Override
	public void agregarValidador(Validador<Opcion> v) {
		this.getValidadores().add(v);
		
	}

}