package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Receta;

@Repository
public interface IRecetaRepository extends CrudRepository<Receta, Long> {

	public List<Receta> findByEstado(boolean estado);
	
	@Query("SELECT r FROM Receta r WHERE r.categoria = :categoria")
	public List<Receta> findAll(@Param("categoria") String categoria);
}
