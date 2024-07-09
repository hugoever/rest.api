package py.edu.ucsa.jweb.rest.api.core.services;

import py.edu.ucsa.jweb.rest.api.core.entities.Usuario;

public interface UsuarioService extends GenericService<Integer, Usuario>{
	
	Usuario getByUsuario(String usuario);
//	void eliminarTodos();
	boolean isExisteUsuario(String usuario);

}
