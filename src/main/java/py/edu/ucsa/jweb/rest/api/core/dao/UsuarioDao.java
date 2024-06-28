package py.edu.ucsa.jweb.rest.api.core.dao;

import java.util.List;

import py.edu.ucsa.jweb.rest.api.core.entities.Usuario;

public interface UsuarioDao extends GenericDao<Integer, Usuario> {
	
	Usuario getById(int id);
	Usuario getByUsuario(String usuario);
	void persistir(Usuario usu);
	void actualizar(Usuario usu);
	void borrarPorId(int id);
	void borrarPorUsuario(String usuario);
	List<Usuario> listar();

}
