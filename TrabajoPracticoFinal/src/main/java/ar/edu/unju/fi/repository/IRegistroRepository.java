package ar.edu.unju.fi.repository;

import ar.edu.unju.fi.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRegistroRepository extends CrudRepository<Usuario, Integer> {

	public List<Usuario> findByEstado(boolean estado);

}
