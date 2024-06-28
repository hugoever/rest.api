package py.edu.ucsa.jweb.rest.api.core.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<PK extends Serializable, T> {
	List<T> listar();
	T getById(PK id);
	public void persistir(T entity);
	public void actualizar(T entity);
	void eliminar(T entity);
	void eliminar(PK id);

}
