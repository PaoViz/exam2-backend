package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.domain.Servicio;
import ec.edu.insteclrg.domain.Usuario;
import ec.edu.insteclrg.dto.ServicioDTO;
import ec.edu.insteclrg.dto.UsuarioDTO;
import ec.edu.insteclrg.persistence.ServicioRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class ServicioService extends GenericCrudServiceImpl<Servicio, ServicioDTO>{

	@Autowired
	private ServicioRepository repository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Optional<Servicio> find(ServicioDTO dto) {
		return repository.findById(dto.getId());

	}

	@Override
	public ServicioDTO mapToDto(Servicio domain) {
		return modelMapper.map(domain,ServicioDTO.class);

	}

	@Override
	public Servicio mapToDomain(ServicioDTO dto) {
		return modelMapper.map(dto,Servicio.class);

	}

}
