package py.edu.ucsa.jweb.rest.api.core.services;

import java.util.List;

public interface GenericService<PK,T>{

	List<T> listar();
	T getById(PK id);
	T persistir(T entity);
	T actualizar(T entity);
	void eliminar(T entity);
//	boolean isExisteUsuario(String usuario);
}
