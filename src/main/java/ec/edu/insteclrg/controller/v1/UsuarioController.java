package ec.edu.insteclrg.controller.v1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import ec.edu.insteclrg.domain.Usuario;
import ec.edu.insteclrg.dto.ApiResponseDTO;
import ec.edu.insteclrg.dto.UsuarioDTO;
import ec.edu.insteclrg.service.crud.UsuarioService;

@RestController
@RequestMapping("/api/v1.0/usuario/")
public class UsuarioController {

	@Autowired
	UsuarioService service;

	
	
	@PostMapping
	public ResponseEntity<Object> guardar(@RequestBody UsuarioDTO dto) {
		service.save(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

    // Completar

	@PutMapping
	public ResponseEntity<Object> actualizar(@RequestBody UsuarioDTO dto) {
	    service.update(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Object> listar() {
		List<UsuarioDTO> list = service.findAll(new UsuarioDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<UsuarioDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "{id}")
	public ResponseEntity<Object> buscar(@PathVariable Long id) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setId(id);
		Optional<Usuario> domain = service.find(dto);
		if (!domain.isEmpty()) {
			dto = service.mapToDto(domain.get());
			return new ResponseEntity<>(new ApiResponseDTO<>(true, dto), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
	// Completar
	
	@DeleteMapping(path = "{id}")
	public ResponseEntity<Object> eliminar(@PathVariable Long id) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setId(id);
		Optional<Usuario > categoryOptional = service.find(dto);
	
		if(categoryOptional.isPresent()) {
			service.delete(dto);
			return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody UsuarioDTO userDTO) {
		Usuario user = service.findByUsername(userDTO.getName());

		if (user != null && user.getPassword().equals(userDTO.getPassword())) {
			return new ResponseEntity<>(new ApiResponseDTO<>(true, "Inicio de sesión exitoso"), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, "Credenciales inválidas"), HttpStatus.UNAUTHORIZED);
		}
	}

	
	
}

