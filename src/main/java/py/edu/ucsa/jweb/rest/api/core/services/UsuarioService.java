package py.edu.ucsa.jweb.rest.api.core.services;

import java.util.List;

import py.edu.ucsa.jweb.rest.api.web.dto.UsuarioDTO;

public interface UsuarioService {
	
	UsuarioDTO getById(long Id);
	UsuarioDTO getByUsuario(String usuario);
	void crearUsuario(UsuarioDTO usuario);
	void actualizarUsuario(UsuarioDTO usuario);
	void eliminarUsuario(long id);
	List<UsuarioDTO> listarTodos();
	void eliminarTodos();
	boolean isExisteUsuario(UsuarioDTO usuario);

}
