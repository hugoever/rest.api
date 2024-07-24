package py.edu.ucsa.jweb.rest.api.core.dao.impl;

import org.springframework.stereotype.Repository;

import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.Query;
import py.edu.ucsa.jweb.rest.api.core.dao.AbstractDao;
import py.edu.ucsa.jweb.rest.api.core.dao.SocioDao;
import py.edu.ucsa.jweb.rest.api.core.entities.Socio;

@Repository("socioDao")
public class SocioDaoImpl extends AbstractDao<Integer, Socio> implements SocioDao {

	@Override
	public Socio getSocioByNroSocio(Integer nroSocio) {
		try {
		Query q = this.getEntityManager().createNamedQuery("Socio.getSocioByNroSocio");
		q.setParameter("nroSocio", nroSocio);
		return (Socio) q.getSingleResult();
		} catch (NoResultException e) {
            return null; // Manejar el caso donde no se encuentra la opción
        }
	}
	@Override
	public Socio getSocioByNroCedula(Long nroCedula) {
		try {
		Query q = this.getEntityManager().createNamedQuery("Socio.getSocioByNroCedula");
		q.setParameter("nroCedula", nroCedula);
		return (Socio) q.getSingleResult();
		} catch (NoResultException e) {
            return null; // Manejar el caso donde no se encuentra la opción
        }
	}
	@Override
	public Socio getSocioById(Integer id) {
		try {
		Query q = this.getEntityManager().createNamedQuery("Socio.getSocioById");
		q.setParameter("id", id);
		return (Socio) q.getSingleResult();
		} catch (NoResultException e) {
            return null; // Manejar el caso donde no se encuentra la opción
        } catch (NonUniqueResultException e) {
       	 return null;
       }
	}
}
