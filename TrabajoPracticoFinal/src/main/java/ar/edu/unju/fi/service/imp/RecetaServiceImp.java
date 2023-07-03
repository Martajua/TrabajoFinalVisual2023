package ar.edu.unju.fi.service.imp;

import ar.edu.unju.fi.entity.Receta;
import ar.edu.unju.fi.repository.IRecetaRepository;
import ar.edu.unju.fi.service.IRecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("recetaServiceImp")
public class RecetaServiceImp implements IRecetaService {

	//region Dependencies
	@Autowired
	private Receta receta;

	@Autowired
	private IRecetaRepository recetaRepository;

	//endregion

	//region Methods
	@Override
	public void addReceta(Receta receta) {
		recetaRepository.save(receta);
	}

	@Override
	public List<Receta> getAllRecetas() {
		List<Receta> recetas = recetaRepository.findByEstado(true);
		return recetas;
	}

	@Override
	public Receta findRecetaById(int id) {
		receta = recetaRepository.findById(id).get();
		return receta;
	}

	@Override
	public void deleteRecetaById(Receta receta) {
		receta.setEstado(false);
		recetaRepository.save(receta);
	}
	//endregion Methods

}
