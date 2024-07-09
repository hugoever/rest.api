package py.edu.ucsa.jweb.rest.api.core.services.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.Priority;
import jakarta.transaction.Transactional;
import py.edu.ucsa.jweb.rest.api.core.dao.UsuarioDao;
import py.edu.ucsa.jweb.rest.api.core.entities.Usuario;
import py.edu.ucsa.jweb.rest.api.core.services.UsuarioService;

@Service("usuarioService")
@Priority(0)
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao usuDao;
	
	@Override
	public List<Usuario> listar() {
		return usuDao.listar();
	}

	@Override
	public Usuario getById(Integer id) {
		
		return usuDao.getById(id);
	}

	@Transactional	
	@Override
	public Usuario persistir(Usuario entity) {
		Usuario insertado = usuDao.persistir(entity);
		return insertado;
	}

	@Transactional
	@Override
	public Usuario actualizar(Usuario entity) {
		Usuario actualizado = usuDao.persistir(entity);
			//	.persistir(entity);
		return actualizado;
	}

	@Transactional
	@Override
	public void eliminar(Usuario entity) {
		
		usuDao.eliminar(entity);
	}

	@Override
	public Usuario getByUsuario(String usuario) {
		return usuDao.getByUsuario(usuario);
	}

//	@Override
//	public void eliminarTodos() {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public boolean isExisteUsuario(String usuario) {
		return Objects.nonNull(getByUsuario(usuario));
	}


	

}
