package py.edu.ucsa.jweb.rest.api.core.dao.impl;

import java.util.List;

import py.edu.ucsa.jweb.rest.api.core.dao.AbstractDao;
import py.edu.ucsa.jweb.rest.api.core.dao.UsuarioDao;
import py.edu.ucsa.jweb.rest.api.core.entities.Usuario;

public class UsuarioDaoImpl extends AbstractDao<Integer, Usuario> implements UsuarioDao {

	@Override
	public Usuario getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario getByUsuario(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void persistir(Usuario usu) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void actualizar(Usuario usu) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void borrarPorId(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrarPorUsuario(String usuario) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public List<Usuario> listar(){
		return null;
	}

}
