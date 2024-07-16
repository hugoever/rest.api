package py.edu.ucsa.jweb.rest.api.core.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import py.edu.ucsa.jweb.rest.api.core.dao.AbstractDao;
import py.edu.ucsa.jweb.rest.api.core.dao.OpcionDao;
import py.edu.ucsa.jweb.rest.api.core.entities.Opcion;

@Repository("opcionDaoImpl")
public class OpcionDaoImpl extends AbstractDao<Integer, Opcion> implements OpcionDao {

	
	@Override
	public List<Opcion> getOpcionesByCodDominio(String codDominio) {
		Query q = this.getEntityManager().createNamedQuery("Opcion.getOpcionesByCodDominio");
		q.setParameter("codigoDominio", codDominio);
		List<Opcion> resultado = q.getResultList();
		return resultado;
	}

	@Override
	public Opcion getOpcionesByCodigoYCodDominio(String codOpcion, String codDominio) {
		 try {
	            Query q = this.getEntityManager().createNamedQuery("Opcion.getOpcionesByCodigoYCodDominio");
	            q.setParameter("codigoOpcion", codOpcion);
	            q.setParameter("codigoDominio", codDominio);
	            return (Opcion) q.getSingleResult();
	        } catch (NoResultException e) {
	            return null; // Manejar el caso donde no se encuentra la opción
	        }
	    }
	

}
