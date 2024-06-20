package py.edu.ucsa.jweb.rest.api.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.edu.ucsa.jweb.rest.api.core.services.UsuarioService;
import py.edu.ucsa.jweb.rest.api.web.dto.UsuarioDTO;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuService;
	
	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id){
		UsuarioDTO dto = usuService.getById(id);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping
	public ResponseEntity<?> listar(){
		List<UsuarioDTO> dto = usuService.listarTodos();
		return ResponseEntity.ok(dto);
	}

}
