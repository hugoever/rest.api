package py.edu.ucsa.jweb.rest.api.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.edu.ucsa.jweb.rest.api.core.services.UsuarioService;
import py.edu.ucsa.jweb.rest.api.dto.UsuarioDTO;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	public static final Logger logger  = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@SuppressWarnings("rawtypes")
	
	
	@GetMapping
	public ResponseEntity<?> getById(){

//		UsuarioDTO dto = new UsuarioDTO();
//		dto.setUsuario("pablo.py");
//		dto.setNombres("Pablo");
//		dto.setApellidos("Rodriguez");
		UsuarioDTO dto = UsuarioDTO.builder()
				.usuario("pablo.py")
				.nombres("PABLO")
				.apellidos("RODRIGUEZ").build();
		return ResponseEntity.ok(dto);
	}

}
