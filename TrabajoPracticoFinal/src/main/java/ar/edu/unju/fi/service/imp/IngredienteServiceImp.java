package ar.edu.unju.fi.service.imp;

import ar.edu.unju.fi.entity.Ingrediente;
import ar.edu.unju.fi.repository.IIngredienteRepository;
import ar.edu.unju.fi.service.IIngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ingredienteServiceImp")
public class IngredienteServiceImp implements IIngredienteService {

	//region Dependencies
	@Autowired
	private IIngredienteRepository ingredienteRepository;

	@Autowired
	private Ingrediente ingrediente;
	//endregion

	//region Methods
	@Override
	public void addIngrediente(Ingrediente ingrediente) {
		ingredienteRepository.save(ingrediente);
	}

	@Override
	public List<Ingrediente> getAllIngredientes() {
		return ingredienteRepository.findByEstado(true);
	}

	@Override
	public Ingrediente findIngredienteById(int id) {
		ingrediente = ingredienteRepository.findById(id).get();
		return ingrediente;
	}

	@Override
	public void deleteIngredienteByIdentifier(Ingrediente ingrediente) {
		ingrediente.setEstado(false);
		ingredienteRepository.save(ingrediente);
	}
	//endregion

}
