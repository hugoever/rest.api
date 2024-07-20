package py.edu.ucsa.jweb.rest.api.core.services.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import py.edu.ucsa.jweb.rest.api.core.dao.SocioDao;
import py.edu.ucsa.jweb.rest.api.core.entities.Socio;
import py.edu.ucsa.jweb.rest.api.core.services.SocioService;

@Service("socioService")
@Transactional
public class SocioServiceImpl implements SocioService {

	@Autowired
	private SocioDao socioDao;
	
	@Override
	public List<Socio> listar() {
		return socioDao.listar();
	}

	@Override
	public Socio getById(Integer id) {		
		return socioDao.getById(id);
	}

	@Override
	public Socio persistir(Socio entity) {
		Socio insertado = socioDao.persistir(entity);
		return insertado;
	}

	@Override
	public Socio actualizar(Socio entity) {
		Socio actualizado = socioDao.persistir(entity);
		return actualizado;
	}

	@Override
	public void eliminar(Socio entity) {
		socioDao.eliminar(entity);

	}

	@Override
	public boolean isExisteSocio(Integer nroSocio) {
		return Objects.nonNull(getSocioByNroSocio(nroSocio));
	}
	
	@Override
	public boolean isExisteSocioPorCedula(Long nroCedula) {
		return Objects.nonNull(getSocioByNroCedula(nroCedula));
	}
	@Override
	public boolean isExisteSocioPorId(Integer id) {
		return Objects.nonNull(getSocioById(id));
	}

	@Override
	public Socio getSocioByNroSocio(Integer nroSocio) {
		return socioDao.getSocioByNroSocio(nroSocio);
	}

	@Override
	public Socio getSocioByNroCedula(Long nroCedula) {
		return socioDao.getSocioByNroCedula(nroCedula);
	}
	@Override
	public Socio getSocioById(Integer id) {
		return socioDao.getSocioById(id);
	}


}
