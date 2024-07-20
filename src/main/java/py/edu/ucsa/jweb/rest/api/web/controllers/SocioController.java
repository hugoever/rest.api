package py.edu.ucsa.jweb.rest.api.web.controllers;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import py.edu.ucsa.jweb.rest.api.core.entities.Socio;
import py.edu.ucsa.jweb.rest.api.core.services.SocioService;
import py.edu.ucsa.jweb.rest.api.web.dto.ErrorDTO;

@RestController
@RequestMapping("socios")
public class SocioController {

	private static final Logger logger = LoggerFactory.getLogger(SocioController.class);

	@Autowired
	@Qualifier("socioService")
	private SocioService socioService;

	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok(socioService.listar());
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(socioService.getById(id));
	}

	@PostMapping
	public ResponseEntity<?> crearSocio(@RequestBody Socio socio, UriComponentsBuilder ucBuilder) {
		logger.info("Creando socio: {}", socio);
		
			if (socioService.isExisteSocio(socio.getNroSocio())) {
				logger.error("Ya existe el socio con el número de socio: {}", socio.getNroSocio());
				return new ResponseEntity<ErrorDTO>(
						new ErrorDTO("Ya existe el socio con el número de socio: " + socio.getNroSocio()),
						HttpStatus.CONFLICT);

			} else if (socioService.isExisteSocioPorCedula(socio.getNroCedula())) {
				logger.error("Ya existe el socio con el número de cédula: {}", socio.getNroCedula());
				return new ResponseEntity<ErrorDTO>(
						new ErrorDTO("Ya existe el socio con el número de cédula: " + socio.getNroCedula()),
						HttpStatus.CONFLICT);

			}else if (socioService.isExisteSocioPorId(socio.getId())) {
				logger.error("Ya existe el socio con el número de id: {}", socio.getId());
				return new ResponseEntity<ErrorDTO>(
						new ErrorDTO("Ya existe el socio con el id: " + socio.getId()),
						HttpStatus.CONFLICT);

			}
			
		
		Socio insertado = socioService.persistir(socio);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/socios/{id}").buildAndExpand(insertado.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> actualizarSocio(@PathVariable("id") Integer id, @RequestBody Socio socio){
		logger.info("Actualizando socio: {}", id);
		Socio socioBD = socioService.getById(id);
		if(Objects.isNull(socioBD)) {
			logger.error("Actualización de socio fallida, no existe el socio con id: {}",id);
			return new ResponseEntity<ErrorDTO>(
				new ErrorDTO("Actualización de socio fallida, no existe el socio con id"+id), HttpStatus.NOT_FOUND);
			}
		socioService.actualizar(socio);
		return new ResponseEntity<Socio>(socio, HttpStatus.OK); 
	}
	
	@DeleteMapping("/eliminarsocio/{id}")
	public ResponseEntity<?> eliminarSocio(@PathVariable("id") Integer id){
		logger.info("Eliminando la socio con el id: {}", id);
		Socio socioBD = socioService.getById(id);
		if(Objects.isNull(socioBD)) {
			logger.error("Eliminación fallida, no existe el socio con id: {}", id);
			return new ResponseEntity<ErrorDTO>(
					new ErrorDTO("Eliminación fallida, no existe la socio con el id: "+
							id), HttpStatus.NOT_FOUND
					);
		}
		Integer socioEliminado = socioBD.getNroSocio();
		socioService.eliminar(socioBD);
		return new ResponseEntity<ErrorDTO>(
				new ErrorDTO("El socio con nro de socio: " + socioEliminado +
						" fue eliminado exitosamente."), HttpStatus.OK
						);
				
	}
	
	@GetMapping("pornrodesocio/{nroSocio}")
	public ResponseEntity<?> getSocioByNroSocio(@PathVariable("nroSocio") Integer nroSocio){
		return ResponseEntity.ok(socioService.getSocioByNroSocio(nroSocio) );
	}
	
	@GetMapping("pornrodecedula/{nroCedula}")
	public ResponseEntity<?> getSocioByNroCedula(@PathVariable("nroCedula") Long nroCedula){
		return ResponseEntity.ok(socioService.getSocioByNroCedula(nroCedula) );
	}

}
