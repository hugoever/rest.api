package py.edu.ucsa.jweb.rest.api.core.services;

import java.util.List;

import py.edu.ucsa.jweb.rest.api.core.entities.Usuario;
import py.edu.ucsa.jweb.rest.api.web.dto.UsuarioDTO;

public interface UsuarioService extends GenericService<Integer, Usuario>{
	
	List<UsuarioDTO> listarTodos();
	UsuarioDTO getById(long Id);
	Usuario getByUsuario(String usuario);
	void crearUsuario(UsuarioDTO usuario);
	void actualizarUsuario(UsuarioDTO usuario);
	void eliminarUsuario(long id);
	void eliminarTodos();
	boolean isExisteUsuario(Usuario usuario);

}
