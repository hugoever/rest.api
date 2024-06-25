package py.edu.ucsa.jweb.rest.api.web.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
	
	private Long id;
	private String usuario;
	private String email;
	private String clave;
	private String nombres;
	private String apellidos;
	private Boolean habilitado;
	private Boolean cuentaBloqueada;
	private Boolean cuentaExpirada;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime fechaCreacion;
/*
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Boolean getHabilitado() {
		return habilitado;
	}
	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}
	public Boolean getCuenta_bloqueada() {
		return cuenta_bloqueada;
	}
	public void setCuenta_bloqueada(Boolean cuenta_bloqueada) {
		this.cuenta_bloqueada = cuenta_bloqueada;
	}
	public Boolean getCuenta_expirada() {
		return cuenta_expirada;
	}
	public void setCuenta_expirada(Boolean cuenta_expirada) {
		this.cuenta_expirada = cuenta_expirada;
	}
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
*/
}
