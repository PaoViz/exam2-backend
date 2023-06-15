package ec.edu.insteclrg.dto;

import java.io.Serializable;

import lombok.Data;
@Data
public class ServicioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String nombre;
	
	private String descripcion;
	
	private int duracion;
	
}
