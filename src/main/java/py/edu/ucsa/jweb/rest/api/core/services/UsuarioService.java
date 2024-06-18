package py.edu.ucsa.jweb.rest.api.core.services;

import java.util.List;

import py.edu.ucsa.jweb.rest.api.dto.UsuarioDTO;

public interface UsuarioService {
	
	UsuarioDTO getById(long Id);
	UsuarioDTO getByUsuario(String usuario);
	void CrearUsuario(UsuarioDTO usuario);
	void ActualizarUsuario(UsuarioDTO usuario);
	void EliminarUsuario(long id);
	List<UsuarioDTO> ListarTodos();
	void EliminarTodos();
	boolean isExisteUsuario(UsuarioDTO usuario);

}
