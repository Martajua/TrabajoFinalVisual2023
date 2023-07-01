package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.Usuario;

public interface IRegistroServiceRepository extends CrudRepository<Usuario, Integer> {
	public List<Usuario> findByEstado(boolean estado);
}
