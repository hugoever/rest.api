package py.edu.ucsa.jweb.rest.api.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the menus database table.
 * 
 */
@Entity
@Table(name="menus")
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="columna_menu")
	private String columnaMenu;

	private String estado;

	private String icono;

	private String nombre;

	@Column(name="tipo_menu")
	private String tipoMenu;

	@Column(name="tipo_usuario")
	private String tipoUsuario;

	private String vista;

	//uni-directional many-to-one association to Menu
	@ManyToOne
	@JoinColumn(name="id_sub_menu")
	private Menu menu;

	public Menu() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getColumnaMenu() {
		return this.columnaMenu;
	}

	public void setColumnaMenu(String columnaMenu) {
		this.columnaMenu = columnaMenu;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getIcono() {
		return this.icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoMenu() {
		return this.tipoMenu;
	}

	public void setTipoMenu(String tipoMenu) {
		this.tipoMenu = tipoMenu;
	}

	public String getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getVista() {
		return this.vista;
	}

	public void setVista(String vista) {
		this.vista = vista;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}