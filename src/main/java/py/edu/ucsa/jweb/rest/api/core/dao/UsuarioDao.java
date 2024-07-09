package py.edu.ucsa.jweb.rest.api.core.dao;

import py.edu.ucsa.jweb.rest.api.core.entities.Usuario;

public interface UsuarioDao extends GenericDao<Integer, Usuario> {

//LOS MÈTODOS COMENTADOS YA FUERON HEREDADOS DE GENERIC DAO 
//POR LO QUE SOLO DEFINEN LOS MÉTODOS QUE NO SE ENCUENTRAN EN GENERIC DAO	
	
//	Usuario getById(int id);
	Usuario getByUsuario(String usuario);
//	Usuario persistir(Usuario usu);
//	Usuario actualizar(Usuario usu);
//	void borrarPorId(int id);
	void borrarPorUsuario(String usuario);
//	List<Usuario> listar();

}
