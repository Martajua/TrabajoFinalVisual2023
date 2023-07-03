package ar.edu.unju.fi.repository;

import ar.edu.unju.fi.entity.Receta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRecetaRepository extends CrudRepository<Receta, Integer> {

    public List<Receta> findByEstado(boolean estado);

}
