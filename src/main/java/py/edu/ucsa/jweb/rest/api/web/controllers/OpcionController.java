package py.edu.ucsa.jweb.rest.api.web.controllers;

import java.util.List;
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

import jakarta.persistence.NoResultException;
import py.edu.ucsa.jweb.rest.api.core.entities.Opcion;
import py.edu.ucsa.jweb.rest.api.core.services.OpcionService;
import py.edu.ucsa.jweb.rest.api.web.dto.ErrorDTO;
import py.edu.ucsa.jweb.rest.api.web.validators.impl.OpcionValidador;

@RestController
@RequestMapping("opciones")
public class OpcionController {

	private static final Logger logger = LoggerFactory.getLogger(OpcionController.class);

	@Autowired
	@Qualifier("opcionService")
	private OpcionService opcionService;

	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok(opcionService.listar());
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
		Opcion dto = opcionService.getById(id);
		return ResponseEntity.ok(dto);
	}

	@PostMapping
	public ResponseEntity<?> crearOpcion(@RequestBody Opcion opcion, UriComponentsBuilder ucBuilder) {
		logger.info("Creando la opción : {}", opcion);
		if (opcionService.isExisteOpcion(opcion.getCodigo(), opcion.getDominio().getCodigo())) {
			logger.error("Inserción fallida. Ya existe un registro con la código {} y el dominio {}",
					opcion.getCodigo(), opcion.getDominio().getCodigo());

			return new ResponseEntity<ErrorDTO>(new ErrorDTO("Inserción Fallida. Ya existe un registro con el código"
					+ opcion.getCodigo() + " y el dominio" + opcion.getDominio().getCodigo()), HttpStatus.CONFLICT);
		}
		OpcionValidador v1 = new OpcionValidador();
		opcion.agregarValidador(v1);
		List<ErrorDTO> errores = opcion.validar();
		if (errores.isEmpty()) { // NO HAY ERRORES Y SE PROCEDE A INSERTAR
			Opcion insertado = opcionService.persistir(opcion);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/opciones/{id}").buildAndExpand(insertado.getId()).toUri());
			return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<List<ErrorDTO>>(errores, HttpStatus.CREATED);
		}
	}

	@PutMapping("{id}")
	public ResponseEntity<?> actualizarOpcion(@PathVariable("id") Integer id, @RequestBody Opcion opcion) {
		logger.info("Actualizando opción con el id: {}", id);
		Opcion opcionBD = opcionService.getById(id);
		if (Objects.isNull(opcionBD)) {
			logger.error("Actualización fallida, no existe la opción: {}", id);
			return new ResponseEntity<ErrorDTO>(
					new ErrorDTO("Actualización fallida. No existe la opción con el id " + id), HttpStatus.NOT_FOUND);
		}
		opcionService.actualizar(opcion);
		return new ResponseEntity<Opcion>(opcion, HttpStatus.OK);

	}

	@DeleteMapping("/eliminaropcion/{id}")
	public ResponseEntity<?> eliminarOpcion(@PathVariable("id") Integer id) {
		logger.info("Eliminando la opción con el id: {}", id);
		Opcion opcionBD = opcionService.getById(id);
		if (Objects.isNull(opcionBD)) {
			logger.error("Eliminación fallida, no existe la opción: {}", id);
			return new ResponseEntity<ErrorDTO>(
					new ErrorDTO("Eliminación fallida, no existe la opción con el id: " + id), HttpStatus.NOT_FOUND);
		}
		String opcionEliminada = opcionBD.getDescripcion();
		opcionService.eliminar(opcionBD);
		return new ResponseEntity<ErrorDTO>(
				new ErrorDTO("La opción: " + opcionEliminada + " fue eliminada exitosamente."), HttpStatus.OK);

	}

	@GetMapping("pordominio/{dominio}")
	public ResponseEntity<?> getOpcionesByCodDominio(@PathVariable("dominio") String dominio) {
		return ResponseEntity.ok(opcionService.getOpcionesByCodDominio(dominio));
	}

	@GetMapping("/porcodigoydominio/{codigo}/{dominio}")
	public ResponseEntity<?> getOpcionesByCodigoYCodDominio(@PathVariable("codigo") String codigo,
			@PathVariable("dominio") String dominio) {
		try {
			return ResponseEntity.ok(opcionService.getOpcionesByCodigoYCodDominio(codigo, dominio));
		} catch (NoResultException e) {
			return new ResponseEntity<>(
					new ErrorDTO("No se encontró ninguna opción con el código y dominio proporcionados"),
					HttpStatus.NOT_FOUND);
		}
	}

}
