package py.edu.ucsa.jweb.rest.api.core.services.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import py.edu.ucsa.jweb.rest.api.core.dao.OpcionDao;
import py.edu.ucsa.jweb.rest.api.core.entities.Opcion;
import py.edu.ucsa.jweb.rest.api.core.services.OpcionService;

@Service("opcionService")
@Transactional
public class OpcionServiceImpl implements OpcionService {

	@Autowired
	private OpcionDao opcionDao;

	@Override
	public List<Opcion> listar() {

		return opcionDao.listar();
	}

	@Override
	public Opcion getById(Integer id) {

		return opcionDao.getById(id);
	}

	@Override
	public Opcion persistir(Opcion entity) {
		Opcion insertado = opcionDao.persistir(entity);
		return insertado;
	}

	@Override
	public Opcion actualizar(Opcion entity) {
		Opcion actualizado = opcionDao.persistir(entity);
		return actualizado;
	}

	@Override
	public void eliminar(Opcion entity) {

		opcionDao.eliminar(entity);

	}

	@Override
	public List<Opcion> getOpcionesByCodDominio(String codDominio) {

		return opcionDao.getOpcionesByCodDominio(codDominio);

	}

	@Override
	public Opcion getOpcionesByCodigoYCodDominio(String codOpcion, String codDominio) {

		Opcion opcion = opcionDao.getOpcionesByCodigoYCodDominio(codOpcion, codDominio);
//        if (opcion == null) {
//            //throw new NoResultException("No se encontró ninguna opción con el código y dominio proporcionados");
//        	return null;
//        }
		return opcion;

	}

	@Override
	public boolean isExisteOpcion(String codOpcion, String codDominio) {

		return Objects.nonNull(getOpcionesByCodigoYCodDominio(codOpcion, codDominio));

	}

}
