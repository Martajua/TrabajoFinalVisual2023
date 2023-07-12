package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Usuario;

@Repository
public interface IIndiceMasaCorporalRepository extends CrudRepository<IndiceMasaCorporal, Integer> {
	public List<IndiceMasaCorporal> findByEstado(boolean estado);
	
	
	List<IndiceMasaCorporal> findByUsuarioAndEstadoOrderByFechaImcDesc(Usuario usuario, boolean estado);
}
