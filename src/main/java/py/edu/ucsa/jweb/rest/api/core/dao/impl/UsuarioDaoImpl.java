package py.edu.ucsa.jweb.rest.api.core.dao.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Repository;

import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import py.edu.ucsa.jweb.rest.api.core.dao.AbstractDao;
import py.edu.ucsa.jweb.rest.api.core.dao.UsuarioDao;
import py.edu.ucsa.jweb.rest.api.core.entities.Usuario;

@Repository("UsuarioDao")
public class UsuarioDaoImpl extends AbstractDao<Integer, Usuario> implements UsuarioDao {

	@Override
	public Usuario getById(int id) {
		return super.getById(id);
	}
	
//Método que devuelve un usuario por su nombre de usuario si lo encuentra, 
//caso contrario devuelve null		
	@Override
	public Usuario getByUsuario(String usuario) {
		try {
		Query q = getEntityManager().createQuery("select u from Usuario u where u.usuario = :usu");
		q.setParameter("usu", usuario);
		Usuario u = (Usuario) q.getSingleResult();
		return u;
		} catch (NoResultException e) {
			
			return null;
		}
	}

	@Override
	public Usuario persistir(Usuario usu) {
		return super.persistir(usu);

	}
	
	@Override
	public Usuario actualizar(Usuario usu) {
		return super.actualizar(usu);

	}
	
	@Override
	public void borrarPorId(int id) {
		super.eliminar(id);
//		Usuario usuParaBorrar = this.getById(id);
//		if(Objects.nonNull(usuParaBorrar)) {
//			super.eliminar(usuParaBorrar);
//		}
		
	}

	@Override
	public void borrarPorUsuario(String usuario) {
		Usuario usuParaBorrar = this.getByUsuario(usuario);
		if(Objects.nonNull(usuParaBorrar)) {
			super.eliminar(usuParaBorrar);
		}

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listar(){
//		return super.listar(); //otra forma ya que esta declarado en la clase abstracta
		Query q = this.getEntityManager().createNamedQuery("Usuario.findAll");
		List<Usuario> resultado = (List<Usuario>)q.getResultList();
		return resultado;
	}

}
