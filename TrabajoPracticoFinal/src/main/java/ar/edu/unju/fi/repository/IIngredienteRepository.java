package ar.edu.unju.fi.repository;

import ar.edu.unju.fi.entity.Ingrediente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IIngredienteRepository extends CrudRepository<Ingrediente, Integer> {

	//region Methods
	public List<Ingrediente> findByEstado(boolean estado);
	//endregion

}
