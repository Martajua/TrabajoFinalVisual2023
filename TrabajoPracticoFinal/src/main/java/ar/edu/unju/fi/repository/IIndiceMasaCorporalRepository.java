package ar.edu.unju.fi.repository;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IIndiceMasaCorporalRepository extends CrudRepository<IndiceMasaCorporal, Integer> {

	public List<IndiceMasaCorporal> findByEstado(boolean estado);

}
