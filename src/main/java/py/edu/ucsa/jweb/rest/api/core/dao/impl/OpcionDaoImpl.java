package py.edu.ucsa.jweb.rest.api.core.dao.impl;

import java.util.List;

import jakarta.persistence.Query;
import py.edu.ucsa.jweb.rest.api.core.dao.AbstractDao;
import py.edu.ucsa.jweb.rest.api.core.dao.OpcionDao;
import py.edu.ucsa.jweb.rest.api.core.entities.Opcion;

public class OpcionDaoImpl extends AbstractDao<Integer, Opcion> implements OpcionDao {

	
	@Override
	public List<Opcion> getOpcionesByCodDominio(String codDominio) {
		Query q = this.getEntityManager().createQuery("Opcion.getOpcionesByCodDominio");
		q.setParameter("codigoDominio", codDominio);
		List<Opcion> resultado = q.getResultList();
		return resultado;
	}

	@Override
	public Opcion getOpcionesByCodigoYCodDominio(String codOpcion, String codDominio) {
		Query q = this.getEntityManager().createQuery("Opcion.getOpcionesByCodigoYCodDominio");
		q.setParameter("codigoOpcion", codOpcion);
		q.setParameter("codigoDominio", codDominio);
		Opcion resultado = (Opcion) q.getSingleResult();
		return resultado;
	}

}
