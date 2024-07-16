package py.edu.ucsa.jweb.rest.api.core.services;

import java.util.List;

import py.edu.ucsa.jweb.rest.api.core.entities.Opcion;

public interface OpcionService extends GenericService<Integer, Opcion> {

	public List<Opcion> getOpcionesByCodDominio(String codDominio);
	public Opcion getOpcionesByCodigoYCodDominio(String codOpcion, String codDominio);
	public boolean isExisteOpcion(String codOpcion, String codDominio);
	
}
