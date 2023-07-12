package ar.edu.unju.fi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import ar.edu.unju.fi.entity.Usuario;

public interface IRegistroServiceRepository extends CrudRepository<Usuario, Long> {
	public List<Usuario> findByEstado(boolean estado);
	
	Optional<Usuario> findUsuarioById(Long id);
}
