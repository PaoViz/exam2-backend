package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.domain.Usuario;
import ec.edu.insteclrg.dto.UsuarioDTO;
import ec.edu.insteclrg.persistence.UsuarioRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class UsuarioService extends GenericCrudServiceImpl<Usuario, UsuarioDTO>{
	
	@Autowired
	private UsuarioRepository repository;
	
	private ModelMapper modelMapper = new ModelMapper();
	

	@Override
	public Optional<Usuario> find(UsuarioDTO dto) {
		return repository.findById(dto.getId());

	}

	@Override
	public UsuarioDTO mapToDto(Usuario domain) {
		return modelMapper.map(domain,UsuarioDTO.class);
	}

	@Override
	public Usuario mapToDomain(UsuarioDTO dto) {
		return modelMapper.map(dto,Usuario.class);
	}
	
	
	public Usuario findByUsername(String name) {
        return repository.findByname(name);
    }
	
	
}
