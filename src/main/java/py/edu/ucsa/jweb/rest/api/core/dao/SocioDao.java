package py.edu.ucsa.jweb.rest.api.core.dao;

import org.springframework.stereotype.Repository;

import py.edu.ucsa.jweb.rest.api.core.entities.Socio;

@Repository
public interface SocioDao extends GenericDao<Integer, Socio> {

	public Socio getSocioByNroSocio(Integer nroSocio);
	public Socio getSocioByNroCedula(Long nroCedula);
	public Socio getSocioById(Integer id);
}
