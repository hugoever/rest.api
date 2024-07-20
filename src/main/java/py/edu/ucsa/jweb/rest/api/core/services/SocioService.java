package py.edu.ucsa.jweb.rest.api.core.services;

import org.springframework.stereotype.Service;

import py.edu.ucsa.jweb.rest.api.core.entities.Socio;

@Service
public interface SocioService extends GenericService<Integer, Socio> {
	
	public Socio getSocioByNroSocio(Integer nroSocio);
	public Socio getSocioByNroCedula(Long nroCedula);
	public Socio getSocioById(Integer id);
	public boolean isExisteSocio(Integer nroSocio);
	public boolean isExisteSocioPorCedula(Long nroCedula);
	public boolean isExisteSocioPorId(Integer id);

}
