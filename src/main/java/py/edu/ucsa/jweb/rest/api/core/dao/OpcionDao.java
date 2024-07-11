package py.edu.ucsa.jweb.rest.api.core.dao;

import java.util.List;

import py.edu.ucsa.jweb.rest.api.core.entities.Opcion;

public interface OpcionDao extends GenericDao<Integer, Opcion> {
	public List<Opcion> getOpcionesByCodDominio(String codDominio);
	public Opcion getOpcionesByCodigoYCodDominio(String codOpcion, String codDominio);
	

}
